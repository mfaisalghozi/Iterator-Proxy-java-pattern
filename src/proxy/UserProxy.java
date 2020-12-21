package proxy;

import Users.User;

public interface UserProxy {
	public User Validate(String username, String password);
}
