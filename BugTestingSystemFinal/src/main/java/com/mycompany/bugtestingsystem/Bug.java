package com.mycompany.bugtestingsystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Bug 
{
    //attributes
    private String name;
    private String type;
    private int priority;
    private int bugLevel;
    private String projectName;
    private String bugDate;
    private Boolean status;
    private String path;

    public Bug( String name, String type, int priority, int bugLevel, String projectName, String bugDate, Boolean status, String path)
    {

        this.name = name;
        this.type = type;
        this.priority = priority;
        this.bugLevel = bugLevel;
        this.projectName = projectName;
        this.bugDate = bugDate;
        this.status = status;
        this.path = path;
    }
    //setters and getters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getBugLevel() {
        return bugLevel;
    }

    public void setBugLevel(int bugLevel) {
        this.bugLevel = bugLevel;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getBugDate() {
        return bugDate;
    }

    public void setBugDate(String bugDate) {
        this.bugDate = bugDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }



    //methods

    public boolean bug_to_file() throws IOException {
        File file=new File("bug.txt");
        try
        {
            if (file.exists())
            {

                FileWriter fw =new FileWriter(file,true);
                fw.append(getName()+"\n");
                fw.append(getStatus()+"\n");
                fw.append(getType()+"\n");
                fw.append(getPriority()+"\n");
                fw.append(getBugLevel()+"\n");
                fw.append(getProjectName()+"\n");
                fw.append(getBugDate()+"\n");
                fw.append(getPath()+"\n\n");
                fw.close();
                return true;
            }
    } catch (IOException e) {
            return false;
        }

        return false;
    }
}
