#!/usr/bin/env bash
#DIRPATH="/Users/gzy/workspace/gitpro/main-pom"
DIRPATH="/Users/zhaohongbo/Workspaces/idea-workspace8/main-pom"
if [ "$1" = "" ]; then
    scp ${DIRPATH}/main4-daifa/main4-daifa-default/target/main4-daifa-default-assembly.zip root@192.168.1.193:/acs/daifa_dubbo/upload/
    scp ${DIRPATH}/main4-item/main4-item-default/target/main4-item-default-assembly.zip root@192.168.1.193:/acs/item_dubbo/upload/
    scp ${DIRPATH}/main4-monitor/main4-monitor-default/target/main4-monitor-default-assembly.zip root@192.168.1.193:/acs/monitor_dubbo/upload/
    scp ${DIRPATH}/main4-order/main4-order-default/target/main4-order-default-assembly.zip root@192.168.1.193:/acs/order_dubbo/upload/
    scp ${DIRPATH}/main4-spread/main4-spread-default/target/main4-spread-default-assembly.zip root@192.168.1.193:/acs/spread_dubbo/upload/
    scp ${DIRPATH}/main4-store/main4-store-default/target/main4-store-default-assembly.zip root@192.168.1.193:/acs/store_dubbo/upload/
    scp ${DIRPATH}/main4-ucenter/main4-ucenter-default/target/main4-ucenter-default-assembly.zip root@192.168.1.193:/acs/ucenter_dubbo/upload/
    ssh -t -p 22 root@192.168.1.193 "~/restart_all_dubbo.sh"
else
    scp ${DIRPATH}/main4-${1}/main4-${1}-default/target/main4-${1}-default-assembly.zip root@192.168.1.193:/acs/${1}_dubbo/upload/
    ssh -t -p 22 root@192.168.1.193 "~/restart_all_dubbo.sh ${1}"
fi