package ru.learnup.lesson22springjdbc.essence;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Author {
    private long id;
    private String authorName;

    @Override
    public String toString() {
        return "[Автор № " + id +
                ", ФИО: " + authorName + ']';
    }
}
