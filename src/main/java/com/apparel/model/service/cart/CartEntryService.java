package com.apparel.model.service.cart;

import java.util.List;
import java.util.Map;

import com.apparel.model.entity.cart.CartModel;
import com.apparel.model.entity.catalog.ProductModel;
import com.apparel.model.entity.order.OrderModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import com.apparel.model.entity.cart.CartEntryModel;

public interface CartEntryService {

	public void save(CartModel cartModel,int productId);
	
	public CartEntryModel update(CartEntryModel CartEntry);
 
	public void delete(Integer id);

	public void deleteAllByCartId(int cartId);

	public List<CartEntryModel> findAll();
 
	public CartEntryModel findById(Integer id);

	public void flush();
 
	public Page<CartEntryModel> search(PageRequest request, Specification<CartEntryModel> search);
	
	public List<CartEntryModel> search(Specification<CartEntryModel> search);
	
	public Page<CartEntryModel> search(PageRequest request);

	public List<CartEntryModel> getProductsByCartId(int id);

	public OrderModel getTotalCartAmount(int id);

	public Map<ProductModel,Integer> getCartItemList();
	
}