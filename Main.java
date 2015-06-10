
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.parse4j.*;
import org.parse4j.callback.FindCallback;

public class Main {
    private static Date updatedAt = new Date(92, 1, 10);

    // run till terminated every 30 seconds
    public static void main(String[] args) {
        Database database = new Database();
        // Decision_WFEngine decision = new Decision_WFEngine();
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
                    // Connect to form
                    ParseQuery<ParseObject> query = 
                            ParseQuery.getQuery("WorkflowUser");
                    
                    // Condition to search for
                    //TODO: hopefully a key for if something is approved/completed
                    query.orderByAscending("UpdatedAt");
                    query.findInBackground(new FindCallback<ParseObject>() {
                        public void done(List<ParseObject> object, ParseException e) {
                            for (ParseObject a : object) {
                               if (updatedAt.compareTo(a.getUpdatedAt()) <= 0) {
                                   
                                   updatedAt = a.getUpdatedAt(); // keep track of time if no approval states
                                   
                                   // check state (0 for new, 1 for needs approval?) 
                                   // and if necessary calls webservice
                                   database.checkState(a);
                                   
                                   // TODO: make decision from here
                                   // decision();
                                   
                                   // checking to see it calling from parse.com
                                   System.out.println(a.getUpdatedAt());
                               } else {
                                   continue;
                               }
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

