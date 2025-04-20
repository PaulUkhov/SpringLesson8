package org.example.soringlesson8homework.model.task2;

public enum ItemStatus {

    AVAILABLE,       // Товар доступен для покупки или резервирования
    RESERVED,        // Товар зарезервирован, но ещё не куплен
    SOLD,            // Товар продан
    OUT_OF_STOCK,    // Нет в наличии
    DAMAGED,         // Поврежден или не подлежит продаже
    RETURNED,        // Возвращён
    IN_TRANSIT       // В пути (например, между складами)
}

