package com.vaishnavi.spring.boot.repository;

import com.vaishnavi.spring.boot.model.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository implements EntityRepository<Payment> {
    private static final Logger logger = LoggerFactory.getLogger(PaymentRepository.class);
    private List<Payment> paymentList = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(Payment payment) {
        logger.info("Inside PaymentRepository.store()");
        payment.setId(++index);
        paymentList.add(index, payment);
        return true;
    }

    @Override
    public boolean delete(int id) {
        logger.info("Inside PaymentRepository.delete()");
        paymentList.remove(id);
        return true;
    }

    @Override
    public List<Payment> retrieve() {
        logger.info("Inside PaymentRepository.retrieve()");
        return paymentList;
    }

    @Override
    public Payment search(int id) {
        logger.info("Inside PaymentRepository.search()");
        return paymentList.get(id);
    }
}

