/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iib.plugins;

import com.iib.plugins.tools.FileTools;
import com.iib.plugins.tools.Util;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

/**
 *
 * @author fx13293
 */
@Mojo(name = "libzip")
public class LibZip extends AbstractMojo {

    @Parameter(property = "project.build.directory", readonly = true)
    private String outputDirectory;
    @Parameter(defaultValue = "${project}", required = true)
    private MavenProject project;
    private final int BUFFER = 2048;

    public void execute() throws MojoExecutionException {
        try {
            getLog().info("Creating bar file with libzip");
            String artifact = project.getArtifactId();
            String current = new File(".").getCanonicalPath();
            String relativePath = FileTools.getRelativePath(this.outputDirectory, current);
            
            File barFile = new File(relativePath + "/" + artifact + ".bar");
            File libzipFile = new File(relativePath + "/" + artifact + ".ziplib");
            String command = String.format("mqsicreatebar -data ../ -b %1$s%3$s%2$s.bar -l %2$s -skipWSErrorCheck -trace -deployAsSource",relativePath, artifact, File.separator);
            getLog().info(command);
            Util.executeCommand(command, getLog());
            getLog().info(barFile.getAbsolutePath());
            if (barFile.exists()) {
                FileInputStream fis = new FileInputStream(barFile);
                ZipInputStream zin = new ZipInputStream(new BufferedInputStream(fis));
                ZipEntry entry;
                while ((entry = zin.getNextEntry()) != null) {
                    if (entry.getName().endsWith("libzip")) {
                        byte data[] = new byte[BUFFER];
                        // write the files to the disk
                        FileOutputStream fos = new FileOutputStream(libzipFile);
                        BufferedOutputStream dest = new BufferedOutputStream(fos, BUFFER);
                        int count;
                        while ((count = zin.read(data, 0, BUFFER)) != -1) {
                            dest.write(data, 0, count);
                        }
                        dest.flush();
                        dest.close();
                    }
                }
                this.project.getArtifact().setFile(libzipFile);
            }else{
                getLog().error("Could not create bar file ["+command+"]");
                 throw new MojoExecutionException("could not create the libzip");
            }
        } catch (IOException ex) {
            getLog().error(ex);
        } catch (InterruptedException ex) {
            getLog().error(ex);
        }
    }
}
