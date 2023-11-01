FROM openjdk:17
EXPOSE 8080
ADD target/spring-boot-apps.jar spring-boot-apps.jar
ENTRYPOINT ["java","-jar","spring-boot-apps.jar"]