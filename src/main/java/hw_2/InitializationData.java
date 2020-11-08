package hw_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class InitializationData {
    private static final int RAND_LEN = 5;
    private static final int RAND_VAL_LEN = 30;
    private static final int SAME_VAL_LEN = 10;
    private static final String STD_DOMAIN = "@vas.net";
    private static final String OPT_DOMAIN = "@vy.est";
    private static final char[] charPool;

    static
    {
        int i = 0;
        charPool = new char[62];

        for(int j = 48; j < 58; ++j) {
            charPool[i++] = (char)j;
        }

        for(int j = 65; j < 91; ++j) {
            charPool[i++] = (char)j;
        }

        for(int j = 97; j < 123; ++j) {
            charPool[i++] = (char)j;
        }
    }

    public static Information createInformation() {
        ArrayList<String> aliases = new ArrayList<>(RAND_VAL_LEN + SAME_VAL_LEN);
        HashSet<String> emails = new HashSet<>(RAND_VAL_LEN + SAME_VAL_LEN);
        HashMap<String, String> emailAliases = new HashMap<>(RAND_VAL_LEN + SAME_VAL_LEN);

        appendRandomValues(aliases, emails, emailAliases);
        appendSameValues(aliases, emails, emailAliases);
        return new Information(aliases, emails, emailAliases);
    }

    private static String makeRandomString() {
        int threshold = charPool.length;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < RAND_LEN; ++i) {
            sb.append(charPool[(int)Math.floor(Math.random() * threshold)]);
        }

        return sb.toString();
    }

    private static void appendRandomValues(ArrayList<String> aliases, HashSet<String> emails, HashMap<String, String> map){
        String alias, email;

        for(int i = 0; i < RAND_VAL_LEN; ++i) {
            do {
                alias = makeRandomString();
            } while (aliases.contains(alias));

            do {
                email = makeRandomString() + STD_DOMAIN;
            } while (emails.contains(email));

            aliases.add(alias);
            emails.add(email);
            map.put(email, alias);
        }
    }

    private static void appendSameValues (ArrayList<String> aliases, HashSet<String> emails, HashMap<String, String> emailAliases) {
        String alias, email;

        for (int i = 0; i < SAME_VAL_LEN; ++i) {
            do {
                alias = makeRandomString();
                email = alias + OPT_DOMAIN;
            } while (emails.contains(email) || aliases.contains(alias));

            aliases.add(alias);
            emails.add(email);
            emailAliases.put(email, alias);
        }
    }
}
