find | grep dubbo.properties | xargs grep zoo -l | xargs sed -i s#zookeeper://[0-9\.]*:[0-9]*#zookeeper://localhost:2181#g
