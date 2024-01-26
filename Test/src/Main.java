import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    public static void main(String[] args) {


        List<Person> persons = new ArrayList<>();

        persons.



    }

    class Person {

        public String fistname;
        public String lastname;

        public List<Address> addressList;

        public Person(String fistname, String lastname, List<Address> addressList) {
            this.fistname = fistname;
            this.lastname = lastname;
            this.addressList = addressList;
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

    class Treatment{
        public String name;
        public int number;
        public double avgCharges;
        public double avgTotalPayments;
        public double avgMedicalPayments;


    }

    class Hospital{

        public int id;
        public String name;
        public int providerId;
        public double address;
        List<Treatment> treatments;

        public Hospital(int id, String name, int providerId, double address) {
            this.id = id;
            this.name = name;
            this.providerId = providerId;
            this.address = address;
            this.treatments = new ArrayList<>();
        }
    }
}