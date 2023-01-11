package sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DietDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(dietjournal: DietEntity)
    @Query("SELECT * FROM DietJournal WHERE UserName= :name")
    fun getName(name: String?):List<DietEntity>
}