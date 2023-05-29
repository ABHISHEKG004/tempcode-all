package MCexamples.VenndingMachine.exceptions;

public class NoSufficientBalance extends Exception{

    public NoSufficientBalance(String msg){
        super(msg);
    }
}