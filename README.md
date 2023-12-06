# Spring Boot Analytics Dashboard Setup

This project is a Spring Boot application that serves as an analytics dashboard. To successfully run the application,
it's required to set up PostgreSQL and configure the `application.properties` file with the necessary database
credentials.

## Prerequisites

Before setting up the Spring Boot application, ensure you have the following prerequisites installed and configured:

- **PostgreSQL**: Install PostgreSQL and set it up with the following configurations:
    - **Database Name**: `analytics`
    - **Port**: `5432` (Default PostgreSQL port)
    - **Username**: `postgres` (or your preferred username)
    - **Password**: `postgres` (or your preferred password)

## Deployment 

1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   ```

2. **Open the Project**:
   Navigate to the project directory:
   ```bash
   cd project-directory
   ```

3. **Customize `application.properties`**:
   Modify the `application.properties` file in the project or set environment variables for PostgreSQL connection:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/custom_database
   spring.datasource.username=custom_user
   spring.datasource.password=custom_password
   ```

4. **Build the Application**:
   Execute the following command in the project directory to build the Spring Boot application:
   ```bash
   ./mvnw clean package
   ```

5. **Run the Application**:
   Once the build is successful, a JAR file will be generated in the `target/` directory. Run the JAR file using the
   following command:
   ```bash
   java -jar target/dadc-0.0.1-SNAPSHOT.jar
   ```

6. **Access the Dashboard**:
   Once the application starts successfully deploy https://github.com/hritikchaudhary/dadc-ui, access the dashboard by navigating to `http://localhost:4200` in your web
   browser.
