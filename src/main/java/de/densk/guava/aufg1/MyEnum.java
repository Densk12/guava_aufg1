package de.densk.guava.aufg1;

public enum MyEnum {
    ENUM_HELLO("Hello"),
    ENUM_WORLD("World");

    private final String msg;

    MyEnum(String msg) {
        this.msg = msg;
    }
}
