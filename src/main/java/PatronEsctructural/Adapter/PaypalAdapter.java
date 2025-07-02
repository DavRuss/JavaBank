package PatronEsctructural.Adapter;

public class PaypalAdapter implements PaymentGateway {
    private PayPal payPal;

    public PaypalAdapter(PayPal payPal){
        this.payPal = payPal;
    }
    @Override
    public void pay(double amount) {
        payPal.sendPayment(amount);
    }
}
