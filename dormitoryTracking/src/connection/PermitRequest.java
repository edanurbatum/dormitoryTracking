
package connection;

public class PermitRequest {
    private int id;
    private String tc;
    private String name;
    private String lastName;
    private int remainingPermitAmount;
    private String permitStart;
    private String permitFinish;
    private String permitAddress;
    private int usedPermitAmount;
    private String response;

    public PermitRequest(int id,String tc, String name, String lastName, int remainingPermitAmount, String permitStart, String permitFinish, String permitAddress, int usedPermitAmount, String response) {
        this.id=id;
        this.tc = tc;
        this.name = name;
        this.lastName = lastName;
        this.remainingPermitAmount = remainingPermitAmount;
        this.permitStart = permitStart;
        this.permitFinish = permitFinish;
        this.permitAddress = permitAddress;
        this.usedPermitAmount = usedPermitAmount;
        this.response = response;
    }
  
    public int getId() {
        return id;
    }

    public void setId(String tc) {
        this.id = id;
    }
    
    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
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

    public int getRemainingPermitAmount() {
        return remainingPermitAmount;
    }

    public void setRemainingPermitAmount(int remainingPermitAmount) {
        this.remainingPermitAmount = remainingPermitAmount;
    }

    public String getPermitStart() {
        return permitStart;
    }

    public void setPermitStart(String permitStart) {
        this.permitStart = permitStart;
    }

    public String getPermitFinish() {
        return permitFinish;
    }

    public void setPermitFinish(String permitFinish) {
        this.permitFinish = permitFinish;
    }

    public String getPermitAddress() {
        return permitAddress;
    }

    public void setPermitAddress(String permitAddress) {
        this.permitAddress = permitAddress;
    }

    public int getUsedPermitAmount() {
        return usedPermitAmount;
    }

    public void setUsedPermitAmount(int usedPermitAmount) {
        this.usedPermitAmount = usedPermitAmount;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}
