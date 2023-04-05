package com.example.bumblebee.DAO;

import com.example.bumblebee.entity.InstallmentPlans;
import com.example.bumblebee.repositories.InstallmentPlanRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InstallmentPlansDAO {
    private InstallmentPlanRepo repo;

    public InstallmentPlansDAO(InstallmentPlanRepo repo) {
        this.repo = repo;
    }

    public InstallmentPlans createInstallmentPlan(InstallmentPlans installmentPlan){
        return repo.save(installmentPlan);
    }

    public List<InstallmentPlans> getAllInstallmentPlans(){
        return repo.findAll();
    }

    public InstallmentPlans getInstallmentPlanByID(Long id){
        return repo.findById(id).get();
    }
}
