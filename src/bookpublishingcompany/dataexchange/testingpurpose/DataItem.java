package bookpublishingcompany.dataexchange.testingpurpose;

public class DataItem {
    private String data;
    private String type;
    private String fileToSave;

    public DataItem(String data, String type, String fileToSave) {
        this.data = data;
        this.type = type;
        this.fileToSave = fileToSave;
    }

    public String getData() {
        return data;
    }

    public String getType() {
        return type;
    }

    public String getFileToSave() {
        return fileToSave;
    }
}
