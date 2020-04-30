FROM maven:3.6.3-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/SAPEnterprisesBackend-1.0-SNAPSHOT.jar /usr/local/lib/sap.jar
RUN chmod 755 /var/log
USER root
ENTRYPOINT ["java","-jar","/usr/local/lib/sap.jar"]