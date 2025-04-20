package org.example.soringlesson8homework.repository.task2;

import org.example.soringlesson8homework.model.task2.Item;
import org.example.soringlesson8homework.model.task2.ItemStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
//    Item findById(Long itemId);
    List<Item> findByName(String name);
    List<Item> findByStatus(ItemStatus status);
    //Количество товара на складе
    List<Item> findByAvailableQuantity(int availableQuantity);


}
