package cs480.engine;

public class Database {
    
    public Database() {
    }
    
    public void checkTimeStamp(/*JSON string*/) {
        //compare time from previous db list
        
        if (Main.timeStamp < database:timeStamp) {
            //get json string and put through decision method
            Decision_WFEngine();
        } else if (database:state==waiting for approval) {
            die;
        } else if (database:state==approved) {
            // pass to where needed
            Decision_WFEngine();
        } else { //already complete
            break;
        }
    }
}
