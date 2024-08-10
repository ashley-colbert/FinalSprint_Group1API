FROM eclipse-temurin:17
COPY target/*.jar ./bark-api.jar
EXPOSE 8080
CMD ["java", "-jar", "bark-api.jar"]