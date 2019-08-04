package design.behavior.strategy;

public class Test {
    public static void main(String[] args) {
        Validator numericValidator = new Validator(new IsNumeric());
        boolean b1 = numericValidator.validate("aaaa");

        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        boolean b2 = lowerCaseValidator.validate("bbbb");

        //lambda优化，可以不写IsAllLowerCase这个类了
        Validator lowerCaseValidator2 = new Validator(s -> s.matches("[a-z]+"));
        boolean b3 = lowerCaseValidator2.validate("bbbb");

        //验证器（应用类）具备接口属性，根据构造（接口实现）不同，验证器的执行策略也不同
    }
}
