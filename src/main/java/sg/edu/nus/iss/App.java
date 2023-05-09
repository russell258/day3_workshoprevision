package sg.edu.nus.iss;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        String directoryName = "";
        Scanner scan = new Scanner(System.in);
        String input = "";
        String secondInputName = "";
        String addInput = "";
        String deleteInput = "";
        boolean isLoggedIn = false;
        ArrayList<String> shoppingCart = new ArrayList<String>();
        
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
                secondInputName = scan.nextLine().trim();
                if (secondInputName.isEmpty()){
                    System.out.println("Please include your login username");
                }else{
                    ShoppingCartDB.login(directoryName, secondInputName, shoppingCart);
                    isLoggedIn = true;
                }
            }

            if (input.equals("list")){
                if (isLoggedIn){
                    ShoppingCartDB.list(secondInputName, shoppingCart);  
                }else{
                    System.out.println("Please log in first");
                }
              
            }
            // users
            // list all the files in the directory
            if (input.equals("users")){
                ShoppingCartDB.users(directoryFile);
            }

            if (input.equals("add")){
                addInput = scan.nextLine().trim().toLowerCase();
                if (!addInput.isEmpty() && isLoggedIn){
                    ShoppingCartDB.add(addInput, shoppingCart);
                }else{
                    System.out.println("Please ensure you are logged in or you are adding something");
                }
            }

            if (input.equals("delete") && isLoggedIn){
                deleteInput = scan.nextLine();
                ShoppingCartDB.delete(deleteInput, shoppingCart);
            }
            
            // save
            // write from current arraylist into the user file and flush
            if (input.equals("save")){
                if (!isLoggedIn){
                    System.out.println("Please log in first");
                }else{
                    ShoppingCartDB.save(directoryName, secondInputName, shoppingCart);
                }
            }

        }

        scan.close();
    }
}
