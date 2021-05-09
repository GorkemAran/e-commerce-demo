package eCommerceDemo.business.abstracts;

import eCommerceDemo.entities.concretes.User;

public interface ValidationService {
	boolean existMail(User[] users, User user);

	boolean validateMail(String mail);

	void isClicked(boolean click);
}
