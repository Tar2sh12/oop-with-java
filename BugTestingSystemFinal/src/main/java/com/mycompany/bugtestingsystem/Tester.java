package com.mycompany.bugtestingsystem;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Tester extends Person 
{
    Tester(String name, String password)
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
        File file=new File(FilePath.tester+".txt");

        try
        {
                  Scanner fr = new Scanner (file);
                  while(fr.hasNextLine()) 
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

    public boolean addBug (String name, String type, int priority, int bugLevel, String projectName, String bugDate, Boolean status, String path)
    {
        try
        {
            Bug bug= new Bug(name, type, priority, bugLevel, projectName, bugDate, status, path);
            bug.bug_to_file();
        } 
        catch (IOException e) 
        {
            return false;
        }

        FileHandler f_t=new FileHandler("Tester.txt");
        String all = f_t.read_file("Tester.txt");
        f_t.delete("Tester.txt");
        String[] arr=all.split("\n",all.length());
        String all1="";
        int c=0;
        for(int i=0;i<arr.length;i++)
        {
                 if(arr[i].equals(getName()) && c==0)
                 {
                         all1+=arr[i]+"\n";
                         all1+=arr[i+1]+"\n";
                          String n=arr[i+=2];
                          n=String.valueOf(Integer.parseInt(n)+1);
                          all1+=n+"\n";
                          c=1;
                 }
                else
                 {
                         all1+=arr[i]+"\n";
                 }
      }
        f_t.create_file();
        all1 = all1.trim();
        f_t.write_file(all1);
        return true;
    }
    
    
    public boolean addBug (String name,String type,int priority,int bugLevel,String projectName,String bugDate,Boolean status)
    {
         return addBug (name,type,priority,bugLevel,projectName,bugDate,status,"Null");
    }
    
    
    public String viewStatus(String bugName)
    {
         File file=new File ("bug.txt");
         try 
         {
                  Scanner fr = new Scanner(file);
                  while(fr.hasNextLine()) 
                  {
                           String name = fr.nextLine();
                           if (name.equals(bugName)) 
                           {
                                    String s = fr.nextLine();
                                    fr.close();
                                    return s;
                           }
                  }
 
        }
        catch (FileNotFoundException e) 
        {
                  throw new RuntimeException(e);
        }
        return "Bug not found";
         }
    
    
    public boolean assignBug (String devName,String bugName)
    {
         File file=new File ("dev_"+devName+".txt");
         File filemail=new File ("dev_"+devName+"_mailbox"+".txt");
         File filebug=new File ("bug.txt");
         try 
         {
                  Scanner fr = new Scanner(filebug);
                  String bug_detail="";
                  while(fr.hasNextLine()) 
                  {
                           String name = fr.nextLine();
                           if (name.equals(bugName)) 
                           {
                                   for (int i=0;i<7;i++) 
                                   {
                                            bug_detail += (fr.nextLine()+"\n");
                                   }
                                   fr.close();
                                   break;

                           }
                  }
                  if (bug_detail.equals("")) return false;
                  if (file.exists()) 
                  {
                            FileWriter fw = new FileWriter(file, true);
                            FileWriter fw1=new FileWriter(filemail,true);
                            fw.append(bugName + "\n");
                            fw.append(bug_detail + "\n");
                            fw.close();
                            fw1.append("You have bug assigned bug name: "+bugName+"\n");
                            fw1.close();
                            return true;
                  }
                 else return false;

        }
         catch (IOException e) 
         {
                  throw new RuntimeException(e);
        }
    }
     
}
