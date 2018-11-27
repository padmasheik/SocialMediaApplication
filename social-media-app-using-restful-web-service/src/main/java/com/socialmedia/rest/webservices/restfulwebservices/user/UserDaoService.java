package com.socialmedia.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static int userscount = 3;
	private static List<User> users = new ArrayList<>();
	static {
		users.add(new User(1, "padma", new Date()));
		users.add(new User(2, "saleem", new Date()));
		users.add(new User(3, "Akil", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++userscount);
		}
		users.add(user);
		return user;
	}

	public User findOne(Integer id) {
		for (User user : users) {
			if (user.getId() == id)
				return user;
		}
		return null;

	}

	public User deleteById(Integer id) {
		ListIterator<User> userIterator = users.listIterator();
		while (userIterator.hasNext()) {
			User user = userIterator.next();
			if (user.getId() == id) {
				userIterator.remove();
				return user;
			}
		}
		return null;

	}

}
