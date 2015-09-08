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

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;

import static com.google.common.base.Preconditions.checkNotNull;

public final class Identifiables {
	
	private Identifiables() {
		throw new AssertionError();
	}

	public static <T> T getId(Identifiable<T> identifiable) {
		return (identifiable != null) ? identifiable.getId() : null;
	}
	
	public static <T> List<T> getIds(Iterable<? extends Identifiable<T>> identifiables) {
		List<T> ids = new ArrayList<>();
		
		for (Identifiable<T> identifiable : identifiables) {
			ids.add(getId(identifiable));
		}
		
		return ids;
	}
	
	public static <T extends Identifiable<?>> Iterable<T> getTransients(Iterable<T> identifiables) {
		return Iterables.filter(identifiables, Predicates.not(arePersistent()));
	}
	
	public static <T extends Identifiable<?>> Iterable<T> getPersistents(Iterable<T> identifiables) {
		return Iterables.filter(identifiables, arePersistent());
	}
	
	private static <T extends Identifiable<?>> Predicate<T> arePersistent() {
		return new Predicate<T>() {
			@Override
			public boolean apply(T identifiable) {
				return checkNotNull(identifiable).getId() != null;
			}
		};
	}
}
