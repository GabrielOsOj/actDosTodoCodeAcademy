FROM openjdk:20-jdk-slim
ARG JAR_FILE=./target/actividadDosTDC-3.4.3.jar
COPY ${JAR_FILE} actividadDosTDC.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","actividadDosTDC.jar"]
