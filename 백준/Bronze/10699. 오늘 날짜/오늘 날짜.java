import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
        System.out.println(simpleDateFormat.format(today));
    }
}