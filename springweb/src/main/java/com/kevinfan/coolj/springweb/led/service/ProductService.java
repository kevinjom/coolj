package com.kevinfan.coolj.springweb.led.service;

import com.kevinfan.coolj.springweb.led.domain.Product;

public interface ProductService {
    Product get(long id);

    Long add(Product product);

    boolean delete(long id);

    boolean update(Product newProduct);
}
