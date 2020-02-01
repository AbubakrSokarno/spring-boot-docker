<h2> Build the app using maven, and deploy it with docker </h2>
<h2> Run the following commands </h2>
* ./mvnw package ; java -jar target/flairstech-spring-boot-docker-0.1.0.jar
* docker build -t flairstech/spring-boot-docker .
* ./mvnw com.google.cloud.tools:jib-maven-plugin:dockerBuild -Dimage=flairstech/spring-boot-docker
* docker run -p 8000:8080 flairstech/spring-boot-docker

<h2> The database found here  https://github.com/ghusta/docker-postgres-world-db </h2>

<h2> To configure the database connection with the application, please check db.conf file and change the database configuration for your environment </h2>
