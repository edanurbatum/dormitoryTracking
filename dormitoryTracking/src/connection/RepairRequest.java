
package connection;

public class RepairRequest {
    private int repairId;
    private String name; 
    private String lastName;
    private String roomNumber;
    private String bedNumber;
    private String problemDefinition;
    private String result;

    public RepairRequest(int repairId, String name, String lastName, String roomNumber, String bedNumber, String problemDefinition, String result) {
        this.repairId = repairId;
        this.name = name;
        this.lastName = lastName;
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
        this.problemDefinition = problemDefinition;
        this.result = result;
    }

    public int getRepairId() {
        return repairId;
    }

    public void setRepairId(int repairId) {
        this.repairId = repairId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

    public String getProblemDefinition() {
        return problemDefinition;
    }

    public void setProblemDefinition(String problemDefinition) {
        this.problemDefinition = problemDefinition;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    

}
