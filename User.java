import java.io.Serializable;

public class User implements Serializable {

    String fn; // First name
    String ln; //Last name
    String username;
    String password;

    public User(String fn, String ln, String username, String password) {
        this.fn = fn;
        this.ln = ln;
        this.username = username;
        this.password = password;
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
}