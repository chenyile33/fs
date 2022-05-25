#项目地址
    https://gitee.com/chenyile/fs.git
#本地环境搭建
## 1、mongo安装

1. 拉取docker镜像

   ```sh
   docker pull mongo:3.6.8
   ```

2. 启动mongo,使用卷持久化数据

   ```sh
   docker run -d -p 27017:27017 --name my-mongo -v mongo-data:/home/ylchen/software/mongo/db mongo:3.6.8
   ```
## 2、nacos安装
    docker run --name my-nacos -e MODE=standalone -p 8848:8848 -d nacos/nacos-server:2.0.2

