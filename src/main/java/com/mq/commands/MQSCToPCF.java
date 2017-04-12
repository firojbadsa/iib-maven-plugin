/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mq.commands;

import com.ibm.mq.constants.MQConstants;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author fx13293
 */
public class MQSCToPCF {

    private static MQSCToPCF instance;
    private Properties pcfcommands;
    private Properties types;
    private Properties options;

    private MQSCToPCF() {
        try {
            pcfcommands = new Properties();
            types = new Properties();
            options = new Properties();
                     
            pcfcommands.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("pcfcommands.properties"));
            types.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("types.properties"));
            options.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("options.properties"));

        } catch (IOException ex) {
            Logger.getLogger(MQSCToPCF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static MQSCToPCF getInstance() {
        if (instance == null) {
            instance = new MQSCToPCF();
        }
        return instance;
    }

    public Integer getCommand(String command) {
        return (Integer) MQConstants.getValue(pcfcommands.getProperty(command));
    }

    public Object getOptionFor(String key) {
        String result = options.getProperty(key);
        if (result != null) {
            //[YES,MQFC_YES]
            return MQConstants.getValue(getPropValue(result));
        }
        return null;
    }

    private String getPropValue(String v) {
        return v.substring(v.indexOf(",") + 1, v.lastIndexOf("]"));
    }

    public String getType(String key) {
        return types.getProperty(key);
    }

    public Integer getOptionFor(String key, String s) {
        String v = options.getProperty(key);
        if (v != null) {
            String val = v.substring(v.indexOf(s)).substring(v.substring(v.indexOf(s)).indexOf(",") + 1, v.substring(v.indexOf(s)).indexOf("]"));

            return getCommand(val);
        }
        return null;
    }

    /*
    
    public PCFMessage[] createTopic(String topicName, String topic_cluster, String topicString) throws MQDataException, PCFException, IOException {
        PCFMessage pcfCmd = new PCFMessage(MQConstants.MQCMD_CREATE_TOPIC);
        pcfCmd.addParameter(MQConstants.MQCA_TOPIC_NAME, topicName);
        pcfCmd.addParameter(MQConstants.MQCA_TOPIC_STRING, topicString);
        pcfCmd.addParameter(MQConstants.MQCA_CLUSTER_NAME, topic_cluster);
        PCFMessage[] pcfResponse = null;
        return pcfResponse;
    }

    private PCFMessage[] createSub(MQObject sub) throws MQDataException, PCFException, IOException {
        PCFMessage message = new PCFMessage(MQConstants.MQCMD_CREATE_SUBSCRIPTION);
        message.addParameter(MQConstants.MQCACF_SUB_NAME, sub.getObjectName()); //TOPIC_CLUSTER
        String topicNameProperty = sub.getProperty("TOPICOBJ");
        String topicStringVal = sub.getProperty("TOPICSTR");
        String topicName = (topicNameProperty.equals("SYSTEM.BROKER.DEFAULT.SUBPOINT")) ? topicStringVal.substring(0, topicStringVal.indexOf("/")) : topicNameProperty.substring(0, topicNameProperty.indexOf("/"));
        String topicString = topicStringVal.substring(topicStringVal.indexOf("/") + 1);

        message.addParameter(MQConstants.MQCA_TOPIC_NAME, topicName);
        message.addParameter(MQConstants.MQCA_TOPIC_STRING, topicString);

        message.addParameter(MQConstants.MQCACF_DESTINATION, sub.getProperty("DEST"));
        int pubprt = (sub.getProperty("PSPROP").equals("RFH2")) ? MQConstants.MQPSPROP_RFH2 : MQConstants.MQPSPROP_NONE;
        message.addParameter(MQConstants.MQIACF_PUBSUB_PROPERTIES, pubprt);
        message.addParameter(MQConstants.MQCACF_SUB_SELECTOR, sub.getProperty("SELECTOR"));
        int subscope = (sub.getProperty("SUBSCOPE").equals("QMGR")) ? MQConstants.MQTSCOPE_QMGR : MQConstants.MQTSCOPE_ALL;
        message.addParameter(MQConstants.MQIACF_SUBSCRIPTION_SCOPE, subscope);
        int varuser = (sub.getProperty("VARUSER").equals("FIXED")) ? MQConstants.MQVU_FIXED_USER : MQConstants.MQVU_ANY_USER;
        message.addParameter(MQConstants.MQIACF_VARIABLE_USER_ID, varuser);

        return agent.send(message);
    }

    

    public PCFMessage[] createReceiverChannel(String name, String comments) throws MQDataException, PCFException, IOException {
        PCFMessage pcfCmd = createChannel(name, MQConstants.MQCHT_RECEIVER, comments);
        pcfCmd.addParameter(MQConstants.MQIACH_SSL_CLIENT_AUTH, MQConstants.MQSCA_OPTIONAL);
        return null;
    }

    public PCFMessage[] createSenderChannel(String qmAdress, int port, String txqueue, String name) throws MQDataException, PCFException, IOException {
        PCFMessage pcfCmd = createChannel(name, MQConstants.MQCHT_SENDER, "");
        pcfCmd.addParameter(MQConstants.MQCACH_XMIT_Q_NAME, txqueue);
        pcfCmd.addParameter(MQConstants.MQCACH_CONNECTION_NAME, qmAdress + "(" + port + ")");
        return null;

    }

    private void deleteChannel(String channel) throws MQDataException, PCFException, IOException {
        PCFMessage pcfCmd = new PCFMessage(MQConstants.MQCMD_DELETE_CHANNEL);
        pcfCmd.addParameter(MQConstants.MQCACH_CHANNEL_NAME, channel);
        PCFMessage[] pcfResponse = null;
        for (PCFMessage pCFMessage : pcfResponse) {
            System.out.println(pCFMessage);
        }
    }

    public PCFMessage[] modifyTargetQueue(String queueToSwitch, String qname) throws MQDataException, PCFException, IOException {
        PCFMessage pcfCmd = new PCFMessage(MQConstants.MQCMD_CHANGE_Q);
        pcfCmd.addParameter(MQConstants.MQCA_Q_NAME, queueToSwitch);
        pcfCmd.addParameter(MQConstants.MQIA_Q_TYPE, MQConstants.MQQT_ALIAS);
        pcfCmd.addParameter(MQConstants.MQCA_BASE_Q_NAME, qname);
        pcfCmd.addParameter(MQConstants.MQIACF_FORCE, MQConstants.MQFC_YES);

        return null;

    }

    private PCFMessage createChannel(String channelName, int typeChannel, String comments) {
        PCFMessage pcfCmd = new PCFMessage(MQConstants.MQCMD_CREATE_CHANNEL);
        pcfCmd.addParameter(MQConstants.MQCACH_CHANNEL_NAME, channelName);
        pcfCmd.addParameter(MQConstants.MQIACH_CHANNEL_TYPE, typeChannel);
        pcfCmd.addParameter(MQConstants.MQCACH_DESC, comments);
        pcfCmd.addParameter(MQConstants.MQCACH_MCA_USER_ID, "");
        pcfCmd.addParameter(MQConstants.MQCACH_SSL_CIPHER_SPEC, "");
        return pcfCmd;
    }
     */
}
