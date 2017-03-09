/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iib.plugins.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.maven.plugin.logging.Log;

/**
 *
 * @author fx13293
 */
public class Util {

    public static void print(InputStream inputStream) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void print(InputStream inputStream, Log log, Level level) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (Level.SEVERE == level) {
                    log.error(line);
                }
                if (Level.ALL == level) {
                    log.info(line);
                }
            }
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void executeCommand(String command, Log log) throws InterruptedException, IOException {
        Runtime runtime = Runtime.getRuntime();
        Process p = runtime.exec(command);
        Util.print(p.getInputStream(), log, Level.ALL);
        Util.print(p.getErrorStream(), log, Level.SEVERE);
        p.waitFor();
    }

}
