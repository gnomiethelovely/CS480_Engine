/*
    Database for the workflow engine.
    Calls database and checks the state of the entry.

*/


public class Database {
    
    public void checkState() {
        //compare time from previous db list
        
        if (database:state==waiting for approval) {
            die;
        } else (database:state==approved) {
            // pass to where needed/Service
            Decision_WFEngine();
        }
    }
}
