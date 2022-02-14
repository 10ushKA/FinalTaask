package by.niitzi.bushylo.v3.entity;

import java.util.Objects;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && Objects.equals(color, item.color) && Objects.equals(type, item.type) && Objects.equals(size, item.size) && Objects.equals(creator, item.creator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, color, type, size, creator);
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
