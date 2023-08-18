package com.jaecoding.keep.coding.domain.dto.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.JsonTokenId;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.BuilderBasedDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.google.common.collect.Maps;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public class SuperBuilderBasedDeserializer<T> extends BuilderBasedDeserializer {
    protected SuperBuilderBasedDeserializer(BuilderBasedDeserializer src, Class<T> superClass) {
        super(src);
        this.superclass = superClass;
        for (Field declaredField : superClass.getDeclaredFields()) {
            this.superclassProperty.put(declaredField.getName(), null);
        }
    }

    private final Class<T> superclass;
    private final Map<String, Object> superclassProperty = Maps.newHashMap();

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException {
        // common case first:
        if (p.isExpectedStartObjectToken()) {
            JsonToken t = p.nextToken();
            if (_vanillaProcessing) {
                return finishBuild(ctxt, vanillaDeserialize(p, ctxt, t));
            }
            Object builder = deserializeFromObject(p, ctxt);
            return finishBuild(ctxt, builder);
        }
        // and then others, generally requiring use of @JsonCreator
        switch (p.getCurrentTokenId()) {
            case JsonTokenId.ID_STRING:
                return finishBuild(ctxt, deserializeFromString(p, ctxt));
            case JsonTokenId.ID_NUMBER_INT:
                return finishBuild(ctxt, deserializeFromNumber(p, ctxt));
            case JsonTokenId.ID_NUMBER_FLOAT:
                return finishBuild(ctxt, deserializeFromDouble(p, ctxt));
            case JsonTokenId.ID_EMBEDDED_OBJECT:
                return p.getEmbeddedObject();
            case JsonTokenId.ID_TRUE:
            case JsonTokenId.ID_FALSE:
                return finishBuild(ctxt, deserializeFromBoolean(p, ctxt));
            case JsonTokenId.ID_START_ARRAY:
                // these only work if there's a (delegating) creator...
                return finishBuild(ctxt, deserializeFromArray(p, ctxt));
            case JsonTokenId.ID_FIELD_NAME:
            case JsonTokenId.ID_END_OBJECT:
                return finishBuild(ctxt, deserializeFromObject(p, ctxt));
            default:
        }
        return ctxt.handleUnexpectedToken(handledType(), p);
    }


    @Override
    protected Object finishBuild(DeserializationContext ctxt, Object builder)
            throws IOException {
        // As per [databind#777], allow returning builder itself
        if (null == _buildMethod) {
            return builder;
        }
        try {
            Object o = _buildMethod.getMember().invoke(builder, (Object[]) null);
            if (this.superclass.isAssignableFrom(o.getClass())) {
                setSuperProperty(o);
            }
            return o;
        } catch (Exception e) {
            return wrapInstantiationProblem(e, ctxt);
        }
    }

    private void setSuperProperty(Object o) throws IllegalAccessException {
        for (Field declaredField : this.superclass.getDeclaredFields()) {
            Object fieldValue = superclassProperty.get(declaredField.getName());
            if (null != fieldValue) {
                try {
                    declaredField.setAccessible(true);
                    declaredField.set(o, fieldValue);
                } catch (IllegalAccessException e) {
                    throw e;
                }
            }
        }
    }

    private final Object vanillaDeserialize(JsonParser p,
                                            DeserializationContext ctxt, JsonToken t)
            throws IOException {
        Object bean = _valueInstantiator.createUsingDefault(ctxt);
        for (; p.getCurrentToken() != JsonToken.END_OBJECT; p.nextToken()) {
            String propName = p.getCurrentName();
            // Skip field name:
            p.nextToken();
            extractSuperProperty(p, propName);
            SettableBeanProperty prop = _beanProperties.find(propName);
            if (prop != null) { // normal case
                try {
                    bean = prop.deserializeSetAndReturn(p, ctxt, bean);
                } catch (Exception e) {
                    wrapAndThrow(e, bean, propName, ctxt);
                }
            } else {
                handleUnknownVanilla(p, ctxt, bean, propName);
            }
        }
        return bean;
    }

    @Override
    public Object deserializeFromObject(JsonParser p, DeserializationContext ctxt)
            throws IOException {
        if (_nonStandardCreation) {
            if (_unwrappedPropertyHandler != null) {
                return deserializeWithUnwrapped(p, ctxt);
            }
            if (_externalTypeIdHandler != null) {
                return deserializeWithExternalTypeId(p, ctxt);
            }
            return deserializeFromObjectUsingNonDefault(p, ctxt);
        }
        Object bean = _valueInstantiator.createUsingDefault(ctxt);
        if (_injectables != null) {
            injectValues(ctxt, bean);
        }
        if (_needViewProcesing) {
            Class<?> view = ctxt.getActiveView();
            if (view != null) {
                return deserializeWithView(p, ctxt, bean, view);
            }
        }
        for (; p.getCurrentToken() != JsonToken.END_OBJECT; p.nextToken()) {
            String propName = p.getCurrentName();
            // Skip field name:
            p.nextToken();
            extractSuperProperty(p, propName);// add extract here
            SettableBeanProperty prop = _beanProperties.find(propName);
            if (prop != null) { // normal case
                try {
                    bean = prop.deserializeSetAndReturn(p, ctxt, bean);
                } catch (Exception e) {
                    wrapAndThrow(e, bean, propName, ctxt);
                }
                continue;
            }
            handleUnknownVanilla(p, ctxt, bean, propName);
        }
        return bean;
    }

    private void extractSuperProperty(JsonParser p, String propName) throws IOException {
        if (superclassProperty.containsKey(propName)) {
            String value = p.readValueAs(String.class);
            if (value != null) {
                superclassProperty.put(propName, value);
            }
        }
    }
}
