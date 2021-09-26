package com.apparel.model.dao.order;

import com.apparel.model.entity.catalog.ProductModel;
import com.apparel.model.entity.order.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface OrderRepository extends JpaRepository<OrderModel,Integer>, JpaSpecificationExecutor<OrderModel> {

        public OrderModel findOrderModelById(int id);

}
