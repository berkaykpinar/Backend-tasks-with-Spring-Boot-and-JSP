package com.apparel.actions.controler;

import javax.servlet.http.HttpServletRequest;

import com.apparel.model.entity.cart.CartEntryModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.apparel.model.entity.catalog.ProductModel;
import com.apparel.model.service.catalog.ProductService;

import java.util.List;

@Controller
@EnableAsync
@ControllerAdvice
@RequestMapping(value = "/**/p")
public class ProductPageControler extends BaseControl {

    static Logger LOGGER = LoggerFactory.getLogger(ProductPageControler.class);

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/{productCode}", method = RequestMethod.GET)
    public String detail(Model model, HttpServletRequest servletRequest, @PathVariable(value = "productCode") String productCode) {
        model.addAttribute("productCode", productCode);
        ProductModel product = productService.findByCode(productCode);
        model.addAttribute("product", product);
        return "/product";
    }

    @RequestMapping(value = "/{productCode}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ProductModel productDetail(Model model, HttpServletRequest servletRequest, @PathVariable(value = "productCode") String productCode) {

        ProductModel product = productService.findByCode(productCode);

        return product;
    }


}