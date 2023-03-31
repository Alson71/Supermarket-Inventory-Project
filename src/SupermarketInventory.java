import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;
import org.apache.commons.io.input.*;


public class SupermarketInventory{

    static File file = new File("src/supermarket.txt");
    static String intro;
    static int items, YesNo, lockedOut,makeupMind;
    static ArrayList<Object> item,id;
    static ArrayList<Integer> quantity;
    static URL url1,url2,url3,url4,url5;
    static ImageIcon icon,icon1,icon2,icon3,icon4;
    static Object [] i,l,km;



    public static void main(String[] args) throws IOException {
        supermarketInventory();
    }



    public static void saveToFile() throws IOException{

        //Confirm dialog to end the program
        YesNo = JOptionPane.showConfirmDialog(null, "Are you sure you want to end the program?", "End Program", JOptionPane.YES_NO_OPTION);

        if (YesNo == 0) {
            PrintWriter writer=new PrintWriter(file); //The data will be saved to a text file that's already instantiated

            //Presentation of the list on the text file
            writer.println("Supermarket Inventory: ");
            writer.println();
            Object [][] array= new Object[3][2];
            array[0]= new Object[i.length+1];
            array[0][0]= "Item Name:";
            for(int j=1; j<array[0].length; j++){
                array[0][j]= i[j-1];
                if(j==i.length-1){
                    break;
                }
            }
            for(int j=0; j<array[0].length-1;j++){
                writer.print(array[0][j]+" ");
            }
            writer.println();
            array[1]= new Object[l.length+1];
            array[1][0]= "Item ID:";
            System.arraycopy(l, 0, array[1], 1, array[1].length - 1);
            for(int j=0; j<array[1].length;j++){
                writer.print(array[1][j]+" ");
            }
            writer.println();
            array[2]= new Object[km.length+1];
            array[2][0]= "Item Quantity:";
            System.arraycopy(km, 0, array[2], 1, array[2].length - 1);
            for(int j=0; j<array[2].length;j++){
                writer.print(array[2][j]+" ");
            }

            //Spacing in the text file
            writer.println();
            writer.println();
            writer.println();
            writer.println();
            writer.println();

            //The data to be parsed is at the end of the file to read from in reverse
            writer.println("Saved Data:");
            writer.println();
            for (Object o : i) {
                writer.print(o + "#");
            }
            writer.println();
            for (Object o : l) {
                writer.print(o + "#");
            }
            writer.println();
            for (Object o : km) {
                writer.print(o + "#");
            }
            writer.flush();
            writer.close();

            //Finally, the program ends
            System.exit(0);
        }

    }



    //The method is the same as "saveToFile()", however there's a funny twist
    public static void specialSaveToFile() throws IOException{

        YesNo = JOptionPane.showConfirmDialog(null, "Are you sure you want to end the program?", "End Program", JOptionPane.YES_NO_OPTION);

        if (YesNo == 0){
            PrintWriter writer=new PrintWriter(file);
            writer.println("Supermarket Inventory: ");
            writer.println();
            Object [][] array= new Object[3][2];
            array[0]= new Object[i.length];
            array[0][0]= "Item Name:";
            System.arraycopy(i, 0, array[0], 1, array[0].length - 1);
            array[1]= new Object[l.length+1];
            array[1][0]= "Item ID:";
            System.arraycopy(l, 0, array[1], 1, array[1].length - 1);
            array[2]= new Object[km.length+1];
            array[2][0]= "Item Quantity:";
            System.arraycopy(km, 0, array[2], 1, array[2].length - 1);
            for(int j=0; j<3;j++){
                for(int k=0; k<array[j].length; k++){
                    writer.print(array[j][k]+" ");
                }
                writer.println();
            }
            writer.println();
            writer.println();
            writer.println();
            writer.println();
            writer.println("Saved Data:");
            writer.println();
            for (Object o : i) {
                writer.print(o + "#");
            }
            writer.println();
            for (Object o : l) {
                writer.print(o + "#");
            }
            writer.println();
            for (Object o : km) {
                writer.print(o + "#");
            }
            writer.flush();
            writer.close();
            System.exit(0);
        }
        else if(YesNo==1){

            //Interacts with the user if they keep on clicking no to close the program
            makeupMind++;
            if(makeupMind==5){
                JOptionPane.showMessageDialog(null, "Make up your mind!");
            }

            //After a total of 10 times, the program shutdowns for the user's indecisiveness
            else if(makeupMind==10){
                JOptionPane.showMessageDialog(null,"Fine, we'll do it for you. Initiating system shutdown!");
                PrintWriter writer=new PrintWriter(file);
                writer.println("Supermarket Inventory: ");
                writer.println();
                Object [][] array= new Object[3][2];
                array[0]= new Object[i.length];
                array[0][0]= "Item Name:";
                System.arraycopy(i, 0, array[0], 1, array[0].length - 1);
                array[1]= new Object[l.length+1];
                array[1][0]= "Item ID:";
                System.arraycopy(l, 0, array[1], 1, array[1].length - 1);
                array[2]= new Object[km.length+1];
                array[2][0]= "Item Quantity:";
                System.arraycopy(km, 0, array[2], 1, array[2].length - 1);
                for(int j=0; j<3;j++){
                    for(int k=0; k<array[j].length; k++){
                        writer.print(array[j][k]+" ");
                    }
                    writer.println();
                }
                writer.println();
                writer.println();
                writer.println();
                writer.println();
                writer.println("Saved Data:");
                writer.println();
                for (Object o : i) {
                    writer.print(o + "#");
                }
                writer.println();
                for (Object o : l) {
                    writer.print(o + "#");
                }
                writer.println();
                for (Object o : km) {
                    writer.print(o + "#");
                }
                writer.flush();
                writer.close();
                System.exit(0);
            }

        }
    }




    public static void createPictures() throws IOException{

        //The picture links
         url1 = new URL("https://t3.ftcdn.net/jpg/01/27/54/10/360_F_127541046_yLlMu84gM9kKBjzNKp6ZSwAjuydyJA48.jpg");
         url2= new URL("https://zktecopos.com/assets/img/software/supermarket-with-food-shelves-illustration_1262-16618.jpg");
         url3= new URL("https://t4.ftcdn.net/jpg/01/00/83/01/360_F_100830164_GkCBwckrE0g9FJrOdt4t8LFYgNN32z88.jpg");
         url4= new URL("https://img.freepik.com/premium-vector/opposite-old-new-vector-illustration_74440-558.jpg");
         url5= new URL("https://i0.wp.com/www.complexsql.com/wp-content/uploads/2018/01/Alter-table.png?fit=400%2C400&ssl=1");

         icon= new ImageIcon(url1);
         icon1= new ImageIcon(url2);
         icon2= new ImageIcon(url3);
         icon3= new ImageIcon(url4);
         icon4= new ImageIcon(url5);

        //Reformatting the images for JOptionPane
        Image img = icon.getImage();
        Image img1=icon1.getImage();
        Image img2=icon2.getImage();
        Image img3=icon3.getImage();
        Image img4=icon4.getImage();

        Image newImg = img.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
        Image newImg1 = img1.getScaledInstance(300, 200,  java.awt.Image.SCALE_SMOOTH);
        Image newImg2 = img2.getScaledInstance(160, 240,  java.awt.Image.SCALE_SMOOTH);
        Image newImg3 = img3.getScaledInstance(208, 208,  java.awt.Image.SCALE_SMOOTH);
        Image newImg4 = img4.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);

        icon= new ImageIcon(newImg);
        icon1= new ImageIcon(newImg1);
        icon2= new ImageIcon(newImg2);
        icon3= new ImageIcon(newImg3);
        icon4= new ImageIcon(newImg4);
    }




    public static void loadData() throws IOException{

        //Default list
        if(file.length()==0){
            item = new ArrayList<>(Arrays.asList("Candy", "Meat", "Alcohol", "Fruit", "Actions"));
            id = new ArrayList<>(Arrays.asList("N08D5", "M8T91", "L3N61", "P2K46"));
            quantity = new ArrayList<>(Arrays.asList(287, 36, 62, 322));
        }

        //Saved list from text file
        else{

            ReversedLinesFileReader fileReader= new ReversedLinesFileReader(file, StandardCharsets.UTF_8);
            String [] array= new String[3];
            for(int i=0; i<3; i++){
                array[i]= fileReader.readLine();
            }
            Object [] i2,l2;
            String [] km2;


            i2 = array[2].split("#");
            if(i2.length==1){
                item=new ArrayList<>();
                item.add("Actions");
            }
            else {
                item = new ArrayList<>(Arrays.asList(i2));
            }
            if(array[1].length()!=0) {
                l2 = array[1].split("#");
                id = new ArrayList<>(Arrays.asList(l2));
            }
            else{
                id=new ArrayList<>();
            }
            if(array[2].length()!=0) {
                km2 = array[0].split("#");
                quantity = new ArrayList<>();
                for (String s : km2) {
                    int j = Integer.parseInt(s);
                    quantity.add(j);
                }
            }
            else{
                quantity=new ArrayList<>();
            }
            fileReader.close();

        }
    }







    public static void login(){

        //Password dialog box
        do {
            intro = JOptionPane.showInputDialog(null,"Enter passcode:","Login",JOptionPane.INFORMATION_MESSAGE);

            if(intro==null){
                System.exit(0);
            }
            if(intro.equals("")){
                continue;
            }

            //Precautions taken if the user enters the wrong password
            if (!intro.equals("password")) {
                lockedOut++;
                if(lockedOut<5) {

                    //Password hint dialog
                    if(lockedOut==3){
                        JOptionPane.showMessageDialog(null,"Hint: The password starts with a p");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Error! Wrong password. Please try again.");
                    }
                }

                //The user will get locked out if they get the password wrong 5 times
                else if(lockedOut==5){
                    JOptionPane.showMessageDialog(null,"You have entered the wrong password five times. \n            Initiating system shutdown...");
                    System.exit(0);
                }
            }

        } while (!intro.equals("password"));
        JOptionPane.showMessageDialog(null, "Successful Login!");

    }



    public static void supermarketInventory() throws IOException{

        //Changing the style of the JOptionPane font
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD,17));

        //Prerequisites before starting the program
        createPictures();
        login();
        loadData();

        //Program runs infinitely until the user clicks the "x" button on the JOptionPane
        do {
            //Initializing the inventory data fields and actions lists
            id.remove("Actions");
            i = item.toArray();
            l= id.toArray();
            km= quantity.toArray();
            Object [] options={"Add Item","Remove Item","Replace Item","Modify Item","Back"};

            //Default state of the inventory
            items = JOptionPane.showOptionDialog(null, "Choose an item to oversee.", "Supermarket Inventory", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, i, i[0]);

            //User wants to close the program
            if (items == -1) {
                specialSaveToFile();
                continue;
            }

            //Actions list is displayed after clicking actions button
            else if(item.get(items).equals("Actions")){
                int actions = JOptionPane.showOptionDialog(null, "Choose an action.", "Actions", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, icon1, options, options[0]);

                //The back button
                if(actions==4) {
                    continue;
                }

                //User wants to close file
                else if(actions==-1){
                    saveToFile();
                    continue;
                }

                //Add an item to the inventory
                else if(actions==0) {
                    int cancel=-1,f=-1;
                    String k1,k2="",k3="";
                    boolean b;

                    do {
                        do {
                            k1 = JOptionPane.showInputDialog(null,"Enter the name of the item","Add Item",JOptionPane.INFORMATION_MESSAGE);

                            if (k1 == null) {
                                break;
                            }

                            if(k1.equalsIgnoreCase("Actions")){
                                JOptionPane.showMessageDialog(null,"You can't add \"Actions\" button.");
                            }
                            else if(item.contains(k1)){
                                JOptionPane.showMessageDialog(null,"Two items can't have the same name.","Error!",JOptionPane.INFORMATION_MESSAGE,null);
                            }
                            else if(!k1.matches("[a-zA-Z\\s]*")){
                                JOptionPane.showMessageDialog(null,"The name of an item cannot have any numbers or special characters.","Error!",JOptionPane.INFORMATION_MESSAGE,null);
                            }

                        }while(k1.equalsIgnoreCase("Actions") || item.contains(k1) || !k1.matches("[a-zA-Z\\s]*"));
                        if (k1 == null) {
                            cancel = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this action?", "Cancel", JOptionPane.YES_NO_OPTION);
                            if (cancel == 0) {
                                break;
                            } else if (cancel == 1) {
                                continue;
                            }

                        }
                        else {
                            k1 = k1.replaceAll("\\s+", " ");
                        }

                        do {
                            k2 = JOptionPane.showInputDialog(null,"Enter the ID of the item","Add Item",JOptionPane.INFORMATION_MESSAGE);
                            if(k2==null) break;
                            if(id.contains(k2)){
                                JOptionPane.showMessageDialog(null,"Two items cannot have the same ID.","Error!",JOptionPane.INFORMATION_MESSAGE);
                            }
                            else if(k2.length()>5){
                                JOptionPane.showMessageDialog(null,"The ID must be within five characters.","Error!",JOptionPane.INFORMATION_MESSAGE);
                            }
                            else if(!k2.matches("[a-zA-Z\\d]*")){
                                JOptionPane.showMessageDialog(null,"The ID of an item cannot have any numbers or special characters.","Error!",JOptionPane.INFORMATION_MESSAGE,null);
                            }
                        }while(id.contains(k2) || k2.length()>5 || !k2.matches("[a-zA-Z\\d]*"));

                        if (k2 == null) {
                            cancel = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this action?", "Cancel", JOptionPane.YES_NO_OPTION);
                            if (cancel == 0) {
                                break;
                            } else if (cancel == 1) {
                                continue;
                            }
                        }
                        else {
                            k2 = k2.replaceAll("\\s+", " ");
                        }

                        do {
                            b=true;
                            try {
                                k3 = JOptionPane.showInputDialog(null,"Enter the quantity of the item","Add Item",JOptionPane.INFORMATION_MESSAGE);
                                if(k3==null){
                                    break;
                                }
                                f=Integer.parseInt(k3);
                                if(f<0){
                                    JOptionPane.showMessageDialog(null,"The quantity must be greater than 0.","Error!",JOptionPane.INFORMATION_MESSAGE,null);
                                }
                            }catch(Exception e){
                                b=false;
                                JOptionPane.showMessageDialog(null,"You must type in real numbers","Error!",JOptionPane.INFORMATION_MESSAGE,null);
                            }
                        }while(!b || f<0);
                        if (k3 == null) {
                            cancel = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this action?", "Cancel", JOptionPane.YES_NO_OPTION);
                            if (cancel == 0) {
                                break;
                            }
                        }
                    }while(k1==null || k2==null || k3==null);

                    if(cancel==0){
                        continue;
                    }

                    if(k1.equalsIgnoreCase("") || k2.equalsIgnoreCase("") || k3.equalsIgnoreCase("")){
                        continue;
                    }

                    item.add("Actions");
                    item.set(item.size()-2,k1);
                    id.add(k2);
                    quantity.add(f);

                    JOptionPane.showMessageDialog(null,"Item successfully added!","Item Added",JOptionPane.INFORMATION_MESSAGE);
                    continue;

                }

                //Remove an item from the inventory
                else if(actions==1){

                    //Empty list
                    if(i.length == 1){
                        JOptionPane.showMessageDialog(null,"You must have items on your list first.","Empty List",JOptionPane.INFORMATION_MESSAGE);
                        continue;
                    }

                    int cancel=-1,k1,confirm=2;
                    Object [] huh= new Object[i.length-1];
                    System.arraycopy(i, 0, huh, 0, i.length - 1);

                    do {

                        k1 = JOptionPane.showOptionDialog(null,"Choose an item to remove.","Remove Item",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,icon2,huh,huh[0]);
                        if(k1==-1) {
                            cancel = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this action?", "Cancel", JOptionPane.YES_NO_OPTION);
                            if (cancel == 0) {
                                break;
                            }
                            else if(cancel==1){
                                continue;
                            }
                        }
                        confirm = JOptionPane.showConfirmDialog(null, "Are you sure that you want to remove " + i[k1] +"?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon2);

                    }while(k1==-1 || confirm==1);

                    if(cancel==0){
                        continue;
                    }

                    item.remove(k1);
                    id.remove(k1);
                    quantity.remove(k1);
                    JOptionPane.showMessageDialog(null,"Item (" + i[k1] + ") removed successfully!" ,"Item Removed",JOptionPane.INFORMATION_MESSAGE);
                    continue;

                }

                //Replace an item in the inventory
                else if(actions==2){

                    //Empty list
                    if(i.length == 1){
                        JOptionPane.showMessageDialog(null,"You must have items on your list first.","Empty List",JOptionPane.INFORMATION_MESSAGE);
                        continue;
                    }

                    int cancel=-1,f=-1;
                    Object [] huh= new Object[i.length-1];
                    System.arraycopy(i, 0, huh, 0, i.length - 1);
                    int k1;
                    String k2="",k3="",k4="";
                    boolean b;

                    do {
                        k1 = JOptionPane.showOptionDialog(null,"Choose an item to replace.","Replace Item",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,icon3,huh,huh[0]);

                        if(k1==-1) {
                            cancel = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this action?", "Cancel", JOptionPane.YES_NO_OPTION);
                            if (cancel == 0) {
                                break;
                            } else if (cancel == 1) {
                                continue;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Item Chosen: " + i[k1],"Item Chosen",JOptionPane.INFORMATION_MESSAGE);

                        do {
                            k2 = JOptionPane.showInputDialog("Enter the name to replace item");
                            if(k2==null){
                                break;
                            }
                            if(k2.equalsIgnoreCase("Actions")){
                                JOptionPane.showMessageDialog(null,"You can't make another \"Actions\" button.");
                            }
                            else if(!k2.matches("[a-zA-Z\\s]*")){
                                JOptionPane.showMessageDialog(null,"The name of an item cannot have any numbers or special characters.","Error!",JOptionPane.INFORMATION_MESSAGE,null);
                            }
                        }while(k2.equalsIgnoreCase("Actions") || !k2.matches("[a-zA-Z\\s]*"));

                        if (k2 == null) {
                            cancel = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this action?", "Cancel", JOptionPane.YES_NO_OPTION);
                            if (cancel == 0) {
                                break;
                            } else if (cancel == 1) {
                                continue;
                            }
                        }
                        else {
                            k2 = k2.replaceAll("\\s+", " ");
                        }

                        do {
                            k3 = JOptionPane.showInputDialog("Enter the ID of the replaced item");
                            if(k3==null){
                                break;
                            }
                            if(k3.length()>5){
                                JOptionPane.showMessageDialog(null,"The ID must be within five characters.","Error!",JOptionPane.INFORMATION_MESSAGE);
                            }
                            else if(!k3.matches("[a-zA-Z\\d]*")){
                                JOptionPane.showMessageDialog(null,"The ID of an item cannot have any numbers or special characters.","Error!",JOptionPane.INFORMATION_MESSAGE,null);
                            }
                        }while(k3.length()>5 || !k3.matches("[a-zA-Z\\d]*"));

                        if (k3 == null) {
                            cancel = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this action?", "Cancel", JOptionPane.YES_NO_OPTION);
                            if (cancel == 0) {
                                break;
                            } else if (cancel == 1) {
                                continue;
                            }
                        }
                        else {
                            k3 = k3.replaceAll("\\s+", " ");
                        }

                        do {
                            b=true;
                            try {
                                k4 = JOptionPane.showInputDialog("Enter the quantity of the replaced item");
                                if(k4==null){
                                    break;
                                }
                                f=Integer.parseInt(k4);
                                if(f<0){
                                    JOptionPane.showMessageDialog(null,"The quantity must be greater than 0.","Error!",JOptionPane.INFORMATION_MESSAGE,null);
                                }
                            }catch(Exception e){
                                b=false;
                                JOptionPane.showMessageDialog(null,"You must type in real numbers","Error!",JOptionPane.INFORMATION_MESSAGE,null);
                            }
                        }while(!b || f<0);

                        if (k4 == null) {
                            cancel = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this action?", "Cancel", JOptionPane.YES_NO_OPTION);
                            if (cancel == 0) {
                                break;
                            }
                        }
                    }while(k1==-1 || k2==null || k3==null || k4==null);

                    if(cancel==0){
                        continue;
                    }


                    item.set(k1,k2);
                    id.set(k1,k3);
                    quantity.set(k1,f);

                    JOptionPane.showMessageDialog(null,"Item (" + i[k1] + ") replaced with (" + k2 + ") successfully!" ,"Item Replaced",JOptionPane.INFORMATION_MESSAGE);
                    continue;
                }

                //Modify the data fields of an item: name,ID, or quantity
                else if(actions==3){
                    String [] options2= {"Name","ID","Quantity"};

                    //Empty list
                    if(i.length == 1){
                        JOptionPane.showMessageDialog(null,"You must have items on your list first.","Empty List",JOptionPane.INFORMATION_MESSAGE);
                        continue;
                    }

                    Object [] modifyName = new Object[i.length-1];
                    Object [] modifyID = new Object[l.length];
                    Object [] modifyQuantity = new Object[km.length];
                    System.arraycopy(i, 0, modifyName, 0, i.length - 1);
                    System.arraycopy(l, 0, modifyID, 0, l.length);
                    System.arraycopy(km, 0, modifyQuantity, 0, km.length);
                    int bruh,cancel1=-5,ok;

                    do {
                        bruh = JOptionPane.showOptionDialog(null, "Choose an item to modify.", "Modify", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, icon4, modifyName, modifyName[0]);
                        if (bruh == -1) {
                            cancel1 = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this action?", "Cancel", JOptionPane.YES_NO_OPTION);
                            if (cancel1 == 0) {
                                break;
                            }
                        }
                    }while(cancel1==1 && bruh==-1);
                    if(cancel1==0){
                        continue;
                    }
                    int cancel2=-5;
                    do {

                        ok = JOptionPane.showOptionDialog(null, "What would you like to modify for " + modifyName[bruh] + "?", "Modify", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options2, options2[0]);
                        if (ok == -1) {
                            cancel2= JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this action?", "Cancel", JOptionPane.YES_NO_OPTION);
                            if(cancel2==0){
                                break;
                            }
                        }
                    }while(cancel2==1 && ok==-1);
                    if(cancel2==0){
                        continue;
                    }

                    //Modify item name
                    if(ok==0){
                        int cancel=5;
                        String k1;
                        do {

                            do {
                                k1 = JOptionPane.showInputDialog(null, "What is the new name of your item?", "Name Change", JOptionPane.INFORMATION_MESSAGE);
                                if (item.contains(k1)) {
                                    if(k1.equals("Actions")){
                                        JOptionPane.showMessageDialog(null,"Can't rename item to \"Actions\"","Error!",JOptionPane.INFORMATION_MESSAGE,null);
                                    }
                                    else {
                                        JOptionPane.showMessageDialog(null, "Two items can't have the same name.", "Error!", JOptionPane.INFORMATION_MESSAGE, null);
                                    }
                                }
                                else if(k1==null){
                                    break;
                                }
                                else if(!k1.matches("[a-zA-Z\\s]*")){
                                    JOptionPane.showMessageDialog(null,"The name of an item cannot have any numbers or special characters.","Error!",JOptionPane.INFORMATION_MESSAGE,null);
                                }
                            } while(item.contains(k1) || !k1.matches("[a-zA-Z\\s]*"));
                            if(k1==null) {
                                cancel = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this action?", "Cancel", JOptionPane.YES_NO_OPTION);
                                if (cancel == 0) {
                                    break;
                                }
                            }
                            else {
                                k1 = k1.replaceAll("\\s+", " ");
                            }
                        }while(k1==null);
                        if(cancel==0){
                            continue;
                        }
                        item.set(bruh,k1);
                        JOptionPane.showMessageDialog(null,"Item Name (" + modifyName[bruh] + ") changed to (" + k1 + ") successfully!" ,"Item Name Replaced",JOptionPane.INFORMATION_MESSAGE);
                    }

                    //Modify item ID
                    else if(ok==1){
                        int cancel=-5;
                        String k1;
                        do {

                            do {
                                k1 = JOptionPane.showInputDialog(null, "What is the new ID of your item?", "ID Change", JOptionPane.INFORMATION_MESSAGE);
                                if (id.contains(k1)) {
                                    JOptionPane.showMessageDialog(null,"Two items can't have the same ID.","Error!",JOptionPane.INFORMATION_MESSAGE,null);
                                }
                                else if(k1==null){
                                    break;
                                }
                                else if(k1.length()>5){
                                    JOptionPane.showMessageDialog(null,"The ID must be within five characters.","Error!",JOptionPane.INFORMATION_MESSAGE);
                                }
                                else if(!k1.matches("[a-zA-Z\\d]*")){
                                    JOptionPane.showMessageDialog(null,"The ID of an item cannot have any numbers or special characters.","Error!",JOptionPane.INFORMATION_MESSAGE,null);
                                }

                            } while(id.contains(k1) || k1.length()>5 || !k1.matches("[a-zA-Z\\d]*"));
                            if(k1==null) {
                                cancel = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this action?", "Cancel", JOptionPane.YES_NO_OPTION);
                                if (cancel == 0) {
                                    break;
                                }
                            }
                            else {
                                k1 = k1.replaceAll("\\s+", " ");
                            }
                        }while(k1==null);
                        if(cancel==0){
                            continue;
                        }
                        id.set(bruh,k1);
                        JOptionPane.showMessageDialog(null,"ID of "  + modifyName[bruh] + ": " + modifyID[bruh] + " changed to " + k1 + " successfully!" ,"ID Replaced",JOptionPane.INFORMATION_MESSAGE);
                    }

                    //Modify item quantity
                    else if(ok==2){
                        int cancel=-5,f=-1;
                        String k1="";
                        boolean b;
                        do {
                            do {
                                b=true;
                                try {
                                    k1 = JOptionPane.showInputDialog(null, "What is the new quantity of your item?", "ID Change", JOptionPane.INFORMATION_MESSAGE);
                                    if(k1==null){
                                        break;
                                    }
                                    f=Integer.parseInt(k1);
                                    if(f<0){
                                        JOptionPane.showMessageDialog(null,"The quantity must be greater than 0.","Error!",JOptionPane.INFORMATION_MESSAGE,null);
                                    }
                                }catch(Exception e){
                                    b=false;
                                    JOptionPane.showMessageDialog(null,"You must type in real numbers","Error!",JOptionPane.INFORMATION_MESSAGE,null);
                                }
                            }while(!b || f<0);

                            if (k1 == null) {
                                cancel = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this action?", "Cancel", JOptionPane.YES_NO_OPTION);
                                if (cancel == 0) {
                                    break;
                                }
                            }
                        }while(k1==null);

                        if(cancel==0){
                            continue;
                        }

                        quantity.set(bruh,f);
                        JOptionPane.showMessageDialog(null,"Quantity of "  + modifyName[bruh] + ": " + modifyQuantity[bruh] + " changed to " + k1 + " successfully!" ,"ID Replaced",JOptionPane.INFORMATION_MESSAGE);
                    }
                    continue;
                }
            }
            JOptionPane.showMessageDialog(null, "Item: " + i[items] +"\n" +"ID: " + l[items] +"\n"+"Quantity: " + km[items] +"\n","Item Information",JOptionPane.INFORMATION_MESSAGE);
        } while(true);
    }



}