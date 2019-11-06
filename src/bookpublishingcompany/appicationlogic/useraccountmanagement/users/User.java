package bookpublishingcompany.appicationlogic.useraccountmanagement.users;

public class User {
    private String firstName,lastName,id,address,email;
    private float salary;
    private int mobileNo;
    private UserType type;

    private Unit unit;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;

    }

    public String getId() {
        return id;
    }

    public float getSalary() {
        return salary;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public Unit getUnit() {
        return unit;
    }

    public UserType getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }

    public enum UserType {
        PRINTINGUNIT("PrintingUnitUser"),
        STOREKEEPINGUNIT("StoreKeepingUnitUser"),
        TYPESETTINGUNIT("TypeSettingUnitUser"),
        MAINUNITUSER("MainUnitUser"),
        FINANCEUNITUSER("FinanceUnitUser");

        private String string;
        UserType(String string){
            this.string = string;
        }

        public String toString() {
            return string;
        }
    }
}
