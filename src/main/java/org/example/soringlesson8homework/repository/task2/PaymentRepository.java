package org.example.soringlesson8homework.repository.task2;

import org.example.soringlesson8homework.model.task2.Payment;
import org.example.soringlesson8homework.model.task2.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByUser(User user);
}
