package vendingmachine;

import java.math.BigDecimal;

public class PaymentManager {
    private PaymentMethod paymentMethod;

    public PaymentManager(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal calculatePaymentAndReturnBalance(BigDecimal totalAmount, BigDecimal customerPayment) throws Exception {
        return paymentMethod.calculate(totalAmount, customerPayment);
    }
}
