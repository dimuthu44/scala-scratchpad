package vendingmachine;

import vendingmachine.exception.NotEnoughFundsException;
import vendingmachine.exception.PaymentNotAuthorizedException;

import java.math.BigDecimal;

public class CreditCard implements PaymentMethod {
    @Override
    public BigDecimal calculate(BigDecimal totalAmount, BigDecimal customerPayment) throws NotEnoughFundsException, PaymentNotAuthorizedException {
        authorize();
        pay();
        return BigDecimal.ZERO; // no balance to return
    }

    private void authorize() throws PaymentNotAuthorizedException {
        // todo
    }

    private void pay() { //todo exceptions
        // todo
    }
}
