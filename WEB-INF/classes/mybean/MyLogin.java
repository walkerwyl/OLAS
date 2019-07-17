
package mybean;

public class MyLogin {
    int id;
    String name,password,flag;
    boolean ss;

    public boolean isSs() {
        return ss;
    }

    public void setSs(boolean ss) {
        this.ss = ss;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
    
}
