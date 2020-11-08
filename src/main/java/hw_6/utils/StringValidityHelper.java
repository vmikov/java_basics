package hw_6.utils;

import java.util.GregorianCalendar;
import java.util.regex.Pattern;

public class StringValidityHelper {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    private static final Pattern UA_PHONE_PATTERN = Pattern.compile("^\\+380\\d{9}$");
    private static final Pattern UA_DATE_PATTERN_NORMAL = Pattern.compile("^(((0|1)\\d\\.(0[1-9]|1[0-2]))|(2\\d\\.(0[1,3-9]|1[0-2]))|(2[1-8]\\.02)|(30\\.(0[13-9]|1[0-2]))|(31\\.((0[13578])|(1[0-2]))))\\.\\d{4}$");
    private static final Pattern UA_DATE_PATTERN_LEAP = Pattern.compile("^(((0|1)\\d\\.(0[1-9]|1[0-2]))|(2\\d\\.(0[1,3-9]|1[0-2]))|(2[1-9]\\.02)|(30\\.(0[13-9]|1[0-2]))|(31\\.((0[13578])|(1[0-2]))))\\.\\d{4}$");

    public static boolean isUAPhoneNumberValid(String phoneNumber) {
        return UA_PHONE_PATTERN.matcher(phoneNumber).matches();
    }

    public static boolean isEmailValid(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean isBirthdayValid(String birthday) throws ArrayIndexOutOfBoundsException, NumberFormatException {
            int year = Integer.valueOf(birthday.split("\\.", 3)[2]);
            GregorianCalendar c = (GregorianCalendar) (GregorianCalendar.getInstance());

            return c.isLeapYear(year)
                    ? UA_DATE_PATTERN_LEAP.matcher(birthday).matches()
                    : UA_DATE_PATTERN_NORMAL.matcher(birthday).matches();
    }
}
