package com.jaecoding.keep.coding.domain.dto.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class ItemDeserializer<T extends Parent1> extends StdDeserializer<T> {

    public ItemDeserializer() {
        this(null);
    }

    public ItemDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public T deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {


        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        ObjectNode node = (ObjectNode) mapper.readTree(jp);


//        String parentName = node.get("parentName").asText();

//        T t = (T) mapper.treeToValue(node, Parent1.class);
//        t.setParentName(parentName);

        return (T)mapper.treeToValue(node, Parent1.class);
    }
}
