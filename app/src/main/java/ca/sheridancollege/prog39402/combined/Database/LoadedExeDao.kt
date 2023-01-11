package sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LoadedExeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(workout: LoadedExeEntity)
    @Query("SELECT * FROM PreLoadedExercise WHERE Name= :name")
    fun getName(name: String?):List<LoadedExeEntity>
    @Query("SELECT * FROM PreLoadedExercise")
    fun getAll():List<LoadedExeEntity>
}