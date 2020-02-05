import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Convert {
    public static void main(String[] args) {
        ArrayList<Volunteer> volunteers = new ArrayList<Volunteer>();
        volunteers.setId(1L);
        volunteers.setName("The Volunteers");

        ObjectMapper mapper = new ObjectMapper();

        File file = new File("volunteer.json");
        try {
            // Serialize Java object info JSON file.
            mapper.writeValue(file, volunteers);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // Deserialize JSON file into Java object.
            ArrayList<Volunteer> newVolunteer = mapper.readValue(file, Volunteer.class);
            System.out.println("newArtist.getId() = " + newVolunteer.getId());
            System.out.println("newArtist.getName() = " + newVolunteer.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}