FROM openjdk:8u212-jre
MAINTAINER cactusli 1183895890@qq.com

COPY ./target/nstr-search-2.2-RELEASE.jar /nstr/nstr-search-2.2-RELEASE.jar
ADD agent /agent

ENTRYPOINT ["java", "-javaagent:/agent/skywalking-agent.jar", "-Dskywalking.agent.service_name=nstr-search", "-Dskywalking.collector.backend_service=192.168.1.10:11800", "-jar", "/nstr/nstr-search-2.2-RELEASE.jar"]