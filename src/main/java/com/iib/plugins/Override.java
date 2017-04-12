/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iib.plugins;


import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

/**
 *
 * @author FX13293
 */
@Mojo(name = "override")
public class Override extends AbstractMojo{
    
    @Parameter(defaultValue="${project}",  required = true)
    private MavenProject project;

    public void execute() throws MojoExecutionException, MojoFailureException {
        
    }
    
}
