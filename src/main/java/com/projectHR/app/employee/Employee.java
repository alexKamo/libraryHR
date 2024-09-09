package com.projectHR.app.employee;

import com.projectHR.app.department.Department;
import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int id;

    @Column(name = "emp_fullname")
    private String fullName;

    @Column(name = "start_date")
    private int startDate;

    @Column(name = "end_date")
    private int endDate;

    @Column(name = "salary")
    private int salary;

    @Column(name = "department_name")
    private Department depName;

    @Column(name = "department_id")
    private Department depId;

    public Employee() {
    }

    public Employee(String fullName, int id, int startDate, int endDate, int salary, Department depName, Department depId) {
        this.fullName = fullName;
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.salary = salary;
        this.depName = depName;
        this.depId = depId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Department getDepName() {
        return depName;
    }

    public void setDepName(Department depName) {
        this.depName = depName;
    }

    public Department getDepId() {
        return depId;
    }

    public void setDepId(Department depId) {
        this.depId = depId;
    }
}
