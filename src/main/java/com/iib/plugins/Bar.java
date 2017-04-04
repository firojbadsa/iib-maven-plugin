package com.iib.plugins;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import com.iib.plugins.tools.Util;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.maven.project.MavenProject;

@Mojo(name = "bar")
public class Bar extends AbstractMojo {

    /**
     * Location of the file.
     */
    @Parameter(defaultValue = "${project.build.directory}", property = "outputDir", required = true)
    private File outputDirectory;

    @Parameter(defaultValue="${project}",  required = true)
    private MavenProject project;

    public void execute()  throws MojoExecutionException {
        try {
            String artifact = project.getArtifactId();
            String filePath = String.format("%1$s/%2$s.bar", outputDirectory.getCanonicalPath(), artifact);
            String command = String.format("mqsicreatebar -data %1$s -b %1$s/%2$s.bar -a %2$s -deployAsSource -trace",outputDirectory.getCanonicalPath(), artifact);
            Util.executeCommand(command, getLog());
            project.getArtifact().setFile(new File(filePath));
            
        } catch (IOException ex) {
            Logger.getLogger(Bar.class.getName()).log(Level.SEVERE, null, ex);
            throw new MojoExecutionException("Error execution Runtime", ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Bar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
