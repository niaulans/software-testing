# Java Web UI Path

## Junit5 Tests

### Test Annotations

- **@Test**: tag to indicate a method is a test case.
- **@DisplayName**: tag to provide a custom name for the test case, useful for documentation and readability.
- **@BeforeAll**: tag to indicate a method that should be run once before all tests in the class. Must be static, as it is run before any instance of the test class is created.
- **@AfterAll**: tag to indicate a method that should be run once after all tests in the class. Must be static, as it is run after all instances of the test class have been created.
- **@BeforeEach**: tag to indicate a method that should be run before each test case in the class.
- **@AfterEach**: tag to indicate a method that should be run after each test case in the class.

<br>

- **@TestInstance(TestInstance.Lifecycle.PER_CLASS)**: allows the use of non-static methods for `@BeforeAll` and `@AfterAll` by changing the lifecycle of the test instance to per class instead of per method.
- **@TestInstance(TestInstance.Lifecycle.PER_METHOD)**: the default lifecycle, where a new instance of the test class is created for each test method.

<br>

- **@ValueSource**: used to provide multiple sets of parameters to a test method, allowing for parameterized tests.
  Example: `@ValueSource(int s = {1, 2, 3})` will run the test method three times with the values 1, 2, and 3.
- **@ParameterizedTest**: used to indicate that a test method is parameterized and can be run multiple times with different parameters.
- **EmptySource**: used to provide an empty set of parameters to a test method.
- **NullSource**: used to provide a null value as a parameter to a test method.
- **@NullAndEmptySource**: used to provide both null and empty values as parameters to a test method. It cannot be used with primitive types like `int`, `double`, etc., as they cannot be null.
- **@CsvSource**: used to provide parameters from a CSV file, allowing for more complex parameterized tests with multiple values per test case.
- **@CsvFileSource**: used to provide parameters from a CSV file located in the resources directory, allowing for externalized test data. "" -> empty string, empty -> null.
- **@MethodSource**: used to provide parameters from a method that returns a stream of arguments, allowing for dynamic parameterized tests. Method must be static and return a `Stream<Arguments>` or `Stream<T>`.

### Test Method Order

- **TestMethodOrder**: used to specify the order in which test methods should be executed.
  - **TestMethodOrder(MethodOrderer.OrderAnnotation.class)**: orders test methods based on the `@Order` annotation.
  - **TestMethodOrder(MethodOrderer.MethodName.class)**: orders test methods by their names in lexicographical order.
  - **TestMethodOrder(MethodOrderer.Random.class)**: orders test methods in a random order for each test run.

### Assertions

- **assertEquals(expected, actual)**: checks if the expected value is equal to the actual value.
- **assertNotEquals(unexpected, actual)**: checks if the unexpected value is not equal to the actual value.
- **assertTrue(condition)**: checks if the condition is true.
- **assertFalse(condition)**: checks if the condition is false.
- **assertNull(object)**: checks if the object is null.

### Assumptions

- **assumeTrue(condition)**: checks if the condition is true; if not, the test is skipped.
- **assumeFalse(condition)**: checks if the condition is false; if not, the test is skipped.
- **assumeThat(actual, matcher)**: checks if the actual value matches the given matcher; if not, the test is skipped.
- **assumeAll(assumptions)**: checks if all assumptions are true; if not, the test is skipped.
- **assumeNone(assumptions)**: checks if none of the assumptions are true; if any assumption is true, the test is skipped.

### Disabling Tests

- **@Disabled**: used to disable a test method or a test class, indicating that it should not be executed.
- **@EnabledOnOs**: used to enable a test method or class only on specific operating systems.
- **@DisabledOnOs**: used to disable a test method or class on specific operating systems.
- **@EnabledIf**: used to enable a test method or class based on a condition, such as an environment variable or system property.
- **@DisabledIf**: used to disable a test method or class based on a condition, such as an environment variable or system property.
- **EnabledIfSystemProperty**: used to enable a test method or class if a specific system property is set to a certain value.
- **DisabledIfSystemProperty**: used to disable a test method or class if a specific system property is set to a certain value.
