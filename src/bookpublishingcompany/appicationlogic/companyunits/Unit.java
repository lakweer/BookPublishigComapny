package bookpublishingcompany.appicationlogic.companyunits;

public class Unit {
    private int unitId;
    private String unitName;

    public Unit(int unitId, String unitName) {
        this.unitId = unitId;
        this.unitName = unitName;
    }

    public int getUnitId() {
        return unitId;
    }

    public String getUnitName() {
        return unitName;
    }

}
