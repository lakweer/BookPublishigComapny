package bookpublishingcompany.appicationlogic.useraccountmanagement.users;

public class User {
    private String firstName, lastName, id, address;
    private int mobileNo;
    private float salary;
    private UserType type;

    public User(String id,String firstName, String lastName, String address, float salary, int mobileNo, UserType type) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.salary = salary;
        this.mobileNo = mobileNo;
        this.type = type;
    }

    public User(String firstName, String lastName, String address, float salary, int mobileNo, UserType type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.salary = salary;
        this.mobileNo = mobileNo;
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() { return lastName; }

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

    public UserType getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object[] getAllDetails(){
        Object[] details = {id, firstName, lastName, address, mobileNo, salary, type};
        return details;
    }

    public enum UserType {
        PRINTING_UNIT_USER("PrintingUnitUser",2),
        STORE_KEEPING_UNIT_USER("StoreKeepingUnitUser",5),
        TYPE_SETTING_UNIT_USER("TypeSettingUnitUser",4),
        MAIN_UNIT_USER("MainUnitUser",1),
        FINANCE_UNIT_USER("FinanceUnitUser",3);

        private String string;
        private int unitId;

        UserType(String string, int id){
            this.string = string;
            this.unitId = id;
        }

        public String toString() {
            return string;
        }

        public int getUnitId() {
            return unitId;
        }

        public static UserType getType(String string){
            if(string.equals(PRINTING_UNIT_USER.toString())) return PRINTING_UNIT_USER;
            else if (string.equals(STORE_KEEPING_UNIT_USER.toString())) return STORE_KEEPING_UNIT_USER;
            else if (string.equals(TYPE_SETTING_UNIT_USER.toString())) return TYPE_SETTING_UNIT_USER;
            else if (string.equals(MAIN_UNIT_USER.toString())) return MAIN_UNIT_USER;
            else if (string.equals(FINANCE_UNIT_USER.toString())) return FINANCE_UNIT_USER;
            else return null;
        }
    }
}
