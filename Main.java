

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.parse4j.*;
import org.parse4j.callback.FindCallback;

public class Main {
    
    // run till terminated every 30 seconds
    public static void main(String[] args) {
        ScheduledExecutorService executorService = 
                Executors.newSingleThreadScheduledExecutor(); 

        Runnable task = new Runnable() {    
            public void run() {
                try {
                    System.out.println("About to start querying database.");
                    String APP_ID = "ej29LXB9zHARKwcF5gHhkQ4SnJS7mGwWZ01qrZAa";
                    String API_ID = "qzclRmYPQZwd0guChjOdwFsSrIfvZXFCM42jXaIq";
                    
                    // Connect to parse.com database
                    Parse.initialize(APP_ID, API_ID);
                    
                    // Connect to Object
                    ParseQuery<ParseObject> query = ParseQuery.getQuery("WorkflowUser");
                    
                    // Condition to search for
                    //TODO: hopefully a key for if something is approved or nto
                    query.whereEqualTo("Name", "FirstName");
                    query.findInBackground(new FindCallback<ParseObject>() {
                        public void done(List<ParseObject> results, ParseException e) {
                            for (ParseObject a : results) {
                                // Test for printing a value
                                System.out.println(a.getString("email"));
                            }
                        }
                    });
                    System.out.println("");
                } catch (Exception e) {
                    System.err.println("Got an exception! ");
                    System.err.println(e.getMessage());
                }
            }
        };
        executorService.scheduleAtFixedRate(task, 0, 30, TimeUnit.SECONDS);
    }
}

