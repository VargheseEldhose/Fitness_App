package ca.sheridancollege.prog39402.combined.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SimpleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(student: SimpleUser)
    @Query("SELECT * FROM simple")
    fun getAll():List<SimpleUser>

}