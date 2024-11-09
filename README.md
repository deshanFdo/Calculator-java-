# JavaFX Calculator

A basic calculator application built using Java and JavaFX. This calculator can perform fundamental arithmetic operations such as addition, subtraction, multiplication, and division.

## Features

- Supports basic arithmetic operations: `+`, `-`, `*`, and `/`.
- Simple and responsive UI built with JavaFX.
- Real-time display of inputs and results.
- Error handling for division by zero.

## Prerequisites

To run this project, ensure you have the following installed:

- **Java Development Kit (JDK)** (version 8 or higher)
- **JavaFX SDK**: JavaFX libraries need to be set up if you're using Java 11 or higher, as they are no longer bundled with the JDK.

## Setup and Installation

1. **Clone the repository:**

    ```bash
    git clone https://deshanFdo/javafx-calculator.git
    cd javafx-calculator
    ```

2. **Add JavaFX library** to your project if required.

   - Download JavaFX SDK from [https://gluonhq.com/products/javafx/](https://gluonhq.com/products/javafx/).
   - Add the JavaFX library to your IDE:
     - In **IntelliJ IDEA**:
       - Go to `File > Project Structure > Libraries`.
       - Click `+` to add the JavaFX library directory.
       - Specify `--module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml` in the VM options.
     - In **Eclipse**:
       - Go to `Project > Properties > Java Build Path`.
       - Add the JavaFX library under `Libraries`.

3. **Run the Application:**

   Run the `Calculator` class in your IDE or using the command:

    ```bash
    java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -jar Calculator.jar
    ```

## Usage

- **Enter numbers** by clicking the number buttons (0-9).
- **Perform operations** by clicking on `+`, `-`, `*`, or `/`.
- **Get the result** by clicking `=`.
- **Clear the display** by starting a new operation or using backspace on input.

## Code Structure

- **`Calculator`** (Main class): Contains all logic for handling operations and managing the display.
- **Methods**:
  - `handleNumber(String number)`: Appends a selected number to the input.
  - `handleOperator(String operator)`: Sets up the chosen operator for calculation.
  - `handleEquals()`: Calculates and displays the result.
  - `handleDecimalPoint()`: Manages decimal input in the number.

## Contributing

Feel free to submit issues or pull requests to help improve this project.

## License

This project is open-source and available under the MIT License.
