package uk.co.blackpepper.common.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CredentialsTest {

	@Test
	public void constructorSetsProperties() {
		Credentials actual = new Credentials("x", "y");

		assertThat("username", actual.getUsername(), is("x"));
		assertThat("password", actual.getPassword(), is("y"));
	}
	
	@Test(expected = NullPointerException.class)
	public void constructorWithNullUsernameThrowsException() {
		new Credentials(null, "x");
	}
	
	@Test(expected = NullPointerException.class)
	public void constructorWithNullPasswordThrowsException() {
		new Credentials("x", null);
	}
}
