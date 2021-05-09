package eCommerceDemo.business.concretes;

import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.business.abstracts.ValidationService;
import eCommerceDemo.core.Logger;
import eCommerceDemo.entities.concretes.User;

public class UserManager implements UserService{
	ValidationService validationService;
	Logger logger;

	public UserManager(ValidationService validationService, Logger logger) {
		super();
		this.validationService = validationService;
		this.logger = logger;
	}

	@Override
	public void add(User user, User[] users) {
		if (user.getFirstName().length() >= 2 && user.getLastName().length() >= 2 && user.getPassword().length() >= 6
				&& validationService.validateMail(user.getMail())) {
			if (validationService.existMail(users, user)) {
				System.out.println("Bu mail sistemde kayýtlý !");
			} else {
				logger.log();
				System.out.println("Lütfen aktivasyon mailini onaylayýnýz.");
				validationService.isClicked(true);
			}

		} else {
			System.out.println("Geçersiz bilgi girdiniz !");
		}

	}
}
