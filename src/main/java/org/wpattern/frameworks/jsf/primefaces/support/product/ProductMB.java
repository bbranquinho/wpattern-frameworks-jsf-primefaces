package org.wpattern.frameworks.jsf.primefaces.support.product;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;
import org.wpattern.frameworks.jsf.primefaces.model.ProductEntity;
import org.wpattern.frameworks.jsf.primefaces.model.repositories.IProductRepository;
import org.wpattern.frameworks.jsf.primefaces.model.utils.BaseBeans;

// ConfigurableBeanFactory.SCOPE_SINGLETON, ConfigurableBeanFactory.SCOPE_PROTOTYPE,
// WebApplicationContext.SCOPE_REQUEST, WebApplicationContext.SCOPE_SESSION
@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Named(value = "productMB")
public class ProductMB extends BaseBeans {

	private static final long serialVersionUID = 201404221641L;

	private static final Logger logger = Logger.getLogger(ProductMB.class);

	@Inject
	private IProductRepository productRepository;

	private List<ProductEntity> products;

	private ProductEntity selectedProduct;

	private Long id;

	public ProductMB() {
	}

	public void onLoad() {
		this.products = this.productRepository.findAll();
	}

	public List<ProductEntity> getProducts() {
		return this.products;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void delete() {
		if (this.selectedProduct != null) {
			this.productRepository.delete(this.selectedProduct.getId());
		}
	}

	public void selectProduct(SelectEvent evt) {
		try {
			if (evt.getObject() != null) {
				this.selectedProduct = (ProductEntity) evt.getObject();
			} else {
				this.selectedProduct = null;
			}
		} catch (Exception e) {
			this.selectedProduct = null;

			logger.error(e.getMessage(), e);
		}
	}

	public void unselectProduct() {
		this.selectedProduct = null;
	}

	public ProductEntity getSelectedProduct() {
		return this.selectedProduct;
	}

	public void setSelectedProduct(ProductEntity selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

}
