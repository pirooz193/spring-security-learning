FROM openjdk:11
COPY . /my-first-app
WORKDIR /my-first-app
CMD java -jar online-exam-0.0.1-SNAPSHOT.jar spring.profiles.active=dev