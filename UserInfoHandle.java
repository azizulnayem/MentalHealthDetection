/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class UserInfoHandle {
    private static File file= new File("/home/jadid/All/study/academic/spring 2022/os lab/after mid/src/src/userInfo.csv");
    private static File dataFile= new File("/home/jadid/All/study/academic/spring 2022/os lab/after mid/src/src/data.csv");
    private static String decodeRisk(String prediction){
        if(prediction.equals("2")){return "high risk";}
        if(prediction.equals("1")){return "moderate risk";}
        return "low risk";
    }
    public static String getHistory(){
        String id=User.id;
        FileReader fr;
        BufferedReader br;
        String line;
        String dataAll="";
        try{

            fr= new FileReader(dataFile) ;
            br= new BufferedReader(fr);
            while((line=br.readLine())!=null){
                String [] parts= line.split(",");
                if(parts[0].equals(id)){
                    dataAll+="date: "+parts[1]+" bodyTemp : "+parts[6]+" heart rate "+ parts[7]+" risk: "+decodeRisk(parts[8])+"\n\n";
                }


            }


        }
        catch(IOException e ){
            System.out.println("file not found ");
        }
        return dataAll;
    }
    public static void writeFile(String toappend){
        FileWriter fw;
        BufferedWriter bw;
        String [] parts= toappend.split(",");
         int lines =-1;
        try{
            lines=(int) Files.lines(Path.of("/home/jadid/All/study/academic/spring 2022/os lab/after mid/src/src/userInfo.csv")).count();
        fw= new FileWriter(file,true ) ;
        bw= new BufferedWriter(fw);
        bw.write(parts[0]+","+parts[1]+","+(lines+1)+","+parts[2]+"\n");
        User.id=""+(lines+1);
        User.age=""+parts[2];
        bw.close();
        }
        catch(IOException e){
            System.out.println("file not found");
        }
     }
     public static boolean matchUset(String email, String password) {
         FileReader fr;
         BufferedReader br;
         String line;

        try{

            fr= new FileReader(file) ;
            br= new BufferedReader(fr);
            while((line=br.readLine())!=null){
                String [] parts= line.split(",");
                if(email.equalsIgnoreCase(parts[0]) && password.equalsIgnoreCase(parts[1])) {
                    User.id=parts[2];
                    User.age=parts[3];
                    return true;
                }


            }


        }
        catch(IOException e ){
            System.out.println("file not found ");
        }
        return false;
     }
     public static boolean isUniqueUser(String email){
         FileReader fr;
         BufferedReader br;
         String line;

         try{

             fr= new FileReader(file) ;
             br= new BufferedReader(fr);
             while((line=br.readLine())!=null){
                 String [] parts= line.split(",");
                 if(email.equalsIgnoreCase(parts[0]) ) {
                     return false;
                 }


             }


         }
         catch(IOException e ){
             System.out.println("file not found ");
         }
         return true;
     }
    public static void main(String[] args) {
     System.out.println(UserInfoHandle.getHistory());

        // UserInfoHandle.writeFile("def@gmail.com,kopaSamsu");
    }
}
