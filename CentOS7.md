<!--
 * @Description: centos7 系统使用手册
 * @Version: 1.0
 * @Autor: x-one
 * @Date: 2020-11-23 14:14:26
 * @LastEditors: x-one
 * @LastEditTime: 2020-11-27 09:50:08
-->

# 一、CentoOS 7 日期时间设置

## 1.1 设置系统时间为中国时区并启用NTP同步

1. 安装ntp服务
    >yum install -y ntp

2. 开机启动服务
    >systemctl enable ntpd

3. 启动服务
    >systemctl start ntpd

4. 更改时区
    >timedatectl set-timezone Asia/Shanghai
5. 启用ntp同步
    >timedatectl set-ntp yes
6. 同步时间
    >ntpq -p

## 1.2 timedatectl 命令

    # 读取时间
    timedatectl  //等同于 timedatectl status
    # 设置时间
    timedatectl set-time "YYYY-MM-DD HH:MM:SS"
    # 列出所有时区
    timedatectl list-timezones
    # 更改时区
    timedatectl set-timezone Asia/Shanghai
    # 或   ln -sf /usr/share/zoneinfor/Asia/Shanghai /etc/localtime     
    设置是否与NTP服务器同步
    timedatectl set-ntp yes  //yes或者no
    将硬件时钟调整为与本地时钟一致
    hwclock --systohc --localtime 或 timedatectl set-local-rtc 1
    注，硬件时钟默认使用UTC时间，因为硬件时钟不能保存时区和夏令时调整，修改后就无法从硬件时钟中读取出准确标准时间，因此不建议修改。修改后系统会出现警告。
    将硬件时间设置成 UTC
    hwclock --systohc --utc 或 timedatectl set-local-rtc 1
    # 显示硬件时间：
    hwclock --show
    # 设置硬件时间：
    hwclock --set --date ‘08/02/2012 12:00:00’
    # 将硬件时间同步到系统时间：
    hwclock --hctosys
    # 强制把系统时间写入CMOS：
    # clock -w

# 二、CentOS 7 防火墙管理

## 2.1 防火墙开放端口

### 查看已开放端口

> sudo firewall-cmd --list-ports

### 开放端口 / 关闭端口

> sudo firewall-cmd --zone=public --add-port=9200/tcp --permanent  
> sudo firewall-cmd --zone=public --remove-port=9200/tcp --permanent

### 重启防火墙

> sudo firewall-cmd --reload

### 开启/停止防火墙

> sudo systemctl start firewalld  
> systemctl stop firewalld

### 开机启动/禁止防火墙

> sudo systemctl enable firewalld  
> sudo systemctl disable firewalld

## 2.2 防火墙关闭

# 三、文件权限管理

授予全部权限
>chmod -R 777 dirPath

# 四、 常用命令

## ps aux
