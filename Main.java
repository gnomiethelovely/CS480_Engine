package cs480.engine;

import java.util.concurrent.*;
import java.sql.*;
import com.google.gson.Gson; // maye use to convert from JSON to java

public class Main {
    //store current timestamp to know when there are new entries in db
    protected static String timeStamp = "";
    
    // run till terminated every 30 seconds
    public static void main(String[] args) {
        
        ScheduledExecutorService executorService = 
                Executors.newSingleThreadScheduledExecutor(); 
        
        System.out.println("About to start querying database.");
        Runnable task = new Runnable() {    
            public void run() {
                try {
                    // TODO: Add url for sql site in the form of x://host/database
                    String url = "";
                    Connection conn = DriverManager.getConnection(url,"","");
                    Statement stmt = conn.createStatement();
                    ResultSet rs;
                    
                    // TODO: timeStamp = getCurrentTimeStamp
                    
                    // get JSON stuff or get directly from database
                    rs = stmt.executeQuery("SELECT something");
                    while ( rs.next() ) { // approval method
                        // get data and parse into new, waiting for approval, approved
                        // if data already parsed ignore
                        // else if (new) {
                            // go to approval step
                        // }
                        // else if (waiting for approval ignore)
                        // else if (approved)
                        // else (whatever else)
                    }
                    conn.close();
                } catch (Exception e) {
                    System.err.println("Got an exception! ");
                    System.err.println(e.getMessage());
                }
            }
        };
        executorService.scheduleWithFixedDelay(task, 0, 30, TimeUnit.SECONDS);
    }
}
