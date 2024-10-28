| CS-665       | Software Design & Patterns |
|--------------|----------------------------|
| Name         | NINA SUDHEESH              |
| Date         | 10/24/2024                 |
| Course       | Fall                       |
| Assignment # | 3                          |

# Assignment Overview

- The goal of the assignment is to create an email generation system while using a design pattern that manage
  /creates personalized emails for various types of customers (such as Business, Returning, Frequent, New, and VIP).
- The system's purpose is so that management from a company can create tailored email content using a template
  ( with a greeting, message, and signature) based on customer type.
- For each customer type the application would have specific customer-based messaging & promotions
  as well addressing the customer directly to efficiently communicate with different types of customers.

# GitHub Repository Link:

https://github.com/ninasudh688/cs665assignment3

# Implementation Description

- The implementation has been kept simple and easy to understand by organizing the code.
    - The interfaces (EmailStrategy) helps to organize the code logically, ensuring a clean
      separation of concerns.
    - Each customer type class are focused on creating specific email content, following the Strategy Pattern,
      which separates each customer type’s unique function from other parts of the email generation system.
    - Each class serves a distinct job making it easy for others to read and maintain.
    - This separation of the classes' roles helps make the code more readable.
    - Also, all the code is documented with doc-blocks that explain each method/class's purpose.


- I chose the Strategy Pattern-Here is how I Set up the classes:
    - EmailStrategy.js = Strategy Interface
    - BusinessCustomerStrategy.js = Concrete Strategy
    - FrequentCustomerStrategy.js = Concrete Strategy
    - NewCustomerStrategy.js = Concrete Strategy
    - ReturningCustomerStrategy.js = Concrete Strategy
    - VipCustomerStrategy.js = Concrete Strategy
    - Customer.js = Context Class
        - It has composition relationship with EmailStrategy interface since you require a customer or subject
          to send emails to/create email templates for.
        - Customer has an instance of emailStrategy interface in it.


- I chose the Strategy Pattern because the problem requires creating multiple email
  content template types each of the 5 different customer types.
    - This pattern is useful when have related similar objects that differ in their behaviors and by implementing it,
      you gain flexibility to manage those behaviors.
    - Without the usage of this pattern, I would have to implement
      multiple conditional or switch statements to management with different customer email types.
        - Instead of repetitive usage of conditionals throughout the program, I defined concrete strategy classes for
          each customer to manage each type of behavior.
    - The patterns also allows for reuse of behaviors and prioritizes
      composition over inheritance which helps increase flexibility.
    - It also encapsulates the system's details of how each strategy works away from the customer. The customer just
      interacts with the interface to get their needed email content.
    - Also, the pattern allows for centralized changes to an email strategy, so that all customers using that strategy
      will automatically benefit from the changes without effecting other strategies.


- The implementation is designed with future flexibility in mind.
    - Each customer type (Business, Returning, Frequent, New, VIP) has its own strategy class that implements the
      EmailStrategy interface, therefore it would be easy to add a new customer type without modifying the core logic of
      the Customer class.
        - You would just need to create a new strategy class for that customer type without altering
          existing code.
        - It would also be easy to edit or remove any customer types in the future as well.
    - This flexibility also allows easy changes to existing strategies if the email format or content needs to change,
      as each strategy class is independent and only affects its associated customer type.
    - This makes the system to flexible for future customer segments that the company may want to
      communicate with in the future.
    - This makes it easy to test specific strategies independent as well.


- Code duplication has been carefully avoided:
    - The EmailStrategy is common interface sets up 3 methods for creating an email (generateGreeting,
      generateEmailMessage, and generateEmailSignature) that is implemented by/shared by the 5 concrete strategy
      classes.
        - This prevents duplication because all 5 customer strategies share the same email structure and only their
          details
          need to create that type of customer email. Therefore, there wouldn't be customer types with same
          repetitive/details.
    - The Strategy pattern helped ensure that you don't need to update multiple places in the code when modification
      occurs which keeps the code D.R.Y as well easier to debug.
    - Also, it that ensures all email generation strategies are consistent and uniform, making it less error-prone.
    - The Customer class manages main logic for choosing customer strategies so that it is centralized in one place.


- Assumptions that I made:
    - I assumed that each customer segment is messaging about some type of discount or offer
      similar to when you get rewards emails from certain stores.
    - I assumed that each email requires greeting customer, message,offer, and ends with closing remark and signature
    - I assumed that each email with signed by management team or person.
    - I assumed that returning meant returning customer not someone who returned a product.
    - I assumed that each customer segment is type of email strategy.
    - I assumed that each customer receives personalized communication in order to increase a customer's usage/purchases
      of a company's product/service and enhance customer engagement.

# Running My Code And UML:

- I placed my UML diagram in cs665_assignment3_UMLDiagram_Sudheesh.PDF within this zipped folder
- I placed my code in package emailsystem under the edu.bu.met.cs665 package.
- The Main class is outside this package.
- I tested my code using junit tests by using a JUnit test class TestEmailGenerationSystem in the test package.
    - I also tested some code as well in the Main class.
- The code compiles using mvn clean compile.

# Maven Commands

We'll use Apache Maven to compile and run this project. You'll need to install Apache Maven (https://maven.apache.org/)
on your system.

Apache Maven is a build automation tool and a project management tool for Java-based projects. Maven provides a
standardized way to build, package, and deploy Java applications.

Maven uses a Project Object Model (POM) file to manage the build process and its dependencies. The POM file contains
information about the project, such as its dependencies, the build configuration, and the plugins used for building and
packaging the project.

Maven provides a centralized repository for storing and accessing dependencies, which makes it easier to manage the
dependencies of a project. It also provides a standardized way to build and deploy projects, which helps to ensure that
builds are consistent and repeatable.

Maven also integrates with other development tools, such as IDEs and continuous integration systems, making it easier to
use as part of a development workflow.

Maven provides a large number of plugins for various tasks, such as compiling code, running tests, generating reports,
and creating JAR files. This makes it a versatile tool that can be used for many different types of Java projects.

## Compile

Type on the command line:

```bash
mvn clean compile
```

## JUnit Tests

JUnit is a popular testing framework for Java. JUnit tests are automated tests that are written to verify that the
behavior of a piece of code is as expected.

In JUnit, tests are written as methods within a test class. Each test method tests a specific aspect of the code and is
annotated with the @Test annotation. JUnit provides a range of assertions that can be used to verify the behavior of the
code being tested.

JUnit tests are executed automatically and the results of the tests are reported. This allows developers to quickly and
easily check if their code is working as expected, and make any necessary changes to fix any issues that are found.

The use of JUnit tests is an important part of Test-Driven Development (TDD), where tests are written before the code
they are testing is written. This helps to ensure that the code is written in a way that is easily testable and that all
required functionality is covered by tests.

JUnit tests can be run as part of a continuous integration pipeline, where tests are automatically run every time
changes are made to the code. This helps to catch any issues as soon as they are introduced, reducing the need for
manual testing and making it easier to ensure that the code is always in a releasable state.

To run, use the following command:

```bash
mvn clean test
```

## Spotbugs

SpotBugs is a static code analysis tool for Java that detects potential bugs in your code. It is an open-source tool
that can be used as a standalone application or integrated into development tools such as Eclipse, IntelliJ, and Gradle.

SpotBugs performs an analysis of the bytecode generated from your Java source code and reports on any potential problems
or issues that it finds. This includes things like null pointer exceptions, resource leaks, misused collections, and
other common bugs.

The tool uses data flow analysis to examine the behavior of the code and detect issues that might not be immediately
obvious from just reading the source code. SpotBugs is able to identify a wide range of issues and can be customized to
meet the needs of your specific project.

Using SpotBugs can help to improve the quality and reliability of your code by catching potential bugs early in the
development process. This can save time and effort in the long run by reducing the need for debugging and fixing issues
later in the development cycle. SpotBugs can also help to ensure that your code is secure by identifying potential
security vulnerabilities.

Use the following command:

```bash
mvn spotbugs:gui 
```

For more info see
https://spotbugs.readthedocs.io/en/latest/maven.html

SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.

## Checkstyle

Checkstyle is a development tool for checking Java source code against a set of coding standards. It is an open-source
tool that can be integrated into various integrated development environments (IDEs), such as Eclipse and IntelliJ, as
well as build tools like Maven and Gradle.

Checkstyle performs static code analysis, which means it examines the source code without executing it, and reports on
any issues or violations of the coding standards defined in its configuration. This includes issues like code style,
code indentation, naming conventions, code structure, and many others.

By using Checkstyle, developers can ensure that their code adheres to a consistent style and follows best practices,
making it easier for other developers to read and maintain. It can also help to identify potential issues before the
code is actually run, reducing the risk of runtime errors or unexpected behavior.

Checkstyle is highly configurable and can be customized to fit the needs of your team or organization. It supports a
wide range of coding standards and can be integrated with other tools, such as code coverage and automated testing
tools, to create a comprehensive and automated software development process.

The following command will generate a report in HTML format that you can open in a web browser.

```bash
mvn checkstyle:checkstyle
```

The HTML page will be found at the following location:
`target/site/checkstyle.html`




