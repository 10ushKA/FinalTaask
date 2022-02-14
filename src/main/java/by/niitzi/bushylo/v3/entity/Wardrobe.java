package by.niitzi.bushylo.v3.entity;

import java.util.List;
import java.util.Objects;

public class Wardrobe {
    private int id;
    private String name;
    private int volume;
    private List<Item> items;

    public Wardrobe() {
    }

    public Wardrobe(int id, String name, int volume, List<Item> items) {
        this.id = id;
        this.name = name;
        this.volume = volume;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wardrobe wardrobe = (Wardrobe) o;
        return id == wardrobe.id && volume == wardrobe.volume && Objects.equals(name, wardrobe.name) && Objects.equals(items, wardrobe.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, volume, items);
    }

    @Override
    public String toString() {
        return "Wardrobe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", volume=" + volume +
                ", items=" + items +
                '}';
    }
}
