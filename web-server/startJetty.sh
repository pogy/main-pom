MAVEN_OPTS=''
if [ $1 = 'd' ] ; then
 MAVEN_OPTS='-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=y'
fi
export MAVEN_OPTS
mvn jetty:run


