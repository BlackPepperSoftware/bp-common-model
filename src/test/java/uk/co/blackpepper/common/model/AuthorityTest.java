/*
 * Copyright 2014 Black Pepper Software
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.co.blackpepper.common.model;

import java.util.List;

import org.junit.Test;

import static java.util.Arrays.asList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class AuthorityTest {

	@Test
	public void constructorWithNameSetsProperties() {
		Authority actual = new Authority("x");
		
		assertThat(actual.getName(), is("x"));
	}

	@Test(expected = NullPointerException.class)
	public void constructorWithNullThrowsException() {
		new Authority(null);
	}

	@Test
	public void hashCodeWhenEqualReturnsEqual() {
		Authority authority1 = new Authority("x");
		Authority authority2 = new Authority("x");
		
		assertThat(authority1.hashCode(), is(authority2.hashCode()));
	}

	@Test
	public void equalsWithEqualReturnsTrue() {
		Authority authority1 = new Authority("x");
		Authority authority2 = new Authority("x");
		
		assertThat(authority1.equals(authority2), is(true));
	}

	@Test
	public void equalsWithDifferentNameReturnsFalse() {
		Authority authority1 = new Authority("x");
		Authority authority2 = new Authority("y");
		
		assertThat(authority1.equals(authority2), is(false));
	}

	@Test
	public void toStringReturnsString() {
		Authority authority = new Authority("x");
		
		assertThat(authority.toString(), is("uk.co.blackpepper.common.model.Authority[name=x]"));
	}

	@Test
	public void ofWithNamesReturnsAuthorities() {
		List<Authority> actual = Authority.of("x", "y");

		assertThat(actual, contains(new Authority("x"), new Authority("y")));
	}
	
	@Test
	public void namesOfWithAuthoritiesReturnsNames() {
		List<String> actual = Authority.namesOf(asList(new Authority("x"), new Authority("y")));
		
		assertThat(actual, contains("x", "y"));
	}
}
