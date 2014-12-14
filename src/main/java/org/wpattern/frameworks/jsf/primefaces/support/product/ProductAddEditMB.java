package org.wpattern.frameworks.jsf.primefaces.support.product;

import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;
import org.wpattern.frameworks.jsf.primefaces.model.ProductEntity;
import org.wpattern.frameworks.jsf.primefaces.model.repositories.IProductRepository;
import org.wpattern.frameworks.jsf.primefaces.model.utils.BaseBeans;


//ConfigurableBeanFactory.SCOPE_SINGLETON, ConfigurableBeanFactory.SCOPE_PROTOTYPE,
//WebApplicationContext.SCOPE_REQUEST, WebApplicationContext.SCOPE_SESSION
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Named(value = "productAddEditMB")
public class ProductAddEditMB extends BaseBeans {

	private static final long serialVersionUID = 201311132355L;

	@Inject
	private IProductRepository productRepository;

	@Inject
	private ProductMB mbProductBean;

	@Inject
	private FacesContext context;

	private ProductEntity product;

	private String title;

	public ProductAddEditMB() {
		this.product = new ProductEntity();
	}

	public ProductEntity getProduct() {
		return this.product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public void add() {
		this.title = this.getResourceProperty("labels", "product_add");
	}

	public void update() {
		this.product = this.mbProductBean.getSelectedProduct();
		this.title = this.getResourceProperty("labels", "product_update");
	}

	public void cancel() {
		this.mbProductBean.unselectProduct();
	}

	public void save() {
		if (this.product != null) {
			if (this.product.getId() == null) {
				// Add
				this.productRepository.save(this.product);
			} else {
				// Update
				this.productRepository.save(this.product);
			}
		}
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private String getResourceProperty(String resource, String label) {
		Application application = this.context.getApplication();
		ResourceBundle bundle = application.getResourceBundle(this.context, resource);

		return bundle.getString(label);
	}

}
