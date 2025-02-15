FROM openjdk:17-jdk-slim

# Instalar o Maven
RUN apt-get update && apt-get install -y \
    maven \
    curl \
    gnupg2 \
    lsb-release \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app

# Copia o projeto inteiro
COPY . /app

# Compila o projeto (assumindo que você usa Maven)
RUN mvn clean package

# Executa o JAR gerado
CMD ["java", "-jar", "target/seu-projeto.jar"]

EXPOSE 50073
