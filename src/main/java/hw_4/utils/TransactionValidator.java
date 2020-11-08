package hw_4.utils;

import hw_4.exceptions.UserExpectedError;
import hw_4.exceptions.WrongFieldException;
import hw_4.exceptions.WrongSumException;

import java.math.BigDecimal;

public class TransactionValidator {
    public final static BigDecimal MAX_TRANSACTION_VALUE = new BigDecimal(1000);

    public static void validateAccount(String account) throws WrongFieldException {
        if(account == null || account.isBlank() || account.length() != 10) {
            throw new WrongFieldException("Wrong account");
        }
    }

    public static void validateValue(BigDecimal sum) throws WrongSumException {
        if(sum == null) {
            throw new WrongSumException("Sum to be transferred is invalid");
        } else if (sum.compareTo(MAX_TRANSACTION_VALUE) > 0) {
            throw new WrongSumException(String.format("Sum to be transferred exceeds allowed maximum of %.2f", MAX_TRANSACTION_VALUE));
        }
    }

    public static void validateTransactionAccounts(String sourceAccount, String destinationAccount) throws UserExpectedError {
        if (!sourceAccount.equals(destinationAccount)) {
            throw new UserExpectedError("Accounts are not the same");
        }
    }
}
