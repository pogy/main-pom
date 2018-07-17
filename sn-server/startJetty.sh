#!/bin/bash
MAVEN_OPTS=''
if [ $# -gt '0' ] ; then
  echo $#
 if [ $1 = 'd' ] ; then
  MAVEN_OPTS='-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=y'
 fi

fi
export MAVEN_OPTS
mvn jetty:run -X


