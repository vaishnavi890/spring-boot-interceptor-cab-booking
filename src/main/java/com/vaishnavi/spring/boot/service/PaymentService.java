package com.vaishnavi.spring.boot.service;

import com.vaishnavi.spring.boot.model.Payment;
import com.vaishnavi.spring.boot.model.User;
import com.vaishnavi.spring.boot.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);
    private PaymentRepository repo = new PaymentRepository();

    public List<User> getAllPayments() {
        logger.info("Inside PaymentService.getAllPayments()");
        return repo.findAll();
    }

    public boolean processPayment(Payment payment) {
        logger.info("Inside PaymentService.processPayment()");
        return repo.save(payment);
    }

    public boolean deletePayment(int paymentId) {
        logger.info("Inside PaymentService.deletePayment()");
        return repo.delete(paymentId);
    }

    public User getPaymentById(int paymentId) {
        logger.info("Inside PaymentService.getPaymentById()");
        return repo.findById(paymentId);
    }

    public boolean updatePayment(Payment payment) {
        logger.info("Inside PaymentService.updatePayment()");
        return repo.update(payment);
    }

    public List<Payment> retrievePayments() {
        return List.of();
    }

    public boolean storePayment(Payment payment) {
        return false;
    }

    public Object search(int id) {
        return null;
    }
}


