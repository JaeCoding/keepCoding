package spring.aop.aspect;

public aspect CriticAspect {
    public CriticAspect() {
    }

    pointcut performance(): execution(* perform(..));

    //    afterReturning() : performance(){
//        System.out.println();
//    }

}
