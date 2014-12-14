package org.wpattern.frameworks.test.jsf.primefaces.repositories;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.wpattern.frameworks.jsf.primefaces.model.ProductEntity;
import org.wpattern.frameworks.jsf.primefaces.model.repositories.IProductRepository;
import org.wpattern.frameworks.test.jsf.primefaces.AbstractDatabaseTest;

public class ProductRepositoryTest extends AbstractDatabaseTest {

	private static final Logger LOGGER = Logger.getLogger(ProductRepositoryTest.class);

	@Inject
	private IProductRepository productRepository;

	@Test
	public void testProductRepository() {
		List<ProductEntity> products = this.productRepository.findAll();

		LOGGER.info(products);
	}

}
