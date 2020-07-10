package ru.unclediga.inheritance;

import javax.validation.constraints.Min;

public class ChildOne extends Parent {
    @Min(16)
    private Integer age;

    @Override
    public String getName(@Min(45) Integer age) {
        return "My name is " + name + " ," + (age == null ? this.age : age) + " years old";
    }

    public ChildOne(String name, Integer age) {
        super(name);
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ChildOne{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
