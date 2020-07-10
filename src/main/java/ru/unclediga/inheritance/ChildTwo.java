package ru.unclediga.inheritance;

import javax.validation.constraints.Size;

public class ChildTwo extends Parent {
    @Size(min = 10)
    private String name;

    public ChildTwo(String name1, String name2) {
        super(name1);
        this.name = name2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ChildTwo{" +
                "super.name='" + super.name + '\'' +
                ", this.name='" + this.name + '\'' +
                '}';
    }
}
