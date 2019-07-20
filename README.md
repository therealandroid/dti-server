# Setup environment

1 - Clone project

2 - Open in intellij

3 - Install mysql database

4 - Access mysql and create the database

5 - Edit application properties file
    
    spring.datasource.url=jdbc:mysql://localhost:3306/{DB_NAME}
    spring.datasource.username=${USER}
    spring.datasource.password=${PASSWORD}
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.jpa.database-platform = org.hibernate.dialect.MySQL5Dialect
    spring.jpa.generate-ddl=true
    spring.jpa.hibernate.ddl-auto = update

6 - Run application


