package ru.learnup.lesson22springjdbc.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.learnup.lesson22springjdbc.essence.Author;
import java.util.List;

@Repository
public class AuthorDao {

    private static final String SHOW_ALL = "select * from learn_up.author";

    private NamedParameterJdbcTemplate template;

    public AuthorDao(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public List<Author> showAuthors() {
        return template.query(SHOW_ALL,
                new MapSqlParameterSource(),
                (rs, rn) -> Author.builder()
                        .id(rs.getInt("id"))
                        .authorName(rs.getString("author_name"))
                        .build()
        );
    }
}
