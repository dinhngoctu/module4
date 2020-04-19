package model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {
    @NotEmpty(message = "Thông tin này không được để trống")
    @Size(min = 2, max = 30,message = "do dai toi thieu 2 den 30")
    private String name;

    @Min(value = 8,message = "do dai toi thieu la 8")
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
