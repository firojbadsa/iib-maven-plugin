/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iib.plugins;

import com.ibm.broker.config.util.ApplyBarOverride;
import java.io.File;
import java.util.List;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.model.Profile;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.BuildPluginManager;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import static org.twdata.maven.mojoexecutor.MojoExecutor.artifactId;
import static org.twdata.maven.mojoexecutor.MojoExecutor.configuration;
import static org.twdata.maven.mojoexecutor.MojoExecutor.element;
import static org.twdata.maven.mojoexecutor.MojoExecutor.executeMojo;
import static org.twdata.maven.mojoexecutor.MojoExecutor.executionEnvironment;
import static org.twdata.maven.mojoexecutor.MojoExecutor.goal;
import static org.twdata.maven.mojoexecutor.MojoExecutor.groupId;
import static org.twdata.maven.mojoexecutor.MojoExecutor.name;
import static org.twdata.maven.mojoexecutor.MojoExecutor.plugin;
import static org.twdata.maven.mojoexecutor.MojoExecutor.version;

/**
 *
 * @author FX13293
 */
@Mojo(name = "override")
public class Override extends AbstractMojo {

    @Parameter(defaultValue = "${project}", required = true)
    private MavenProject project;

    @Parameter(defaultValue = "${project.build.directory}", property = "outputDir", required = true)
    private File outputDirectory;

    @Parameter(defaultValue = "${session}", required = true)
    private MavenSession session;

    @Component
    protected BuildPluginManager pluginManager;

    public void execute() throws MojoExecutionException, MojoFailureException {

        getLog().info("----------------------------------------------------");
        getLog().info("        Integration Bus - OVERRIDE APP              ");
        getLog().info("----------------------------------------------------");
        getLog().info(" ");
        String groupId = project.getGroupId();
        String artifactId = project.getArtifactId();
        String version = project.getVersion();
        String packaging = project.getPackaging();
        String fileName = String.format("%1$s-%2$s.%3$s", artifactId, version, packaging);

        File propertiesFolder = new File("resources/properties");
        if (propertiesFolder.exists()) {
            File barFile = new File(outputDirectory, fileName);
            if (!barFile.exists()) {
                String fullArtifactName = String.format("%1$s:%2$s:%3$s:%4$s", groupId, artifactId, version, packaging);

                executeMojo(
                        plugin(
                                groupId("org.apache.maven.plugins"),
                                artifactId("maven-dependency-plugin"),
                                version("2.8")
                        ),
                        goal("copy"),
                        configuration(
                                element(name("artifact"), fullArtifactName),
                                element(name("outputDirectory"), outputDirectory.getAbsolutePath()),
                                element(name("overWriteReleases"), "true"),
                                element(name("overWriteSnapshots"), "true"),
                                element(name("stripClassifier"), "true")
                        ),
                        executionEnvironment(
                                project,
                                session,
                                pluginManager
                        )
                );
            }
            String filePath = new File(outputDirectory, fileName).getAbsolutePath();

            getLog().info("OVERRIDE BAR FILE " + filePath);
            List listprofiles = project.getActiveProfiles();
            String idProfiles[] = new String[listprofiles.size()];
            for (int i = 0; i < idProfiles.length; i++) {
                String idProfile = ((Profile) listprofiles.get(i)).getId();
                getLog().info("PROFILE " + idProfile);
                File properties = new File(propertiesFolder, idProfile + ".properties");
                String[] args = new String[]{"-b", filePath, "-k", artifactId, "-p", properties.getAbsolutePath(), "-runtime"};
                if (properties.exists()) {
                    getLog().info("APPLING PROPERTIES " + properties.getName());
                    ApplyBarOverride.execute(args);
                } else {
                    getLog().info("NOT PROPERTIES FOR PROFILE " + idProfile);
                }
            }

        }
    }

}
