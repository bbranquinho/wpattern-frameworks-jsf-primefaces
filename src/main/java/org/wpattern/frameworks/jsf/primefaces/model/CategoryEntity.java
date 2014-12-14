package org.wpattern.frameworks.jsf.primefaces.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.wpattern.frameworks.jsf.primefaces.model.utils.BaseEntities;

@Entity
@Table(name = "Categories")
@AttributeOverride(name = "id", column = @Column(name = "CategoryID"))
public class CategoryEntity extends BaseEntities<Long> {

	private static final long serialVersionUID = 201404120102L;

	private String categoryName;

	private String description;

	private Byte[] picture;

	public CategoryEntity() {
	}

	public CategoryEntity(String categoryName, String description, Byte[] picture) {
		super();
		this.categoryName = categoryName;
		this.description = description;
		this.picture = picture;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Byte[] getPicture() {
		return this.picture;
	}

	public void setPicture(Byte[] picture) {
		this.picture = picture;
	}

}
