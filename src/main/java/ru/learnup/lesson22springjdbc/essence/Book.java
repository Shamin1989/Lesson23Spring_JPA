package ru.learnup.lesson22springjdbc.essence;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    private long id;
    private String title;
    private long authorId;
    private int price;

    @Override
    public String toString() {
        return "[Книга №" + id +
                ", название: " + title +
                ", автор: " + authorId +
                ", цена: " + price +
                ']';
    }
}
