Running the server:

## Option 1 - Setup with static response

1 - Clone project

2 - Open in intellij

6 - Run application

### Option 2 - Setup with JPA (extra)

1 - Clone project

2 - Open in intellij

3 - Install mysql database

4 - Access mysql and create the database with name `DTI`

5 - **Uncomment** all lines in the following files:

Java folder[-]

    - api/UserControllerProduction.java
    - entities/User.java
    - mapper/UserMapper.java
    - repositoy/AuthRepository.java
    - repositoy/UserRepository.java

resources folder [-]

    - application.properties
 
pom.xml file

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>

5 - Edit application properties with your `database name`, `user` and `password` for your mysql

    ```
    spring.datasource.url=jdbc:mysql://localhost:3306/{DB_NAME}
    spring.datasource.username=${USER}
    spring.datasource.password=${PASSWORD}
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.jpa.database-platform = org.hibernate.dialect.MySQL5Dialect
    spring.jpa.generate-ddl=true
    spring.jpa.hibernate.ddl-auto = update
    ```

6 - Run application




