package hw_6.utils;

import hw_6.exceptions.StringFormatException;

public class StringTransformHelper {
    public static String transform(String inputString, char[] chars) throws StringFormatException {
        if (chars == null) {
            throw new NullPointerException("The array of chars was not provided");
        }

        String stringFromChars = String.valueOf(chars);

        if(inputString.isBlank() || stringFromChars.isBlank()) {
            throw new StringFormatException("Blank string was provided for formatting");
        }

        String uppercaseString = inputString.toUpperCase().trim();
        String lowercaseString = stringFromChars.toLowerCase().trim();
        String resultString = uppercaseString.concat(" ").concat(lowercaseString);
        int len = resultString.length();

        return len % 2 == 0
                ? resultString.substring(0, len / 2 - 1) + resultString.substring(len / 2 + 1)
                : resultString.substring(0, len / 2) + resultString.substring(len / 2 + 1);
    }
}
