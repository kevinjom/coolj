package com.kevinfan.coolj.springweb.led.service.impl;

import com.kevinfan.coolj.springweb.led.domain.Product;
import com.kevinfan.coolj.springweb.led.service.ProductService;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

public class ProductServiceImpl implements ProductService {
    private static final ConcurrentMap<Long, Product> products = new ConcurrentHashMap<Long, Product>();
    private static final AtomicLong                   counter  = new AtomicLong(0);

    @Override
    public Product get(long id) {
        return products.get(id);
    }

    @Override
    public Long add(Product product) {
        long id = counter.getAndIncrement();
        product.setId(id);
        products.put(id, product);
        return id;
    }

    @Override
    public boolean delete(long id) {
        return products.remove(id) != null;
    }

    @Override
    public boolean update(Product newProduct) {
        return products.put(newProduct.getId(), newProduct) != null;
    }
}
