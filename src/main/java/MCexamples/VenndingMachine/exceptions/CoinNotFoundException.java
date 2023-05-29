package MCexamples.VenndingMachine.exceptions;

public class CoinNotFoundException extends Exception{

    public CoinNotFoundException(String msg){
        super(msg);
    }
}
