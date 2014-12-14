package org.wpattern.frameworks.jsf.primefaces.model.utils;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.AbstractPersistable;

public abstract class BaseEntities<PK extends Serializable> extends AbstractPersistable<PK> implements Serializable {

	private static final long serialVersionUID = -5377726703339445533L;

	@Override
	public void setId(PK id) {
		super.setId(id);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

}
