package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ShoppingCartDB {
    // login
    //detect if file exists, otherwise create user file
    public static void login (String directoryName, String secondInputName, ArrayList<String> shoppingCart) throws IOException{
        //reset the shoppingCart everytime 
        shoppingCart.removeAll(shoppingCart);
        String directoryUserName = directoryName+ File.separator+secondInputName;
        File user = new File(directoryUserName);
        if (user.createNewFile()){
            System.out.println(secondInputName + ", your cart is empty");
            }else if (user.length()==0){
                System.out.println(secondInputName + ", your cart is empty");
                    }else{
                        System.out.println(secondInputName+ ", your cart contains the following items");
                        //call list and check if empty list
                        ShoppingCartDB.list(directoryUserName, shoppingCart);
                    }
                }


    // list
    public static void list(String secondInputName, ArrayList<String> shoppingCart) throws IOException{
        if (shoppingCart.size()==0){
            File user = new File(secondInputName);
            if (user.length()==0){
                System.out.println(secondInputName + ", your cart is empty");
            }else{
                FileReader fr = new FileReader(user);
                BufferedReader br = new BufferedReader(fr);
                String line = "";
                int count = 1;
                while ((line=br.readLine())!=null){
                    shoppingCart.add(line);
                    System.out.println(count+ ". "+ line);
                    count++;
                }
                br.close();
            }
        }else{
            int count = 1;
            for (String cartItem: shoppingCart){
                System.out.println(count+ ". "+ cartItem);
                count++;
            }
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

    public static void add(String addInput, ArrayList<String> shoppingCart){
        String[] addList = addInput.split("[ ,]+");

        for (String addItem: addList){
            if (shoppingCart.contains(addItem)){
                System.out.println("You have "+ addItem + " in your cart");
            }else{
                shoppingCart.add(addItem);
                System.out.println(addItem + " added to your cart");
            }
        }
    }

    public static void delete(String deleteInput, ArrayList<String> shoppingCart){
        int deleteInt;
        if (deleteInput.isEmpty() || !deleteInput.matches(".*\\d+.*")){
            System.out.println("Incorrect input");
        }else{
            deleteInt = Integer.parseInt(deleteInput.trim()) - 1;
            if (deleteInt >= shoppingCart.size() || deleteInt<0){
                System.out.println("Incorrect item index");
            }else{
                System.out.println(shoppingCart.get(deleteInt) + " removed from cart");
                shoppingCart.remove(deleteInt);
            }
        }
    }

    public static void save(String directoryName, String secondInputName, ArrayList<String> shoppingCart) throws IOException{
        String directoryUserName = directoryName+ File.separator+secondInputName;
        File writeIntoFile = new File(directoryUserName);
        FileWriter fw = new FileWriter(writeIntoFile);
        BufferedWriter bw = new BufferedWriter(fw);
        
        for (String cartItem: shoppingCart){
            bw.write(cartItem +"\n");
        }
        System.out.println("Your cart has been saved");
        bw.close();
    }
    

}
