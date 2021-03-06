import java.io.Serializable;

public class User implements Serializable {
    private String fn; // First name
    private String ln; //Last name
    private String username;
    private String password;
    private String phoneNum; // For later use dynamically adding () & - between numbers
    private String email;
    private String bMonth;
    private int bDay;
    private int bYear;

    public User(String fn, String ln, String username, String password, String phoneNum,
                String email, String bMonth, int bDay, int bYear) {
        this.fn = fn;
        this.ln = ln;
        this.username = username;
        this.password = password;
        this.phoneNum = phoneNum;
        this.email = email;
        this.bMonth = bMonth;
        this.bDay = bDay;
        this.bYear = bYear;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getbMonth() {
        return bMonth;
    }

    public void setbMonth(String bMonth) {
        this.bMonth = bMonth;
    }

    public int getbDay() {
        return bDay;
    }

    public void setbDay(int bDay) {
        this.bDay = bDay;
    }

    public int getbYear() {
        return bYear;
    }

    public void setbYear(int bYear) {
        this.bYear = bYear;
    }

    public String toString() {
        return String.format("First Name: " + getFn() + "\nLast Name: " + getLn() + "\nUsername: " +
                getUsername() + "\nPassword: " + getPassword() + "\nEmail: " + getEmail() +
                "\nPhone Number: " + getPhoneNum() + "\nMonth: " + getbMonth() + "\nDay: " + getbDay()
                + "\nYear: " + getbYear());
    }
}