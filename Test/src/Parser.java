import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    static String read_csv(String file_address) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file_address));
        try {

            StringBuilder sb = new StringBuilder();
            String first_line = br.readLine();
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

    List<Address> stringToAddresses(String addressList) {
        List<Address> ret = new ArrayList<Address>();
        String noBracket = addressList.replace("[", "").replace("]", "");
        System.out.println(noBracket);
        for (String desc: noBracket.split(",")){
            String[] parts = desc.split("|");
            int id = Integer.parseInt(parts[0]);
            String state = parts[1];
            String city = parts[2];
            String street = parts[3];
            int houseNumber = Integer.parseInt(parts[4]);
            int zipCode = Integer.parseInt(parts[5]);
            String refRegion = parts[6];

            ret.add(new Address(id, state, city, street, houseNumber, zipCode, refRegion));
        }


        return ret;
    }

    List<Person> csvToPersons(String csv) {
        List<Person> ret = new ArrayList<>();
        for(String description: csv.split("\n")) {
            String[] parts = description.split(";");
            System.out.println(description);
            Person cur = new Person(parts[0], parts[1], stringToAddresses(parts[2]), Integer.parseInt(parts[3]));
            ret.add(cur);
        }
        return ret;
    }
}