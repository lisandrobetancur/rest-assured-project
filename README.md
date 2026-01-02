# Rest Assured Project

## Overview

This project is a robust framework for API testing, built with a powerful combination of `Rest-Assured`, `Serenity BDD`, and `Cucumber`. It provides a structured and maintainable approach to writing and executing API tests, with a focus on clear, descriptive, and easy-to-understand test scenarios.

## Architecture

The project follows a layered architecture that separates concerns and promotes code reusability.

## Technologies

This project uses the following technologies:

| Technology | Version |
|---|---|
| `Serenity BDD` | `4.3.2` |
| `Java` | `21` |
| `Lombok` | `9.1.0` |
| `Spotless` | `8.1.0` |
| `Serenity BDD` | `4.3.2` |
| `Serenity Rest-Assured` | `4.3.4` |
| `Logback` | `1.5.21` |
| `Jackson` | `3.0.2` |
| `Assertj` | `3.27.6` |
| `JsonUnit` | `5.1.0` |
| `Cucumber` | `7.32.0` |
| `JunitPlatform` | `6.0.1` |
| `Jupiter` | `6.0.1` |

## Getting Started

To get a copy of the project up and running on your local machine, follow these simple steps.

### Prerequisites

- `Java JDK 21`
- `Gradle 8.1.0` or higher

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/rest-assured-project.git
   ```
2. **Navigate to the project directory:**
   ```bash
   cd rest-assured-project
   ```
3. **Build the project to download dependencies:**
   ```bash
   ./gradlew build
   ```

## Running the tests

To run the tests, you can use the following command:

```bash
./gradlew test
```

This will execute the tests and generate a `Serenity` report in the `target/site/serenity` directory.

## Reports

After running the tests, you can view the `Serenity` report by opening the `index.html` file in your browser:

```bash
open target/site/serenity/index.html
```

The report provides a detailed overview of the test results, including a breakdown of each test scenario and the steps involved.

## Code Style

This project uses `Spotless` to enforce a consistent code style. `Spotless` automatically formats the code to meet the project's style guidelines, which helps to maintain a clean and readable codebase.

To apply the code style, run the following command:

```bash
./gradlew spotlessApply
```

This will format all the `Java` files in the project.

## Contributing

Contributions are welcome! Please feel free to submit a pull request or open an issue if you have any suggestions or find any bugs.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Changelog

All notable changes to this project will be documented in the [CHANGELOG.md](CHANGELOG.md) file.

Enjoy!
