package org.wpattern.frameworks.jsf.primefaces.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wpattern.frameworks.jsf.primefaces.model.CategoryEntity;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
