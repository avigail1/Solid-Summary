# Project Overview

This project is an automated testing framework built using Java and Selenium. The framework is designed to test an online store, specifically focusing on the purchase flow and form submission functionalities. It utilizes the JUnit 5 testing framework and follows Clean Code principles, ensuring that the code is readable, maintainable, and scalable.

## Features

- Automated purchase flow testing.
- Dynamic selection of products from the "Accessories" section.
- Parameterized tests using XML data for form filling.
- Custom extensions for managing WebDriver lifecycle and logging test results.

## Implementation of SOLID Principles

1. **Single Responsibility Principle (SRP)**:
    - Each class in the project has a single responsibility. For example, `StoreHomePage` is responsible solely for interactions with the homepage, while `CheckoutPage` handles the form filling process. This separation of concerns makes the code easier to maintain and test.

2. **Open/Closed Principle (OCP)**:
    - The framework is designed to be open for extension but closed for modification. New test scenarios can be added by creating new test classes without modifying the existing ones. Additionally, the `OpenCloseBrowser` interface allows for different browser implementations without changing the core functionality.

3. **Liskov Substitution Principle (LSP)**:
    - Classes that implement the `OpenCloseBrowser` interface can be substituted interchangeably. For instance, if a new browser driver is added, it can replace the `ChromeDriverFactory` without affecting the existing tests. This allows for flexibility and easy scalability in the future.

4. **Interface Segregation Principle (ISP)**:
    - The project uses specific interfaces for different functionalities, ensuring that classes only implement methods they need. The `OpenCloseBrowser` interface defines methods specific to browser management, while other interfaces can be created for different components of the framework.

5. **Dependency Inversion Principle (DIP)**:
    - High-level modules depend on abstractions rather than concrete implementations. The tests depend on interfaces like `OpenCloseBrowser`, allowing the underlying implementation (like `ChromeDriverFactory`) to be changed without impacting the tests. This promotes flexibility and easier testing.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- Maven (for dependency management)
- WebDriverManager for managing browser drivers

### Installation

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd <repository-directory>
