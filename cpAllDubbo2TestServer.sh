#!/bin/bash

modules="item monitor order package spread store ucenter"
otherModules="daifa photo"

serverTest="root@192.168.1.193"
serverDev="udev@192.168.1.192"
serverDev195="dev195@192.168.1.193"

deployModule=${modules}

# 部署服务器位置
case $1 in
dev)
    deployServer=${serverDev}
    ;;
dev195)
    deployServer=${serverDev195}
    ;;
*)
    deployServer=${serverTest}
esac
if [ ! $2 -z ]
then
    deployModule=$2
fi

echo "server:${deployServer}"
echo "dubbo_module: ${deployModule}"

dubbos=""
for module in ${deployModule}
do
    scp main4-${module}/main4-${module}-default/target/main4-${module}-default-assembly.zip ${deployServer}:/acs/${module}_dubbo/upload/
    dubbos+="${module}_dubbo "
done

ssh -f ${deployServer} docker restart ${dubbos}