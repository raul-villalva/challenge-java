# Usamos imagen de Maven para build
FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /app

# Copiamos pom y descargamos dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos el código y compilamos
COPY src ./src
RUN mvn clean package -DskipTests

# Imagen final con JDK para ejecutar
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copiamos el jar generado
COPY --from=build /app/target/*.jar app.jar

# Puerto expuesto
EXPOSE 8080

# Comando de arranque
ENTRYPOINT ["java","-jar","app.jar"]
