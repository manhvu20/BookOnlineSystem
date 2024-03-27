package com.bookonline.managedbean;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import com.bookonline.entities.Orders;
import com.bookonline.sessions.OrdersManagement;

@Named
@ViewScoped
public class OrderManagementBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private OrdersManagement ordersManagement;

    private List<Orders> ordersList;

    public List<Orders> getOrdersList() {
        if (ordersList == null) {
            refreshOrdersList();
        }
        return ordersList;
    }

    public void refreshOrdersList() {
        ordersList = ordersManagement.getAllOrders();
    }
}

