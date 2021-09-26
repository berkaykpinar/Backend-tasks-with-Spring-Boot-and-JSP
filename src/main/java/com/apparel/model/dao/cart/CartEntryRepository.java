package com.apparel.model.dao.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import com.apparel.model.entity.cart.CartEntryModel;

import java.util.List;

@Transactional
public interface CartEntryRepository extends JpaRepository<CartEntryModel, Integer>, JpaSpecificationExecutor<CartEntryModel>{

    List<CartEntryModel> getCartEntryModelsByCart_Id(int cartId);

    public void deleteByProductId(int id);

    public void deleteAllByCart_Id(int cartId);
}
