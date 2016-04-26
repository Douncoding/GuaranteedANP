package com.douncoding.guaranteedanp.dto;

/**
 * 강의
 */
public class Lesson implements Model {

    private String name;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void serialization() {

    }

    @Override
    public void deserialization() {

    }
}
