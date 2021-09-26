package com.apparel.actions.controler;

import com.apparel.model.entity.catalog.ProductModel;
import com.apparel.model.entity.order.OrderModel;
import com.apparel.model.service.order.OrderService;
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
import java.util.List;
import java.util.Map;

@Controller
@EnableAsync
@ControllerAdvice
@RequestMapping(value = "/**/orders")
public class OrderPageController extends BaseControl {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String orders(HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {


        return "orders";
    }

    @RequestMapping(value = "/detail/{orderId}", method = RequestMethod.GET)
    public String detail(HttpServletRequest request, HttpServletResponse response, Model model, @PathVariable(value = "orderId") int orderId) throws ServletException, IOException {
        model.addAttribute("orderId", orderId);
        OrderModel orderModel = orderService.findOrderById(orderId);
        model.addAttribute("orderModel", orderModel);

        return "/orderDetails";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        orderService.save();
        response.sendRedirect("/orders");

    }

    @ModelAttribute("getOrders")
    public List<OrderModel> cartItems() {

        return orderService.findAll();
    }


}
