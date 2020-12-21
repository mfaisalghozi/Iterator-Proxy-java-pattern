package Users;

import java.util.ArrayList;
import java.util.Iterator;

import iterators.UserIterator;
import proxy.UserProxy;

public class UserMenu implements UserIterator,UserProxy {
	
	private ArrayList<User> users;
	
	public UserMenu() {
		this.users = new ArrayList<>();
	}
	
	public void addUser(String name, String email, String password, String currentJob, String companyName, String desc, int age) {
		this.users.add(new User(name,email,password,currentJob,companyName,desc,age));
	}
	
	@Override
	public Iterator createIterator() {
		return users.iterator();
	}

	@Override
	public User Validate(String email, String password) {
		for (User user : users) {
			if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

}
