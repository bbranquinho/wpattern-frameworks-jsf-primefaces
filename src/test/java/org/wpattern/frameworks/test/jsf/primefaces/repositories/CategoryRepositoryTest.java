package org.wpattern.frameworks.test.jsf.primefaces.repositories;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.wpattern.frameworks.jsf.primefaces.model.CategoryEntity;
import org.wpattern.frameworks.jsf.primefaces.model.repositories.ICategoryRepository;
import org.wpattern.frameworks.test.jsf.primefaces.AbstractDatabaseTest;

public class CategoryRepositoryTest extends AbstractDatabaseTest {

	private static final Logger LOGGER = Logger.getLogger(CategoryRepositoryTest.class);

	@Inject
	private ICategoryRepository categoryRepository;

	@Test
	public void testCategoryRepository() {
		List<CategoryEntity> categories = this.categoryRepository.findAll();

		LOGGER.info(categories);
	}

}
