FROM openjdk:8u212-jre
MAINTAINER cactusli 1183895890@qq.com

COPY ./target/nstr-gateway-2.2-RELEASE.jar /nstr/nstr-gateway-2.2-RELEASE.jar
ADD agent.zip /agent

ENTRYPOINT ["java", "-javaagent:/agent/skywalking-agent.jar", "-Dskywalking.agent.service_name=nstr-gateway", "-Dskywalking.collector.backend_service=192.168.1.10:11800", "-jar", "/nstr/nstr-gateway-2.2-RELEASE.jar"]