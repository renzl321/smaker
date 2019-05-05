
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![codecov](https://codecov.io/gh/zhoutaoo/SpringCloud/branch/master/graph/badge.svg)](https://codecov.io/gh/zhoutaoo/SpringCloud)

## 

# 快速开始 smaker-cloud**

### 先决条件

首先本机先要安装以下环境，建议先学习了解springboot和springcloud基础知识。

- [git](https://git-scm.com/)

- [java8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) 

- [maven](http://maven.apache.org/) 

  **编译与运行**

  ```
  git clone https://github.com/fanxinglong/fisher
  先配置数据库，然后reids，启动mysql,启动nacos
  启动顺序：
  - smaker-auth
  - smaker-back
  - smaker-gateway
  
  如果对您对此项目有兴趣，可以点 "Star" 支持一下 谢谢！ ^_^
  
  或者您可以 "follow" 一下
  
  如有问题请直接在 Issues 中提，或者您发现问题并有非常好的解决方案，欢迎 PR 👍
  
  传送门：前端项目地址
  ```

# **smaker-cloud**是基于`Spring Cloud`微`服务`化`开发平台`，具有统一授权、认证后台管理系统，其中包含具备用户管理、资源权限管理、网关API
管理等多个模块，支持多业务系统并行开发，可以作为后端服务的开发脚手架。代码简洁，架构清晰，适合学习和直接项目中使用。
#技术栈



此项目是 Spring cloud Oauth2 构建的后台管理系统，计划采用以下技术

- 注册中心：Nacos
- 服务网关：Spring cloud-Gateway
- 配置中心：Nacos
- 服务调用：Spring-cloud-open-Feign
- 负载均衡：Spring-cloud-loadbalancer
- 熔断降级：Sentinel
- 消息队列：RabbitMQ
- 权限认证：Spring secruity Oauth2
- 监控服务：zipkin

### QQ群号：667650593

### 基础模块

### 

| 服务          | 使用技术                 | 进度 | 备注                                                  |
| ------------- | ------------------------ | ---- | ----------------------------------------------------- |
| 注册\配置中心 | nacos                    | ✅    |                                                       |
| 消息总线      | SpringCloud Bus+Rabbitmq | ✅    |                                                       |
| 动态网关      | SpringCloud Gateway      | ✅    | 多种维度的流量控制（服务、IP、用户等），后端可配置化🏗 |
| 授权认证      | Spring Security OAuth2   | ✅    |                                                       |
| 服务容错      | SpringCloud Hystrix      | ✅    |                                                       |
| 服务调用      | SpringCloud OpenFeign    | ✅    |                                                       |



### 架构摘要
#### 服务鉴权
通过`JWT`的方式来加强服务之间调度的权限验证，保证内部服务的安全性。

#### 监控
利用Spring Boot Admin 来监控各个独立Service的运行状态；利用Hystrix Dashboard来实时查看接口的运行状态和调用频率等。

#### 负载均衡
将服务保留的rest进行代理和网关控制，除了平常经常使用的node.js、nginx外，Spring Cloud系列的zuul和ribbon，可以帮我们进行正常的网关管控和负载均衡。其中扩展和借鉴国外项目的扩展基于JWT的`Zuul限流插件`，方面进行限流。

#### 服务注册与调用
基于Nacos来实现的服务注册与调用，在Spring Cloud中使用Feign, 我们可以做到使用HTTP请求远程服务时能与调用本地方法一样的编码体验，开发者完全感知不到这是远程方法，更感知不到这是个HTTP请求。

#### 熔断机制
因为采取了服务的分布，为了避免服务之间的调用“雪崩”，采用了`Hystrix`的作为熔断器，避免了服务之间的“雪崩”。

------












## License
Apache License Version 2.0# smaker
