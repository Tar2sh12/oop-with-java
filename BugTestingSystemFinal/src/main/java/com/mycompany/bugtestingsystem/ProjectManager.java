package com.mycompany.bugtestingsystem;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProjectManager extends Person
{
    ProjectManager(String name, String password)
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
        File file=new File(FilePath.projectManager+".txt");

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
       
       
    public String trackDev(String name)
    {
         String bugs_no=""; 
         File file = new File(FilePath.developer+name+".txt");
         FileHandler f=new FileHandler(FilePath.developer+name+".txt");
         try
         {
                  Scanner fr = new Scanner(file);
                  fr.nextLine();
                  bugs_no= fr.nextLine();
                  fr.close();
         }
         catch (FileNotFoundException e) 
         {
                  throw new RuntimeException(e);
         }
         String devTrack="Dev_name: "+name+"\nBugs solved= "+bugs_no;
         return devTrack;
        }
    
    
     public String trackTester(String name)
    {
         String bugs_no=""; 
         File file = new File("Tester.txt");
         FileHandler f=new FileHandler("Tester.txt");
         String all = f.read_file("Tester.txt");
         try
         {
                  Scanner fr = new Scanner(file);
                  while(fr.hasNextLine())
                  {
                           if(fr.nextLine().equals(name))
                           {
                               fr.nextLine();
                               bugs_no=fr.nextLine();
                           }
                  }
                            
         }
         catch (FileNotFoundException e) 
         {
                  throw new RuntimeException(e);
         }
         String devTrack="Tester_name: "+name+"\nBugs Found= "+bugs_no;
         return devTrack;
     }
     
     
     public String viewOpenBugs()
     {
                  File file = new File("bug.txt");
                  String op="Open Bugs are: ";
                  FileHandler f_t=new FileHandler("bug.txt");
                  String all = f_t.read_file("bug.txt");
                  String[] arr=all.split("\n",all.length());
                  int c=0;
                  for(int i=0;i<arr.length;i++)
                  {
                           if(arr[i].equals("false"))
                           {       
                                   op+=arr[i-1]+" || ";
                                   c=1;
                           }
                    
                  }
                  if(c==0)return "No open bugs found";
                  else return op;  

     }
     
     
     public String viewClosedBugs()
     {
                  File file = new File("bug.txt");
                  String op="Closed Bugs are: ";
                  FileHandler f_t=new FileHandler("bug.txt");
                  String all = f_t.read_file("bug.txt");
                  String[] arr=all.split("\n",all.length());
                  int c=0;
                  for(int i=0;i<arr.length;i++)
                  {
                           if(arr[i].equals("true"))
                           {       
                                   op+=arr[i-1]+" || ";
                                   c=1;
                           }
                    
                  }
       
                  if(c==0)return "No Closed bugs found";
                  else return op;  
 

     }
     
          
}



