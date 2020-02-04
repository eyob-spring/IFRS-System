package com.example.Exam.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class person {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private String Fname;
    private String Lname;
    private int access_level;
    private String password;

    @OneToOne
    private report last_update;

    @ManyToMany ()
    @JoinTable (name = "person_report" , joinColumns = @JoinColumn(name = "person_id") ,
            inverseJoinColumns = @JoinColumn(name = "report_id"))
    private Set<report> reports_involved = new HashSet<>();

    public Set<report> getReports_involved() {
        return reports_involved;
    }

    public void setReports_involved(Set<report> reports_involved) {
        this.reports_involved = reports_involved;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public int getAccess_level() {
        return access_level;
    }

    public void setAccess_level(int access_level) {
        this.access_level = access_level;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        person person = (person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "person{" +
                "id=" + id +
                ", Fname='" + Fname + '\'' +
                ", Lname='" + Lname + '\'' +
                ", access_level=" + access_level +
                ", password='" + password + '\'' +
                ", last_update=" + last_update +
                ", reports_involved=" + reports_involved +
                '}';
    }
}
