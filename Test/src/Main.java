import java.time.LocalDate;
import java.util.List;
import java.util.Set;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.print("Hello and welcome!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }
    }

    class Person {
        public int id;
        public String fistname;
        public String lastname;
        public LocalDate birthday;
        public List<Solution2.Address> addresses;
        public Set<Integer> friends;

        public Person(int id, String fistname, String lastname, LocalDate birthday, List<Solution2.Address> addresses, Set<Integer> friends) {
            this.id = id;
            this.fistname = fistname;
            this.lastname = lastname;
            this.birthday = birthday;
            this.addresses = addresses;
            this.friends = friends;
        }
    }

    class Address {
        public int id;
        public String state;
        public String city;
        public String street;
        public int houseNumber;
        public int zipCode;
        public String refRegion;

        public Address(
                int id,
                String state,
                String city,
                String street,
                int houseNumber,
                int zipCode,
                String refRegion) {
            this.id = id;
            this.state = state;
            this.city = city;
            this.street = street;
            this.houseNumber = houseNumber;
            this.zipCode = zipCode;
            this.refRegion = refRegion;
        }
    }

    class
}