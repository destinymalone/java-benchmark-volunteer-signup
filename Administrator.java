import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Administrator {
    static Scanner in = new Scanner(System.in);

    public static void main(final String[] args) throws ClassNotFoundException {

        final ArrayList<Volunteer> volunteers = reloadForm();

        System.out.println("Volunteer Signup Form");

        readFile();

        viewVolunteers(volunteers);

        saveNominations(volunteers);

    }

    public static void viewVolunteers(final ArrayList<Volunteer> volunteers) throws ClassNotFoundException {
        while (true) {
            ArrayList<Volunteer> list = readFile();
            for (Volunteer firstName : list) {
                System.out.println("Hello!");
                System.out.println(firstName);
            }
            for (Volunteer lastName : list) {
                System.out.println(lastName + " people are interested in volunteering.");
            }
            // for (Volunteer worship : list) {
            // if (volunteers.worship == "Y") {
            // System.out.println(worfullName + " is interested in Worship");
            // } else if (volunteers.production == "Y") {
            // System.out.print(", Production");
            // } else if (volunteers.childMinistry == "Y") {
            // System.out.print(", Children Ministry");
            // } else if (volunteers.communityGroups == "Y") {
            // System.out.print(", Community Group");
            // } else if (volunteers.studentMinistry == "Y") {
            // System.out.print(", Student Ministry");
            // } else if (volunteers.moreInformation == "Y") {
            // System.out.print(", More Information");
            // } else {
            // System.out.print("No teams or groups were signed up for.");
            // }
            // }
            // }
            // System.out.print("Hello!");
            // System.out.println(
            // volunteers.stream().map(null).distinct().count() + " people are interested in
            // volunteering.");

            // for (final var volunteer : volunteers) {
            // if (volunteer.worship == "Y") {
            // System.out.println(volunteer.fullName + " is interested in Worship");
            // } else if (volunteer.production == "Y") {
            // System.out.print(", Production");
            // } else if (volunteer.childMinistry == "Y") {
            // System.out.print(", Children Ministry");
            // } else if (volunteer.communityGroups == "Y") {
            // System.out.print(", Community Group");
            // } else if (volunteer.studentMinistry == "Y") {
            // System.out.print(", Student Ministry");
            // } else if (volunteer.moreInformation == "Y") {
            // System.out.print(", More Information");
            // } else {
            // System.out.print("No teams or groups were signed up for.");
            // }
            // i++;
            // }
            System.out.println("Have a great day!");
            break;
        }

    }

    private static void saveNominations(final ArrayList<Volunteer> volunteers) {
        try {
            final FileOutputStream fileStream = new FileOutputStream("volunteers.ser");
            final ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(volunteers);
            os.close();
        } catch (final IOException ex) {
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

    private static ArrayList<Volunteer> readFile() throws ClassNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader("volunteers.ser"))) {
            br.lines().collect(Collectors.toList()).forEach(System.out::println);
        } catch (IOException ex) {
            return new ArrayList<Volunteer>();
        }
        return null;
    }
}