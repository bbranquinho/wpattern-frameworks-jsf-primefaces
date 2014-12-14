package org.wpattern.frameworks.jsf.primefaces.support.category;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;
import org.wpattern.frameworks.jsf.primefaces.model.CategoryEntity;
import org.wpattern.frameworks.jsf.primefaces.model.repositories.ICategoryRepository;
import org.wpattern.frameworks.jsf.primefaces.model.utils.BaseBeans;

// ConfigurableBeanFactory.SCOPE_SINGLETON, ConfigurableBeanFactory.SCOPE_PROTOTYPE,
// WebApplicationContext.SCOPE_REQUEST, WebApplicationContext.SCOPE_SESSION
@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Named(value = "categoryMB")
public class CategoryMB extends BaseBeans {

	private static final long serialVersionUID = 201404221641L;

	private static final Logger logger = Logger.getLogger(CategoryMB.class);

	@Inject
	private ICategoryRepository categoryRepository;

	private List<CategoryEntity> categories;

	private CategoryEntity selectedCategory;

	private Long id;

	public CategoryMB() {
	}

	public void onLoad() {
		this.categories = this.categoryRepository.findAll();
	}

	public List<CategoryEntity> getCategories() {
		return this.categories;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void delete() {
		if (this.selectedCategory != null) {
			this.categoryRepository.delete(this.selectedCategory.getId());
		}
	}

	public void selectCategory(SelectEvent evt) {
		try {
			if (evt.getObject() != null) {
				this.selectedCategory = (CategoryEntity) evt.getObject();
			} else {
				this.selectedCategory = null;
			}
		} catch (Exception e) {
			this.selectedCategory = null;

			logger.error(e.getMessage(), e);
		}
	}

	public void unselectCategory() {
		this.selectedCategory = null;
	}

	public CategoryEntity getSelectedCategory() {
		return this.selectedCategory;
	}

	public void setSelectedCategory(CategoryEntity selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

}
