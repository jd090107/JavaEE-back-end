FROM java:openjdk-8-alpine

ADD ./target/locust-runner-1.0.0.jar app.jar
ADD ./locust-files locust-files
ADD ./src/main/resources/application.properties  application.properties
EXPOSE 8080
VOLUME ["/home"]
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar --spring.config.location=/application.properties" ]