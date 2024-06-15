# Retail Discount Calculator

This project calculates the net payable amount for a bill considering various discounts.

## How to Run

1. **Build the Project**
    ```bash
    ./mvnw clean install
    ```

2. **Run Unit Tests**
    ```bash
    ./mvnw test
    ```

3. **Generate Coverage Report**
    ```bash
    ./mvnw jacoco:report
    ```

4. **Run SonarQube Analysis**
    ```bash
    ./mvnw sonar:sonar
    ```

## Project Structure

- `model` package contains the domain models.
- `service` package contains the discount strategy implementations.
- `test` package contains unit tests for the business logic.

## UML Diagram
![UML Diagram](uml.png)
