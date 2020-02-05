import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Administrator {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Volunteer> volunteers = reloadForm();

        System.out.println("Volunteer Signup Form");

        reloadForm();

        viewVolunteers(volunteers);

        saveNominations(volunteers);

    }

    public static void viewVolunteers(ArrayList<Volunteer> volunteers) {
        while (true) {
            int i = 0;
            for (var volunteer : volunteers) {
                System.out.println(i + volunteer.firstName);
                i++;
            }
            System.out.print("Hello!");
            System.out.println(volunteers.stream().map(null).distinct().count() + " people are interested in volunteering.");
        }

    }

    private static void saveNominations(ArrayList<Volunteer> volunteers) {
        try {
            FileOutputStream fileStream = new FileOutputStream("volunteers.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(volunteers);
            os.close();
        } catch (IOException ex) {
            System.out.println("Failed to save nominations.");
        }
    }

    private static ArrayList<Volunteer> reloadForm() {
        try {
            FileInputStream fileStream = new FileInputStream("volunteers.ser");
            ObjectInputStream os = new ObjectInputStream(fileStream);
            ArrayList<Volunteer> volunteers = (ArrayList<Volunteer>) os.readObject();
            os.close();
            fileStream.close();
            return volunteers;
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<Volunteer>();
        }
    }
}