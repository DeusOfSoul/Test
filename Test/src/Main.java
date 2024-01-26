import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    public static void main(String[] args) throws IOException {

        // Read patient CSV
        String csvInpatient = read_csv("C:\\Users\\mauri\\Desktop\\Test\\data\\inpatientCharges.csv");
        String csvPerson = read_csv("C:\\Users\\mauri\\Desktop\\Test\\data\\persons.csv");

        // convert patient
        List<Person> personList = new ArrayList<>();
        for(String description: csv.split("\n")) {
            String[] parts = description.split(";");

            // parse address
            String noBracket = addressList.replace("[", "").replace("]", "");
            String[] parts = noBracket.split("|");
            int id = Integer.parseInt(parts[0]);
            String state = parts[1];
            String city = parts[2];
            String street = parts[3];
            int houseNumber = Integer.parseInt(parts[4]);
            int zipCode = Integer.parseInt(parts[5]);
            String refRegion = parts[6];

            List address = List.of(new Address[]{new Address(id, state, city, street, houseNumber, zipCode, refRegion)});


            Person cur = new Person(parts[0], parts[1], address, Integer.parseInt(parts[3]));
            personList.add(cur);
        }


        // Sorting
//        personList.stream().sorted((p1, p2) -> );
//        .sorted((p1, p2) -> )
//        .sorted((p1, p2) -> )
//        .sorted((p1, p2) -> )

        System.out.println();

    }

    public class Person {

        public String firstname;
        public String lastname;

        public int hospitalId;

        public List<Address> addressList;

        public Person(String firstname, String lastname, List<Address> addressList, int hospitalId) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.addressList = addressList;
            this.hospitalId = hospitalId;
        }
    }

    public class Address {
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

    public class Treatment{
        public String name;
        public int number;
        public double avgCharges;
        public double avgTotalPayments;
        public double avgMedicalPayments;

        public Treatment(String name, int number, double avgCharges, double avgTotalPayments, double avgMedicalPayments) {
            this.name = name;
            this.number = number;
            this.avgCharges = avgCharges;
            this.avgTotalPayments = avgTotalPayments;
            this.avgMedicalPayments = avgMedicalPayments;
        }
    }

    public class Hospital{

        public int id;
        public String name;
        public int providerId;
        public Address address;
        List<Treatment> treatments;

        public Hospital(int id, String name, int providerId, Address address) {
            this.id = id;
            this.name = name;
            this.providerId = providerId;
            this.address = address;
            this.treatments = new ArrayList<>();
        }
    }



    static String read_csv(String file_address) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file_address));
        try {

            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everyline = sb.toString();
            return everyline;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            br.close();
        }
    }

    static List<Address> stringToAddresses(String addressList) {
        String noBracket = addressList.replace("[", "").replace("]", "");
        String[] parts = noBracket.split("|");
        int id = Integer.parseInt(parts[0]);
        String state = parts[1];
        String city = parts[2];
        String street = parts[3];
        int houseNumber = Integer.parseInt(parts[4]);
        int zipCode = Integer.parseInt(parts[5]);
        String refRegion = parts[6];

        return List.of(new Address[]{new Address(id, state, city, street, houseNumber, zipCode, refRegion)});
    }
//
//    static List<Person> csvToPersons(String csv) {
//        List<Person> ret = new ArrayList<>();
//        for(String description: csv.split("\n")) {
//            String[] parts = description.split(";");
//            Person cur = new Person(parts[0], parts[1], Main::stringToAddresses(parts[2]), Integer.parseInt(parts[3]));
//            ret.add(cur);
//        }
//        return ret;
//    }
}