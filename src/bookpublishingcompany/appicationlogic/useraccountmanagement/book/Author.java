package bookpublishingcompany.appicationlogic.useraccountmanagement.book;

public class Author {
    private String id,name;
    private int mobileNo;

    public Author(String id, String name, int mobileNo) {
        this.id = id;
        this.name = name;
        this.mobileNo = mobileNo;
    }

    public Author(String name, int mobileNo) {
        this.name = name;
        this.mobileNo = mobileNo;
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
}
