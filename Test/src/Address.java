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