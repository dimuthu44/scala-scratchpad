package vendingmachine;

import vendingmachine.exception.NotEnoughFundsException;

import java.math.BigDecimal;

public class Cash implements PaymentMethod {

    @Override
    public BigDecimal calculate(BigDecimal totalAmount, BigDecimal customerPayment) throws NotEnoughFundsException {
        if (customerPayment.compareTo(totalAmount) < 0) {
            throw new NotEnoughFundsException();
        }
        return customerPayment.subtract(totalAmount);
    }
}
