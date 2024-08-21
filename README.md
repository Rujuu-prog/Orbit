# Orbit-backend

It is a backend application for a todo application called Orbit.

## Development

### Prerequisites

Before starting the development environment, make sure you have the following installed:

- **Docker**: To run the application and services in containers.
- **Docker Compose**: To manage multi-container Docker applications.

### Getting Started

1. **Clone the Repository**

   First, clone the repository to your local machine:

   ```bash
   git clone git@github.com:Rujuu-prog/Orbit.git
   cd orbit-backend
   ```

2. **Setup Environment Variables**

   Create an .env file in the root directory or customize the existing .env.example file:

    ```bash
    cp .env.example .env
    ```
   
   Update the environment variables in the .env file as needed.

3. **Start the Development Environment**

    You can start the application using Docker Compose. This will set up all the necessary services:

    ```bash
    docker-compose -f docker/docker-compose.yaml up
    ```

4. **Setup DB**

   If the database tables are not automatically created, you'll need to manually run the `resouces/sql/schema.sql` file.

   Additionally, if initial data is required for the application, please make sure to execute the `resources/sql/data.sql` file after setting up the database schema.

5. **Stopping the Development Environment**

    When you're done with your development session, you can stop and remove the containers:
    ```bash
    docker-compose -f docker/docker-compose.yaml down
    ```

### API Endpoints

The API endpoints and their specifications are documented in the `src/main/resources/api-schema.yaml` file. Please refer to this file for detailed information about the available API routes and their usage.
