/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iib.plugins.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.maven.plugin.logging.Log;

/**
 *
 * @author fx13293
 */
public class FileTools {

    public static String getRelativePath(String filePath, String folderPath) {
        if (filePath.startsWith(folderPath)) {
            return filePath.substring(folderPath.length() + 1);
        } else {
            return "target";
        }
    }

    public static void copy(File sourceLocation, File targetLocation, Log log, File outputdir) throws IOException {
        log.info(String.format("Coping %s", sourceLocation.getName()));
        if (!outputdir.equals(sourceLocation)) {
            if (sourceLocation.isDirectory()) {
                copyDirectory(sourceLocation, targetLocation, log, outputdir);
            } else {
                copyFile(sourceLocation, targetLocation);
            }
        }
    }

    public static void copyDirectory(File source, File target, Log log, File outputdir) throws IOException {
        if (!target.exists()) {
            target.mkdirs();
        }

        for (String f : source.list()) {
            copy(new File(source, f), new File(target, f), log, outputdir);
        }
    }

    public static void copyFile(File source, File target) {

        InputStream in = null;
        try {
            in = new FileInputStream(source);
            OutputStream out = new FileOutputStream(target);
            byte[] buf = new byte[1024];
            int length;
            while ((length = in.read(buf)) > 0) {
                out.write(buf, 0, length);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileTools.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileTools.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(FileTools.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void renameProjects(File outputDirectory, String iibartifact) {
        File[] folders = outputDirectory.listFiles();
        if (folders != null) {
            for (File folder : folders) {
                if (folder.getName().endsWith(iibartifact)) {
                    try {
                        Files.move(folder.toPath(), folder.toPath().resolveSibling(folder.getName().replace(iibartifact, "")));
                    } catch (IOException ex) {
                        Logger.getLogger(FileTools.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }
    }

    public static void deleteFolder(File file) {
        File[] entries = file.listFiles();
        if (entries != null) {
            for (File s : entries) {
                if (s.isDirectory()) {
                    deleteFolder(s);
                }
                s.delete();
            }
        }
        file.delete();
    }

    public static String readFile(File mqFile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
