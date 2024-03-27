package com.bookonline.managedbean;

import javax.inject.Inject;
import com.bookonline.entities.Payment;
import com.bookonline.sessions.PaymentManagement;

public class PaymentManagementBean {

    @Inject
    private PaymentManagement paymentManagement;

    private Payment selectedPayment;

    public Payment getSelectedPayment() {
        return selectedPayment;
    }

    public void setSelectedPayment(Payment selectedPayment) {
        this.selectedPayment = selectedPayment;
    }

    public void loadPaymentDetails(Long paymentId) {
        selectedPayment = paymentManagement.findPaymentById(paymentId);
    }
}
