package com.mycompany.bugtestingsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler
{

    private String path;
    private File file;
    
    
    FileHandler(String path){this.path = path;}
    FileHandler(){this("default.txt");}

    public boolean create_file()
    {
        file = new File(path);
        try 
        {
            if (file.createNewFile()) return true;
            else return false;
        }
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        return true;
    }
    

    public void write_file(String data)
    {
        try 
        {
            String name = data+"\n";
            FileWriter fw =new FileWriter(file,true);
            fw.append(name+"\n");
            fw.close();
        } 
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public String read_file(String file_n)
    {
        File file_n1=new File (file_n);
       String all="";
        try 
        {
            Scanner fr = new Scanner(file_n1);
            while(fr.hasNextLine()) 
            {
                    String name = fr.nextLine();
                    all+=(name+"\n");
            }
            fr.close();
            return  all;
         } 
        catch (FileNotFoundException e) 
        {
            throw new RuntimeException(e);
        }
    }
    
    public boolean delete(String path)
    {
        File file_n1=new File (path);
        file_n1.delete();
        return true;
    }
    
}
