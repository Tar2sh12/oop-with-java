/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bugtestingsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author pc
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Admin extends Person 
{

    Admin(String name, String password)
    {
        setName(name);
        setPassword(password);
    }


    @Override
    public boolean Login()
    {
        String name = getName();
        String pass = getPassword();
        String userName;
        String userPass;
        File file = new File(FilePath.admin+".txt");


        try
        {
                    Scanner fr = new Scanner(file);
                    while (fr.hasNextLine())
                    {
                             userName = fr.nextLine();
                             userPass = fr.nextLine();
                             if (name.equals(userName))
                             {
                                    if (pass.equals(userPass))
                                    {
                                            fr.close();
                                            return true;
                                    }

                             }
                    }
        }
        catch (FileNotFoundException e)
        {
                   throw new RuntimeException(e);
        }

        return false;
    }

    public boolean add(String type, String name, String pass)
    {
            if (type .equals("Developer") || type.equals("developer"))
            {
                  File file = new File(FilePath.developer+name+".txt");
                  File file1= new File ("dev_"+name+"_mailbox"+".txt");
                  try
                  {
                             if (file.createNewFile() && file1.createNewFile())
                             {
                                    FileWriter fw = new FileWriter(file, true);
                                    fw.append(pass+"\n0\n");
                                    fw.close();
                                    return true;
                            }
                             else return false;
                  }
                catch (Exception e)
                {
                            System.out.println(e.getMessage());
                }
            }

            else if (type.equals("Tester") )
            {
                    File file = new File(FilePath.tester+".txt");
                    try
                    {
                            if (file.exists())
                            {

                                    FileWriter fw = new FileWriter(file, true);
                                    fw.append(name + "\n");
                                    fw.append(pass + "\n");
                                    fw.append("0"+ "\n");
                                    fw.close();
                                    return true;
                            }
                            else
                            {
                                    return false;
                            }
                  }
                    catch (IOException e)
                    {
                            throw new RuntimeException(e);
                    }
            }

            else if (type.equals("ProjectManager") )
            {
                    File file = new File(FilePath.projectManager+".txt");
                    try
                    {
                             if (file.exists())
                             {

                                    FileWriter fw = new FileWriter(file, true);
                                    fw.append(name + "\n");
                                    fw.append(pass + "\n");
                                    fw.close();
                                    return true;
                            }
                            else return false;

                    }
                    catch (IOException e)
                    {
                        throw new RuntimeException(e);
                    }
               }
                return false;
    }

    public boolean update(String type, String name,String pass, String new_value,String name_or_pass) {
        if(type.equals("Developer"))
        {
                    FileHandler f = new FileHandler(FilePath.developer+name+".txt");
                    String all = f.read_file("dev_"+name+".txt");
                    String all1 = "";
                    all1= all.replaceFirst(pass,new_value);
                    if (all.equals(all1)) return false;
                    f.delete("dev_"+name+".txt");
                    f.create_file();
                    all1 = all1.trim();
                    f.write_file(all1);
                    return true;
        }
        else
        {
                    FileHandler f = new FileHandler(type+".txt");
                    String all = f.read_file(type+".txt");
                    String all1 = "";
                    if (name_or_pass.equals("Name") || name_or_pass.equals("name"))
                    {
                           all1= all.replaceFirst(name+"\n"+pass,new_value+"\n"+pass);
                    }
                    else if (name_or_pass.equals("pass") || name_or_pass.equals("password"))
                    {

                            all1= all.replaceFirst(name+"\n"+pass,name+"\n"+new_value);
                    }
                    if (all.equals(all1)) return false;
                    f.delete(type+".txt");
                    f.create_file();
                    all1 = all1.trim();
                    f.write_file(all1);
                    return true;
        }


    }


    public boolean delete(String type, String name, String password)
    {
        if(type.equals("Developer"))
        {
                    FileHandler f = new FileHandler(FilePath.developer+name+".txt");
                    f.delete(FilePath.developer+name+".txt");
                    return true;
        }
        else
        {
                    FileHandler f = new FileHandler(type+".txt");
                    String all = f.read_file(type+".txt");
                    String all1 = "";
                    all1= all.replaceFirst(name+"\n"+password,"");
                    if (all.equals(all1)) return false;
                    f.delete(type+".txt");
                    f.create_file();
                    f.write_file(all1.trim()+"\n");
                    return true;


        }

    }


    public String view_all_bugs()
    {
        FileHandler file = new FileHandler("bug.txt");
        return file.read_file("bug.txt");
    }
}
