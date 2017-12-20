package android.arch.leeyi.db.dao;

import android.arch.leeyi.db.Token;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

/**
 * Created by Leeyi on 2017/12/19.
 */

@Dao
public interface TokenDao {

    @Update
    void insert(Token o);

    @Query("select * from token limit 1")
    LiveData<Token> getToken();
}
