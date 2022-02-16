package by.niitzi.bushylo.v3.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
@Getter
@Setter
@EqualsAndHashCode
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
