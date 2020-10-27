import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.jsoup.Jsoup;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Optional;

/**
 * Набор утилит для загрузки и сохранения html-страницы
 *
 * @author Alexander Eliseev
 */
@Slf4j
public class Utils {

    /**
     * Загрузить html-страницу
     *
     * @param url URL страницы
     * @return html-страница
     */
    public static Optional<String> downloadHtml(String url) {

        try {
            return Optional.of(Jsoup.connect(url).get().html());
        } catch (IllegalArgumentException | IOException exception) {
            if (ExceptionUtils.getRootCause(exception) instanceof MalformedURLException) {
                log.error("Отсутствует название протокола в имени файла");
            } else if (ExceptionUtils.getRootCause(exception) instanceof UnknownHostException) {
                log.error("Страница " + url + " не найдена");
            } else {
                log.error("Что-то пошло не так", exception);
            }
        }
        return Optional.empty();
    }

    /**
     * Сохранить html-страницу на диск
     *
     * @param html html-страница
     * @param filename имя файла
     * @return булевское значение результата записи файла на диск
     */
    public static boolean saveToFile(String html, String filename) {

        try (PrintWriter out = new PrintWriter(filename)) {
            out.println(html);
            return true;
        } catch (FileNotFoundException exception) {
            log.error("Что-то пошло не так", exception);
        }
        return false;
    }

    /**
     * Получить имя файла
     *
     * @param url URL страницы
     * @return имя файла
     */
    public static String getFilename(String url) {
        try {
            return new URL(url).getHost() + ".html";
        } catch (MalformedURLException exception) {
            log.error("Отсутствует название протокола в имени файла");
        }
        return "empty.html";
    }
}
