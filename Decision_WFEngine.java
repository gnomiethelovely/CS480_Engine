/*
 This class is to make the decisions given a variable then send 
 them to the appropriate destination.
 According to meeting 1:
 “Make decision”
 some number of decisions to direct where the form should “go”, or move to 
 the next state.
 */

public class Decision_WFEngine {

    private int input;
    private int[] outputs;

    /*
     What this method should do:
     This is the constructor for this class.  Initializing this class
     will need the input then should decide where it should go in the
     array of outputs.  
     */
    public Decision_WFEngine(int input, int[] outputs) {
        this.input = input;
        this.outputs = new int[outputs.length];
        System.arraycopy(outputs, 0, this.outputs, 0, this.outputs.length);
        
    }

    /*
     I'm not entirely sure if this is how it works, but this will 
     return the decision.
     */
    public int MakeDecision() {
        //makes decision then returns either...
        //index of the array outputs or the actual int
        return 0;
    }

}
