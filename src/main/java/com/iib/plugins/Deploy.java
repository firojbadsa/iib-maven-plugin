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
import java.io.IOException;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

/**
 *
 * @author FX13293
 */
@Mojo(name = "deploy")
public class Deploy extends AbstractMojo {

    @Parameter(defaultValue = "", property = "iib.host", required = true)
    private String host;
    @Parameter( property = "iib.port", required = true)
    private int port;
    @Parameter(defaultValue = "", property = "iib.user", required = true)
    private String user;
    @Parameter(defaultValue = "", property = "iib.password", required = true)
    private String password;
    @Parameter(defaultValue = "defaultx²", property = "integrationServer", required = true)
    private String integrationServer;
    @Parameter(defaultValue="${project}",  required = true)
    private MavenProject project;
    @Parameter(defaultValue = "20", property = "iib.timeout", required = true)
    private int timeout;
    @Parameter(defaultValue = "false", property = "iib.useSSL", required = true)
    private boolean useSSL;
    

    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("----------------------------------------------------");
        getLog().info("        Integration Bus - DEPLOY APP                ");
        getLog().info("----------------------------------------------------");
        getLog().info(" ");
        String barFile="";
        deployBAR(host, port, integrationServer, barFile, timeout, useSSL);
        
        getLog().info("----------------------------------------------------");
        getLog().info("        Application DEPLOYED                        ");
        getLog().info("----------------------------------------------------");
    }

    private  void deployBAR(String brokerHostName, int brokerPort,  String executionGroupName,   String barFileName,  int timeoutSecs, boolean useSSL) {
        // Instantiate an object that describes the connection
        // characteristics to the integration node.
        BrokerConnectionParameters bcp = new IntegrationNodeConnectionParameters(brokerHostName, brokerPort, user, password, useSSL);
        BrokerProxy b = null;

        try {
            // Start communication with the integration node
            getLog().info("Connecting to the integration node running at " + brokerHostName + ":" + brokerPort + "...");
            
            b = BrokerProxy.getInstance(bcp);

            // Has the integration node responded to the connection attempt?
            if (!b.hasBeenPopulatedByBroker(true)) {
                // The application timed out while waiting for a response from the
                // integration node. When it finally becomes available, hasBeenPopulatedByBroker()
                // will return true. This application won't wait for that though-
                // it will just exit now.
                getLog().info("Broker is not responding.");
            } else {

                getLog().info("Discovering integration server '" + executionGroupName + "'...");
                ExecutionGroupProxy eg = b.getExecutionGroupByName(executionGroupName);

                // If the integration server exists, deploy to it.
                if (eg == null) {
                    getLog().info("Integration server not found");
                } else {
                    // Deploy the BAR file and display the result
                    getLog().info("Deploying " + barFileName + "...");
                    try {
                        DeployResult deployResult = eg.deploy(barFileName, // location of BAR
                                true, // incremental, i.e. don't empty the integration server first
                                timeoutSecs * 1000); // wait for integration node response

                        getLog().info("Result = " + deployResult.getCompletionCode());

                        // You may like to improve this application by querying
                        // the deployResult for more information, particularly if
                        // deployResult.getCompletionCode() == CompletionCodeType.failure.
                    } catch (IOException ioEx) {
                        // e.g. if BAR file doesn't exist
                        ioEx.printStackTrace();
                    }

                }

            }
        } catch (ConfigManagerProxyException cmpEx) {
            cmpEx.printStackTrace();
        } finally {
            if (b != null) {
                b.disconnect();
            }
        }
    }

}
