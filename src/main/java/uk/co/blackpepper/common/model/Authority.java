package uk.co.blackpepper.common.model;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public final class Authority {

	private final String name;

	public Authority(String name) {
		this.name = checkNotNull(name, "name");
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Authority)) {
			return false;
		}
		
		Authority authority = (Authority) object;
		
		return name.equals(authority.getName());
	}
	
	@Override
	public String toString() {
		return String.format("%s[name=%s]", getClass().getName(), name);
	}

	public static List<Authority> of(String... authorityNames) {
		List<Authority> authorities = new ArrayList<>();
		
		for (String authorityName : authorityNames) {
			authorities.add(new Authority(authorityName));
		}
		
		return authorities;
	}

	public static List<String> namesOf(Iterable<Authority> authorities) {
		List<String> authorityNames = new ArrayList<>();
		
		for (Authority authority : authorities) {
			authorityNames.add(authority.getName());
		}
		
		return authorityNames;
	}
}
