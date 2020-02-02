# Build the app, create the database and deploy them with docker 
# Run the following commands
* ./mvnw clean install
* docker-compose up -d 
* docker cp .\world.sql postgres_db:/
* docker exec -it postgres_db psql -U postgres -c "CREATE DATABASE world_db"
* docker exec -it postgres_db psql -U postgres -f world.sql world_db
* docker exec -it spring-boot-docker java -jar app.jar

# To run it localy not in docker container run the following command in the project directory
* ./mvnw spring-boot:run

# The database reference found here  https://github.com/ghusta/docker-postgres-world-db

# Please Don't forget to configure the DATABASE connection with the application, please check db.conf file and change the database configuration for your environment
