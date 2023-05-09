package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ShoppingCartDB {
    
    // login
    //detect if file exists, otherwise create user file
    public static void login (String secondInputName) throws IOException{
        File user = new File(secondInputName);
        if (user.createNewFile()){
            System.out.println(secondInputName + ", your cart is empty");
            }else if (user.length()==0){
                System.out.println(secondInputName + ", your cart is empty");
                    }else{
                        System.out.println(secondInputName+ ", your cart contains the following items");
                        //call list and check if empty list
                        ShoppingCartDB.list(secondInputName);
                    }
                }


    // list
    public static void list(String secondInputName) throws IOException{
        File user = new File(secondInputName);
        if (user.length()==0){
            System.out.println(secondInputName + ", your cart is empty");
        }else{
            FileReader fr = new FileReader(user);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            int count = 1;
            while ((line=br.readLine())!=null){
                System.out.println(count+ ". "+ line);
                count++;
            }
            br.close();
        }
    }

    //users list files in directory
    public static void users(File directoryFile){
        String[] userFiles = directoryFile.list();
        if (userFiles.length==0){
                System.out.println("No users yet");
            }else{
                int count = 1;
                for (String fileName: userFiles){
                    System.out.println(count+". "+ fileName);
                    count++;
                }
            }
    }



}
