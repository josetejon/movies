# movies7
In order to run it, you need to create the image for the app:

./mvnw package && java -jar target/gs-spring-boot-docker-0.1.0.jar

sudo docker build -t movies .

And then, compose the dockers:

sudo docker-compose up
