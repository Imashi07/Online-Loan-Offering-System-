package com.example.bumblebee.mappers;

import com.example.bumblebee.DTO.requestDTO.CreateInstallmentPlansDTO;
import com.example.bumblebee.DTO.responseDTO.InstallmentPlansDTO;
import com.example.bumblebee.entity.InstallmentPlans;

public class InstallmentPlanMapper {
    public InstallmentPlansDTO entityToDTO(InstallmentPlans installmentPlan){
        return new InstallmentPlansDTO(
                installmentPlan.getId(),
                installmentPlan.getPlanName()
        );
    }

    public InstallmentPlans dtoToEntityForCreate(CreateInstallmentPlansDTO createInstallmentPlansDTO){
        return new InstallmentPlans(
                createInstallmentPlansDTO.planName()
        );
    }
}
