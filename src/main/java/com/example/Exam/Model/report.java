package com.example.Exam.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int type;

    @OneToOne
    private person person_generated;
    @OneToOne
    private person person_last_modified;

    @ManyToMany (mappedBy = "reports_involved")
    private Set<person> people_invloved = new HashSet<>();

    public long getId() {
        return id;
    }

    public person getPerson_generated() {
        return person_generated;
    }

    public void setPerson_generated(person person_generated) {
        this.person_generated = person_generated;
    }

    public person getPerson_last_modified() {
        return person_last_modified;
    }

    public void setPerson_last_modified(person person_last_modified) {
        this.person_last_modified = person_last_modified;
    }

    public Set<person> getPeople_invloved() {
        return people_invloved;
    }

    public void setPeople_invloved(Set<person> people_invloved) {
        this.people_invloved = people_invloved;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        report report = (report) o;
        return id == report.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "report{" +
                "id=" + id +
                ", type=" + type +
                ", person_generated=" + person_generated +
                ", person_last_modified=" + person_last_modified +
                ", people_invloved=" + people_invloved +
                '}';
    }
}
