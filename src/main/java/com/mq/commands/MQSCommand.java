/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mq.commands;

import com.ibm.mq.constants.MQConstants;
import com.ibm.mq.headers.pcf.PCFMessage;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author fx13293
 */
public class MQSCommand {

    private String command;
    private String name;
    private String type;
    private HashMap<String, String> properties;

    public MQSCommand(String command, String name, HashMap<String, String> properties) {
        this.command = command;
        this.name = name;
        this.properties = properties;
    }

    public MQSCommand(String command, String type, String name) {
        this.command = command;
        this.name = name;
        this.type = type;
        this.properties = new HashMap<String, String>();
    }

    public void addAllProperties(HashMap<String, String> parseToHashMap) {
        properties.putAll(parseToHashMap);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, String> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, String> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "MQSCommand{" + "command=" + command + ", type=" + type + ", name=" + name + '}';
    }

    public int getCommandInt() {
        return MQSCToPCF.getInstance().getCommand(command + type);
    }

    public HashMap<Integer, Object> getPCFProperties() {

        HashMap<Integer, Object> props = new HashMap<Integer, Object>();
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            int cmd = MQSCToPCF.getInstance().getCommand(key);
            String type = MQSCToPCF.getInstance().getType(key);
            if (type != null) {
                /* THE PROPERTY DOES NOT EXIST OR IS NO IN THE CATALOG*/
                Integer action = MQSCToPCF.getInstance().getCommand(key);
                switch (type.charAt(0)) {
                    case 'A':
                        Object option = MQSCToPCF.getInstance().getOptionFor(key);
                        props.put(action, option);
                        break;
                    case 'I':
                        props.put(action, new Integer(value));
                        break;
                    case 'S':
                        props.put(action, value);
                        break;
                    case 'O':
                        Object toption = MQSCToPCF.getInstance().getOptionFor(key, value);
                        props.put(action, toption);
                        break;
                }
            }

        }
        return props;
    }

    /*
    message.addParameter(MQConstants.MQCA_Q_NAME, queue);
        message.addParameter(MQConstants.MQIA_Q_TYPE, type);
    
    pcfCmd.addParameter(MQConstants.MQCA_TOPIC_NAME, topicName);
        pcfCmd.addParameter(MQConstants.MQCA_TOPIC_STRING, topicString);
     */
    public PCFMessage getPCFMessage() {

        int cmd = getCommandInt();
        PCFMessage message = new PCFMessage(cmd);
        Integer objectName = MQSCToPCF.getInstance().getCommand(type.charAt(0) + "NAME");
        message.addParameter(objectName, name);
        if (type.charAt(0) == 'Q') {
            Integer objectkeyType = MQSCToPCF.getInstance().getCommand(type.charAt(0) + "TYPE");
            Integer objectType = MQSCToPCF.getInstance().getCommand(type);
            message.addParameter(objectkeyType, objectType);
        }
        HashMap<Integer, Object> parameters = getPCFProperties();
        for (Map.Entry<Integer, Object> entry : parameters.entrySet()) {
            Integer key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Number) {
                message.addParameter(key, ((Integer) value));
            } else {
                message.addParameter(key, ((String) value));
            }

        }

        return message;
    }

}
