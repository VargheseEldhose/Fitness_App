package sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LoadedDietDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(diet: LoadedDietEntity)
    @Query("SELECT * FROM PreLoadedDiet")
    fun getAll():List<LoadedDietEntity>
    @Query("SELECT * FROM PreloadedDiet WHERE Name= :name")
    fun getName(name:String):List<LoadedDietEntity>
}