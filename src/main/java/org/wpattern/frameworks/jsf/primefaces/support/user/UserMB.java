package org.wpattern.frameworks.jsf.primefaces.support.user;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;
import org.wpattern.frameworks.jsf.primefaces.model.UserEntity;
import org.wpattern.frameworks.jsf.primefaces.model.repositories.IUserRepository;
import org.wpattern.frameworks.jsf.primefaces.model.utils.BaseBeans;

// ConfigurableBeanFactory.SCOPE_SINGLETON, ConfigurableBeanFactory.SCOPE_PROTOTYPE,
// WebApplicationContext.SCOPE_REQUEST, WebApplicationContext.SCOPE_SESSION
@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Named(value = "userMB")
public class UserMB extends BaseBeans {

	private static final long serialVersionUID = 201404221641L;

	private static final Logger logger = Logger.getLogger(UserMB.class);

	@Inject
	private IUserRepository userRepository;

	private List<UserEntity> users;

	private UserEntity selectedUser;

	private Long id;

	public UserMB() {
	}

	public void onLoad() {
		this.users = this.userRepository.findAll();
	}

	public List<UserEntity> getUsers() {
		return this.users;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void delete() {
		if (this.selectedUser != null) {
			this.userRepository.delete(this.selectedUser.getId());
		}
	}

	public void selectUser(SelectEvent evt) {
		try {
			if (evt.getObject() != null) {
				this.selectedUser = (UserEntity) evt.getObject();
			} else {
				this.selectedUser = null;
			}
		} catch (Exception e) {
			this.selectedUser = null;

			logger.error(e.getMessage(), e);
		}
	}

	public void unselectUser() {
		this.selectedUser = null;
	}

	public UserEntity getSelectedUser() {
		return this.selectedUser;
	}

	public void setSelectedUser(UserEntity selectedUser) {
		this.selectedUser = selectedUser;
	}

}
