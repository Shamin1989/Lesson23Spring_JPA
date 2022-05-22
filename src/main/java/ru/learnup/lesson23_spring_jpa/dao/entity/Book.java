package ru.learnup.lesson23_spring_jpa.dao.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Getter
@Setter
@RequiredArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private int year;

    @ManyToOne
    @JoinColumn
    private Author author;

    @Column
    private int countPage;

    @Column
    private int price;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", author=" + author +
                ", countPage=" + countPage +
                ", price=" + price +
                '}';
    }
}
