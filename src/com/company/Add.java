package com.company;

import java.util.*;
import java.util.Arrays;
import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Add extends Main{
    public static void add_contact() throws IOException, FileNotFoundException{
        BufferedReader reader1 = new BufferedReader(new FileReader(DATA_PATH)); // we get reader for the file
        PrintWriter writer1 = new PrintWriter(String.valueOf(reader1));
        BufferedWriter writer = new BufferedWriter(writer1);//this is a way to get a writer for the specific file
        Scanner input= new Scanner(System.in);
        boolean duplicate, valid;
        String currentLine1;
        String f1 = "";//I initialize the variables to avoid errors
        String f2 = "";
        String f6 = "";
        String f8 = "";
        String f3 = "";
        String str;
        System.out.println("Give Name: ");
        f1 = input.nextLine();
        System.out.println("Give Surname: ");
        f2 = input.nextLine();
        do {//this is a do-while loop in which I check for valid input and i loop through the txt file again to check if input is duplicate
            duplicate = false;
            valid = true;
            System.out.println("Give Phone: ");
            //f3 = input.nextInt();
            try {
                f3 = input.nextLine().trim();
            } catch (NumberFormatException e) {
                valid = false;
                System.out.println("Phone must be number.");
                //e.printStackTrace();
            }
            while((currentLine1 = reader1.readLine()) != null) {//check for duplicate
                String[] words1=currentLine1.split(",");
                if(words1[2].equals(String.valueOf(f3))) {
                    duplicate=true;
                    System.out.println("Phone must be unique among the contacts.");
                }
            }
            reader1 = new BufferedReader(new FileReader(DATA_PATH));
        }while (duplicate == true || valid == false);
        System.out.println("Give Address: ");
        f6 = input.nextLine();
        do {
            valid = true;
            try {
//                f7 = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                //e.printStackTrace();
//                System.out.println("Street number must be a number.");
//                valid = false;
            }
        }while(valid == false);
        System.out.println("Give City: ");
        f8 = input.nextLine();
        do {
            valid = true;
            try {
//                f9 = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                //e.printStackTrace();
//                System.out.println("Zip code must be a number.");
//                valid = false;
            }
        }while(valid == false);
        if(f1 == "" || f2 == "" || f6 == "" || f8 == "" || f3 == "") {//i check that all variables have a valid attribute assigned
            System.out.println("You gave false inputs, adding new contact wasn't successful: ");
        }
        else {//if everything is correct i build a string
            str = f1 + "," + f2 + "," + f3 + "," + f6 + "," + f8;
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(DATA_PATH, true)));//with these code I add a line at the bottom of the file
            out.println(str);
            out.close();
        }
        //input.close();
        //writer1.close();
        writer.close();
        reader1.close();
    }

}
