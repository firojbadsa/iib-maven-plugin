/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iib.plugins;

import com.iib.plugins.tools.FileTools;
import com.iib.plugins.tools.Util;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

/**
 *
 * @author fx13293
 */
@Mojo(name = "compile")
public class CompileWorkspace  extends AbstractMojo {

    @Parameter(property = "project.build.directory", readonly = true)
    private String outputDirectory;

    @Parameter(defaultValue="${project}",  required = true)
    private MavenProject project;
    public void execute() throws MojoExecutionException, MojoFailureException {
        try {
            String current = new File(".").getCanonicalPath();
            String relativePath = FileTools.getRelativePath(outputDirectory, current);
            String command = String.format("mqsicreatebar -data %s -compileOnly -trace", relativePath);
            Util.executeCommand(command, getLog());
        } catch (IOException ex) {
            Logger.getLogger(CompileWorkspace.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(CompileWorkspace.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
