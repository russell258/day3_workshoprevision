package sg.edu.nus.iss;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        String directoryName = "";
        Scanner scan = new Scanner(System.in);
        String input = "";
        String secondInputName = "";
        int secondInt = 0;
        String[] addList = null;
        boolean isLoggedIn = false;
        
        // if no args specified, use default directory db
        if (args.length >0){
            directoryName = args[0];
        }else{
            directoryName = "CartDB";
        }
        File directoryFile = new File(directoryName);

        // task 1: check if directory for shoppingcart, cartdb that holds all the users exist. else create it
        if (directoryFile.exists()){
            System.out.println("Directory " + directoryName + " already exists");
        }else{
            directoryFile.mkdir();
        }

        // task 2:
        // scan keywords > login, list, add, delete, save, users
        while (!input.equals("quit")){
            System.out.print(">");
            input = scan.next();

            if (input.equals("login")){
                secondInputName = directoryName + File.separator+ scan.nextLine().trim();
                if (secondInputName.isEmpty()){
                    System.out.println("Please include your login username");
                }else{
                    ShoppingCartDB.login(secondInputName);
                    isLoggedIn = true;
                }
            }

            if (input.equals("list")){
                if (isLoggedIn){
                    ShoppingCartDB.list(secondInputName);  
                }else{
                    System.out.println("Please log in first");
                }
              
            }

            if (input.equals("users")){
                ShoppingCartDB.users(directoryFile);
            }

        }



        // save
        // write from current arraylist into the user file and flush

        // users
        // list all the files in the directory
        scan.close();
    }
}
