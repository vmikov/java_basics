package hw_2;

import java.util.Collection;
import java.util.Map;

public class Information {
    private final Collection<String> aliases;
    private final Collection<String> emails;
    private final Map<String, String> emailAliases;

    public Information(Collection<String> aliases, Collection<String> emails, Map<String, String> emailAliases) {
        this.aliases = aliases;
        this.emails = emails;
        this.emailAliases = emailAliases;
    }

    public Collection<String> getAliases() {
        return aliases;
    }

    public Collection<String> getEmails() {
        return emails;
    }

    public Map<String, String> getEmailAliases() {
        return emailAliases;
    }
}

