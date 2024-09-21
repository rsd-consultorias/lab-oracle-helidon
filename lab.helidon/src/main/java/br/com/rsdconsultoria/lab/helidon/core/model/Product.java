package br.com.rsdconsultoria.lab.helidon.core.model;

import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    private String category;

    public Product(String name, String category) {
        setId(UUID.randomUUID());
        setName(name);
        setCategory(category);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
