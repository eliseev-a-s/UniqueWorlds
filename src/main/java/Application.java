import lombok.extern.slf4j.Slf4j;
import utils.Utils;

import java.util.Scanner;

/**
 * @author Alexander Eliseev
 */
@Slf4j
public class Application {

    public static void main(String[] args) {

        System.out.println("Введите имя HTML-страницы");

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        if (Utils.downloadHtml(s).isPresent()) {

            String html = Utils.downloadHtml(s).get();
            log.info("HTML-страница " + s + " загружена");

            if (Utils.saveToFile(html, Utils.getFilename(s))) {
                log.info("HTML-страница " + s + " сохранена на диск");
            }

            HtmlParser.parseHtml(html);
        }
    }
}
