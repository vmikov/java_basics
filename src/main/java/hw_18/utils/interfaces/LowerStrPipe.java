package hw_18.utils.interfaces;

import java.util.Optional;

public interface LowerStrPipe {
    default String get(String str) {
        return str == null ? null : str.toLowerCase();
    }

    static Optional<String> getLowerOptional(String str) {
        return str == null ? Optional.empty() : Optional.of(str.toLowerCase());
    }

    String getLowerString();

    boolean getLowerBoolean();
}
