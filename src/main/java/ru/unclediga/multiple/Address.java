package ru.unclediga.multiple;

import javax.validation.constraints.Pattern;

public class Address {
    AddressType type;
    @Pattern.List({
            @Pattern(regexp = "([A-Z0-9]{4}-){3}[A-Z0-9]{4}", groups = AddressType.FIASGROUP.class),
            @Pattern(regexp = "[0-9]{15}", groups = AddressType.KLADRGROUP.class)
    })
    String code;

    public Address(AddressType type, String code) {
        this.type = type;
        this.code = code;
    }

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Address{" +
                "type=" + type +
                ", code='" + code + '\'' +
                '}';
    }
}
