/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mq.commands;

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
        return "MQSCommand{" + "command=" + command + ", name=" + name + ", type=" + type + '}';
    }

    public int getCommandInt() {
        return MQSCToPCF.getInstance().getCommand(command + type);
    }

    public HashMap<Integer, Object> getPCFProperties() {

        HashMap<Integer, Object> props = new HashMap<Integer, Object>();
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            int command =  getCommandInt(key);

        }
        return props;
    }

    public PCFMessage getPCFMessage() {

        PCFMessage message = new PCFMessage(getCommandInt());
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
