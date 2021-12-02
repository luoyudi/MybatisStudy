package cn.luoyudi.pojo;

import org.apache.ibatis.type.Alias;

@Alias("user")
public class User {
    private Integer Id;
    private String name;
    private String password;

    public User() {
    }

    public User(Integer id, String name, String password) {
        Id = id;
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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
}
