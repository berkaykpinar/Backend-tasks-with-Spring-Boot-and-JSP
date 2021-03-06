package com.apparel.actions.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.apparel.model.entity.cart.CartModel;
import com.apparel.model.service.cart.CartService;

public abstract class BaseControl {

	@Autowired
	private CartService cartService;

	@ModelAttribute("miniCart")
	public CartModel cartData() {

		List<CartModel> list = cartService.findAll();

		return CollectionUtils.isEmpty(list) ? null : list.get(0) ;
	}

}
