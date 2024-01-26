import java.util.ArrayList;
import java.util.List;

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
