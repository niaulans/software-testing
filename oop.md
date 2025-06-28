# 📚 OOP Terminology Table (Java-Focused)

| Term               | Meaning (Simple)                                                  | Example / Purpose                                           |
| ------------------ | ----------------------------------------------------------------- | ----------------------------------------------------------- |
| **Class**          | Blueprint or template to create objects                           | `class Car { String color; }`                               |
| **Object**         | A real instance of a class                                        | `Car myCar = new Car();`                                    |
| **Encapsulation**  | Hiding internal data and exposing only through methods            | Use `private` fields + `getters/setters`                    |
| **Inheritance**    | One class inherits properties and behaviors from another          | `class Dog extends Animal {}`                               |
| **Polymorphism**   | One interface, many forms (object behavior varies by type)        | `WebDriver driver = new ChromeDriver();`                    |
| **Abstraction**    | Hiding implementation details and showing only necessary features | `abstract class Vehicle { abstract void drive(); }`         |
| **Overriding**     | Redefining a parent class method in a child class                 | `@Override void drive() { ... }`                            |
| **Overloading**    | Same method name with different parameters                        | `void add(int a, int b)` and `void add(double a, double b)` |
| **Interface**      | A contract that a class must fully implement                      | `interface Animal { void eat(); }`                          |
| **Constructor**    | Special method for object initialization                          | `Car() { color = "red"; }`                                  |
| **this**           | Refers to the current object instance                             | `this.name = name;`                                         |
| **super**          | Refers to parent class members                                    | `super.drive();`                                            |
| **static**         | Belongs to the class, not an instance                             | `static int totalCars;`                                     |
| **final**          | Cannot be changed or overridden                                   | `final int MAX_SPEED = 120;`                                |
| **Abstract class** | Cannot be instantiated directly, meant to be subclassed           | Must be extended by other classes                           |
| **Instance**       | An object created from a class                                    | `new Car()` is an instance of the `Car` class               |

---

### 💡 Quick Tips:

- **Overloading**: Same method name, different parameters (within the **same class**).
- **Overriding**: Subclass changes the behavior of a method from the **parent class**.

---

If you'd like examples or explanations for any term, just ask!
