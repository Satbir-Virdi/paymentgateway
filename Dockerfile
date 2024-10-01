from amazoncorretto:17

Add target/payments-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ARG USER
ENV DBUSER=$DBUSER

ARG PASSWORD
ENV PASSWORD=$DBPASSWORD

CMD ["java", "-jar", "-Dspring.profiles.active=production", "app.jar"]
