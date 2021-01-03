package hw_18.utils.interfaces;

import java.util.Optional;

public interface UpperStrPipe {
    default String get(String str) {
        return str == null ? null : str.toUpperCase();
    }

    static Optional<String> getUpperOptional(String str) {
        return str == null ? Optional.empty() : Optional.of(str.toUpperCase());
    }

    String getUpperString();

    boolean getUpperBoolean();
}
