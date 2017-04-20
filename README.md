# iib-maven-plugin

This is a maven plugin for the build cycle of the Libraries and Applications in Integration Toolkit 10

## How to install and use
### pre-requirements
* maven
* IBM® Integration Toolkit 
### instalation
* Clone the project
* Install the thrid party jars. there is a script inside the project
** For windows run "mvnartifacts.cmd "
** For linux run "./mvnartifacts.sh"
* Run "mvn install" to install the plugin into the local repository

### How to use
#### example pom.xml for an Application
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>${groupId}</groupId>
	<artifactId>${artifactId}</artifactId>
	<version>${version}</version>
    <packaging>bar</packaging>
    <properties>
        <integrationServer>${integrationServer}</integrationServer>
    </properties>
    <scm>					 
    	<developerConnection>scm:svn:${svnTag}</developerConnection>
    </scm>
    <distributionManagement>
        <repository>
            <id>local-repository</id>
            <name>Local Repository</name>
            <url>${distributionManagement}</url>
        </repository>
    </distributionManagement> 
    <build>
        <plugins>
            <plugin>
                <groupId>com.iib.plugins</groupId>
                <artifactId>iib-maven-plugin</artifactId>
                <version>1.0</version>
                <extensions>true</extensions>
            </plugin>
        </plugins>
        <pluginManagement>
        	<plugins>
        		<plugin>
        			<groupId>org.eclipse.m2e</groupId>
        			<artifactId>lifecycle-mapping</artifactId>
        			<version>1.0.0</version>
        			<configuration>
        				<lifecycleMappingMetadata>
        					<pluginExecutions>
        						<pluginExecution>
        							<pluginExecutionFilter>
        								<groupId>
        									com.iib.plugins
        								</groupId>
        								<artifactId>
        									iib-maven-plugin
        								</artifactId>
        								<versionRange>
        									[1.0-SNAPSHOT,)
        								</versionRange>
        								<goals>
        									<goal>compile</goal>
        									<goal>
        										process-resources
        									</goal>
        								</goals>
        							</pluginExecutionFilter>
        							<action>
        								<ignore />
        							</action>
        						</pluginExecution>
        					</pluginExecutions>
        				</lifecycleMappingMetadata>
        			</configuration>
        		</plugin>
        	</plugins>
        </pluginManagement>
    </build>   
</project>
```

#### example pom.xml for a Library
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>${groupId}</groupId>
	<artifactId>${artifactId}</artifactId>
	<version>${version}</version>
	<packaging>iib-artifact</packaging>
	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	</properties>
	<scm>					 
    		<developerConnection>scm:svn:${svnTag}</developerConnection>
    	</scm>
	<distributionManagement>
		<repository>
		    <id>local-repository</id>
		    <name>Local Repository</name>
		    <url>${distributionManagement}</url>
		</repository>
    	</distributionManagement> 	
	<build>
		<plugins>
			<plugin>
				<groupId>com.iib.plugins</groupId>
				<artifactId>iib-maven-plugin</artifactId>
				<version>1.0</version>
				<extensions>true</extensions>
			</plugin>
		</plugins>
	</build>
</project>`
```

#### Configuration for deployment
To artifact you have to give the information about tha queue manager (for the MQ Scripts) and the integration bus (for the Application).
This information is in the properties ( you can add the properties in the `settings.xml` file of your maven installation or in the `pom.xml` file)

in `settings.xml` i added a profile for each enviroment.
Example of profile configuration for DEV.
```xml
    <profile>
      <id>DEV</id>
      <properties>
      	<mq.host>${mqhost}</mq.host>
	<mq.port>${mqport}</mq.port>
	<mq.queueManager>${queueManagerName}</mq.queueManager>
	<mq.channel>${channel}</mq.channel>
	<mq.user>${user if needed}</mq.user>
	<mq.password>${password if needed}</mq.password>
		
        <iib.host>${IntegrationBusIPNode}</iib.host>
        <iib.port>${Port of webconsole}</iib.port>
        <iib.user>${user if needed}</iib.user>
        <iib.password>${password if needed}</iib.password>
      </properties>
    </profile>
```

#### After the configuration... the deployment
* First of all you should build and publish you project into the distribution management system (Nexus)
* the plugin deploy the artifact that is published in the distribution management system

