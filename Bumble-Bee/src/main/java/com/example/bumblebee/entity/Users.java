package com.example.bumblebee.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Users {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String email;
    private String name;
    private String password;
    private String createdDate;
    private String dateOfBirth;
    private float LoanBalance;
    @ManyToOne(targetEntity = InstallmentPlans.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "installment_ID", referencedColumnName = "id")
    private InstallmentPlans installmentPlan;
    @OneToMany(targetEntity = PurchaseLoanOrders.class, mappedBy = "user", fetch = FetchType.EAGER)
    private List<PurchaseLoanOrders> loanOrders;

    public Users(String email, String name, String password, String createdDate, String dateOfBirth) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.createdDate = createdDate;
        this.dateOfBirth = dateOfBirth;
    }

    public Users(String email, String name, String password, String createdDate, String dateOfBirth, float loanBalance, InstallmentPlans installmentPlan, List<PurchaseLoanOrders> loanOrders) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.createdDate = createdDate;
        this.dateOfBirth = dateOfBirth;
        this.LoanBalance = loanBalance;
        this.installmentPlan = installmentPlan;
        this.loanOrders = loanOrders;
    }

    public Users() {
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public float getLoanBalance() {
        return LoanBalance;
    }

    public void setLoanBalance(float loanBalance) {
        LoanBalance = loanBalance;
    }

    public InstallmentPlans getInstallmentPlan() {
        return installmentPlan;
    }

    public void setInstallmentPlan(InstallmentPlans installmentPlan) {
        this.installmentPlan = installmentPlan;
    }

    public List<PurchaseLoanOrders> getLoanOrders() {
        return loanOrders;
    }

    public void setLoanOrders(List<PurchaseLoanOrders> loanOrders) {
        this.loanOrders = loanOrders;
    }
}
