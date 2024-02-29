# Asset Management REST API

This is a REST API for managing assets in a company.

## Tech Stack

- Spring Boot 2.4
- Spring Data JPA
- H2 Database
- JUnit 5, Spring Boot Test, Mockito

## Endpoints:
- GET /assets: Retrieve all assets.
- GET /assets/{id}: Retrieve an asset by ID.
- POST /assets: Add a new asset.
- PUT /assets/{id}: Update an existing asset.
- DELETE /assets/{id}: Delete an asset by ID.
- GET /assets/search?name={name}: Search assets by name.
- PUT /assets/{assetId}/assign/{employeeId}: Assign an asset to an employee.
- PUT /assets/{assetId}/recover: Recover an asset from an employee.
