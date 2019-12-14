# 基础镜像
FROM java:8
# 指定作者
MAINTAINER xiaohe
# 把文件复制到镜像中, 路径是相对于 Dockerfile
ADD docker-java-app-1.0.0.jar /app/docker-java-app-1.0.0.jar
ADD application.properties /app/application.properties
# 容器内部程序启动命令
ENTRYPOINT ["java","-jar","-Dspring.config.location=/app/application.properties","/app/docker-java-app-1.0.0.jar"]
