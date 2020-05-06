package br.sc.senai.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
@NamedQueries({
        @NamedQuery(name = "Company.listAll", query = "SELECT c FROM Company c"),
        @NamedQuery(name = "Company.listAllOrderByName", query = "SELECT c FROM Company c ORDER BY c.name")
})
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private List<User> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
