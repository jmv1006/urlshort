FROM eclipse-temurin:latest@sha256:41acc982e932eeb61a51af3262f3070ccfc23a32fd6f89bc16e7fec7647979fa
ARG JAR_FILE=target/urlshort-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]