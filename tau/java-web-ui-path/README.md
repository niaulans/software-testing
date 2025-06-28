# Java Web UI Path

## Junit5 Tests

- **methodName_expectedBehavior_whenCondition** -> structure for naming test methods in JUnit 5, where:

  - **methodName**: the name of the method being tested.
  - **expectedBehavior**: the expected outcome of the test.
  - **whenCondition**: an optional condition under which the test is run, providing additional context for the test case.
  - **Example**:
    | Test Method Name | Description |
    | --------------------------------------------------------- | ------------------------------------------------------------------------- |
    | retrievePassword_shouldShowError_whenEmailIsEmpty() | Verifies that retrieving password shows an error when the email is empty |
    | login_shouldRedirectToDashboard_whenCredentialsAreValid() | Verifies that login redirects to the dashboard when credentials are valid |
    | submitForm_shouldFail_whenRequiredFieldsAreMissing() | Verifies that the form submission fails when required fields are missing |
    | uploadFile_shouldShowSuccessMessage_whenFileIsValid() | Verifies that file upload shows a success message when the file is valid |

### Test Annotations (JUnit 5)

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

#### Test Method Order

- **TestMethodOrder**: used to specify the order in which test methods should be executed.
  - **TestMethodOrder(MethodOrderer.OrderAnnotation.class)**: orders test methods based on the `@Order` annotation.
  - **TestMethodOrder(MethodOrderer.MethodName.class)**: orders test methods by their names in lexicographical order.
  - **TestMethodOrder(MethodOrderer.Random.class)**: orders test methods in a random order for each test run.

#### Assumptions

- **assumeTrue(condition)**: checks if the condition is true; if not, the test is skipped.
- **assumeFalse(condition)**: checks if the condition is false; if not, the test is skipped.
- **assumeThat(actual, matcher)**: checks if the actual value matches the given matcher; if not, the test is skipped.
- **assumeAll(assumptions)**: checks if all assumptions are true; if not, the test is skipped.
- **assumeNone(assumptions)**: checks if none of the assumptions are true; if any assumption is true, the test is skipped.

#### Disabling Tests

- **@Disabled**: used to disable a test method or a test class, indicating that it should not be executed.
- **@EnabledOnOs**: used to enable a test method or class only on specific operating systems.
- **@DisabledOnOs**: used to disable a test method or class on specific operating systems.
- **@EnabledIf**: used to enable a test method or class based on a condition, such as an environment variable or system property.
- **@DisabledIf**: used to disable a test method or class based on a condition, such as an environment variable or system property.
- **EnabledIfSystemProperty**: used to enable a test method or class if a specific system property is set to a certain value.
- **DisabledIfSystemProperty**: used to disable a test method or class if a specific system property is set to a certain value.

#### Repeating Tests

- **@RepeatedTest**: used to indicate that a test method should be executed multiple times.
- **@TestTemplate**: used to indicate that a test method is a template for other tests, allowing for dynamic test generation.

#### Tags

- **@Tag**: used to categorize tests with specific tags, allowing for filtering and grouping of tests.

#### Assertions

- **assertEquals(expected, actual)**: checks if the expected value is equal to the actual value.
- **assertNotEquals(unexpected, actual)**: checks if the unexpected value is not equal to the actual value.
- **assertTrue(condition)**: checks if the condition is true.
- **assertFalse(condition)**: checks if the condition is false.
- **assertNull(object)**: checks if the object is null.
- **assertAll(assertions)**: checks if all assertions are true, allowing for multiple assertions to be checked in a single test.
- **assertThrows(expectedType, executable)**: checks if the executable throws an exception of the expected type.

#### Running Tests Manually

- **mvn test**: command to run all tests in the project.
- **mvn test -Dtest=TestClassName**: command to run a specific test class.
- **mvn test -Dtest=TestClassName#testMethodName**: command to run a specific test method in a test class.
- **mvn test -Dtest=TestClassName#testMethodName[1]**: command to run a specific test method with a specific parameter set in a parameterized test.
- **mvn test -Dname=TestClassName**: command to run tests with a specific name pattern.
- **mvn test -Dgroups=tagName**: command to run tests with a specific tag.
- **mvn test -DskipTests**: command to skip running tests during the build process.

<br>

- **mvn clean install -DskipTests**: command to clean the project, build it, and skip running tests.

#### Listeners

- **TestWatcher**: used to listen for test events and perform actions based on those events.
  - **TestWatcher**: a base class for creating custom test watchers that can react to test lifecycle events.
  - **TestExecutionExceptionHandler**: used to handle exceptions thrown during test execution, allowing for custom error handling.
  - **TestReporter**: used to report additional information during test execution, such as custom messages or results.
- **ExtendWith**: used to extend the functionality of a test class with additional features, such as custom annotations or listeners.

#### Timeouts, Nested Tests, and Custom Annotations

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

  - `#` -> ID selector
  - `.` -> class selector
  - `>` -> child selector
  - `space` -> descendant selector
  - `,` -> group selector
  - `:` -> pseudo-class selector
  - `:not()` -> negation pseudo-class

- **CSS Selector Examples**:
  | **Selector** | **Description** |
  |--------------------------------------|-------------------------------------------------------------------------------|
  | `div` | Selects all `<div>` elements |
  | `div.class` | Selects all `<div>` elements with a specific class |
  | `div#id` | Selects a specific `<div>` element with a unique ID |
  | `div > p` | Selects all `<p>` elements that are direct children of a `<div>` |
  | `div p` | Selects all `<p>` elements that are descendants of a `<div>` |
  | `#id` | Selects an element with a specific ID |
  | `.class` | Selects all elements with a specific class |
  | `div.class1 div.class2` | Selects all `<div>` elements with `class2` that are descendants of `class1` |
  | `div.class1 > div.class2` | Selects all `<div>` elements with `class2` that are direct children of `class1` |
  | `div.class1, div.class2` | Selects all `<div>` elements with either `class1` or `class2` |
  | `div.result:not(.result--more)` | Selects all `<div>` elements with class `result` that do not have `result--more` |
  | `div.result:nth-child(2)` | Selects the second child `<div>` with class `result` |
  | `div.result:nth-of-type(2)` | Selects the second `<div>` of type `result` among its siblings |
  | `input[type='text']` | Selects all `<input>` elements of type `text` |
  | `button#main-button.submit` | Selects a `<button>` with ID `main-button` and class `submit` |
  | `input[type="checkbox"] + label` | Selects a `<label>` that is immediately after an `<input type="checkbox">` |
  | `input[required]` | Selects all `<input>` elements with the `required` attribute |

### XPath Selectors

- XPath is a language used to navigate and select nodes in an XML or HTML document. It provides a way to traverse the document tree and locate elements based on their attributes, relationships, and hierarchy.

- **XPath Selector Examples**:
  | **XPath** | **Description** |
  |----------------------------------------------------------|-----------------------------------------------------------------------------------------------|
  | `//*` | Selects all elements in the document |
  | `//div` | Selects all `<div>` elements in the document |
  | `//div[@class='class']` | Selects all `<div>` elements with a specific class attribute |
  | `//div[@id='id']` | Selects a specific `<div>` element with a unique ID attribute |
  | `//div/p` | Selects all `<p>` elements that are descendants of a `<div>` |
  | `//div/p[@class='class']` | Selects all `<p>` elements with a specific class that are descendants of a `<div>` |
  | `//div[@id='id']/p` | Selects all `<p>` elements that are direct children of a `<div>` with a specific ID |
  | `//a[text()='link text']` | Selects an `<a>` element with specific visible text |
  | `//a[contains(text(), 'partial text')]` | Selects an `<a>` element with partial visible text |
  | `//input[@type='text']` | Selects all `<input>` elements of type `text` |
  | `//input[@name='name']` | Selects an `<input>` element with a specific `name` attribute |
  | `//img[@width<20][@height<20]` | Selects all `<img>` elements with width and height less than 20 pixels |
  | `//div[contains(@class, 'class1') and contains(@class, 'class2')]` | Selects all `<div>` elements that have both `class1` and `class2` in the class attribute |
  | `//input[@name='q' or @id='search']` | Selects an `<input>` element with either a specific `name` or `ID` attribute |
  | `//p[not(contains(@class, 'class'))]` | Selects all `<p>` elements that do not contain a specific class |
  | `//div[starts-with(@class, 'prefix')]` | Selects all `<div>` elements whose class attribute starts with a specific prefix |
  | `//p[contains(., 'text')]` | Selects all `<p>` elements that contain a specific text (anywhere inside, not just direct text) |
  | `(//h2[contains(@class, 'class')])[1]` | Selects the first `<h2>` element with a specific class |
  | `//div[contains(@class, 'class')][contains(., 'text')]` | Selects all `<div>` elements with a specific class that also contain a specific text |
  | `//a[.//img]` | Selects all `<a>` elements that contain an `<img>` inside |
  | `//a[contains(@class, 'class')][preceding::div[@class='class']]` | Selects `<a>` with a specific class preceded by a `<div>` with that class |
  | `//a[contains(@class, 'class')][following::div[@class='class']]` | Selects `<a>` with a specific class followed by a `<div>` with that class |
  | `//input[@type='checkbox']/following-sibling::label[1]` | Selects the first `<label>` element that follows an `<input type="checkbox">` |
  | `//tr/td[last()]` | Selects the last `<td>` element in each `<tr>` row |

### Codeless Locators

- Codeless locators are tools or frameworks that allow users to interact with web elements without writing code, often through a graphical user interface (GUI).
- They typically use a combination of visual element recognition and predefined strategies to identify elements on a web page.
- Examples of codeless locator tools include:
- **Selenium IDE**: a browser extension that allows users to record and playback tests without writing code.
- **Katalon Recorder**: a browser extension that provides codeless test automation capabilities.
- **TestProject**: a cloud-based test automation platform that supports codeless test creation and execution.
- **Ranorex**: a commercial tool that provides codeless test automation capabilities for web, desktop, and mobile applications.
- **UFT (Unified Functional Testing)**: a commercial tool that supports codeless test automation for web and desktop applications.

### Best Practices for Locators

**1. Prefer Unique IDs**

- Use when available.
- IDs are the fastest and most reliable locator.
- ✅ Example: `#login-button` (CSS) or `//*[@id='login-button']` (XPath)

**2. Use Descriptive and Stable Attributes**

- Choose attributes like `name`, `data-*`, `aria-*` that are unlikely to change.
- ✅ Example: `input[name='email']`, `button[data-test='submit']`

**3. Avoid Auto-Generated or Dynamic Attributes**

- ❌ Avoid using IDs or classes that are randomly generated or change often.
- ❌ Example: `div[class='x-1024-header']`

**4. Use CSS Selectors Over XPath (When Possible)**

- CSS is faster and simpler in most environments.
- ✅ Example (CSS): `div.content > p`
- ❌ Example (XPath): `//div[@class='content']/p`

**5. Avoid Relying on Indexes**

- ❌ Avoid: `(//input)[5]` — fragile, breaks easily with UI changes.
- ✅ Use meaningful attributes or relationships instead.

**6. Use Custom `data-*` Attributes**

- Add attributes like `data-testid`, `data-qa`, etc., for testing.
- ✅ Example: `[data-testid='signup-button']`

**7. Avoid Chained Class Selectors**

- ❌ Avoid: `div.container .main .content .title`
- ✅ Prefer simpler selectors: `.title`, or attribute-based selectors

**8. Use Text Carefully**

- Useful when the text is stable (e.g., button/label).
- ✅ Example: `//button[text()='Submit']`
- ❌ Avoid: `//a[text()='Click here']` if the text can change or is translated

**9. Keep Locators Short and Readable**

- Prefer simple, semantic selectors over deeply nested ones.
- ✅ `input[name='username']`
- ❌ `html > body > div > form > div:nth-child(1) > input`

**10. Regularly Maintain and Refactor Locators**

- Keep up with UI changes.
- Use a centralized locator strategy (e.g., Page Object Model).

## Selenium WebDriver with Java

- **Page Object Model (POM)** is a design pattern that enhances test maintainability and readability by encapsulating web page elements and actions in separate classes.
- **Example**:
  - LoginPage.java -> contains locators and methods for interacting with the login page.
  - LoginTest.java -> contains test cases that use the LoginPage class to perform actions and assertions.

## Selenium 4 with Java

Selenium Client & WebDriver Language Bindings -> JSON Wire Protocol Over HTTP -> Browser Drivers -> Web Browser

Advantages of Selenium 4:

- **Improved W3C WebDriver Standard**: Selenium 4 fully implements the W3C WebDriver standard, ensuring better compatibility and performance across different browsers.
- **New Features**: Selenium 4 introduces new features like relative locators, improved window and tab management, and enhanced support for modern web technologies.
- **Better Documentation**: The documentation for Selenium 4 is more comprehensive and user-friendly, making it easier for developers to get started and find solutions to common problems.

- **Relative Locators**: Selenium 4 introduces relative locators, allowing you to find elements based on their position relative to other elements.
  - left
  - right
  - above
  - below
  - near

## Scaling Tests with Docker

- Selenium Grid allows you to run tests in parallel across multiple browsers and machines, improving test execution speed and coverage.
- Selenium Grid 4 supports Docker, enabling you to run browser instances in isolated containers.
- Selenium Hub -> manages the grid and routes test requests to available nodes.
- Selenium Node -> runs the actual browser instances and executes the tes
- Docker Swarm -> allows you to deploy and manage a cluster of Docker containers, making it easier to scale your Selenium Grid setup.
  - `docker swarm init` -> initializes a Docker Swarm cluster.
  - `docker swam join <token>` -> joins a node to an existing Docker Swarm cluster.
  - `docker stack deploy -c docker-compose.yml selenium` -> deploys the Selenium Grid stack using a Docker Compose file.
