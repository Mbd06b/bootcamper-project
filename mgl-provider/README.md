

# MGL Provider

## Overview
MGL Provider is a Spring Boot-based RESTful service that demonstrates JPA/Hibernate implementation with H2 database integration. This project is part of the larger bootcamper-project suite and serves as a reference implementation for modern Java persistence patterns.

## Technical Stack
- Spring Boot
- Hibernate/JPA
- H2 Database
- Maven
- Swagger/OpenAPI

## Quick Start

### Prerequisites
- Java 8 or higher
- Maven

### Running the Application
```bash
mvn spring-boot:run
```
The application will start on port 8900.

## Available Endpoints
See: src/main/resources/application.properties for bootstrapped configs

### H2 Database Console
- URL: `http://localhost:8900/h2-ui/`
- Username: `sa`
- Password: `samplePass`

### API Documentation
- Swagger UI: `http://localhost:8900/swagger-ui.html`
  - Interactive API documentation
  - Test endpoints directly from the browser
  - View Hibernate-generated SQL in the console when endpoints are called

## Database Configuration
Database configuration can be found in `src/main/resources/application.properties`. The project uses H2 as an in-memory database for development and testing purposes.

## Development Notes

### Important Notice Regarding Hibernate Criteria Queries
⚠️ **Note:** Since Hibernate 5.2, the Hibernate Criteria API is deprecated. New development should use the JPA Criteria API instead.

When referencing older code samples:
- Hibernate 4 Criteria queries cannot be directly copy/pasted into Hibernate 5/6 projects
- Use existing Hibernate 4 Criteria queries as reference only
- Queries must be rewritten using the JPA Criteria API syntax

## Contributing
Feel free to submit issues and enhancement requests.