package com.tapi.mathcalculator.database;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.tapi.mathcalculator.model.Word;

import java.util.List;

public interface QueryDb {
    @Insert
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * from word_table ORDER BY 'word' ASC")
    List<Word> getAllWords();
}
