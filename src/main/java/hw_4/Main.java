package hw_4;

import hw_4.entities.Client;
import hw_4.exceptions.WrongFieldException;
import hw_4.exceptions.WrongSumException;
import hw_4.services.TransactionService;
import hw_4.utils.TransactionValidator;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        String destinationAccount;

        System.out.println("Preparing transaction...");

        Scanner scanner = new Scanner(System.in);
        String sourceAccount = requestClientAccount ("Enter source account:", scanner);
        client.setAccount(sourceAccount);

        destinationAccount = requestClientAccount ("Enter destination account:", scanner);

        BigDecimal sumToTransfer = requestSumToTransfer("Enter the sum to be transferred:", scanner);
        client.setSum(sumToTransfer);

        TransactionService.transfer(client, destinationAccount);
        System.out.println("Transaction OK");
    }

    private static String requestClientAccount (String prompt, Scanner scanner) {
        String account;
        boolean ok = false;

        do {
            System.out.println(prompt);
            account = scanner.nextLine();

            try{
                TransactionValidator.validateAccount(account);
                ok = true;
            }
            catch(WrongFieldException e) {
                System.out.println(e.getMessage());
            }
        } while (!ok);

        return account;
    }

    private static BigDecimal requestSumToTransfer (String prompt, Scanner scanner) {
        BigDecimal sum = null;
        boolean ok = false;

        do {
            System.out.println(prompt);
            String line = scanner.nextLine();

            try {
                sum = new BigDecimal(line);
                TransactionValidator.validateValue(sum);
                ok = true;
            } catch (NoSuchElementException | IllegalStateException | NumberFormatException | WrongSumException e) {
                System.out.println(e.getMessage());
            }
        } while (!ok);

        return sum;
    }
}
