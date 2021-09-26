package com.apparel.model.dao.cart;

import com.apparel.model.entity.cart.CartEntryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import com.apparel.model.entity.cart.CartModel;

import java.util.List;

@Transactional
public interface CartRepository extends JpaRepository<CartModel, Integer>, JpaSpecificationExecutor<CartModel>{

	
}
