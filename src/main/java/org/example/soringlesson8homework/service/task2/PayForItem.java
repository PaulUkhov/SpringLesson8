package org.example.soringlesson8homework.service.task2;

import lombok.RequiredArgsConstructor;
import org.example.soringlesson8homework.aspect.task2.TrackTransactionsAspect;
import org.example.soringlesson8homework.exceptions.task2.InsufficientFundsException;
import org.example.soringlesson8homework.exceptions.task2.ItemNotFoundException;
import org.example.soringlesson8homework.model.task2.Item;
import org.example.soringlesson8homework.model.task2.ItemStatus;
import org.example.soringlesson8homework.model.task2.Payment;
import org.example.soringlesson8homework.model.task2.User;
import org.example.soringlesson8homework.repository.task2.ItemRepository;
import org.example.soringlesson8homework.repository.task2.PaymentRepository;
import org.example.soringlesson8homework.repository.task2.UserRepository;
import org.slf4j.event.Level;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class PayForItem {
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final PaymentRepository paymentRepository;
    private final ItemReserved itemReserved;

    @TrackTransactionsAspect(level = Level.DEBUG)
    @Transactional
    public void payForItem(Long userId, Integer itemId) {
        Item item = itemReserved.reservedItem(itemId);
        User user = userRepository.findById(userId).orElseThrow(() -> new ItemNotFoundException("User not found"));
        if (user.getBalance().compareTo(item.getPrice()) < 0) {// Если баланс пользователя меньше чем цена товара
            throw new InsufficientFundsException("Insufficient funds");
        }
        user.setBalance(user.getBalance().subtract(item.getPrice()));
        userRepository.save(user);
        item.setStatus(ItemStatus.SOLD);
        itemRepository.save(item);
        Payment payment = new Payment();
        payment.setUser(user);
        payment.setItem(item);
        payment.setAmount(item.getPrice());
        payment.setModifiedAt(LocalDateTime.now());
        paymentRepository.save(payment);
    }

}

