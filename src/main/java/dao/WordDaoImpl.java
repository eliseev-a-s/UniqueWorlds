package dao;

import entity.Word;

import java.util.List;

/**
 * Реализация {@link WordDao}.
 *
 * @author Alexander Eliseev
 */
public class WordDaoImpl implements WordDao {

    @Override
    public boolean saveWord(Word word) {
        return false;
    }

    @Override
    public List<Word> getAllWords() {
        return null;
    }
}
