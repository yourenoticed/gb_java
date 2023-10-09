package homework;
import java.util.ArrayList;
import java.util.HashMap;

public class task1_hashmapPhonebook {    
    public static void main(String[] args) {
        Phonebook book = new Phonebook();

        System.out.println("Adding Eugene:");
        book.addContact("Eugene", "8932761323");
        printPhonebook(book);
        System.out.println();

        System.out.println("Adding Vlad:");
        book.addContact("Vlad", "8961145613");
        printPhonebook(book);
        System.out.println();

        System.out.println("Adding Vlad phone number:");
        book.addPhoneNumber("Vlad", "123993772");
        printPhonebook(book);
        System.out.println();

        System.out.println("Deleting Eugene:");
        book.deleteContact("Eugene");
        printPhonebook(book);
        System.out.println();

        System.out.println("Deleting Vlad phoneNumber:");
        book.deletePhoneNumber("Vlad", "8961145613");
        printPhonebook(book);
    }

    private static void printPhonebook(Phonebook book) {
        for (String personName : book.getPhonebook().keySet()) {
            StringBuilder contactInfoBuilder = new StringBuilder(personName);
            contactInfoBuilder.append(":");
            for (String number : book.getPhonebook().get(personName)) {
                contactInfoBuilder.append(" ").append(number);
            }
            System.out.println(contactInfoBuilder.toString());
        }
    }
}

class Phonebook {
    private HashMap<String, ArrayList<String>> phonebook = new HashMap<>();
    
    public void addContact(String name, String phoneNumber) {
        ArrayList<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(phoneNumber);
        this.phonebook.put(name, phoneNumbers);
    }
    
    public void deleteContact(String name) {
        try {
            this.phonebook.remove(name);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    public void addPhoneNumber(String name, String phoneNumber) {
        this.phonebook.get(name).add(phoneNumber);
    }

    public void deletePhoneNumber(String name, String phoneNumber) {
        try {
            this.phonebook.get(name).remove(phoneNumber);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    public HashMap<String, ArrayList<String>> getPhonebook() {
        return phonebook;
    }
}