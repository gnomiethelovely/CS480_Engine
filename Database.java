
import org.parse4j.ParseObject;

/*
    Database for the workflow engine.
    Calls database and checks the state of the entry.

*/


public class Database {
    WebService_WFEngine webService = new WebService_WFEngine();
    protected int value;
    
    public int checkState(ParseObject object) {
        
        if (object.getString("State") == "1") { // needs approval
            value = webService.get_Value(object);
            
        } else if (object.getString("State") == "0") { // new entry
            value = webService.get_Value(object);
        } else {
            // form is completed
        }
        
        return value;
    }
}
