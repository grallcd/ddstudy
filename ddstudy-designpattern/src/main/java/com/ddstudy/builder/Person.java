package com.ddstudy.builder;

/**
 * @Classname Person
 * @Description TODO
 * @Date 2020/6/28
 * @Author Grain Rain
 */
public class Person {

    private final String name;

    private final GenderEnum gender;

    private final String description;

    public Person(Builder builder) {
        this.name = builder.name;
        this.gender = builder.gender;
        this.description = builder.description;
    }

    public String getName() {
        return name;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", description='" + description + '\'' +
                '}';
    }

    public static class Builder {

        private final String name;

        private final GenderEnum gender;

        private String description;

        public Builder(String name, GenderEnum gender) {
            if (name == null || gender == null) {
                throw new IllegalArgumentException("name or gender can not be null");
            }
            this.name = name;
            this.gender = gender;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }
}
