# Calculator Application

This is a simple calculator application built using JavaFX. The application supports basic arithmetic operations such as addition, subtraction, multiplication, division and modulus.

![Calculator Image](src/main/resources/image/Calculator.png)

## Features

- Basic arithmetic operations: addition, subtraction, multiplication, division and modulus.
- User-friendly interface with buttons for digits and operations.
- Clear and delete functionalities.
- Toggle sign functionality.

## Prerequisites

- Java Development Kit (JDK) 17 or higher.
- Maven 3.6.0 or higher.
- JavaFX SDK 17.0.12.

## How to Run

1. **Clone the repository**:
   ```sh
   git clone https://github.com/r4ppz19/calculator-application.git
   cd calculator-application
2. **Build the project using Maven**:
   ```sh
   mvn clean install

3. Run the application:
   ```sh
   mvn javafx:run
   
## Known Problem

You can only do one calculation at a time. After one calculation, you need to click the `C` button to enter another calculation.
