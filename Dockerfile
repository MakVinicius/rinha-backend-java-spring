# Start by basing it on another image
#FROM openjdk:17-alpine
# Create /home/app folder in the container
#RUN mkdir -p /home/app
# Copies the source (.) into the destination (/home/app)
#COPY . /home/app
# Executes the node server.js command
#ENTRYPOINT ["node", "server.js"]


FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/rinha-backend-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]