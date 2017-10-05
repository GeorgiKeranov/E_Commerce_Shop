package app.entities;

import app.models.Message;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String address;

    private String email;

    private String firstName;

    private String lastName;

    private String phone;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
                joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public Message validateData() {

        if(username == null || username.equals(""))
            return new Message(true, "Username can\'t be blank!");

        if(password == null || password.equals(""))
            return new Message(true, "Password can\'t be blank!");

        if(address == null || address.equals(""))
            return new Message(true, "Address can\'t be blank!");

        if(email == null || email.equals(""))
            return new Message(true, "Email can\'t be blank!");

        if(firstName == null || firstName.equals(""))
           return new Message(true, "First name can\'t be blank!");

        if(lastName == null || lastName.equals(""))
            return new Message(true, "Last name can\'t be blank!");

        if(phone == null || phone.equals(""))
           return new Message(true, "Phone can\'t be blank!");

        return new Message(false);
    }

    // TODO add many addresses. UserRepository can choose the main address when it is buying.
    // TODO add birthday, question and answer to reset password if it's forgotten.
}
