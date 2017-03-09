/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iib.plugins.tools;

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
    
}
