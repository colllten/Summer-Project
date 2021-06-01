import java.io.Serializable;

public class User implements Serializable {
    String fn; // First name
    String ln; //Last name
    String username;
    String password;
    String phoneNum; // For later use dynamically adding () & - between numbers
    String streetAdd; // Later use to have drop-box of possible addresses to autofill
    String email;
    String bMonth;
    String bDay;
    int bYear;

    public User(String fn, String ln, String username, String password, String phoneNum, String streetAdd,
                String email, String bMonth, String bDay, int bYear) {
        this.fn = fn;
        this.ln = ln;
        this.username = username;
        this.password = password;
        this.phoneNum = phoneNum;
        this.streetAdd = streetAdd;
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

    public String getStreetAdd() {
        return streetAdd;
    }

    public void setStreetAdd(String streetAdd) {
        this.streetAdd = streetAdd;
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

    public String getbDay() {
        return bDay;
    }

    public void setbDay(String bDay) {
        this.bDay = bDay;
    }

    public int getbYear() {
        return bYear;
    }

    public void setbYear(int bYear) {
        this.bYear = bYear;
    }
}