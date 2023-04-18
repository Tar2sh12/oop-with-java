/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.bugtestingsystem;


/**
 *
 * @author pc
 */
import java.util.*;
import java.lang.*;
public class BugTestingSystem {

       public static void main(String[] args) {
//        Admin admin=new Admin ();
//        System.out.println(admin.update("Tester","Ali","123","789","pass"));
//
//FileHandler file = new FileHandler("Assign");
//file.create_file();
//
//        ProjectManager p = new ProjectManager();
//        System.out.println(p.viewDevelopers());

//Developer d=new Developer();
//d.changeBugStatus("mohamed","false");
//Admin a= new Admin("omar","0000");
//ProjectManager p =new ProjectManager("omar","789");
//Tester t=new Tester("mohamed","678");
//t.addBug("BUGG", "hj", 3, 4, "ss", "9-2-2222", false);
//System.out.println(p.trackTester("mohamed"));
//Tester t= new Tester();
//t.addBug("mohamed", "bug", "severe", 1, 10, "bb", "21-10-22", Boolean.TRUE,"fjnfn");

//ProjectManager o=new ProjectManager();
//String m=o.trackDev("Khaled");
//  System.out.println(m);
//  String k=o.trackTester("omar");
//   System.out.println(k);
//   String h=o.viewOpenBugs();
//   System.out.println(h);
//   String h1=o.viewClosedBugs();
//   System.out.println(h1);
////  
//Admin a= new Admin();

 int m;
    Scanner input = new Scanner(System.in);
    System.out.println("login as ?");
    System.out.println("1) admin");
    System.out.println("2) tester ");
    System.out.println("3) project manager");
    System.out.println("4) developer ");
    m=input.nextInt();
    
    String adminname="";
    String developername="";
    switch (m) 
    {
                case 1:
                    String namew;
                    //System.out.println("enter ur name ");
                    namew = input.nextLine();
                    
                    
                    String name;
                    System.out.println("enter ur name ");
                    name = input.nextLine();
                    
                    

                    
                    
                    String pass;
                    System.out.println("enter ur password ");
                    pass = input.nextLine();
                    
                    Admin a= new Admin(name,pass);
                    
                    if (a.Login()==true)
                    {
                        adminname=name;
                        System.out.println("hello Mr "+adminname);
                        int r;
                        System.out.println("what do u want ?");
                        System.out.println("1) add");
                        System.out.println("2) update ");
                        System.out.println("3) delete");
                        System.out.println("4) view all bugs");
                        r=input.nextInt();
                        switch (r) 
                        {
                            case 1:
                                String namea;
                                //System.out.println("enter the new name ");
                                namea = input.nextLine();


                                String newname;
                                System.out.println("enter the new name ");
                                newname = input.nextLine();





                                String newpass;
                                System.out.println("enter the new password ");
                                newpass = input.nextLine();
                                
                                
                                String type;
                                System.out.println("enter the type of user");
                                System.out.println("b) tester ");
                                System.out.println("c) project manager");
                                System.out.println("d) developer ");
                                type = input.nextLine();
                                switch (type) 
                                {
                                    case "b":
                                        FilePath fpt = new FilePath();
                                        if(a.add(fpt.tester, newname, newpass)== true)
                                        {
                                            System.out.println("new tester added by admin Mr "+adminname+" successfully");
                                        }
                                        else
                                        {
                                            System.out.println("error");
                                        }
                                      break;
                                      
                                      
                                      
                                    case "c":
                                        FilePath fppm = new FilePath();
                                        if(a.add(fppm.projectManager, newname, newpass)== true)
                                        {
                                            System.out.println("new project Manager added by admin Mr "+adminname+" successfully");
                                        }
                                        else
                                        {
                                            System.out.println("error");
                                        }
                                      break;
                                      
                                      
                                      
                                    case "d":
                                        FilePath fpd = new FilePath();
                                        if(a.add("Developer", newname, newpass)== true)
                                        {
                                            System.out.println("new developer added by admin Mr "+adminname+" successfully");
                                        }
                                        else
                                        {
                                            System.out.println("the user name already exists");
                                        }
                                      break;
                                      

                                    default:
                                      break;
                                }
                                
                                
                                break;
                            case 2:
                                
                                int u;
                                System.out.println("update which one ?");
                                System.out.println("1) admin ");
                                System.out.println("2) tester ");
                                System.out.println("3) project manager");
                                System.out.println("4) developer");
                                u=input.nextInt();
                                switch (u)
                                {
                                    case 1:
                                        String named;
                                        //System.out.println("");
                                        named = input.nextLine();


                                        String oldnamea;
                                        System.out.println("enter the old name ");
                                        oldnamea = input.nextLine();





                                        String oldpassa;
                                        System.out.println("enter the old password ");
                                        oldpassa = input.nextLine();
                                        

                                        String newnp;
                                        System.out.println("update password or name? ");
                                        newnp = input.nextLine();
                                        
                                        
                                        String newdata;
                                        System.out.println("Enter the new"+newnp+":");
                                        newdata = input.nextLine();
                                       
                                       

                                     
                                        FilePath fpua = new FilePath();
//                                                     String type, String name,String pass, String new_value,String name_or_pass
                                        if(a.update(fpua.admin, oldnamea, oldpassa, newdata, newnp)==true)
                                        {
                                            System.out.println("admin updated by admin Mr "+adminname+" successfully");
                                        }
                                        else
                                        {
                                            System.out.println("you entered wrong admin data ");
                                        }
                                        
                                      break;
                                            
                                            
                                    case 2:
                                        System.out.println("tester");
                                        String nam;
                                        //System.out.println("");
                                        nam = input.nextLine();


                                        String oldnamet;
                                        System.out.println("enter the old name ");
                                        oldnamet = input.nextLine();





                                        String oldpasst;
                                        System.out.println("enter the old password ");
                                        oldpasst = input.nextLine();
                                        

                                        String newnpt;
                                        System.out.println("update password or name? ");
                                        newnpt = input.nextLine();
                                        
                                        
                                        String newdatat;
                                        System.out.println("Enter the new"+newnpt+":");
                                        newdatat = input.nextLine();
                                       
                                       

                                     
                                        FilePath fput = new FilePath();
//                                                     String type, String name,String pass, String new_value,String name_or_pass
                                        if(a.update(fput.tester, oldnamet, oldpasst, newdatat, newnpt)==true)
                                        {
                                            System.out.println("tester updated by admin Mr "+adminname+" successfully");
                                        }
                                        else
                                        {
                                            System.out.println("you entered wrong tester data ");
                                        }
                                        
                                        
                                      break;
                                    
                                    case 3:
                                        System.out.println("project manager");
                                        String na;
                                        //System.out.println("");
                                        na = input.nextLine();


                                        String oldnamepm;
                                        System.out.println("enter the old name ");
                                        oldnamepm = input.nextLine();





                                        String oldpasspm;
                                        System.out.println("enter the old password ");
                                        oldpasspm = input.nextLine();
                                        
                                        
                                        

                                        String newnppm;
                                        System.out.println("update password or name? ");
                                        newnppm = input.nextLine();
                                        
                                        
                                        String newdatapm;
                                        System.out.println("Enter the new "+newnppm+" :");
                                        newdatapm = input.nextLine();
                                       
                                       

                                     
                                        FilePath fpupm = new FilePath();
//                                                     String type, String name,String pass, String new_value,String name_or_pass
                                        if(a.update(fpupm.projectManager, oldnamepm, oldpasspm, newdatapm, newnppm)==true)
                                        {
                                            System.out.println("Project Manager updated by admin Mr "+adminname+" successfully");
                                        }
                                        else
                                        {
                                            System.out.println("you entered wrong Project Manager data ");
                                        }
                                        
                                        
                                        
                                        
                                      break;
                                      
                                    case 4:
                                        System.out.println("developer");
                                        
                                        String n;
                                        //System.out.println("");
                                        n = input.nextLine();


                                        String oldnamed;
                                        System.out.println("enter the old name ");
                                        oldnamed = input.nextLine();





                                        String oldpassd;
                                        System.out.println("enter the old password ");
                                        oldpassd = input.nextLine();
                                        
                                        
                                        

                                        String newnpd;
                                        System.out.println("update password or name? ");
                                        newnpd = input.nextLine();
                                        
                                        
                                        String newdatad;
                                        System.out.println("Enter the new "+newnpd+" :");
                                        newdatad = input.nextLine();
                                       
                                       

                                     
//                                                     String type, String name,String pass, String new_value,String name_or_pass
                                        if(a.update("Developer", oldnamed, oldpassd, newdatad, newnpd)==true)
                                        {
                                            System.out.println("Developer updated by admin Mr "+adminname+" successfully");
                                        }
                                        else
                                        {
                                            System.out.println("you entered wrong Developer data ");
                                        }
                                        
                                        
                                        
                                      break;  
                                        
                                    default:
                                          break;
                                }
                                
                                
                              break;
                              
                            case 3:
                                System.out.println("delete");
                                
                                String n;
                                //System.out.println("enter the new name ");
                                n = input.nextLine();


                                String deletename;
                                System.out.println("enter the name ");
                                deletename = input.nextLine();





                                String deletepass;
                                System.out.println("enter the password ");
                                deletepass = input.nextLine();
                                
                                String t;
                                System.out.println("enter the type of user u want to delete ");
                                System.out.println("a) admin ");
                                System.out.println("b) tester ");
                                System.out.println("c) project manager");
                                System.out.println("d) developer ");
                                t = input.nextLine();
                                switch (t) 
                                {
                                    
                                    case "a":
                                        FilePath fpa = new FilePath();
                                        if(a.delete(fpa.admin, deletename, deletepass)== true)
                                        {
                                            System.out.println("An admin deleted by admin Mr "+adminname+" successfully");
                                        }
                                        else
                                        {
                                            System.out.println("error");
                                        }
                                      break;
                                    
                                    
                                    
                                    
                                    case "b":
                                        FilePath fpt = new FilePath();
                                        if(a.delete(fpt.tester, deletename, deletepass)== true)
                                        {
                                            System.out.println("tester deleted by admin Mr "+adminname+" successfully");
                                        }
                                        else
                                        {
                                            System.out.println("error");
                                        }
                                      break;
                                      
                                      
                                      
                                    case "c":
//                                        FilePath fpp = new FilePath();
                                        if(a.delete("ProjectManager", deletename, deletepass)== true)
                                        {
                                            System.out.println("project Manager deleted by admin Mr "+adminname+" successfully");
                                        }
                                        else
                                        {
                                            System.out.println("error");
                                        }
                                      break;
                                      
                                      
                                      
                                    case "d":
                                        FilePath fpd = new FilePath();
                                        if(a.delete("Developer", deletename, deletepass)== true)
                                        {
                                            System.out.println("developer deleted by admin Mr "+adminname+" successfully");
                                        }
                                        else
                                        {
                                            System.out.println("error");
                                        }
                                      break;
                                      

                                    default:
                                      break;
                                }
                                
                                
                                
                                
                                
                              break;
                              
                            case 4:
                                System.out.println("bugs in the system :");
                                
                                System.out.println(a.view_all_bugs());
                                
                                
                              break; 
                              
                              
                              
                            default:
                              break;
                        }


                    }
                    else
                    {
                        System.out.println("incorrect password or username ");
                    }
                  break;
                  
                  
                case 2:
                    System.out.println("login tester");
                  break;
                  
                  

                case 3:
                    System.out.println("login project manager");
                  break;
                    
                  
                  
                  
                case 4:
                    System.out.println("login developer");
                    String x;
                    //System.out.println("enter ur name ");
                    x = input.nextLine();
                    
                    
                    String dname;
                    System.out.println("enter ur name ");
                    dname = input.nextLine();
                    
                    

                    
                    
                    String dpass;
                    System.out.println("enter ur password ");
                    dpass = input.nextLine();
                    
                    Developer d = new Developer(dname,dpass);
                    if(d.Login()==true)
                    {
                        developername=dname;
                        String ds="";
                        System.out.println("what do u want ?");
                        System.out.println("a) view assigned bugs ");
                        System.out.println("b) change status of bug ");
                        ds = input.nextLine();
                        switch (ds) 
                        {
                                    
                            case "a":
                                System.out.println(d.viewAssignedBugs(developername));

                              break;
                                    
                                    
                                    
                                    
                            case "b":                               

                                String bugname;
                                System.out.println("enter bug name ");
                                bugname = input.nextLine();





                                String statusd;
                                System.out.println("enter status of the bug");
                                statusd = input.nextLine();
                                
                                

                                
                                if(d.changeBugStatus(bugname,statusd,developername))
                                {
                                    System.out.println("status of bug changed");
                                    System.out.println("check your mail box");
                                }
                                else
                                {
                                    System.out.println("you entered wrong bug data");
                                }

                                
                                

                              break;
                                      

                            default:
                              break;
                        }
                    }
                    else
                    {
                        System.out.println("you entered wrong pass or user name");
                    }
                    
                    
                  break;
                  
                  
                  
                default:
                  break;
    }

    
    
    
    
    }
}






































