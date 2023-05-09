package sg.edu.nus.iss;

import java.io.File;

public class App 
{
    public static void main( String[] args )
    {
        String directoryName = "";
        
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
        
        // login
        //detect if file exists, otherwise create user file

        // save
        // write from current arraylist into the user file and flush

        // users
        // list all the files in the directory

    }
}
