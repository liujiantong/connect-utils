/**
 * Copyright (C) 2016 Jeremy Custenborder (jcustenborder@gmail.com)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.confluent.kafka.connect.utils.config;

import org.junit.Test;

public class ValidPatternTests {

  @Test
  public void ensureValid() {
    ValidPattern validPattern = ValidPattern.of(".*\\.csv$");
    validPattern.ensureValid("file.name", "testing.csv");
  }

  @Test(expected = IllegalStateException.class)
  public void ensureValidInvalid() {
    ValidPattern validPattern = ValidPattern.of(".*\\.csv$");
    validPattern.ensureValid("file.name", "testing.txt");
  }

  @Test(expected = NullPointerException.class)
  public void ensureValidNullString() {
    ValidPattern validPattern = ValidPattern.of(".*\\.csv$");
    validPattern.ensureValid("file.name", null);
  }

  @Test(expected = IllegalStateException.class)
  public void ensureValidNonString() {
    ValidPattern validPattern = ValidPattern.of(".*\\.csv$");
    validPattern.ensureValid("file.name", new Integer(1));
  }
}
