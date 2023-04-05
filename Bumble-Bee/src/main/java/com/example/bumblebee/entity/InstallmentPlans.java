package com.example.bumblebee.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class InstallmentPlans {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private String id;
    private String planName;
    @OneToMany(targetEntity = Users.class, mappedBy = "installmentPlan", fetch = FetchType.LAZY)
    private List<Users> users;

    public InstallmentPlans() {
    }

    public InstallmentPlans(String planName, List<Users> users) {
        this.planName = planName;
        this.users = users;
    }

    public InstallmentPlans(String planName) {
        this.planName = planName;
    }

    public String getId() {
        return id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
