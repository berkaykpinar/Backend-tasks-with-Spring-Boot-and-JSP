package com.apparel.model.service.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.apparel.model.entity.cart.CartModel;
import com.apparel.model.entity.catalog.ProductModel;
import com.apparel.model.entity.order.OrderModel;
import com.apparel.model.service.catalog.ProductService;
import com.apparel.model.service.catalog.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apparel.model.dao.cart.CartEntryRepository;
import com.apparel.model.entity.cart.CartEntryModel;

@Service
@Transactional
public class CartEntryServiceImpl implements CartEntryService {

    @Resource
    private CartEntryRepository dao;

    @Autowired
    private ProductService productService;




    @Override
    public void delete(Integer id) {
        dao.deleteByProductId(id);
    }

    @Override
    public void deleteAllByCartId(int cartId) {
        dao.deleteAllByCart_Id(cartId);
    }

    @Override
    public List<CartEntryModel> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional
    public CartEntryModel findById(Integer id) {
        return dao.findOne(id);
    }

    @Override
    public void flush() {
        dao.flush();
    }

    @Override
    public void save(CartModel cartModel, int productId) {
        CartEntryModel cartEntryModel = new CartEntryModel();
        cartEntryModel.setCart(cartModel);
        cartEntryModel.setProductId(productId);
        dao.save(cartEntryModel);
    }

    @Override
    public CartEntryModel update(CartEntryModel CartEntryModel) {
        dao.save(CartEntryModel);
        return CartEntryModel;
    }


    @Override
    public Page<CartEntryModel> search(PageRequest request, Specification<CartEntryModel> search) {
        return dao.findAll(search, request);
    }


    @Override
    public Page<CartEntryModel> search(PageRequest request) {
        Page<CartEntryModel> list = dao.findAll(request);
        return list;
    }

    @Override
    public List<CartEntryModel> getProductsByCartId(int id) {
        List<CartEntryModel> l1 = dao.getCartEntryModelsByCart_Id(id);

        return l1;
    }

    @Override
    public OrderModel getTotalCartAmount(int id) {
        OrderModel orderModel = new OrderModel();
        double total = 0;
        int dressCount = 0;
        double cheapest = 1000000d;
        double percentDiscount = 0;
        double maxDiscount = 0;
        double tax = 0;
        double discountedTotal;
        List<CartEntryModel> l1 = dao.getCartEntryModelsByCart_Id(id);
        for (CartEntryModel c : l1) {
            ProductModel product = productService.findByCode("" + c.getProductId());
            if (product.getName().contains("Elbise")) {
                if (product.getPrice() < cheapest) {
                    cheapest = product.getPrice();
                }
                dressCount++;
            }
            total += product.getPrice();
        }

        if (dressCount >= 3) {
            maxDiscount = cheapest;
        }
        if (total > 200) {
            percentDiscount = total * 0.2;
        }

        if (percentDiscount > maxDiscount) {
            maxDiscount = percentDiscount;
        }

        discountedTotal = total - maxDiscount;
        tax = discountedTotal * 0.18;
        discountedTotal += tax;

        orderModel.setDiscount(maxDiscount);
        orderModel.setTaxAmount(tax);
        orderModel.setDiscountedAmount(discountedTotal);
        orderModel.setTotal(total);
        return orderModel;
    }

    @Override
    public Map<ProductModel, Integer> getCartItemList() {
        Map<ProductModel, Integer> productModelList = new HashMap<ProductModel, Integer>();


        for (CartEntryModel c1 : getProductsByCartId(1)) {
            String productId = "" + c1.getProductId();
            boolean gate = false;

            for (Map.Entry<ProductModel, Integer> p1 : productModelList.entrySet()) {
                if (c1.getProductId() == p1.getKey().getId()) {
                    int currValue = p1.getValue();
                    currValue += 1;
                    productModelList.put(productService.findByCode(productId), currValue);
                    gate = true;
                }
            }
            if (gate == false) {
                productModelList.put(productService.findByCode(productId), 1);
            }

        }

        return productModelList;
    }


    @Override
    public List<CartEntryModel> search(Specification<CartEntryModel> search) {
        return dao.findAll(search);
    }

}
