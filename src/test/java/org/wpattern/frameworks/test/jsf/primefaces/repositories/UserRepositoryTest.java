package org.wpattern.frameworks.test.jsf.primefaces.repositories;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.wpattern.frameworks.jsf.primefaces.model.UserEntity;
import org.wpattern.frameworks.jsf.primefaces.model.repositories.IUserRepository;
import org.wpattern.frameworks.test.jsf.primefaces.AbstractDatabaseTest;

public class UserRepositoryTest extends AbstractDatabaseTest {

	private static final Logger LOGGER = Logger.getLogger(UserRepositoryTest.class);

	@Inject
	private IUserRepository userRepository;

	@Test
	public void testCategoryRepository() {
		List<UserEntity> users = this.userRepository.findAll();

		LOGGER.info(users);
	}

}
