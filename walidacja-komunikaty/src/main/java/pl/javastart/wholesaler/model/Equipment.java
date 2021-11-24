package pl.javastart.wholesaler.model;

import pl.javastart.wholesaler.constraint.SerialNo;

public class Equipment {
    private String name;
    private String userId;
    @SerialNo(startsWith = "EQ", codeLength = 4)
    private String serialNumber;

    public Equipment(String name, String userId, String serialNumber) {
        this.name = name;
        this.userId = userId;
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
