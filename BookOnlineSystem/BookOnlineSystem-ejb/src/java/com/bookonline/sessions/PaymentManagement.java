package com.bookonline.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import com.bookonline.entities.Payment;

@Stateless
public class PaymentManagement {

    @PersistenceContext
    private EntityManager entityManager;

    public void createPayment(Payment payment) {
        entityManager.persist(payment);
    }

    public void confirmPayment(Long paymentId) {
        Payment payment = entityManager.find(Payment.class, paymentId);
        if (payment != null) {
            payment.setStatus("Confirmed");
            entityManager.merge(payment);
        }
    }

    public void cancelPayment(Long paymentId) {
        Payment payment = entityManager.find(Payment.class, paymentId);
        if (payment != null) {
            payment.setStatus("Cancelled");
            entityManager.merge(payment);
        }
    }

    public List<Payment> getPaymentHistory() {
        return entityManager.createQuery("SELECT p FROM Payment p", Payment.class).getResultList();
    }
    
    public Payment findPaymentById(Long paymentId) {
        return entityManager.find(Payment.class, paymentId);
    }
}

