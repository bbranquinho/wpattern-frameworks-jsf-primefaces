package org.wpattern.frameworks.jsf.primefaces.support.category;

import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;
import org.wpattern.frameworks.jsf.primefaces.model.CategoryEntity;
import org.wpattern.frameworks.jsf.primefaces.model.repositories.ICategoryRepository;
import org.wpattern.frameworks.jsf.primefaces.model.utils.BaseBeans;


//ConfigurableBeanFactory.SCOPE_SINGLETON, ConfigurableBeanFactory.SCOPE_PROTOTYPE,
//WebApplicationContext.SCOPE_REQUEST, WebApplicationContext.SCOPE_SESSION
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Named(value = "categoryAddEditMB")
public class CategoryAddEditMB extends BaseBeans {

	private static final long serialVersionUID = 201311132355L;

	@Inject
	private ICategoryRepository categoryRepository;

	@Inject
	private CategoryMB mbCategoryBean;

	@Inject
	private FacesContext context;

	private CategoryEntity category;

	private String title;

	public CategoryAddEditMB() {
		this.category = new CategoryEntity();
	}

	public CategoryEntity getCategory() {
		return this.category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public void add() {
		this.title = this.getResourceProperty("labels", "category_add");
	}

	public void update() {
		this.category = this.mbCategoryBean.getSelectedCategory();
		this.title = this.getResourceProperty("labels", "category_update");
	}

	public void cancel() {
		this.mbCategoryBean.unselectCategory();
	}

	public void save() {
		if (this.category != null) {
			if (this.category.getId() == null) {
				// Add
				this.categoryRepository.save(this.category);
			} else {
				// Update
				this.categoryRepository.save(this.category);
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
