FROM openjdk:latest
EXPOSE 8080
RUN mkdir /backend
COPY target/spring-boot-nuxt.jar /backend
WORKDIR /backend
ENTRYPOINT ["java","-jar","spring-boot-nuxt.jar"]