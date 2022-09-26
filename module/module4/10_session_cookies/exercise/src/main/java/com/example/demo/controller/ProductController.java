package com.example.demo.controller;

import com.example.demo.dto.CartDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;
import com.example.demo.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@SessionAttributes("cart")//khai báo session tên là cart
@Controller

public class ProductController {

    @ModelAttribute("cart")
    public CartDto initCart() {

        return new CartDto();
    }

    @Autowired
    IProductService productService;

    @GetMapping("/")
    public ModelAndView showListPage(Model model){

        return new ModelAndView("/list", "productList", productService.findAll());
    }

    @GetMapping("detail/{id}")
    public ModelAndView showDetail(@PathVariable Long id,
                                   HttpServletResponse response) {
        Cookie cookie = new Cookie("idProduct", id + "");
        cookie.setMaxAge(1 * 24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
        return new ModelAndView("/detail",
                "product", productService.finById(id).get());

    }
    @GetMapping("/decrease/{id}")
    public String decreaseToCart(@PathVariable Long id, @SessionAttribute("cart") CartDto cart) {
        Optional<Product> productDetail = productService.finById(id);

        if (productDetail.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productDetail.get(), productDto);
            cart.decreaseProduct(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,

                            @SessionAttribute("cart") CartDto cart) {

        Optional<Product> productDetail = productService.finById(id);
        if (productDetail.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productDetail.get(), productDto);
            cart.addProduct(productDto);  //thêm sản phẩm vào giỏ hàng
        }
        return "redirect:/cart";

    }
}
