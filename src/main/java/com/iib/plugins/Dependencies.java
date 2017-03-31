/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iib.plugins;

import java.io.File;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.BuildPluginManager;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import static org.twdata.maven.mojoexecutor.MojoExecutor.*;

/**
 *
 * @author fx13293
 */
@Mojo(name = "dependencies")
public class Dependencies extends AbstractMojo {

    @Parameter(defaultValue = "${project}", required = true)
    private MavenProject project;

    @Parameter(defaultValue = "${session}")
    private MavenSession session;

    @Component
    private BuildPluginManager pluginManager;

    @Parameter(defaultValue = "${project.build.directory}", property = "outputDir", required = true)
    private File outputDirectory;

    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("||||||||||||||||"+outputDirectory.getAbsolutePath()+"||||||||||||||||");
        outputDirectory.mkdirs();
        executeMojo(
                plugin(
                        groupId("org.apache.maven.plugins"),
                        artifactId("maven-dependency-plugin"),
                        version("3.0.0")
                ),
                goal("copy-dependencies"),
                configuration(
                        
                ),
                executionEnvironment(
                        project,
                        session,
                        pluginManager
                )
        );
    }

}
