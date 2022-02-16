package by.niitzi.bushylo.v3.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
@Getter
@Setter
@EqualsAndHashCode
public class Type {
    private int id;
    private String name;

    public Type() {
    }

    public Type(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
