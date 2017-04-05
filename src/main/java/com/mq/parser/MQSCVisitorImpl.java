/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mq.parser;

import com.ibm.mq.constants.MQConstants;
import com.mq.commands.MQSCToPCF;
import com.mq.parser.MQSParser.ObjectDefinitionContext;
import com.mq.parser.MQSParser.PropertyContext;
import com.mq.commands.MQSCommand;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 *
 * @author fx13293
 */
public class MQSCVisitorImpl extends MQSBaseVisitor<List<MQSCommand>> {

    public static void parseCommand(String command) {

    }

    public static void main(String[] args) throws FileNotFoundException, IOException {

        ANTLRInputStream input = new ANTLRInputStream("DEFINE QLOCAL(IIB.WMB_LTEST_MQREPLY)\n"
                + "DEFINE QALIAS(IIB.WMB_ATEST_MQREPLY) TARGET(IIB.WMB_LTEST_MQREPLY) DESCR('Queue Alias for Replay Test') \n"
                + "DEFINE QLOCAL(IIB.WMB_ATEST_MQ)\n"
                + "DEFINE QALIAS(IIB.WMB_LTEST_MQ) TARGET(IIB.WMB_ATEST_MQ) DESCR('Queue Alias for MQ Test')\n");
        MQSLexer lexer = new MQSLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MQSParser parser = new MQSParser(tokens);
        parser.getInterpreter().setPredictionMode(PredictionMode.LL);
        //parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);

        ParseTree tree = parser.objectCommand();
        MQSCVisitorImpl p = new MQSCVisitorImpl();
        
        List<MQSCommand> result = p.visit(tree);
        for (MQSCommand mQSCommand : result) {
            System.out.println(mQSCommand);
            Object obj = MQSCToPCF.getInstance().getCommand(mQSCommand.getCommand()+mQSCommand.getType());
            System.out.println(obj);
            System.out.println(obj.getClass().getName());
        }
    }
    private static int i = 0;

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
            command.setProperties(parseToHashMap(properties));
            commands.add(command);
        }

        return commands;
    }

    private HashMap<String, String> parseToHashMap(List<PropertyContext> properties) {
        HashMap<String, String> props = new HashMap<String, String>();
        for (PropertyContext property : properties) {
            String keyProp = property.ID().getText();
            String valueProp = property.value().getText();
            props.put(keyProp, valueProp);
        }
        return props;
    }

}
