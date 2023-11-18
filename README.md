# SimpleExample-Spring-JPA-Hibernate-MySQL-CRUD

This is simple example for Spring project with JPA, Hibernate, MySQL DB and CRUD operations. Frontend is not included in the project!
Spring boot version: 3.1.5

Software requires: 
1. MySQL Server(not included in the project, for more details check URL: [MySQL community server](https://dev.mysql.com/downloads/mysql));
2. Java 17 LTS;

Useful tools(optional):
1. MySQL Workbench user interface tool URL: [MySQL Workbench](https://dev.mysql.com/downloads/workbench)
2. Multiple DB user interface tool URL: [DBever - Universal Database Tool](https://dbeaver.io/download)

Project setup:

1. Install MySQL Server;
2. Install Java 17+ LTS
3. Create new user in the DB with all privilegies by run this script in the MySQL Workbench:

	-- Now create user with all privileges
	CREATE USER 'springuser'@'localhost' IDENTIFIED BY 'springuser';

	GRANT ALL PRIVILEGES ON * . * TO 'springuser'@'localhost';

4. Connect to the DB with the new user "springuser"
5. Before running the project change configuration "spring.jpa.hibernate.ddl-auto=update"
6. Run the project and have fun

