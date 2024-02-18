# Usar a imagem base do OpenJDK
FROM openjdk:17-jdk-slim

# Configurar um diretório para o trabalho
WORKDIR /app

# Copiar o build.gradle e o gradlew para usar o cache de dependências eficientemente
COPY gradlew /app/
COPY gradle /app/gradle
COPY build.gradle /app/

# Copiar o código fonte do projeto
COPY src /app/src

# Conceder permissão de execução ao gradlew
RUN chmod +x ./gradlew

# Construir o aplicativo usando o Gradle Wrapper
RUN ./gradlew build -x test

# Mover o artefato construído para um local específico e remover os outros arquivos de construção
RUN mv build/libs/api-gateway-0.0.1.jar /app/app.jar
RUN rm -rf build gradle gradlew src build.gradle

# Comando para rodar a aplicação
ENTRYPOINT ["java","-jar","app.jar"]
