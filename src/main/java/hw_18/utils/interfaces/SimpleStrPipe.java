package hw_18.utils.interfaces;

import java.util.Optional;

public interface SimpleStrPipe {
    default String get(String str) {
        return str;
    }

    static Optional<String> getSimpleOptional(String str) {
        return Optional.ofNullable(str);
    }

    String getSimpleString();

    boolean getSimpleBoolean();
}
