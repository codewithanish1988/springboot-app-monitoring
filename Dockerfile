FROM eclipse-temurin:21-jre
ADD target/springboot-app-monitoring.jar springboot-app-monitoring.jar
ENTRYPOINT ["java", "-jar", "springboot-app-monitoring.jar"]