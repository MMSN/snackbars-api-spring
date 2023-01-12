FROM openjdk:8-jdk-alpine
LABEL Mateus Nascimento <mateus.msnascimento@gmail.com>
COPY target/snack-bars-0.0.1-SNAPSHOT.jar snack-bars-0.0.1-SNAPSHOT.jar

#ARG JAR_FILE=*.jar
#COPY ${JAR_FILE} application.jar

#ENTRYPOINT ["java", "-jar", "application.jar"]
ENV _JAVA_OPTIONS="-XX:MaxRAM=70m"
CMD java $_JAVA_OPTIONS -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE -Dspring.datasource.url=$SPRING_DATASOURCE_URL -Dspring.liquibase.url=$SPRING_LIQUIBASE_URL -Dspring.datasource.username=$SPRING_DATASOURCE_USERNAME -Dspring.datasource.password=$SPRING_DATASOURCE_PASSWORD -jar snack-bars-0.0.1-SNAPSHOT.jar
