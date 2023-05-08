FROM openjdk:17
WORKDIR /
ADD ./target/apteka-1.0.jar apteka.jar

EXPOSE 8888
CMD java - jar apteka.jar