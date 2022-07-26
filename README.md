# inventory-employee
Inventory-employee

Creation of API rest for employee inventory for COVID-19 vaccines

## Installation

Install my-project with npm

Install the necessary dependencies, using the MAVEN install command.

Review the database settings in the project's resource folder.
The database BACKUP found in the project is called "inventoryEmployee"
```bash
spring.jpa.database=postgresql
spring.jpa.show-sql=false
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/inventory
spring.datasource.username=postgres
spring.datasource.password=root

```

## Run Locally

Clone the project

```bash
  git clone https://github.com/dennysgf/inventory-employee.git
```

Go to the project directory

```bash
  cd inventory-employee
```

Install dependencies

```bash
  mvm install
```

Start the server

```bash
  mvn spring-boot:run
```


## Documentation

To review each of the endpoints, you can use the SWAGGER doc at the following link.
The port varies according to the local configuration that is given.
http://localhost:8080/swagger-ui/index.html#/

