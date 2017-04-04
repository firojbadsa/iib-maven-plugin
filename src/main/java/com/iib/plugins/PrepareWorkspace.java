/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iib.plugins;

import com.iib.plugins.tools.FileTools;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.BuildPluginManager;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import static org.twdata.maven.mojoexecutor.MojoExecutor.*;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;

import static org.twdata.maven.mojoexecutor.MojoExecutor.groupId;

/**
 *
 * @author jpcasas
 */
@Mojo(name = "process-resources", defaultPhase = LifecyclePhase.PROCESS_RESOURCES, requiresDependencyResolution = ResolutionScope.COMPILE_PLUS_RUNTIME)
public class PrepareWorkspace extends AbstractMojo {

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
        String artifact = project.getArtifactId();
        try {
            getLog().info("----------------------------------------------------");
            getLog().info("        Integration Bus Resources Importer          ");
            getLog().info("----------------------------------------------------");
            getLog().info(" ");
            
            executeMojo(
                    plugin(
                            groupId("org.apache.maven.plugins"),
                            artifactId("maven-dependency-plugin"),
                            version("2.8")
                    ),
                    goal("unpack-dependencies"),
                    configuration(
                            element(name("useSubDirectoryPerArtifact"),"true"),
                            element(name("outputDirectory"),outputDirectory.getAbsolutePath()),
                            element(name("overWriteReleases"),"true"),
                            element(name("overWriteSnapshots"),"true"),
                            element(name("stripVersion"),"true"),
                            element(name("stripClassifier"),"true")
                    ),
                    executionEnvironment(
                            project,
                            session,
                            pluginManager
                    )
            );
            FileTools.renameProjects(outputDirectory, "-iib-artifact");
            String current = new File(".").getCanonicalPath();
            FileTools.copy(new File(current), new File(outputDirectory, artifact), getLog(), outputDirectory);
            FileTools.deleteFolder(new File(outputDirectory, "dependency-maven-plugin-markers"));
            
            
            getLog().info(" ");
            getLog().info("(\"-------------------------END-------------------------\");");
            getLog().info(" ");
        } catch (IOException ex) {
            Logger.getLogger(PrepareWorkspace.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
