import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class VolunteerForm {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Volunteer> volunteers = loadForm();

        System.out.println("Volunteer Signup Form");

        Volunteer volunteer = startForm();

        volunteers.add(volunteer);

        saveVolunteers(volunteers);

    }

    private static Volunteer startForm() {
        while (true) {
            System.out.print("First Name: ");
            String firstName = in.nextLine();
            System.out.print("Lats Name: ");
            String lastName = in.nextLine();
            System.out.print("Phone Number: ");
            String phoneNumber = in.nextLine();
            System.out.print("Email Address: ");
            String emailAddress = in.nextLine();
            System.out.print("Are you interested in volunteering on the Worship Team [Y]es or [N]o: ");
            String worship = in.nextLine();
            System.out.print("Are you interested in volunteering on the Welcome Team [Y]es or [N]o: ");
            String welcome = in.nextLine();
            System.out.print("Are you interested in volunteering on the Production Team [Y]es or [N]o: ");
            String production = in.nextLine();
            System.out.print("Are you interested in leading in a Community Group [Y]es or [N]o: ");
            String community = in.nextLine();
            System.out.print("Are you interested in teaching in Children's Ministry [Y]es or [N]o: ");
            String childMinistry = in.nextLine();
            System.out.print("Are you interested in teaching in Student Ministry [Y]es or [N]o: ");
            String studentMinistry = in.nextLine();
            System.out.print("Are you interested in hearing more information about volunteer opportunities [Y]es or [N]o: ");
            String moreInfo = in.nextLine();
            System.out.print("[Q]uit: ");
            String quite = in.nextLine();
            if (quite.equalsIgnoreCase("Q")) {
                System.out.println("Thanks!");
                System.out.println("We'll get back to you as soon as possible.");
                return null;
            } else {
                return new Volunteer(firstName, lastName, emailAddress, phoneNumber, worship, welcome, production, community, childMinistry, studentMinistry, moreInfo);
            }
        }

    public static ArrayList<Volunteer> loadForm() {
        try {
            FileInputStream fileStream = new FileInputStream("volunteers.ser");
            ObjectInputStream os = new ObjectInputStream(fileStream);
            ArrayList<Volunteer> volunteers = (ArrayList<Volunteer>) os.readObject();
            os.close();
            return volunteers;
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<Volunteer>();
        }
    }

    private static void saveVolunteers(ArrayList<Volunteer> volunteers) {
        try {
            FileOutputStream fileStream = new FileOutputStream("volunteers.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(volunteers);
            os.close();
        } catch (IOException ex) {
            System.out.println("Failed to save volunteers.");
        }
    }

}