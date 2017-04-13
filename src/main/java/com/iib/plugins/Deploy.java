/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iib.plugins;

import com.ibm.broker.config.proxy.BrokerConnectionParameters;
import com.ibm.broker.config.proxy.BrokerProxy;
import com.ibm.broker.config.proxy.ConfigManagerProxyException;
import com.ibm.broker.config.proxy.DeployResult;
import com.ibm.broker.config.proxy.ExecutionGroupProxy;
import com.ibm.broker.config.proxy.IntegrationNodeConnectionParameters;
import java.io.File;
import java.io.IOException;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.BuildPluginManager;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import static org.twdata.maven.mojoexecutor.MojoExecutor.artifactId;
import static org.twdata.maven.mojoexecutor.MojoExecutor.configuration;
import static org.twdata.maven.mojoexecutor.MojoExecutor.element;
import static org.twdata.maven.mojoexecutor.MojoExecutor.executeMojo;
import static org.twdata.maven.mojoexecutor.MojoExecutor.executionEnvironment;
import static org.twdata.maven.mojoexecutor.MojoExecutor.goal;
import static org.twdata.maven.mojoexecutor.MojoExecutor.groupId;
import static org.twdata.maven.mojoexecutor.MojoExecutor.name;
import static org.twdata.maven.mojoexecutor.MojoExecutor.plugin;
import static org.twdata.maven.mojoexecutor.MojoExecutor.version;

/**
 *
 * @author FX13293
 */
@Mojo(name = "deploy")
public class Deploy extends AbstractMojo {

    @Parameter(defaultValue = "${project.build.directory}", property = "outputDir", required = true)
    private File outputDirectory;

    @Parameter(defaultValue = "", property = "iib.host", required = true)
    private String host;
    @Parameter(property = "iib.port", required = true)
    private int port;
    @Parameter(defaultValue = "", property = "iib.user", required = false)
    private String user;
    @Parameter(defaultValue = "", property = "iib.password", required = false)
    private String password;
    @Parameter(defaultValue = "", property = "integrationServer", required = true)
    private String integrationServer;

    @Parameter(defaultValue = "20", property = "iib.timeout", required = true)
    private int timeout;
    @Parameter(defaultValue = "false", property = "iib.useSSL", required = true)
    private boolean useSSL;

    @Parameter(defaultValue = "${project}", required = true)
    private MavenProject project;

    @Parameter(defaultValue = "${session}", required = true)
    private MavenSession session;

    @Component
    protected BuildPluginManager pluginManager;

    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("----------------------------------------------------");
        getLog().info("        Integration Bus - DEPLOY APP                ");
        getLog().info("----------------------------------------------------");
        getLog().info(" ");
        String barFileName = getBar();

        BrokerConnectionParameters bcp = new IntegrationNodeConnectionParameters(host, port, user, password, useSSL);
        BrokerProxy b = null;

        try {
            getLog().info("Connecting to the integration node running at " + host + ":" + port + "...");
            b = BrokerProxy.getInstance(bcp);
            if (!b.hasBeenPopulatedByBroker(true)) {
                getLog().info("Broker is not responding.");
            } else {
                getLog().info("Discovering integration server '" + integrationServer + "'...");
                ExecutionGroupProxy eg = b.getExecutionGroupByName(integrationServer);
                if (eg == null) {
                    getLog().info("Integration server not found");
                } else {
                    getLog().info("Deploying " + barFileName + "...");
                    try {
                        DeployResult deployResult = eg.deploy(barFileName, true, timeout * 1000);
                        getLog().info("Result = " + deployResult.getCompletionCode());
                    } catch (IOException ioEx) {
                        getLog().error(ioEx);
                    }
                }
            }
        } catch (ConfigManagerProxyException cmpEx) {
            getLog().error(cmpEx);
        } finally {
            if (b != null) {
                b.disconnect();
            }
        }

        getLog().info("----------------------------------------------------");
        getLog().info("        Application DEPLOYED                        ");
        getLog().info("----------------------------------------------------");
    }

    private String getBar() throws MojoExecutionException {
        getLog().info("----------------------------------------------------");
        getLog().info("        Geting Bar File                        ");
        getLog().info("----------------------------------------------------");
        //groupId:artifactId:version[:packaging
        String groupId = project.getGroupId();
        String artifactId = project.getArtifactId();
        String version = project.getVersion();
        String packaging = project.getPackaging();
        String fullArtifactName = String.format("%1$s:%2$s:%3$s:%4$s", groupId, artifactId, version, packaging);
        String fileName = String.format("%1$s-%2$s.%3$s", artifactId, version, packaging);
        File barName = new File(outputDirectory, fileName);
        if (!barName.exists()) {
            executeMojo(
                    plugin(
                            groupId("org.apache.maven.plugins"),
                            artifactId("maven-dependency-plugin"),
                            version("2.8")
                    ),
                    goal("copy"),
                    configuration(
                            element(name("artifact"), fullArtifactName),
                            element(name("outputDirectory"), outputDirectory.getAbsolutePath()),
                            element(name("overWriteReleases"), "true"),
                            element(name("overWriteSnapshots"), "true"),
                            element(name("stripClassifier"), "true")
                    ),
                    executionEnvironment(
                            project,
                            session,
                            pluginManager
                    )
            );
        }
        return new File(outputDirectory, fileName).getAbsolutePath();
    }

}
