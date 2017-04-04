/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iib.plugins;

/**
 *
 * @author fx13293
 */
import com.iib.plugins.tools.FileTools;
import com.iib.plugins.tools.Util;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

@Mojo(name = "iib-artifact")
public class ZipProject extends AbstractMojo {

    @Parameter(property = "project.build.directory", readonly = true)
    private String outputDirectory;
    
    @Parameter(defaultValue = "${project}", required = true)
    private MavenProject project;

    public void execute() throws MojoExecutionException, MojoFailureException {
        try {
            String artifact = project.getArtifactId();
            String current = new File(".").getCanonicalPath();
            new File(outputDirectory).mkdirs();
            File destFile = new File(outputDirectory, String.format("%1$s.zip",artifact ));
            File zipFile = Util.ZipDir(new File(current), destFile.getAbsolutePath(), getLog());
            project.getArtifact().setFile(zipFile);
        } catch (IOException ex) {
            getLog().error(ex);
        }
    }

}
