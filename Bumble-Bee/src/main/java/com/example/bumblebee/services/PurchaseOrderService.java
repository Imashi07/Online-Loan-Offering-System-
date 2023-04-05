package com.example.bumblebee.services;

import com.example.bumblebee.DAO.PurchaseOrderDAO;
import com.example.bumblebee.DAO.UsersDAO;
import com.example.bumblebee.DTO.requestDTO.CreatePurchaseOrderDTO;
import com.example.bumblebee.DTO.responseDTO.PurchaseLoanOrdersDTO;
import com.example.bumblebee.entity.PurchaseLoanOrders;
import com.example.bumblebee.entity.Users;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderService {
    private final PurchaseOrderDAO purchaseOrderDAO;
    private final UsersDAO usersDAO;

    public PurchaseOrderService(PurchaseOrderDAO purchaseOrderDAO, UsersDAO usersDAO) {
        this.purchaseOrderDAO = purchaseOrderDAO;
        this.usersDAO = usersDAO;
    }

    public PurchaseLoanOrdersDTO createPurchaseOrder(CreatePurchaseOrderDTO createPurchaseOrderDTO){
        PurchaseLoanOrders order = new PurchaseLoanOrders(
                createPurchaseOrderDTO.loanAmount(),
                createPurchaseOrderDTO.createdDate(),
                createPurchaseOrderDTO.user(),
                createPurchaseOrderDTO.product()
        );

        Users user = usersDAO.getUserByID(createPurchaseOrderDTO.user().getId());
        user.setLoanBalance(user.getLoanBalance()+ createPurchaseOrderDTO.loanAmount());
        usersDAO.createUser(user);
        PurchaseLoanOrders newOder = purchaseOrderDAO.create(order);
        return new PurchaseLoanOrdersDTO(
                newOder.getId(),
                newOder.getLoanAmount(),
                newOder.getCreatedDate()
        );
    }
}
