package com.apparel.model.entity.cart;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.util.CollectionUtils;

import com.apparel.model.entity.BaseEntity;

@Entity
@Table(name = "carts")
public class CartModel extends BaseEntity implements java.io.Serializable {

	@Fetch(FetchMode.SUBSELECT)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cart", cascade = CascadeType.ALL)
	private List<CartEntryModel> entries = new ArrayList<CartEntryModel>();

	@Transient
	private Integer totalQuantity;

	public List<CartEntryModel> getEntries() {
		return entries;
	}

	public void setEntries(List<CartEntryModel> entries) {
		this.entries = entries;
	}

	public Integer getTotalQuantity() {
		return CollectionUtils.isEmpty(entries) ?  0 : entries.size();
	}

	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

}