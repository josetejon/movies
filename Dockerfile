FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} MoviesApplication.jar
ENTRYPOINT ["java","-jar","/MoviesApplication.jar"]
