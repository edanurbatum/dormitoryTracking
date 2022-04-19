
package connection;

public class Opinion {
    private int id;
    private String tc;
    private String name; 
    private String lastName;
    private String roomNumber;
    private String bedNumber;
    private String text;

    public Opinion(int id, String tc, String name, String lastName, String roomNumber, String bedNumber, String text) {
        this.id = id;
        this.tc = tc;
        this.name = name;
        this.lastName = lastName;
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
