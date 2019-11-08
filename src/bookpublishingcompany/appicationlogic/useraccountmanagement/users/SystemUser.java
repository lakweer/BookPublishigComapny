package bookpublishingcompany.appicationlogic.useraccountmanagement.users;

public class SystemUser extends User {
    private String email, systemUserType = "nonAdmin";
    public static final int ADMIN_USER_UNIT = 1;

    public SystemUser(String firstName, String lastName, String address, float salary, int mobileNo, UserType type, String email) {
        super(firstName, lastName, address, salary, mobileNo, type);
        this.email = email;
        if (!(type instanceof UserType)) systemUserType = "admin";
    }

    public SystemUser(String id, String firstName, String lastName, String address, float salary, int mobileNo, UserType type, String email) {
        super(id, firstName, lastName, address, salary, mobileNo, type);
        this.email = email;
        if (!(type instanceof UserType)) systemUserType = "admin";
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getSystemUserType() {
        return systemUserType;
    }
}
