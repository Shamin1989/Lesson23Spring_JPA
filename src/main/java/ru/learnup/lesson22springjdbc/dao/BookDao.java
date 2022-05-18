package ru.learnup.lesson22springjdbc.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.learnup.lesson22springjdbc.essence.Book;

import java.util.List;


@Repository
public class BookDao {

    private static final String SHOW_ALL = "select * from learn_up.book ";

    private static final String FIND_BY_ID = "select * from learn_up.book where id = :id";

    private NamedParameterJdbcTemplate template;

    public BookDao(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public List<Book> showBooks() {
        return template.query(SHOW_ALL,
                new MapSqlParameterSource(),
                (rs, rn) -> Book.builder()
                        .id(rs.getInt("id"))
                        .title(rs.getString("title"))
                        .authorId(rs.getInt("author_id"))
                        .price(rs.getInt("price"))
                        .build()
        );
    }

    public Book findByIdBook(int id) {
        return template.query(
                        FIND_BY_ID,
                        new MapSqlParameterSource("id", id),
                        (rs, rn) -> Book.builder()
                                .id(rs.getInt("id"))
                                .title(rs.getString("title"))
                                .authorId(rs.getInt("author_id"))
                                .price(rs.getInt("price"))
                                .build()
                ).stream()
                .findAny()
                .orElseThrow(() -> new RuntimeException("Books with id = " + id + " is not found"));
    }
}
