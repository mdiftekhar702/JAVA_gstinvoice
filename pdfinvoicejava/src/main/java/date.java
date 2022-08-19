import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class date {
    static void mydate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("          dd/MM/yy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }
}
