package com.apparel.model.service.order;

import com.apparel.model.entity.catalog.ProductModel;
import com.apparel.model.entity.order.OrderModel;

import java.util.List;

public interface OrderService {
    public void save();
    public List<OrderModel> findAll();
    public OrderModel findOrderById(int id);
    public List<ProductModel> findOrderProducts(int id);
}
