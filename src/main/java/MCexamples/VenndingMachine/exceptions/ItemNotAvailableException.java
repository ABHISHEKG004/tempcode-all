package MCexamples.VenndingMachine.exceptions;


public class ItemNotAvailableException extends Exception{

    public ItemNotAvailableException(String msg){
        super(msg);
    }
}
