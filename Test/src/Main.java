import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    public static void main(String[] args) {
        try {
            Parser parser = new Parser();
            System.out.println(parser.csvToPersons(parser.read_csv("data/persons.csv")));
        } catch (IOException e) {
            System.out.println(e);
        }
    }











}