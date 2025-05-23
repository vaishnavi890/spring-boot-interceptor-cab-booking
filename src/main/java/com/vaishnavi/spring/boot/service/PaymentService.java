package com.vaishnavi.spring.boot.service;

import com.vaishnavi.spring.boot.model.Payment;
import com.vaishnavi.spring.boot.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    @Autowired
    private PaymentRepository repo;

    public List<Payment> retrievePayments() {
        logger.info("/inside the PaymentService.retrievePayments()");
        return repo.retrieve();
    }

    public boolean storePayment(Payment payment) {
        logger.info("/inside the PaymentService.storePayment()");
        return repo.store(payment);
    }

    public boolean deletePayment(int id) {
        logger.info("/inside the PaymentService.deletePayment()");
        return repo.delete(id);
    }

    public Payment searchPayment(int id) {
        logger.info("/inside the PaymentService.searchPayment()");
        return repo.search(id);
    }

    public Object search(int id) {
        return null;
    }
}

