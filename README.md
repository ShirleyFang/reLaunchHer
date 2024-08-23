# reLaunchHer

## set up dataBase

- create a database - relaunchher;
- create a table - user_info;
- add a fake user data;
<!-- - set up environment variable
    - run -> debug -> configuration -> Environment variables: DB_URL=jdbc:mysql://localhost:3306/yourdb;DB_USERNAME=youruser;DB_PASSWORD=yourpassword -->
- set up application.properties file like this:
    - spring.datasource.url=jdbc:mysql://localhost:3306/yourdb
    - spring.datasource.username=root
    - spring.datasource.password=yourpassword

## run the project
- frontend
    - npm start
- whole project
    - ./mvnw clean install


## result

- frontend: http://localhost:3000/
![Alt text](./frontend.png)
- backend: http://localhost:8080/user/1
![Alt text](./backend.png)
