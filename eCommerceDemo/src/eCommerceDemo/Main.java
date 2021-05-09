package eCommerceDemo;

import eCommerceDemo.business.concretes.UserManager;
import eCommerceDemo.business.concretes.ValidatorManager;
import eCommerceDemo.core.MailLogger;
import eCommerceDemo.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User[] users = { new User(1, "G�rkem", "Aran", "gorkemaran@hotmail.com", "12345"),
				new User(2, "Ali", "Veli", "aliveli@hotmail.com", "12345") };

		User user3 = new User();
		user3.setId(2);
		user3.setFirstName("Ay�e");
		user3.setLastName("G�ven");
		user3.setMail("grkemaran@hotmail.com");
		user3.setPassword("123547");

		UserManager userManager = new UserManager(new ValidatorManager(users, user3), new MailLogger());

		userManager.add(user3, users);

	}

}
