package sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ExerciseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(workoutjournal: ExerciseEntity)
    @Query("SELECT * FROM WorkoutJournal WHERE username= :name")
    fun getName(name: String?):List<ExerciseEntity>
}