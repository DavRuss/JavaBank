package PatronComportamiento.Strategy;

public class PinAuthstrategy implements AuthStrategy{
    private String pin;
    public PinAuthstrategy(String pin){
        this.pin = pin;
    }
    @Override
    public boolean authenticate(String data) {
        return this.pin.equals(data);
    }
}
