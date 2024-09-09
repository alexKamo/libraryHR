package com.projectHR.app.department;

import jakarta.persistence.*;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    @Column(name = "dep_id")
    private int depId;

    @Column(name = "dep_name")
    private Department depName;

    @Column(name = "location")
    private String location;

    public Department() {
    }

    public Department(int depId, Department depName, String location) {
        this.depId = depId;
        this.depName = depName;
        this.location = location;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public Department getDepName() {
        return depName;
    }

    public void setDepName(Department depName) {
        this.depName = depName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
