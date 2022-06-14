package com.company.config;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConfigReadAndWirte<T> {
    public static String PATH = "C:\\Users\\Admin\\Downloads\\MD2-CaseStudy-master (2)\\MD2-CaseStudy-master\\src\\com\\company\\data\\";
    public List<T> readFromFile(String path){
        List<T> tList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            tList = (List<T>) objectInputStream.readObject();
            objectInputStream.close();
            objectInputStream.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return tList;
    }
    public void writeToFile(String path, List<T> tList){
        try {
//            System.out.println("goi ham write");
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(tList);
//            System.out.println("tList "+tList);
            fileOutputStream.close();
            objectOutputStream.close();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
