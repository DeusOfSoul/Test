import java.util.List;

class Person {

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
