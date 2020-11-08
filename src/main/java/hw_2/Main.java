package hw_2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("App started");
        Information info = InitializationData.createInformation();
        List<Byte> bytes = List.of((byte)1, (byte)5, (byte)20, (byte)56);

        appendFromWildcard(bytes, info);

        for(String key: info.getEmailAliases().keySet()) {
            System.out.println(key + ": " + info.getEmailAliases().get(key));
        }

        System.out.println("App finished");
    }

    private static void appendFromWildcard(Collection<? extends Number> numbers, Information info) {
        if(numbers != null && info != null && numbers.size() > 0) {
            Collection<String> aliases = info.getAliases();
            Collection<String> emails = info.getEmails();
            Map<String, String> emailAliases = info.getEmailAliases();
            Iterator<? extends Number> itr = numbers.iterator();
            String alias, email, domain = "@more.ua";


            while(itr.hasNext()) {
                alias = itr.next().toString();
                email = alias + domain;
                if(!emails.contains(email)) {
                    aliases.add(alias);
                    emails.add(email);
                    emailAliases.put(email, alias);
                }
            }
        }
    }
}