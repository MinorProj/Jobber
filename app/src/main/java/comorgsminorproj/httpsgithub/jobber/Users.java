package comorgsminorproj.httpsgithub.jobber;

/**
 * Created by MK on 09-10-2017.
 */

public class Users {
    private String name;
    private String email;
    private String mobile;

    public Users(String name, String email, String mobile) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }
}
