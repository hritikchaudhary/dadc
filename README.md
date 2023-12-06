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

## Direct Deployment of Provided JAR

To directly deploy the provided JAR file without modifying the default configuration:

1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   ```

2. **Run the JAR**:
   Execute the following command in the project directory to run the provided JAR:
   ```bash
   java -jar path/to/your/application-name.jar
   ```

3. **Access the Dashboard**:
   Once the application starts successfully, access the dashboard by navigating to `http://localhost:8080` in your web
   browser.

## Custom Configuration for PostgreSQL

If you prefer custom configurations for PostgreSQL, follow these steps:

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
   java -jar target/application-name.jar
   ```

6. **Access the Dashboard**:
   Once the application starts successfully, access the dashboard by navigating to `http://localhost:8080` in your web
   browser.

### Options to Override Properties:

1. **External Properties File:**
   Place an external `application.properties` file outside the JAR. Spring Boot can load properties from a few
   predefined locations, such as:
    - `/config` folder within the current directory
    - The current directory
    - A directory defined by the `SPRING_CONFIG_LOCATION` environment variable
    - Classpath roots

   For example, create an `application.properties` outside the JAR in the production server and specify the database
   configuration there.

2. **Environment Variables:**
   Define environment variables for database configurations. Spring Boot automatically maps environment variables to
   properties. For instance:
    - `SPRING_DATASOURCE_URL`
    - `SPRING_DATASOURCE_USERNAME`
    - `SPRING_DATASOURCE_PASSWORD`

   Setting these environment variables in the production environment will override the properties inside the JAR.

3. **Command-Line Arguments:**
   You can also provide properties via command-line arguments when starting the Spring Boot application:
   ```bash
   java -jar your-application.jar --spring.datasource.url=jdbc:mysql://prod-db-url --spring.datasource.username=db_user --spring.datasource.password=db_password
   ```

   These arguments will override the properties defined in the `application.properties` file within the JAR.

### Best Practices:

- **Security:** Avoid storing sensitive information directly in properties files or in environment variables in
  plaintext. Instead, consider using secure storage mechanisms or environment-specific vaults/secrets managers.

- **Automation:** Use deployment scripts or configuration management tools to handle environment-specific configurations
  during deployment.

- **Profiles:** Spring Boot supports profiles (`application-{profile}.properties`). You can have different
  configurations for different environments by activating the respective profiles (`spring.profiles.active=prod` in
  the `application.properties` file, for instance).

By using these methods, you can effectively manage different configurations for your Spring Boot application in various
environments without altering the JAR file itself.

---

These sections provide options for users: they can directly deploy the provided JAR or customize the PostgreSQL
configuration based on their preferences. Adjust the instructions as needed or include additional details specific to
your project's requirements.