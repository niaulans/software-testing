# Java Web UI Path

## Junit5 Tests

- **methodName_expectedBehavior_whenCondition** -> structure for naming test methods in JUnit 5, where:

  - **<methodName>**: the name of the method being tested.
  - **<expectedBehavior>**: the expected outcome of the test.
  - **<whenCondition>**: an optional condition under which the test is run, providing additional context for the test case.
  - **Example**: `calculateSum_returnsCorrectSum_whenTwoPositiveNumbers` indicates that the `calculateSum` method is being tested to ensure it returns the correct sum when two positive numbers are provided.

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

### Repeating Tests

- **@RepeatedTest**: used to indicate that a test method should be executed multiple times.
- **@TestTemplate**: used to indicate that a test method is a template for other tests, allowing for dynamic test generation.

### Tags

- **@Tag**: used to categorize tests with specific tags, allowing for filtering and grouping of tests.

### Assertions

- **assertEquals(expected, actual)**: checks if the expected value is equal to the actual value.
- **assertNotEquals(unexpected, actual)**: checks if the unexpected value is not equal to the actual value.
- **assertTrue(condition)**: checks if the condition is true.
- **assertFalse(condition)**: checks if the condition is false.
- **assertNull(object)**: checks if the object is null.
- **assertAll(assertions)**: checks if all assertions are true, allowing for multiple assertions to be checked in a single test.
- **assertThrows(expectedType, executable)**: checks if the executable throws an exception of the expected type.

### Running Tests Manually

- **mvn test**: command to run all tests in the project.
- **mvn test -Dtest=TestClassName**: command to run a specific test class.
- **mvn test -Dtest=TestClassName#testMethodName**: command to run a specific test method in a test class.
- **mvn test -Dtest=TestClassName#testMethodName[1]**: command to run a specific test method with a specific parameter set in a parameterized test.
- **mvn test -Dname=TestClassName**: command to run tests with a specific name pattern.
- **mvn test -Dgroups=tagName**: command to run tests with a specific tag.
- **mvn test -DskipTests**: command to skip running tests during the build process.

<br>

- **mvn clean install -DskipTests**: command to clean the project, build it, and skip running tests.

### Listeners

- **TestWatcher**: used to listen for test events and perform actions based on those events.
  - **TestWatcher**: a base class for creating custom test watchers that can react to test lifecycle events.
  - **TestExecutionExceptionHandler**: used to handle exceptions thrown during test execution, allowing for custom error handling.
  - **TestReporter**: used to report additional information during test execution, such as custom messages or results.
- **ExtendWith**: used to extend the functionality of a test class with additional features, such as custom annotations or listeners.

### Timeouts, Nested Tests, and Custom Annotations

- **@Timeout**: used to specify a maximum time limit for a test method to complete. If the test exceeds this time, it will fail.
- **@Nested**: used to create nested test classes, allowing for better organization of tests and shared setup/teardown logic.
- Use interfaces to create custom annotations for tests, allowing for reusable test logic and configurations.
  - **@CustomAnnotation**: an example of a custom annotation that can be used to mark test methods or classes with specific behavior or metadata.

## Web Element Locator Strategies

- HTML is a markup language used to create web pages, consisting of elements represented by tags.
- Each element can have attributes that provide additional information about the element.
- Document object model (DOM) is a tree structure representing the HTML document, where each node corresponds to an element or attribute.
- **Element**: a single HTML tag in the DOM, such as `<div>`, `<span>`, or `<input>`.
- **Locator**: a way to identify and interact with elements in the DOM, allowing for automation of web interactions.
- **Selector**: string used to locate elements in the DOM, such as CSS selectors or XPath expressions.

| Term         | What is it?                          | Example                                           |
| ------------ | ------------------------------------ | ------------------------------------------------- |
| **Element**  | The actual object on the web page    | `WebElement loginBtn`                             |
| **Locator**  | A strategy used to find an element   | `By.id("username")`                               |
| **Selector** | The string query used in the locator | `"input[type='text']"` or `//button[@id='login']` |

### Web Driver Locators

- WebDriver provides various locator strategies to find elements on a web page, including:
  - **By.id**: locates an element by its unique ID attribute.
  - **By.name**: locates an element by its name attribute.
  - **By.className**: locates elements by their class attribute.
  - **By.tagName**: locates elements by their tag name.
  - **By.linkText**: locates a link element by its visible text.
  - **By.partialLinkText**: locates a link element by a partial match of its visible text.
  - **By.cssSelector**: locates elements using CSS selectors.
  - **By.xpath**: locates elements using XPath expressions.

The order of preference for locator strategies is as follows:

1. **By.id**: Fastest and most reliable, as IDs are unique.
2. **By.name**: Useful for form elements, but not always unique.
3. **By.className**: Can match multiple elements, but may not be unique.
4. **By.tagName**: Matches all elements of a specific type, but not unique.
5. **By.linkText**: Useful for links, but requires exact text match.
6. **By.partialLinkText**: Useful for links, but requires partial text match.
7. **By.cssSelector**: Flexible and powerful, but can be complex.
8. **By.xpath**: Most powerful and flexible, but can be slower and more complex.

- When using locators, it's important to choose the most efficient and reliable strategy based on the structure of the HTML document and the specific requirements of the test case.

### CSS Selectors

- CSS selectors are patterns used to select elements in an HTML document based on their attributes, relationships, and hierarchy.

  - `.` -> class selector
  - `#` -> ID selector
  - `>` -> child selector
  - `space` -> descendant selector
  - `,` -> group selector
  - `:` -> pseudo-class selector
  - `:not()` -> negation pseudo-class

- **CSS Selector Examples**:
  - `div` -> selects all `<div>` elements.
  - `div.class` -> selects all `<div>` elements with a specific class.
  - `div#id` -> selects a specific `<div>` element with a unique ID.
  - `div > p` -> selects all `<p>` elements that are direct children of a `<div>`.
  - `div p` -> selects all `<p>` elements that are descendants of a `<div>`.
  - `#id ` -> selects an element with a specific ID.
  - `.class` -> selects all elements with a specific class.
  - `div.class1 div.class2` -> selects all `<div>` elements with both `class1` and `class2`. `class2` must be a descendant of `class1`.
  - `div.class1 > div.class2` -> selects all `<div>` elements with `class2` that are direct children of a `<div>` with `class1`.
  - `div.class1, div.class2` -> selects all `<div>` elements with either `class1` or `class2`.
  - `div.result:not(.result --more)` -> selects all `<div>` elements with the class `result` that do not have the class `result --more`.
  - `div.result:nth-child(2)` -> selects the second `<div>` element with the class `result`.
  - `div.result:nth-of-type(2)` -> selects the second `<div>` element of type `result` among its siblings.
