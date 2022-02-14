package by.niitzi.bushylo.v3.entity;

import java.util.Objects;

public class Client extends User{
    private int id;

    private String firstName;
    private String lastName;
    private Parameters params;

    public Client() {
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Parameters getParams() {
        return params;
    }

    public void setParams(Parameters params) {
        this.params = params;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && Objects.equals(firstName, client.firstName) && Objects.equals(lastName, client.lastName) && Objects.equals(params, client.params);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, params);
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
