package PatronComportamiento.Strategy;

public class BiometricAuthStrategy implements AuthStrategy {
    private String biometricData;

    public BiometricAuthStrategy(String biometricData){
        this.biometricData = biometricData;
    }

    @Override
    public boolean authenticate(String data) {
        return this.biometricData.equals(data);
    }
}
