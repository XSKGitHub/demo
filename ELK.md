<!--
 * @Description: ELK 安装使用手册
 * @Version: 1.0
 * @Autor: x-one
 * @Date: 2020-11-23 15:13:55
 * @LastEditors: x-one
 * @LastEditTime: 2020-11-23 15:29:16
-->

## Elastic Search 配置开机自启动

    cd /etc/init.d
    vim es-server
> 编写启动脚本

    #!/bin/bash
    #chkconfig: 345 63 37
    #description: elasticsearch
    #processname: elasticsearch-7.7.1
    
    export ES_HOME=/opt/elasticsearch-7.7.1     【这个目录是你Es所在文件夹的目录】
    
    case $1 in
            start)
                    su elk<<!        【es 这个是启动es的账户，如果你的不是这个记得调整】
                    cd $ES_HOME
                    ./bin/elasticsearch -d -p pid
                    exit
    !
                    echo "elasticsearch is started"
                    ;;
            stop)
                    pid=`cat $ES_HOME/pid`
                    kill -9 $pid
                    echo "elasticsearch is stopped"
                    ;;
            restart)
                    pid=`cat $ES_HOME/pid`
                    kill -9 $pid
                    echo "elasticsearch is stopped"
                    sleep 1
                    su elk<<!     【es 这个是启动es的账户，如果你的不是这个记得调整】
                    cd $ES_HOME
                    ./bin/elasticsearch -d -p pid
                    exit
    !
                    echo "elasticsearch is started"
            ;;
        *)
            echo "start|stop|restart"
            ;; 
    esac
    exit 0

> 修改文件权限

    chmod 777 es-server

> 添加系统服务，开机自启

    chkconfig --add es-server
    
> 启动，关闭、重启服务

    service es-server start
    service es-server stop
    service es-server restart