import java.util.HashSet;
import java.util.Set;

public class Contact {
    private Set<String> phoneNumbers;

    public Contact() {
        this.phoneNumbers = new HashSet<>();
    }

    public void addPhoneNumber(String phoneNumber) {
        this.phoneNumbers.add(phoneNumber);
    }

    public Set<String> getPhoneNumbers() {
        return this.phoneNumbers;
    }
}
