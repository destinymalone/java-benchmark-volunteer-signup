import java.io.Serializable;

public class Volunteer implements Serializable {
    private static final long serialVersionUID = 1L;
    String firstName;
    String lastName;
    String phoneNumber;
    String emailAddress;
    String worship;
    String production;
    String communityGroups;
    String childMinistry;
    String studentMinistry;
    String moreInformation;

    public Volunteer(String firstName, String lastName, String phoneNumber, String emailAddress, String worship,
            String welcome, String production, String communityGroups, String childMinistry, String studentMinistry,
            String moreInformation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.worship = worship;
        this.production = production;
        this.communityGroups = communityGroups;
        this.childMinistry = childMinistry;
        this.studentMinistry = studentMinistry;
        this.moreInformation = moreInformation;
    }
}
