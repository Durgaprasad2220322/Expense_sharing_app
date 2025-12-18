package src;

public class User {
    private String UId;
    private String Uname;

    public User(String UId, String Uname) {
        this.UId = UId;
        this.Uname = Uname;
    }

    public String getUId() {
        return UId;
    }

    public String getUname() {
        return Uname;
    }
}

