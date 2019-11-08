package bookpublishingcompany.appicationlogic.useraccountmanagement.users;

public class SystemUser extends User {
    private String email;

    public SystemUser(String firstName, String lastName, String address, float salary, int mobileNo, UserType type, String email) {
        super(firstName, lastName, address, salary, mobileNo, type);
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}
