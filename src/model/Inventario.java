package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inventario {

    private final List<String> items;

    public Inventario() {
        this.items = new ArrayList<>();
    }

    private Inventario(List<String> items) {
        this.items = new ArrayList<>(items);
    }

    public void agregarItem(String item) {
        items.add(item);
    }

    public List<String> getItems() {
        return Collections.unmodifiableList(items);
    }

    public Inventario copiar() {
        return new Inventario(this.items);
    }

    @Override
    public String toString() {
        return items.toString();
    }
}