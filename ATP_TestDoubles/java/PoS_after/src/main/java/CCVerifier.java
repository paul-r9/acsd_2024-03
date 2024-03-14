import static java.lang.Thread.sleep;

public class CCVerifier implements ICCVerifier {
    private static final double AVAILABLE_CREDIT = 2000;
    private static final double SINGLE_CHARGE_LIMIT = 250;
    private static CCVerifier instance;

    private CCVerifier() {
    }

    public static CCVerifier getInstance() {
        if (null == instance) {
            instance = new CCVerifier();
        }
        return instance;
    }

    public boolean approveCharge(double amount) {
        thisCallIsCostly();
        return sufficientFunds(amount);
    }

    private boolean sufficientFunds(double amount) {
        return (amount <= AVAILABLE_CREDIT) && (amount <= SINGLE_CHARGE_LIMIT);
    }

    private void thisCallIsCostly() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // ignored for demo purpose
        }
    }
}