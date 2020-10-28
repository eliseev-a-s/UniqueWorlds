package utils;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс для подключения к БД
 *
 * @author Alexander Eliseev
 */
@Slf4j
public class DBHelper {

    /**
     * Получить connection к БД
     *
     * @return connection
     */
    public static Connection getConnection() {

        Connection connection = null;

        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:mem:testdb");
        } catch (ClassNotFoundException | SQLException e) {
            log.error("Ошибка подключения к БД", e);
        }

        return connection;
    }
}
