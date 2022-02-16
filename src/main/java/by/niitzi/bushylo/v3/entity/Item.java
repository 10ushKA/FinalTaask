package by.niitzi.bushylo.v3.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
@Getter
@Setter
@EqualsAndHashCode
public class Item {
    private int id;
    private String color;
    private Type type;
    private String size;
    private String creator;

    public Item() {
    }

    public Item(int id, String color, Type type, String size, String creator) {
        this.id = id;
        this.color = color;
        this.type = type;
        this.size = size;
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", type=" + type +
                ", size='" + size + '\'' +
                ", creator='" + creator + '\'' +
                '}';
    }
}
