# Bank Application (Under Development)

## Description
Bank Application is an application for managing clients and deposits in a bank. The application provides interfaces for both clients and administrators, allowing them to perform various operations related to bank accounts.

## Features
- **Login**: Users can log in as clients or administrators using their respective authentication data.
- **Client Interface**: Clients will be able view their accounts, make transactions, manage deposits, and access various functions.
- **Administrator Interface**: Administrators will have access to advanced features such as creating new clients, browsing the client list, and managing their accounts.
- **Account Creation**: Administrators will be able to create new client accounts by entering the necessary information about the new user.

## Requirements
- JavaFX: Required library for creating the user interface in a Java application.
- SQLite: Required database for storing information about clients and their accounts.
- FontAwesomeFX: Required library for using icons in the user interface.

## Project Status
This project is currently under development and is being actively worked on in spare time. New features, improvements, and bug fixes may be added in future updates.

## Project Structure
The project consists of the following components:
- **Source Code**: Contains the source code files for the application.
- **Resources**: Contains FXML and CSS files used for building the user interface with Scene Builder.
- **Database**: Contains the SQLite database file (`bank.db`) with the structure and data stored in the database.
- **POM file**: Contains the configuration for the Maven project, specifying dependencies and build settings.

## Running
To run the application, use the `App` class as the entry point. Ensure that the required dependencies are installed and configured properly. Additionally, make sure that the `bank.db` file is accessible and correctly configured for database operations.