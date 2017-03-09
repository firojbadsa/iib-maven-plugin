/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iib.plugins;

import java.io.File;
import java.io.IOException;
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
@Mojo(name = "iib-bin")
public class Binaries extends AbstractMojo {
    
    @Parameter(defaultValue = "${project.build.directory}", property = "outputDir", required = true)
    private File outputDirectory;

    @Parameter(defaultValue="${project}",  required = true)
    private MavenProject project;
    
    @Parameter(property = "extentions", required = true)
    private String[] extentions =  new String[]{"appzip","libzip","shlibzip","xsdzip","tblxmi","xsd","wsdl","dictionary","xsl","xslt","xml","jar","inadapter","outadapter","insca","outsca","descriptor","idl","mqsc","rule","rules","map","esql","msgflow","subflow"};


    public void execute() throws MojoExecutionException, MojoFailureException {
         try {
            File f = outputDirectory;
            String artifact = project.getArtifactId();
            String command = "mqsicreatebar -data ../ -compileOnly -skipWSErrorCheck";
            Runtime runtime = Runtime.getRuntime();
            runtime.exec(command).waitFor();
             for (String extention : extentions) {
                 File artifactFile = new File(artifact+"."+extention);
                 if(artifactFile.exists()){
                     this.project.getArtifact().setFile(artifactFile);
                 }
             }
        } catch (IOException ex) {
            Logger.getLogger(Bar.class.getName()).log(Level.SEVERE, null, ex);
            throw new MojoExecutionException("Error execution Runtime", ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Binaries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
