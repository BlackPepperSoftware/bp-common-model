package uk.co.blackpepper.common.model;

import static com.google.common.base.Preconditions.checkNotNull;

public class Credentials {

	private final String username;
	
	private final String password;

	public Credentials(String username, String password) {
		this.username = checkNotNull(username, "username");
		this.password = checkNotNull(password, "password");
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
