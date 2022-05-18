package ru.learnup.lesson22springjdbc.essence;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {

    private long id;
    private long bookId;
    private int count;
    private int amount;

    @Override
    public String toString() {
        return "[Заказ №" + id +
                ", Книга №" + bookId +
                ", количество: " + count +
                ", общая сумма: " + amount +
                ']';
    }
}
