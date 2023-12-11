FROM openjdk:20
COPY ./target/amcef-0.0.1-SNAPSHOT.jar amcef.jar
ENTRYPOINT ["java","-jar","/amcef.jar"]