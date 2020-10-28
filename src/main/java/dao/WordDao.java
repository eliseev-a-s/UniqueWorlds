package dao;

import entity.Word;

import java.util.List;

/**
 * DAO для сущности "СЛОВО"
 *
 * @author Alexander Eliseev
 */
public interface WordDao {

    /**
     * Сохранить слово в БД
     *
     * @param word слово
     * @return boolean
     */
    boolean saveWord(Word word);

    /**
     * Получить все слова из БД
     *
     * @return коллекция слов
     */
    List<Word> getAllWords();

}