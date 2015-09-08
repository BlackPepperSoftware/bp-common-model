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

import java.util.Collections;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import static java.util.Arrays.asList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.emptyIterable;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IdentifiablesTest {

	private ExpectedException thrown = ExpectedException.none();

	@Rule
	public ExpectedException getThrown() {
		return thrown;
	}

	@Test
	public void getIdReturnsId() {
		assertThat(Identifiables.getId(newIdentifiable("x")), is("x"));
	}

	@Test
	public void getIdWithNullReturnsNull() {
		assertThat(Identifiables.getId(null), is(nullValue()));
	}

	@Test
	public void getIdsWithPersistentsReturnsIds() {
		Identifiable<String> persistent1 = newIdentifiable("x");
		Identifiable<String> persistent2 = newIdentifiable("y");

		assertThat(Identifiables.getIds(asList(persistent1, persistent2)), contains("x", "y"));
	}

	@Test
	public void getIdsWithTransientsReturnsNulls() {
		Identifiable<String> transient1 = newIdentifiable(null);
		Identifiable<String> transient2 = newIdentifiable(null);
		
		assertThat(Identifiables.getIds(asList(transient1, transient2)), contains(nullValue(), nullValue()));
	}
	
	@Test
	@SuppressFBWarnings("NP_NULL_PARAM_DEREF_NONVIRTUAL")
	public void getIdsWithNullThrowsException() {
		thrown.expect(NullPointerException.class);

		Identifiables.getIds(null);
	}

	@Test
	public void getTransientsWithTransientReturnsTransient() {
		Identifiable<String> tranzient = newIdentifiable(null);
		
		assertThat(Identifiables.getTransients(asList(tranzient)), contains(tranzient));
	}

	@Test
	public void getTransientsWithTransientsReturnsTransients() {
		Identifiable<String> transient1 = newIdentifiable(null);
		Identifiable<String> transient2 = newIdentifiable(null);
		
		assertThat(Identifiables.getTransients(asList(transient1, transient2)), contains(transient1, transient2));
	}

	@Test
	public void getTransientsWithPersistentReturnsEmpty() {
		Identifiable<String> persistent = newIdentifiable("x");
		
		assertThat(Identifiables.getTransients(asList(persistent)), is(emptyIterable()));
	}

	@Test
	public void getTransientsWithPersistentsReturnsEmpty() {
		Identifiable<String> persistent1 = newIdentifiable("x");
		Identifiable<String> persistent2 = newIdentifiable("y");
		
		assertThat(Identifiables.getTransients(asList(persistent1, persistent2)), is(emptyIterable()));
	}

	@Test
	public void getTransientsWithEmptyReturnsEmpty() {
		assertThat(Identifiables.getTransients(Collections.<Identifiable<?>>emptyList()), is(emptyIterable()));
	}

	@Test
	@SuppressFBWarnings("NP_NULL_PARAM_DEREF_NONVIRTUAL")
	public void getTransientsWithNullThrowsException() {
		thrown.expect(NullPointerException.class);

		Identifiables.getTransients(null);
	}

	@Test
	public void getPersistentsWithPeristentReturnsPersistent() {
		Identifiable<String> persistent = newIdentifiable("1");
		
		assertThat(Identifiables.getPersistents(asList(persistent)), contains(persistent));
	}

	@Test
	public void getPersistentsWithPeristentsReturnsPersistent() {
		Identifiable<String> persistent1 = newIdentifiable("1");
		Identifiable<String> persistent2 = newIdentifiable("2");
		
		assertThat(Identifiables.getPersistents(asList(persistent1, persistent2)), contains(persistent1, persistent2));
	}

	@Test
	public void getPersistentsWithTransientReturnsEmpty() {
		Identifiable<String> persistent = newIdentifiable(null);
		
		assertThat(Identifiables.getPersistents(asList(persistent)), is(emptyIterable()));
	}

	@Test
	public void getPersistentsWithTransientsReturnsEmpty() {
		Identifiable<String> persistent1 = newIdentifiable(null);
		Identifiable<String> persistent2 = newIdentifiable(null);
		
		assertThat(Identifiables.getPersistents(asList(persistent1, persistent2)), is(emptyIterable()));
	}

	@Test
	public void getPersistentsWithEmptyReturnsEmpty() {
		assertThat(Identifiables.getPersistents(Collections.<Identifiable<?>>emptyList()), is(emptyIterable()));
	}

	@Test
	@SuppressFBWarnings("NP_NULL_PARAM_DEREF_NONVIRTUAL")
	public void getPersistentsWithNullThrowsException() {
		thrown.expect(NullPointerException.class);

		Identifiables.getPersistents(null);
	}
	
	private static <T> Identifiable<T> newIdentifiable(T id) {
		Identifiable<T> identifiable = mock(Identifiable.class);
		when(identifiable.getId()).thenReturn(id);
		return identifiable;
	}
}
