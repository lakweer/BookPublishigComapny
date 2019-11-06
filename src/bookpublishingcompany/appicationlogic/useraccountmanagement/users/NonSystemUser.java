package bookpublishingcompany.appicationlogic.useraccountmanagement.users;

public class NonSystemUser extends User{
    private int tagId;

    public NonSystemUser(String id,int tagId, String firstName, String lastName, String address, float salary, int mobileNo, UserType type) {
        super(id, firstName, lastName, address, salary, mobileNo, type);
        this.tagId= tagId;
    }

    public NonSystemUser(String firstName, String lastName, String address, float salary, int mobileNo, UserType type) {
        super(firstName, lastName, address, salary, mobileNo, type);
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }
}
