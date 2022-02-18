package by.niitzi.bushylo.v3.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode

public class Client extends User{
    private int id;

    private String firstName;
    private String lastName;
    private Parameters params;

    public Client(int id, String username, String password, Status status, Role role) {
        super(id, username, password, status, role);
    }

    public Client(){}

    public Client(String username, String password, Status status, Role role, String firstName, String lastName, Parameters params) {
        super(username, password, status, role);
        this.firstName = firstName;
        this.lastName = lastName;
        this.params = params;
    }

    public Client(int id, String username, String password, Status status, Role role, int id1, String firstName, String lastName, Parameters params) {
        super(id, username, password, status, role);
        this.id = id1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.params = params;
    }

    public Client(int id, String firstName, String lastName, Parameters params) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.params = params;
    }

    public int getUserId(){
        return super.getId();
    }

    public String getUserUsername(){
        return super.getUsername();
    }

    public String getUserPassword(){
        return super.getPassword();
    }

    public Status getUserStatus(){
        return super.getStatus();
    }

    public Role getUserRole(){
        return super.getRole();
    }




    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", params=" + params +
                '}';
    }
}
