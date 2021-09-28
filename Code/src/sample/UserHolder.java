package sample;

class Users {
    String username = "";
    String password = "";
    Users(String a, String b)
    {
        username = a;
        password = b;
    }
    public String getusername(){

        return username;
    }

    public String getPassword(){

        return password;
    }
}

public final class UserHolder {

    private Users user;
    private final static UserHolder INSTANCE = new UserHolder();

    private UserHolder() {}

    public static UserHolder getInstance() {
        return INSTANCE;
    }

    public void setUser(Users u) {
        this.user = u;
    }

    public Users getUser() {
        return this.user;
    }
}
