package com.example.bumblebee.DAO;

import com.example.bumblebee.entity.PurchaseLoanOrders;
import com.example.bumblebee.repositories.PurchaseLoanOrderRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PurchaseOrderDAO {
    private final PurchaseLoanOrderRepo repo;

    public PurchaseOrderDAO(PurchaseLoanOrderRepo repo) {
        this.repo = repo;
    }

    public PurchaseLoanOrders create(PurchaseLoanOrders purchaseLoanOrder){
        return repo.save(purchaseLoanOrder);
    }

    public List<PurchaseLoanOrders> getAllPurchaseOrders(){
        return repo.findAll();
    }

    public PurchaseLoanOrders getPurchaseOrderByID(Long id){
        return repo.findById(id).get();
    }
}
