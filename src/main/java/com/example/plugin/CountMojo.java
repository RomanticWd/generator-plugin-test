package com.example.plugin;

import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.model.Resource;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Mojo(name = "count")
public class CountMojo extends AbstractMojo {

    private static final String[] INCLUDES_DEFAULT = {"java", "xml", "propertities"};

    @Parameter(property = "project.basedir", required = true, readonly = true)
    private File basedir;

    @Parameter(property = "project.build.sourceDirectory", required = true, readonly = true)
    private File sourceDiretory;

    @Parameter(property = "project.build.testSourceDirectory", required = true, readonly = true)
    private File testSourceDirectory;

    @Parameter(property = "project.build.resources", required = true, readonly = true)
    private List<Resource> resources;

    @Parameter(property = "project.build.testResources", required = true, readonly = true)
    private List<Resource> testResources;

    @Parameter
    private String[] includes;

    public void execute() throws MojoExecutionException {

        /*如果使用插件没有指定配置，则使用默认配置*/
        if (includes == null || includes.length ==0){
            includes = INCLUDES_DEFAULT;
        }

        try {
            countDir(sourceDiretory);
            countDir(testSourceDirectory);

            for(Resource resource : resources) {
                countDir(new File(resource.getDirectory()));
            }

            for (Resource resource : testResources) {
                countDir(new File(resource.getDirectory()));
            }
        } catch ( Exception e){
            throw new MojoExecutionException("unable to count lines of code.",e);
        }

    }

    private void countDir(File dir) throws IOException {

        if (!dir.exists()){return;}

        List<File> collected = new ArrayList<File>();

        collectFiles(collected,dir);

        int lines = 0;

        for (File sourceFile : collected) {
            lines += countLine(sourceFile);
        }

        String path = dir.getAbsolutePath().substring(basedir.getAbsolutePath().length());
        getLog().info(path + ":" + lines + " lines of code in " + collected.size() + " files");

    }

    private void collectFiles(List<File> collected, File file){

        if(file.isFile()){
            for(String include : includes){
                if(file.getName().endsWith("."+include)){
                    collected.add(file);
                    break;
                }
            }
        }else{
            for (File sub : file.listFiles()){
                collectFiles(collected, sub);
            }
        }

    }

    private int countLine(File file) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(file));

        int line = 0;

        try {
            while (reader.ready()){
                reader.readLine();
                line++;
            }
        } finally {
            reader.close();
        }

        return line;
    }
}