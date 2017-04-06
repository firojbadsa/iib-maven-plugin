/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mq.parser;

import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.constants.MQConstants;
import com.ibm.mq.headers.MQDataException;
import com.ibm.mq.headers.pcf.PCFMessage;
import com.ibm.mq.headers.pcf.PCFMessageAgent;
import com.mq.parser.MQSParser.ObjectDefinitionContext;
import com.mq.parser.MQSParser.PropertyContext;
import com.mq.commands.MQSCommand;
import com.mq.parser.MQSParser.EmptyPropertyContext;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 *
 * @author fx13293
 */
public class MQSCVisitorImpl extends MQSBaseVisitor<List<MQSCommand>> {

    public static void parseCommand(String command) {

    }

    public static void main(String[] args) throws FileNotFoundException, IOException, MQException, MQDataException {

        ANTLRInputStream input = new ANTLRInputStream("DEFINE TOPIC(JUAN) TOPICSTR(MY/STRING/TOPIC) CLUSTER(TOPIC_CLUSTER)\n");
        MQSLexer lexer = new MQSLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MQSParser parser = new MQSParser(tokens);
        parser.getInterpreter().setPredictionMode(PredictionMode.LL);

        ParseTree tree = parser.objectCommand();
        MQSCVisitorImpl p = new MQSCVisitorImpl();

        MQEnvironment.hostname = "10.216.67.169";
        MQEnvironment.port = 1414;
        MQEnvironment.channel = "MIGRATION";
        MQQueueManager qm = new MQQueueManager("CMPLL40");
        PCFMessageAgent agent = new PCFMessageAgent(qm);

        List<MQSCommand> result = p.visit(tree);
        for (MQSCommand mQSCommand : result) {
            try {
                
                PCFMessage o = mQSCommand.getPCFMessage();
                PCFMessage[] response = agent.send(o);
                System.out.println(mQSCommand);
                for (PCFMessage pCFMessage : response) {
                    System.out.println(pCFMessage);
                }
            } catch (MQDataException ex) {
                Logger.getLogger(MQSCVisitorImpl.class.getName()).log(Level.SEVERE, null, ex);
                Logger.getLogger(MQSCVisitorImpl.class.getName()).log(Level.SEVERE, MQConstants.lookupReasonCode(ex.getReason()));
            }

        }

    }

    @Override
    public List<MQSCommand> visitObjectCommand(MQSParser.ObjectCommandContext ctx) {
        List<ObjectDefinitionContext> objectdef = ctx.objectDefinition();
        ArrayList<MQSCommand> commands = new ArrayList<MQSCommand>();
        for (ObjectDefinitionContext objectDefinitionContext : objectdef) {
            String action = objectDefinitionContext.objectDefinitionHeader().getStart().getText();
            String type = objectDefinitionContext.objectDefinitionHeader().ID().getText();
            String name = objectDefinitionContext.objectDefinitionHeader().value().getText();
            MQSCommand command = new MQSCommand(action, type, name);
            List<PropertyContext> properties = objectDefinitionContext.property();
            List<EmptyPropertyContext> eproperties = objectDefinitionContext.emptyProperty();
            command.addAllProperties(parseToHashMap(properties));
            command.addAllProperties(parseToHashMap(eproperties));
            commands.add(command);
        }

        return commands;
    }

    private HashMap<String, String> parseToHashMap(List properties) {
        HashMap<String, String> props = new HashMap<String, String>();
        for (Object oproperty : properties) {
            String keyProp = null;
            String valueProp = null;
            if (oproperty instanceof PropertyContext) {
                PropertyContext property = ((PropertyContext) oproperty);
                keyProp = property.ID().getText();
                valueProp = (property.value() == null) ? "" : property.value().getText();
            } else {
                EmptyPropertyContext property = ((EmptyPropertyContext) oproperty);
                keyProp = property.ID().getText();
            }
            props.put(keyProp, valueProp);

        }
        return props;
    }

}
