package com.apparel.model.service.order;

import com.apparel.model.dao.catalog.ProductRepository;
import com.apparel.model.dao.order.OrderRepository;
import com.apparel.model.entity.cart.CartEntryModel;
import com.apparel.model.entity.catalog.ProductModel;
import com.apparel.model.entity.order.OrderModel;
import com.apparel.model.service.cart.CartEntryService;
import com.apparel.model.service.catalog.ProductService;
import com.apparel.model.service.catalog.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    final private int cartId = 1;
    @Autowired
    private CartEntryService cartEntryService;

    @Autowired
    private ProductService productService;

    @Resource
    private OrderRepository dao;

    @Resource
    private ProductRepository productDao;

    @Override
    public void save() {
        OrderModel order = new OrderModel();
        order.setTaxAmount(cartEntryService.getTotalCartAmount(cartId).getTaxAmount());
        order.setTotal(cartEntryService.getTotalCartAmount(cartId).getTotal());
        order.setDiscount(cartEntryService.getTotalCartAmount(cartId).getDiscount());
        order.setDiscountedAmount(cartEntryService.getTotalCartAmount(cartId).getDiscountedAmount());

        List<ProductModel> orderProducts = new ArrayList<ProductModel>();
        for (CartEntryModel cartEntryModel : cartEntryService.getProductsByCartId(cartId)) {
            ProductModel productModel = productService.findByCode("" + cartEntryModel.getProductId());
            orderProducts.add(productModel);
        }
        order.setProducts(orderProducts);
        dao.save(order);
        cartEntryService.deleteAllByCartId(cartId);

        for (ProductModel productModel : dao.findOne(order.getId()).getProducts()) {
            System.out.println(productModel.getName());
        }

    }

    @Override
    public List<OrderModel> findAll() {
        return dao.findAll();
    }

    @Override
    public OrderModel findOrderById(int id) {
        return dao.findOne(id);
    }

    @Override
    public List<ProductModel> findOrderProducts(int id) {

        return dao.findOne(id).getProducts();
    }


}
