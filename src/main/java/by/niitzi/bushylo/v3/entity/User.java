package by.niitzi.bushylo.v3.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
public class User {
    private int id;
    private String username;
    private String password;
    private Status status;
    private Role role;

    public User() {
    }

    public User(String username, String password, Status status, Role role) {
        this.username = username;
        this.password = password;
        this.status = status;
        this.role = role;
    }

    public User(int id, String username, String password, Status status, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
        this.role = role;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", status=" + status +
                ", role=" + role +
                '}';
    }
}
