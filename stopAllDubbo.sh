ps -ef | grep java | grep DubboStart | awk '{print $2}' | xargs -I {} kill -9 {}
