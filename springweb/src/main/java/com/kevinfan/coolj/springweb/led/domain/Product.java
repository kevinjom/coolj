package com.kevinfan.coolj.springweb.led.domain;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 5670453510020339017L;

    private Long   id;
    private String type;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }

        Product product = (Product) o;

        if (!id.equals(product.id)) {
            return false;
        }
        if (!name.equals(product.name)) {
            return false;
        }
        if (!type.equals(product.type)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
