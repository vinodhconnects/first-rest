FROM openjdk:17-alpine
ENV DBHOST=localhost
ENV DBPORT=3306
ENV DBUSER=sample
ENV DBPASS=nothing
ENV DBNAME=dummy
COPY target/first-rest-microservice-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]