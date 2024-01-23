FROM openjdk:17
EXPOSE 80
ADD target/service-proxy.jar service-proxy.jar
ENTRYPOINT [ "java" ,"-jar","service-proxy.jar"]