package ru.learnup.lesson22springjdbc.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.learnup.lesson22springjdbc.essence.Order;

import java.util.List;

@Repository
public class OrderDetailsDao {

    private static final String SAVE =
            "insert into learn_up.order (book_id, count, amount) values (:book_id, :count, :amount)";

    private static final String SHOW_ALL =
            "select * from learn_up.order";

    private NamedParameterJdbcTemplate template;

    public OrderDetailsDao(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public void saveOrder(Order order) {
        template.update(
                SAVE,
                new MapSqlParameterSource()
                        .addValue("book_id", order.getBookId())
                        .addValue("count", order.getCount())
                        .addValue("amount", order.getAmount())
        );
    }

    public List<Order> showOrderDetails() {
        return template.query(SHOW_ALL,
                new MapSqlParameterSource(),
                (rs, rn) -> Order.builder()
                        .id(rs.getInt("id"))
                        .bookId(rs.getInt("book_id"))
                        .count(rs.getInt("count"))
                        .amount(rs.getInt("amount"))
                        .build()
        );
    }
}
