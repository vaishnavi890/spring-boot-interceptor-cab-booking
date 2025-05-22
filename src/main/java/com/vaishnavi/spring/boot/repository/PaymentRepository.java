package com.vaishnavi.spring.boot.repository;

import com.vaishnavi.spring.boot.model.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepository implements EntityRepository<Payment> {
    private static final Logger logger = LoggerFactory.getLogger(PaymentRepository.class);
    private List<Payment> payments = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(Payment payment) {
        logger.info("Inside PaymentRepository.store()");
        payment.setPaymentId(++index);
        payments.add(payment);
        return true;
    }

    @Override
    public List<Payment> retrieve() {
        logger.info("Inside PaymentRepository.retrieve()");
        return payments;
    }

    @Override
    public Payment search(int id) {
        logger.info("Inside PaymentRepository.search()");
        return payments.stream().filter(p -> p.getPaymentId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean delete(int id) {
        logger.info("Inside PaymentRepository.delete()");
        return payments.removeIf(p -> p.getPaymentId() == id);
    }
}

