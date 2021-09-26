package com.apparel.model.entity.order;

import com.apparel.model.entity.BaseEntity;
import com.apparel.model.entity.catalog.ProductModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderModel extends BaseEntity implements java.io.Serializable {

    @Column(name = "total")
    private double total;

    @Column(name = "discount")
    private double discount;

    @Column(name = "discounted")
    private double discountedAmount;

    @Column(name = "tax")
    private double taxAmount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
    private List<ProductModel> products;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscountedAmount() {
        return discountedAmount;
    }

    public void setDiscountedAmount(double discountedAmount) {
        this.discountedAmount = discountedAmount;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }


    public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }


}
