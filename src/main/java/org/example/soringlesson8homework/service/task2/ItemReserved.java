package org.example.soringlesson8homework.service.task2;

import lombok.extern.slf4j.Slf4j;
import org.example.soringlesson8homework.aspect.task1.TrackUserAction;
import org.example.soringlesson8homework.exceptions.task2.InsufficientStockException;
import org.example.soringlesson8homework.exceptions.task2.ItemNotFoundException;
import org.example.soringlesson8homework.model.task2.Item;
import org.example.soringlesson8homework.model.task2.ItemStatus;
import org.example.soringlesson8homework.repository.task2.ItemRepository;
import org.slf4j.event.Level;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@TrackUserAction(level = Level.INFO)
public class ItemReserved {
    ItemRepository itemRepository;
@Transactional
    public Item reservedItem(Integer itemID) {
        Item item = itemRepository.findById(itemID)
                .orElseThrow(() -> new ItemNotFoundException("Item not found"));
        item.setStatus(ItemStatus.RESERVED);
        if (item.getAvailableQuantity() <= 0) {
            throw new InsufficientStockException("Available quantity is less than zero");
        }
        item.setAvailableQuantity(item.getAvailableQuantity() - 1);
        item.setStatus(ItemStatus.SOLD);
        itemRepository.save(item);
        log.info("Reserved Item {}", itemID);
        return item;
    }


}
