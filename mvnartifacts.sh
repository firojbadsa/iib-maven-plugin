mvn install:install-file -Dfile=lib/com.ibm.mq.allclient.jar -DgroupId=com.ibm.mq -DartifactId=allclient -Dversion=8.0.6 -Dpackaging=jar
mvn install:install-file -Dfile=lib/com.ibm.mq.traceControl.jar -DgroupId=com.ibm.mq -DartifactId=traceControl -Dversion=8.0.6 -Dpackaging=jar
mvn install:install-file -Dfile=lib/fscontext.jar -DgroupId=com.ibm.mq -DartifactId=fscontext -Dversion=8.0.6 -Dpackaging=jar
mvn install:install-file -Dfile=lib/jms.jar -DgroupId=com.ibm.mq -DartifactId=jms -Dversion=8.0.6 -Dpackaging=jar
mvn install:install-file -Dfile=lib/providerutil.jar -DgroupId=com.ibm.mq -DartifactId=providerutil -Dversion=8.0.6 -Dpackaging=jar
mvn install:install-file -Dfile=lib/IntegrationAPI.jar -DgroupId=com.ibm.iib -DartifactId=IntegrationAPI -Dversion=10.0.0 -Dpackaging=jar
mvn install:install-file -Dfile=lib/brokerutil.jar -DgroupId=com.ibm.iib -DartifactId=brokerutil -Dversion=10.0.0 -Dpackaging=jar