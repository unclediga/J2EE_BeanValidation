package ru.unclediga.inheritance;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Parent {
    @NotNull
    @Size(min = 2)
    String name;

    public Parent(String name) {
        this.name = name;
    }

    public String getName(@NotNull Integer age) {
        return "I am " + name + " and " + age + " years old";
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "name='" + name + '\'' +
                '}';
    }
}
