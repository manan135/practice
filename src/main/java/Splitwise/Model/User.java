package Splitwise.Model;

public class User {
    final String userid;
    String name;
    String email;
    String mobileNum;

    private static int curr = 1;
    public User(String name, String email, String mobileNum) {
        this.userid = Integer.toString(generateId());
        this.name = name;
        this.email = email;
        this.mobileNum = mobileNum;
    }

    private int generateId() {
        return curr++;
    }

    public String getUserid() {
        return userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }
}
