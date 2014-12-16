package com.kevinfan.coolj.springweb.led.web;

import com.kevinfan.coolj.springweb.led.domain.Product;
import com.kevinfan.coolj.springweb.led.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ModelAttribute
    public Product get(
            @PathVariable
            Long id) {
        return productService.get(id);
    }

    @RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
    public Long add(
            @RequestParam
            Product product) {
        return productService.add(product);
    }
}
