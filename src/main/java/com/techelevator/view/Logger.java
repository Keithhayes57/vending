package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Logger {
    public  void log (String message){

        File logFile = new File("capstone-1/src/main/resources/log.txt");

        boolean fileExit= logFile.exists()? true:false;

        try(PrintWriter writer=new PrintWriter(new FileOutputStream(logFile,fileExit))){
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
            String formattedDate = dateFormat.format(new Date()).toString();
            writer.println(formattedDate +" "+message);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }

}
