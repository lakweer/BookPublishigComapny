package bookpublishingcompany.appicationlogic.customermanagement;

public class Author extends Customer {
    private String id, name, email = "";
    private int mobileNo;

    public Author(String id, String name, int mobileNo, String email) {
        this.id = id;
        this.name = name;
        this.mobileNo = mobileNo;
        this.email = email;
    }

    public Author(String name, int mobileNo, String email) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public String getEmail() {
        return email;
    }
}
