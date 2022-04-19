
package connection;

public class Student {
    
    private String tc;
    private String name;
    private String lastName;
    private String roomNumber;
    private String bedNumber;
    private String remainingPermitAmount;
    private String residenceAddress;
    private String dateOfBirth;
    private String dateOfRegistration;
    private String bloodType;
    private String email;
    private String phoneNumber;
    private String disease;

    public Student(String tc, String name, String lastName, String roomNumber, String bedNumber, String remainingPermitAmount, String residenceAddress, String dateOfBirth, String dateOfRegistration, String bloodType, String email, String phoneNumber, String disease) {
        this.tc = tc;
        this.name = name;
        this.lastName = lastName;
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
        this.remainingPermitAmount = remainingPermitAmount;
        this.residenceAddress = residenceAddress;
        this.dateOfBirth = dateOfBirth;
        this.dateOfRegistration = dateOfRegistration;
        this.bloodType = bloodType;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.disease = disease;
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

    public String getRemainingPermitAmount() {
        return remainingPermitAmount;
    }

    public void setRemainingPermitAmount(String remainingPermitAmount) {
        this.remainingPermitAmount = remainingPermitAmount;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(String dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    
}
