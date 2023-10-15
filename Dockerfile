# Usar imagem base oficial do Java
FROM openjdk:11-jre-slim

# Copiar o JAR para a imagem
COPY target/jvm-teste-1.0-SNAPSHOT.jar /app/MemoryEater.jar

# Comando para executar a aplicação

CMD java $JAVA_OPTS -jar /app/MemoryEater.jar
