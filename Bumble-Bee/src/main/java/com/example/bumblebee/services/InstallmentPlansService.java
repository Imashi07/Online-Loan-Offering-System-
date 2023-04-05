package com.example.bumblebee.services;

import com.example.bumblebee.DAO.InstallmentPlansDAO;
import com.example.bumblebee.DTO.responseDTO.InstallmentPlansDTO;
import com.example.bumblebee.entity.InstallmentPlans;
import com.example.bumblebee.mappers.InstallmentPlanMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstallmentPlansService {
    private InstallmentPlansDAO installmentPlansDAO;
    private InstallmentPlanMapper installmentPlanMapper;

    public InstallmentPlansService(InstallmentPlansDAO installmentPlansDAO) {
        this.installmentPlansDAO = installmentPlansDAO;
    }

    public InstallmentPlansDTO createPlan(InstallmentPlans installmentPlan){
        return installmentPlanMapper.entityToDTO(installmentPlansDAO.createInstallmentPlan(installmentPlan));
    }

    public List<InstallmentPlansDTO> getAllPlans(){
        return installmentPlansDAO.getAllInstallmentPlans().stream().map(installmentPlanMapper::entityToDTO).toList();
    }
}
