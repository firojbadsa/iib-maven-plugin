/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iib.plugins;

import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.constants.MQConstants;
import com.ibm.mq.headers.MQDataException;
import com.ibm.mq.headers.pcf.PCFMessage;
import com.ibm.mq.headers.pcf.PCFMessageAgent;
import java.io.File;
import java.io.FilenameFilter;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.Parameter;

/**
 *
 * @author FX13293
 */
@Mojo(name = "deploy-mq")
public class DeployMQ extends AbstractMojo{

    @Parameter(defaultValue = "false", property = "mq.host", required = true)
    private String host;
    @Parameter(defaultValue = "false", property = "mq.port", required = true)
    private int port;
    @Parameter(defaultValue = "false", property = "mq.queueManager", required = true)
    private String queueManager;
    @Parameter(defaultValue = "false", property = "mq.channel", required = true)
    private String channel;
    @Parameter(defaultValue = "false", property = "mq.user", required = true)
    private String user;
    @Parameter(defaultValue = "false", property = "mq.password", required = true)
    private String password;
    
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("----------------------------------------------------");
        getLog().info("        Integration Bus - DEPLOY MQ Objects         ");
        getLog().info("----------------------------------------------------");
        getLog().info(" ");
        File mqfolder = new File("resources/mqsc/install");
        File[] mqFiles = mqfolder.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith("mqsc");
            }
        });
        if(mqFiles!=null){
            
            for (File mqFile : mqFiles) {
                try {
                    getLog().info("RUN SCRIPT "+mqFile.getName());
                    executeScript(mqFile, getLog());
                    getLog().info("END SCRIPT "+mqFile.getName());
                } catch (IOException ex) {
                    getLog().error(ex);
                } catch (MQException ex) {
                    getLog().error(ex);
                } catch (MQDataException ex) {
                    getLog().error(ex);
                }
            }
        }
        
    }

    private void executeScript(File script, Log log) throws IOException, MQException, MQDataException {
       

        MQEnvironment.hostname = host;
        MQEnvironment.port = port;
        MQEnvironment.channel = channel;
        MQQueueManager qm = new MQQueueManager(queueManager);
        PCFMessageAgent agent = new PCFMessageAgent(qm);

        List<String> commands = readFile(script);
        for (String mQSCommand : commands) {
            try {
                log.info("COMMAND -- "+mQSCommand);
                PCFMessage runmqscCommand = getPCFMessageFromMQSC(mQSCommand);
                PCFMessage[] response = agent.send(runmqscCommand);
                log.debug(mQSCommand.toString());
                for (PCFMessage pCFMessage : response) {
                    
                    log.debug(pCFMessage.getStringParameterValue(MQConstants.MQCACF_ESCAPE_TEXT));
                    
                }
            } catch (MQDataException ex) {
                log.info(MQConstants.lookupReasonCode(ex.getReason()));
                log.error(ex);                
            }

        }
    }

    private List<String> readFile(File script) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(script));
        ArrayList<String> list  = new ArrayList<String>();
        String line = null;
        while((line = br.readLine())!=null) list.add(line);
        return list;
        
    }

    private PCFMessage getPCFMessageFromMQSC(String mQSCommand) {
        PCFMessage pcf = new PCFMessage(MQConstants.MQCMD_ESCAPE);
        pcf.addParameter(MQConstants.MQIACF_ESCAPE_TYPE, MQConstants.MQET_MQSC);
        pcf.addParameter(MQConstants.MQCACF_ESCAPE_TEXT, mQSCommand);
        return pcf;
    }
    
}
