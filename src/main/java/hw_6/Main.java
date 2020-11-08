package hw_6;

import hw_6.exceptions.StringFormatException;
import hw_6.utils.StringTransformHelper;
import hw_6.utils.StringValidityHelper;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.printf("%n%nUsing string functions:%n%n");

        try {
            System.out.println(StringTransformHelper.transform("latte", new char[]{'c', 'o', 'f', 'f', 'e', 'e'}));
            System.out.println(StringTransformHelper.transform("espresso", new char[]{'c', 'o', 'f', 'f', 'e', 'e'}));
            System.out.println(StringTransformHelper.transform("cappuccino", null));
        } catch (StringFormatException | NullPointerException e) {
            System.out.println(e.getMessage());
        }

        System.out.printf("%n%nUsing regular expressions:%n%n");
        System.out.printf("Is the phone number %s Ukrainian: %b%n", "+380933222233", StringValidityHelper.isUAPhoneNumberValid("+380933222233"));
        System.out.printf("Is the email %s syntactically correct: %b%n", "vasya@vas.net", StringValidityHelper.isEmailValid("vasya@vas.net"));

        boolean isDateCorrect;
        String correctDateString = String.format("%1$td.%1$tm.%1$tY", LocalDate.now());
        String incorrectDateString = String.format("%1$tm.%1$td.%1$tY", LocalDate.now());

        try {
            isDateCorrect = StringValidityHelper.isBirthdayValid(correctDateString);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            isDateCorrect = false;
            e.printStackTrace();
        }

        System.out.printf("Is the date %s correct: %b%n", correctDateString, isDateCorrect);

        try {
            isDateCorrect = StringValidityHelper.isBirthdayValid(incorrectDateString);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            isDateCorrect = false;
            e.printStackTrace();
        }

        System.out.printf("Is the date %s correct: %b%n", incorrectDateString, isDateCorrect);
    }
}
