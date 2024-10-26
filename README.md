# Calculator Application

This is a simple calculator application built using JavaFX. The application supports basic arithmetic operations such as addition, subtraction, multiplication, and division.

![Calculator Image](src/main/resources/image/Calculator.png)

## Features

- Basic arithmetic operations: addition, subtraction, multiplication, and division.
- User-friendly interface with buttons for digits and operations.
- Error handling for invalid inputs.
- Clear and delete functionalities.
- Toggle sign functionality.
- Secret codes for special messages.

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
   
## Project Structure

- `src/main/java`: Contains the Java source files.
  - `controller`: Contains the controller classes.
  - `main`: Contains the main application and model classes.
- `src/main/resources`: Contains the FXML files, CSS styles, and images.
- `src/test/java`: Contains the test classes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.
