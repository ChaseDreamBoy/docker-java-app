# 制作 springboot 项目的 dockerfile 

1. 把 springboot 项目打个 jar 包, 我这里是 : `docker-java-app-1.0.0.jar`
2. 把 jar 包上传到服务器指定文件夹
3. 在 jar 包同目录下新建 Dockerfile 文件

Dockerfile 文件内容:

```shell script
# 基础镜像
FROM java:8
# 指定作者
MAINTAINER xiaohe
# 挂载文件
VOLUME /tmp
# 把文件复制到镜像中
ADD docker-java-app-1.0.0.jar /docker-java-app-1.0.0.jar
# 容器内部程序启动命令
ENTRYPOINT ["java","-jar","/docker-java-app-1.0.0.jar"]
```

构建镜像:

```shell script
# -t 指定新生成镜像的名称与版本
# -f 指定 Dockerfile 文件的路径
# 最后的 ./ 是指定该目录作为构建的环境目录
$ sudo docker build -t docker-java-app:1.0.0 -f ./Dockerfile ./
```

创建并启动容器:

```shell script
# -d 表示后台运行容器
# --rm 表示容器停止后就删除该容器
# --name 指定容器名称
# -p <host-port>:<container-port> 端口映射
# 最后的 docker-java-app:1.0.0 是指定镜像名称和版本
$ sudo docker run -d --rm --name docker-test-jar -p 8081:8081 docker-java-app:1.0.0
```


文件结构与构建镜像与启动过程:

[file_structure](./file_structure.png)

如果在服务器的防火墙是打开的，就可以在外网使用服务器ip + 映射端口连接 springboot 服务了。

