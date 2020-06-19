package com.ddstudy.reflect;

/**
 * @Classname Coder
 * @Description TODO
 * @Date 2020/6/19
 * @Author Grain Rain
 */
@Value("Coder")
public class Coder {

    private String name;

    protected int age;

    @Value("hello")
    public String description;

    int salary;

    private Coder(String name, int age, String description, int salary) {
        this.name = name;
        this.age = age;
        this.description = description;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coder() {
    }

    public static Coder newCoder() {
        return new Coder("Java", 20, "Java is well", 20);
    }

    public void say() {
        System.out.println("Hello World");
    }

    private String message(String message){
        return message;
    }

    @Override
    public String toString() {
        return "Coder{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", description='" + description + '\'' +
                ", salary=" + salary +
                '}';
    }
}
