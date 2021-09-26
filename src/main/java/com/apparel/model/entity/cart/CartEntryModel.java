package com.apparel.model.entity.cart;

import javax.persistence.*;

import com.apparel.model.entity.BaseEntity;
import com.apparel.model.entity.catalog.ProductModel;

@Entity
@Table(name = "cart_entries")
public class CartEntryModel extends BaseEntity implements java.io.Serializable{ 	
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=CartModel.class)
	@JoinColumn(name = "cart_id")
	private CartModel cart;

	@Column(name = "productId")
	private int productId;


	private String description;
	
	public CartModel getCart() {
		return cart;
	}
	
	public void setCart(CartModel cart) {
		this.cart = cart;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
}