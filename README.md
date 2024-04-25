# Wallet Service

This service provides endpoints for managing user accounts and their associated wallets. It facilitates operations such as user creation, login, wallet transactions (deposit and withdrawal), and transaction history retrieval.

## Table of Contents
1. [User Controller](#user-controller)
2. [Wallet Controller](#wallet-controller)
3. [Usage](#usage)
4. [Dependencies](#dependencies)
5. [Setup](#setup)

## User Controller

### Endpoints

- **GET** `/wallet/users`: Retrieve a list of all users.
- **GET** `/wallet/users/{userId}`: Retrieve details of a specific user by their ID.
- **POST** `/wallet/users`: Create a new user.
- **POST** `/wallet/login`: Login user.

## Wallet Controller

### Endpoints

- **GET** `/wallet/wallets/{userId}`: Retrieve the wallet associated with a user.
- **POST** `/wallet/wallets/{userId}/deposit`: Deposit funds into a user's wallet.
- **POST** `/wallet/wallets/{userId}/withdraw`: Withdraw funds from a user's wallet.
- **GET** `/wallet/wallets/{userId}/transactions`: Retrieve transaction history for a user.
- **GET** `/wallet/wallets/{userId}/transactions/{transactionId}`: Retrieve details of a specific transaction for a user.
- **POST** `/wallet/wallets/{userId}/transactions`: Add a transaction for a user.

## Usage

- Utilize the provided endpoints to interact with user accounts and wallets.
- Ensure proper authentication and authorization mechanisms are implemented based on your application requirements.

## Dependencies

- Spring Boot
- Spring Data JPA
- ModelMapper

## Setup

1. Clone this repository.
2. Configure your database connection in `application.properties`.
3. Build and run the application using Maven or your preferred IDE.

Please feel free to contribute by submitting bug reports, feature requests, or pull requests.
