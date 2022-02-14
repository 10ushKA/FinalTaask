package by.niitzi.bushylo.v3.entity;

import java.util.Objects;

public class Parameters {
    private int id;
    private int weight;
    private int height;
    private int age;

    public Parameters() {
    }

    public Parameters(int weight, int height, int age) {
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    public Parameters(int id, int weight, int height, int age) {
        this.id = id;
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parameters that = (Parameters) o;
        return id == that.id && weight == that.weight && height == that.height && age == that.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weight, height, age);
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "id=" + id +
                ", weight=" + weight +
                ", height=" + height +
                ", age=" + age +
                '}';
    }
}
