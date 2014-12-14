package org.wpattern.frameworks.jsf.primefaces.model;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.wpattern.frameworks.jsf.primefaces.model.utils.BaseEntities;

@Entity
@Table(name="Products")
@AttributeOverride(name = "id", column = @Column(name = "ProductID"))
public class ProductEntity extends BaseEntities<Long> {

	private static final long serialVersionUID = 201404120102L;

	private String productName;

	private String quantityPerUnit;

	private BigDecimal unitPrice;

	private Short unitsInStock;

	private Short unitsOnOrder;

	private Short reorderLevel;

	private boolean discontinued;

	private Long categoryId;

	public ProductEntity() {
	}

	public ProductEntity(String productName, String quantityPerUnit, BigDecimal unitPrice,
			Short unitsInStock, Short unitsOnOrder, Short reorderLevel, boolean discontinued,
			Long categoryId) {
		super();
		this.productName = productName;
		this.quantityPerUnit = quantityPerUnit;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.unitsOnOrder = unitsOnOrder;
		this.reorderLevel = reorderLevel;
		this.discontinued = discontinued;
		this.categoryId = categoryId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getQuantityPerUnit() {
		return this.quantityPerUnit;
	}

	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Short getUnitsInStock() {
		return this.unitsInStock;
	}

	public void setUnitsInStock(Short unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public Short getUnitsOnOrder() {
		return this.unitsOnOrder;
	}

	public void setUnitsOnOrder(Short unitsOnOrder) {
		this.unitsOnOrder = unitsOnOrder;
	}

	public Short getReorderLevel() {
		return this.reorderLevel;
	}

	public void setReorderLevel(Short reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public boolean isDiscontinued() {
		return this.discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}

	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

}
