import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

class Solution2 {

    public String[] solution(String[] A, String[] B, String[] C) {
        HashMap<Integer, Person> persons = new HashMap<>();

        String string = "January 2, 2010";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Create a person for each row in A
        for (String s : A) {
            String[] csv = s.split(",");
            int id = Integer.parseInt(csv[0]);
            Person person = new Person(
                    id,
                    csv[1],
                    csv[2],
                    LocalDate.parse(csv[3], formatter),
                    new ArrayList<>(),
                    new HashSet<>()
            );
            persons.put(id, person);
        }

        // Create an address for each row and add it to the corresponding person
        for (String s : B) {
            String[] csv = s.split(",");
            Address address = new Address(
                    csv[2],
                    csv[3],
                    csv[4]
            );

            int personId = Integer.parseInt(csv[1]);
            persons.get(personId).addresses.add(address);
        }

        // Find the two persons of each friendship and add them vise versa to their friends list
        for (String s : C) {
            String[] csv = s.split(",");
            int personId1 = Integer.parseInt(csv[0]);
            int personId2 = Integer.parseInt(csv[1]);
            persons.get(personId1).friends.add(personId2);
            persons.get(personId2).friends.add(personId1);
        }

        // Filter persons list by persons who live in Berlin and then sort by age (youngest first -> reversed sort)
        List<Person> filteredPersons = persons.values()
                .stream()
                .filter(p -> p.addresses.stream().anyMatch(a -> a.city.equals("Berlin")))
                .sorted((p1, p2) -> p2.birthday.compareTo(p1.birthday))
                .collect(Collectors.toList());


        String[] output = new String[filteredPersons.size()];
        for (int i = 0; i < filteredPersons.size(); i++) {

            Person person = filteredPersons.get(i);

            // Sort friends
            List<Integer> friends = new ArrayList<>(person.friends);
            Collections.sort(friends);
            String friendsCsv = "";
            for (Integer id : friends) {
                friendsCsv += id + ";";
            }
            if (!person.friends.isEmpty()) {
                friendsCsv = friendsCsv.substring(0, friendsCsv.length() - 1);
            }

            // Format persons data as csv
            output[i] = person.id + ","
                    + person.fistname + ","
                    + person.lastname + ","
                    + formatter.format(person.birthday) + ","
                    + friendsCsv;
        }

        return output;

    }

    class Person {
        public int id;
        public String fistname;
        public String lastname;
        public LocalDate birthday;
        public List<Address> addresses;
        public Set<Integer> friends;

        public Person(int id, String fistname, String lastname, LocalDate birthday, List<Address> addresses, Set<Integer> friends) {
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
        public String street;
        public String zip;
        public String city;

        public Address(String street, String zip, String city) {
            this.street = street;
            this.zip = zip;
            this.city = city;
        }
    }
}