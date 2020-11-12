FROM maven:3.6.3-jdk-8 AS build
COPY /CampusCheckin/CampusCheckin/src /home/app/src
COPY /CampusCheckin/CampusCheckin/pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:8
COPY --from=build /home/app/target/CampusCheckin-0.0.1-SNAPSHOT.jar /usr/src/myapp/CampusCheckin.jar
EXPOSE 5000
ENTRYPOINT ["java","-jar","/usr/src/myapp/CampusCheckin.jar"]
