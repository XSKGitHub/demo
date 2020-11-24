<!--
 * @Description: ELK 安装使用手册
 * @Version: 1.0
 * @Autor: x-one
 * @Date: 2020-11-23 15:13:55
 * @LastEditors: x-one
 * @LastEditTime: 2020-11-24 15:24:58
-->

# ELK 使用手册

## 一. Elastic Search

### Elastic Search 配置开机自启动

#### 创建文件

> vim /etc/systemd/system/elasticsearch.service

#### 添加如下内容

> [Unit]  
> Description=elasticsearch  
> [Service]  
> User=es  
> LimitNOFILE=100000  
> LimitNPROC=100000  
> `#`elasticsearch安装路径 （指定自己的安装路径
> ExecStart=/home/es/elasticsearch-7.9.3/bin/elasticsearch
> [Install]
> WantedBy=multi-user.target

#### 设置开机自启

> sudo systemctl daemon-reload  
> #设置启动服务  
> sudo systemctl enable elasticsearch.service  
> #启动elasticsearch  
> sudo systemctl start elasticsearch.service

## 二. Kibana
