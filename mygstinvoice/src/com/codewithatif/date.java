package com.codewithatif;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class date {
    static void mydate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("          dd/MM/yy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }
}

