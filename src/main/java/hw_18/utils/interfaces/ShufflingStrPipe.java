package hw_18.utils.interfaces;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public interface ShufflingStrPipe {
    default String get(String str) {
        return getShuffledOptional(str).orElse(null);
    }

    static Optional<String> getShuffledOptional(String str) {
        if (str == null) return Optional.empty();

        StringBuilder sb = new StringBuilder(str.length());
        ArrayList<Character> al = new ArrayList<>(str.length());
        Random rnd = new Random(System.currentTimeMillis());

        str.chars().forEach(ch -> al.add((char)ch));

        while(al.size() > 0) {
            sb.append(al.remove(rnd.nextInt(al.size())));
        }

        return Optional.of(sb.toString());
    }

    String getShuffledString();

    boolean getShuffledBoolean();
}
