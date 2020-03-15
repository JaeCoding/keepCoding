package com.jaecoding.keep.coding.util.aop.aspect;

public aspect CriticAspect {
    public CriticAspect() {
    }

    pointcut performance(): execution(* perform(..));

    //    afterReturning() : performance(){
//        System.out.println();
//    }

}
