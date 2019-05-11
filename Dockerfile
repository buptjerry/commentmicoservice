FROM java:8
MAINTAINER bupt.coder
ADD build/libs/comment-microservice-1.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

# spring.profiles.active=create
# spring.profiles.active=upfate