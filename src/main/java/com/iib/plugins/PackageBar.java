/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iib.plugins;

//import com.ibm.broker.MessageBrokerAPIException;
//import com.ibm.broker.config.appdev.FlowRendererBAR;
import com.iib.plugins.tools.Util;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
@Mojo(name = "bar-native")
public class PackageBar extends AbstractMojo {

    

    @Parameter(property = "project.build.directory", readonly = true)
    private String outputDirectory;
    
    @Parameter(defaultValue = "${project}", required = true)
    private MavenProject project;

    public void execute() throws MojoExecutionException, MojoFailureException {
        //FlowRendererBAR.write(root, ArrayList<String> source, DirName, fileName, FlowRendererBAR.CREATE_MODE, true);
    }
    public static void main(String[] args) {
    	/*try {
            ArrayList<String> files = (ArrayList<String>) Util.generateFileList("C:\\Users\\fx13293\\IBM\\IIBT10\\workspace\\Demo\\MyAppication", new File("C:\\Users\\fx13293\\IBM\\IIBT10\\workspace\\Demo\\MyAppication"));
            
            //FlowRendererBAR.write("C:\\Users\\fx13293\\IBM\\IIBT10\\workspace\\Demo\\", files, "MyApplication", "test.bar", FlowRendererBAR.CREATE_MODE, true);
        } catch (IOException ex) {
            Logger.getLogger(PackageBar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessageBrokerAPIException ex) {
            Logger.getLogger(PackageBar.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
}
