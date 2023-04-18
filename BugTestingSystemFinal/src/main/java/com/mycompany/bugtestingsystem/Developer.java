package com.mycompany.bugtestingsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Developer extends Person 
{
    Developer(String name, String password)
    {
        setName(name);
        setPassword(password);
    }

    @Override
    public boolean Login()
    {
        String name = getName();
        String pass = getPassword();
        String userPass;
        File file = new File(FilePath.developer+name+".txt");

        try 
        {
            if (file.exists()) 
            {
                Scanner fr = new Scanner(file);
                userPass = fr.nextLine();
                if (pass.equals(userPass)) 
                {
                            fr.close();
                            return true;
                }
            } 
            else return false;


        } 
        catch (FileNotFoundException e) 
        {
            throw new RuntimeException(e);
        }

        return false;
    }

    public boolean changeBugStatus(String bugName, String status, String devName) 
    {
        FileHandler f = new FileHandler("bug.txt");
        String all = f.read_file("bug.txt");

        if (status.equals("true"))
        {
            all = all.replace(bugName + "\n" + status, bugName + "\n" + "false");
        }
            
        else
        {
            all = all.replace(bugName + "\n" + status, bugName + "\n" + "true");
        }
        f.delete("bug.txt");
        f.create_file();
        f.write_file(all);
        if (status.equals("True") || status.equals("true"))
        {
                    FileHandler f2 = new FileHandler(FilePath.developer+devName);
                    String all2 = f2.read_file(FilePath.developer+devName);
                    Scanner scanner = new Scanner(all2);
                    String firstLine = scanner.nextLine();
                    int number = Integer.parseInt(scanner.nextLine());
                    String replace = firstLine + "\n" + (number);

                    all2 = all2.replaceFirst(replace, firstLine + "\n" + (number + 1));

                    scanner.close();
                    f2.delete("dev_" +devName+".txt");
                    f2.create_file();
                    all2 = all2.trim();
                    f2.write_file(all2);

        }
        return true;
    }


    public String viewAssignedBugs(String devName) 
    {
        File file = new File(FilePath.developer +devName+".txt");

        String all = "";
        try 
        {
                    Scanner fr = new Scanner(file);
                    fr.nextLine();
                    fr.nextLine();
                    while (fr.hasNextLine()) 
                    {
                            String name = fr.nextLine();
                            all += (name + "\n");
                    }
                    fr.close();
                    return all;

        } 
        catch (FileNotFoundException e) 
        {
                    throw new RuntimeException(e);
        }

    }
    
}
