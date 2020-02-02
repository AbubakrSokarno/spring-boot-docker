# Build the app using maven, and deploy it with docker 
# Run the following commands
* ./mvnw package ; java -jar target/flairstech-spring-boot-docker-0.1.0.jar
* docker build -t flairstech/spring-boot-docker .
* ./mvnw com.google.cloud.tools:jib-maven-plugin:dockerBuild -Dimage=flairstech/spring-boot-docker
* docker run -p 8000:8080 flairstech/spring-boot-docker

# To run it localy not in docker container run the following command in the project directory
* ./mvnw spring-boot:run

# The database found here  https://github.com/ghusta/docker-postgres-world-db

# Please Don't forget to configure the DATABASE connection with the application, please check db.conf file and change the database configuration for your environment
