package com.apparel.actions.controler;


import com.apparel.model.entity.cart.CartEntryModel;
import com.apparel.model.entity.cart.CartModel;
import com.apparel.model.entity.catalog.ProductModel;
import com.apparel.model.entity.order.OrderModel;
import com.apparel.model.service.cart.CartEntryService;
import com.apparel.model.service.cart.CartService;
import com.apparel.model.service.catalog.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@EnableAsync
@ControllerAdvice
@RequestMapping(value = "/**/cart")
public class CartPageController extends BaseControl {

    final private int cartId = 1;
    @Autowired
    private CartEntryService cartEntryService;

    @Autowired
    private CartService cartService;


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("id"));
        cartEntryService.save(cartService.findById(cartId), productId);
        response.sendRedirect("c/1");

    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detail(HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {

        return "/cart";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        cartEntryService.delete(id);

        response.sendRedirect("/cart/detail");

    }

    @ModelAttribute("totalAmount")
    public OrderModel getAmount() {

        return cartEntryService.getTotalCartAmount(cartId);
    }

    @ModelAttribute("cartItems")
    public Map<ProductModel, Integer> cartItems() {

        return cartEntryService.getCartItemList();
    }


}
