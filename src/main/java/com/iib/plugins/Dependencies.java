/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iib.plugins;

import java.io.File;
import java.util.List;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.model.Dependency;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.BuildPluginManager;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import static org.twdata.maven.mojoexecutor.MojoExecutor.*;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import org.codehaus.plexus.configuration.xml.XmlPlexusConfiguration;
import org.twdata.maven.mojoexecutor.MojoExecutor;
import static org.twdata.maven.mojoexecutor.MojoExecutor.executeMojo;
import static org.twdata.maven.mojoexecutor.MojoExecutor.executionEnvironment;
import static org.twdata.maven.mojoexecutor.PlexusConfigurationUtils.toXpp3Dom;

/**
 *
 * @author jpcasas
 */
@Mojo(name = "process-resources")
public class Dependencies extends AbstractMojo {

    /**
     * Location of the file.
     */
    @Parameter(defaultValue = "${project.build.directory}", property = "outputDir", required = true)
    private File outputDirectory;

    @Parameter(defaultValue = "${project}", required = true)
    private MavenProject project;

    @Parameter(defaultValue = "${session}", required = true)
    private MavenSession session;

    @Component
    protected BuildPluginManager pluginManager;

    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("----------------------------------------------------");
        getLog().info("        Integration Bus Resources Importer          ");
        getLog().info("----------------------------------------------------");
        getLog().info(" ");

        List<Dependency> deps = project.getDependencies();
        for (Dependency dep : deps) {
            String groupid = dep.getGroupId();
            String artifact = dep.getArtifactId();
            String version = dep.getVersion();
            String type = dep.getType();
            MojoExecutor.executeMojo(
                    MojoExecutor.plugin(
                            MojoExecutor.groupId("org.apache.maven.plugins"),
                            MojoExecutor.artifactId("maven-dependency-plugin"),
                            MojoExecutor.version("3.0.0")
                    ),
                    MojoExecutor.goal("copy"),
                    MojoExecutor.configuration(
                            MojoExecutor.element(MojoExecutor.name("artifactItems"),
                                    MojoExecutor.element(MojoExecutor.name("artifactItem"),
                                            MojoExecutor.element(MojoExecutor.name("groupId"), groupid),
                                            MojoExecutor.element(MojoExecutor.name("artifactId"), artifact),
                                            MojoExecutor.element(MojoExecutor.name("version"), version),
                                            MojoExecutor.element(MojoExecutor.name("type"), type),
                                            MojoExecutor.element(MojoExecutor.name("overWrite"), "true"),
                                            MojoExecutor.element(MojoExecutor.name("outputDirectory"), project.getBuild().getDirectory() + File.separator + "dependencies" + File.separator + artifact),
                                            MojoExecutor.element(MojoExecutor.name("includes"), "**/*")
                                    )
                            )
                    ),
                    MojoExecutor.executionEnvironment(
                            project,
                            session,
                            (BuildPluginManager) pluginManager
                    )
            );

        }

        getLog().info(" ");
        getLog().info("--------------     END   ---------------");
        getLog().info(" ");
    }

}
