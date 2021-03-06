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
