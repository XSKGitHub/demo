<!--
 * @Description: ELK 安装使用手册
 * @Version: 1.0
 * @Autor: x-one
 * @Date: 2020-11-23 15:13:55
 * @LastEditors: x-one
 * @LastEditTime: 2020-11-26 17:05:46
-->

# ELK 使用手册

## 一、环境准备

### 修改系统配置

1. 修改进程最大打开文件数
    > vim /etc/security/limits.conf  
    > `#` 增加下面配置  
    > `*` soft nofile 65536  
    > `*` hard nofile 65536
2. 修改最大线程个数
    > vim /etc/security/limits.conf  
    > `#` 增加下面配置  
    > `*` soft nproc 4096  
    > `*` hard nproc 4096
3. 修改虚拟内存
    > vim /etc/sysctl.conf  
    > `#` 修改配置  
    > vm.max_map_count=262144  
    > `#` 修改生效  
    > sysctl -p

### 1.1 ContOS 7

## 二、Elastic Search

### Elastic Search 配置开机自启动

1. 创建文件
    > sudo vim /etc/systemd/system/elasticsearch.service
2. 添加如下内容
    > [Unit]  
    > Description=elasticsearch  
    > [Service]  
    > User=es  
    > LimitNOFILE=100000  
    > LimitNPROC=100000  
    > ExecStart=serviceName  
    > [Install]  
    > WantedBy=multi-user.target
3. 设置开机自启
    > sudo systemctl daemon-reload  
    > #设置启动服务  
    > sudo systemctl enable elasticsearch.service  
    > #启动elasticsearch  
    > sudo systemctl start elasticsearch.service
4. 注意如果第一次配置失败需要执行一次下面命令
    > systemctl disable （服务名）

## 三、 Kibana

### 下载 安装

``` python
wget https://artifacts.elastic.co/downloads/kibana/kibana-7.9.3-linux-x86_64.tar.gz
```

## 四、Logstash

## 五、Beats

## 六、APM Server

## 七、Elastic Search Hadoop
