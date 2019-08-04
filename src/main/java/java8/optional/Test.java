package java8.optional;

import java.util.Optional;

public class Test {
    public String getCarInsuranceName(Optional<Person> person) {
        return person
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                //因为getName返回的是String而不是Optional类型，故使用map即可
                .map(Insurance::getName)
                //如果Optional的结果值为空，设置默认值
                .orElse("Unknown");
    }
}
