package ru.learnup.lesson22springjdbc.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import ru.learnup.lesson22springjdbc.dao.AuthorDao;
import ru.learnup.lesson22springjdbc.dao.BookDao;
import ru.learnup.lesson22springjdbc.dao.OrderDetailsDao;
import ru.learnup.lesson22springjdbc.essence.Author;
import ru.learnup.lesson22springjdbc.essence.Book;
import ru.learnup.lesson22springjdbc.essence.Order;

import java.util.List;
import java.util.Scanner;

@Component
public class Test {

    AuthorDao authorDao;
    BookDao bookDao;
    OrderDetailsDao orderDetailsDao;

    private Scanner scanner = new Scanner(System.in);

    private int way = 0;

    public void execute(ConfigurableApplicationContext context) {

        authorDao = context.getBean(AuthorDao.class);
        bookDao = context.getBean(BookDao.class);
        orderDetailsDao = context.getBean(OrderDetailsDao.class);


        List<Author> authors = authorDao.showAuthors();
        List<Book> books = bookDao.showBooks();

        while (way != 3) {

            System.out.println("*".repeat(100));
            System.out.println("Доступные действия:");
            System.out.println("0 - Показать все книги в продаже");
            System.out.println("1 - Совершить покупку");
            System.out.println("2 - Посмотреть уже оформленные покупки");
            System.out.println("3 - Выйти");
            System.out.print("Введите номер необходимого действия: ");

            way = scanner.nextInt();

            System.out.println("*".repeat(100));

            switch (way) {
                case 0:
                    System.out.println("ID авторов произведений:");
                    for (Author author: authors) {
                        System.out.println(author.toString());
                    }
                    System.out.println("Каталог книг в магазине:");
                    for (Book book: books) {
                        System.out.println(book.toString());
                    }
                    break;
                case 1:
                    consoleOrder();
                    break;
                case 2:
                    List<Order> orders = orderDetailsDao.showOrderDetails();
                    for (Order order: orders) {
                        System.out.println(order.toString());
                    }
                    break;
                case 3:
                    System.out.println("До встречи!");
                    break;
                default:
                    System.out.println("Вы не ввели число из списка!");
            }
        }
    }

    public void consoleOrder() {

        int count = 0;
        int id = 0;

        System.out.println("Введите номер желаемой книги");
        id = scanner.nextInt();


        System.out.println("Введите количество книг для покупки");
        count = scanner.nextInt();

        Book findBook = bookDao.findByIdBook(id);
        int price = findBook.getPrice();
        int amount = price * count;

        Order order = Order.builder()
                .bookId(id)
                .count(count)
                .amount(amount)
                .build();

        orderDetailsDao.saveOrder(order);
    }
}
