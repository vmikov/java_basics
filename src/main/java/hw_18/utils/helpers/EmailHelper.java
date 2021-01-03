package hw_18.utils.helpers;

import java.util.Optional;
import java.util.regex.Pattern;

public class EmailHelper {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");

    public static Optional<String> check(String email) {
        return email == null || email.isEmpty()
                ? Optional.empty()
                : EMAIL_PATTERN.matcher(email).matches() ? Optional.of(email) : Optional.empty();
    }
}
