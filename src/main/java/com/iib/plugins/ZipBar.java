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

@Mojo(name = "libbar")
public class ZipBar extends AbstractMojo {

    @Parameter(property = "project.build.directory", readonly = true)
    private String outputDirectory;
    
    @Parameter(defaultValue = "${project}", required = true)
    private MavenProject project;

    public void execute() throws MojoExecutionException, MojoFailureException {
        try {
            String artifact = project.getArtifactId();
            String current = new File(".").getCanonicalPath();
            String relativePaths = FileTools.getRelativePath(this.outputDirectory, current);
            File temp =  File.createTempFile("temp", ".bar");
            File zipFile = Util.ZipDir(new File(current), temp.getAbsolutePath(), getLog());
            new File(outputDirectory).mkdirs();
            Path org = FileSystems.getDefault().getPath(temp.getAbsolutePath());
            String destFile = String.format("%1$s/%2$s.bar",outputDirectory, artifact );
            Path dest = FileSystems.getDefault().getPath(destFile);
            Files.copy(org, dest, StandardCopyOption.REPLACE_EXISTING);
            project.getArtifact().setFile(new File(destFile));
        } catch (IOException ex) {
            getLog().error(ex);
        }
    }

}
