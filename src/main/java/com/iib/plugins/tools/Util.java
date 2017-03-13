/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iib.plugins.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
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

    private static String generateZipEntry(String root, String file) {
        return file.substring(root.length() + 1, file.length());
    }

    public static List<String> generateFileList(String root, File node) {
        ArrayList<String> fileList = new ArrayList<String>();
        if (node.isFile()) {
            fileList.add(generateZipEntry(root, node.getAbsoluteFile().toString()));
        }

        if (node.isDirectory()) {
            String[] subNote = node.list();
            for (String filename : subNote) {
                fileList.addAll(generateFileList(root, new File(node, filename)));
            }
        }
        return fileList;

    }

    public static File ZipDir(File toZip, String dest, Log log) {
        byte[] buffer = new byte[1024];

        try {
            File zipFile = new File(dest);
            FileOutputStream fos = new FileOutputStream(dest);
            ZipOutputStream zos = new ZipOutputStream(fos);

            log.info("Output to bar : " + zipFile);
            List<String> fileList = generateFileList(toZip.getAbsolutePath(), toZip);
            for (String file : fileList) {

                log.info("File Added : " + file);
                ZipEntry ze = new ZipEntry(file);
                zos.putNextEntry(ze);

                FileInputStream in = new FileInputStream(toZip.getAbsolutePath() + File.separator + file);

                int len;
                while ((len = in.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }

                in.close();
            }

            zos.closeEntry();
            zos.close();
            
            log.info("Done");
            return zipFile;
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
        return null;
    }
     

}
