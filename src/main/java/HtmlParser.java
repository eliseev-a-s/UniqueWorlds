import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Парсер html-страницы
 *
 * @author Alexander Eliseev
 */
public class HtmlParser {

    /**
     * Получить с html-страницуы набор слов, подсчитать их количество и вывести на экран
     *
     * @param html html-страница
     */
    public static void parseHtml(String html) {

        List<String> words = Stream.of(html.split("[А-Яа-я]+"))
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        Map<String, Integer> wordsAndCount = words.stream()
                .collect(HashMap::new, (m, c) -> {
                    m.put(c, m.containsKey(c) ? (m.get(c) + 1) : 1);
                }, HashMap::putAll);

        wordsAndCount.forEach( (k, v) -> System.out.println(k + " - " + v));

    }
}
