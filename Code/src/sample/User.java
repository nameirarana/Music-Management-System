package sample;

import java.util.Date;

public class User extends CreditCard{
    String name;
    Date DOB;
    String user_Name;
    String email;
    String password;
    CreditCard C_ID;
    String gender;
    int user_ID;

    public User(){
        gender="";
        name = "";
        user_Name = "";
        email = "";
        DOB = new Date(0,0,0);
        C_ID = new CreditCard();
        password = "";
        user_ID = -1;

    }

    public User(String n, Date dob, String Gender, String uname, String e, String pass, CreditCard cid){
        gender = Gender;
        name = n;
        DOB = dob;
        user_Name = uname;
        email = e;
        password = pass;
        C_ID = cid;
    }

    public User(String n, Date dob, String Gender, String uname, String e, String pass, CreditCard cid, int uid){
        gender = Gender;
        name = n;
        DOB = dob;
        user_Name = uname;
        email = e;
        password = pass;
        C_ID = cid;
        user_ID = uid;
    }

}
