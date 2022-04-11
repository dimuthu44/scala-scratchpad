package vendingmachine;

import java.math.BigDecimal;

/**
 * Strategy pattern to calculate payments.
 */
public interface PaymentMethod {
    public BigDecimal calculate(BigDecimal totalAmount, BigDecimal customerPayment) throws Exception;
}
