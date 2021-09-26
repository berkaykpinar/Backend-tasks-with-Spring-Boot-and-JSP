package com.apparel;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import com.apparel.model.entity.cart.CartModel;
import com.apparel.model.service.cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apparel.model.entity.catalog.CategoryModel;
import com.apparel.model.entity.catalog.ProductModel;
import com.apparel.model.service.catalog.CategoryService;
import com.apparel.model.service.catalog.ProductService;

@Component
public class DataLoader {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;

    @PostConstruct
    public void loadInitialData() {


        CartModel cartModel1 = new CartModel();
        cartModel1.setId(1);
        cartService.save(cartModel1);

        CategoryModel c = new CategoryModel();
        c.setCode("1");
        c.setName("Kadın");
        categoryService.save(c);


        ProductModel p = new ProductModel();
        p.setCode("1");
        p.setName("Kırmızı Elbise");
        p.setDescription("Kırmızı Elbise Desc");
        p.setPrice(80d);
        p.setCategories(Arrays.asList(c));

        productService.save(p);


        ProductModel p2 = new ProductModel();
        p2.setCode("2");
        p2.setName("Mavi Elbise");
        p2.setDescription("Mavi Elbise Desc");
        p2.setPrice(50d);
        p2.setCategories(Arrays.asList(c));

        productService.save(p2);


        ProductModel p3 = new ProductModel();
        p3.setCode("3");
        p3.setName("Siyah Elbise");
        p3.setDescription("Siyah Elbise Desc");
        p3.setPrice(170d);
        p3.setCategories(Arrays.asList(c));

        productService.save(p3);

        ProductModel p4 = new ProductModel();
        p4.setCode("4");
        p4.setName("Mor Elbise");
        p4.setDescription("Mor Elbise Desc");
        p4.setPrice(140d);
        p4.setCategories(Arrays.asList(c));

        productService.save(p4);

        ProductModel p5 = new ProductModel();
        p5.setCode("5");
        p5.setName("Sarı Elbise");
        p5.setDescription("Sarı Elbise Desc");
        p5.setPrice(120d);
        p5.setCategories(Arrays.asList(c));

        productService.save(p5);

        ProductModel p6 = new ProductModel();
        p6.setCode("6");
        p6.setName("Kolye");
        p6.setDescription("Kolye Desc");
        p6.setPrice(20d);
        p6.setCategories(Arrays.asList(c));

        productService.save(p6);
        ProductModel p7 = new ProductModel();
        p7.setCode("7");
        p7.setName("Bileklik");
        p7.setDescription("Bileklik Desc");
        p7.setPrice(15d);
        p7.setCategories(Arrays.asList(c));

        productService.save(p7);

        ProductModel p8 = new ProductModel();
        p8.setCode("8");
        p8.setName("Küpe");
        p8.setDescription("Küpe Desc");
        p8.setPrice(30d);
        p8.setCategories(Arrays.asList(c));

        productService.save(p8);

        ProductModel p9 = new ProductModel();
		p9.setCode("9");
		p9.setName("Saç Tokası");
		p9.setDescription("Saç Tokası Desc");
		p9.setPrice(3d);
		p9.setCategories(Arrays.asList(c));

        productService.save(p9);
    }


}