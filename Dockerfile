FROM eclipse-temurin:25
WORKDIR /app
COPY . .
EXPOSE 8080
RUN ./gradlew build
ENTRYPOINT ["java","-jar","./build/libs/URLshortner-1.0-SNAPSHOT.jar"]


