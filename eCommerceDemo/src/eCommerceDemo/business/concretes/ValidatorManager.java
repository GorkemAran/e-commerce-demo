package eCommerceDemo.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceDemo.business.abstracts.ValidationService;
import eCommerceDemo.entities.concretes.User;

public class ValidatorManager implements ValidationService {
	private User[] users;
	private User user;

	public ValidatorManager(User[] users, User user) {
		super();
		this.users = users;
		this.user = user;
	}

	@Override
	public boolean validateMail(String mail) {
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern path = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = path.matcher(mail);
		return matcher.find();
	}

	@Override
	public void isClicked(boolean click) {
		if (click) {
			System.out.println("Üyeliðiniz baþarýyla oluþturuldu !");
		} else {
			System.out.println("Üyeliðiniz oluþturulamadý !");
		}

	}

	@Override
	public boolean existMail(User[] users, User user) {
		for (User u : this.users) {
			if (u.getMail() == user.getMail()) {
				return true;
			}
		}
		return false;

	}
}
