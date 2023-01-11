package sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "WorkoutJournal")
data class ExerciseEntity (
    @PrimaryKey(autoGenerate = true)
    var id:Long,
    @ColumnInfo(name = "WorkoutName")
    var Wname :String,
    @ColumnInfo(name = "username")
    var username :String,
    @ColumnInfo(name="minutes")
    var minutes:Int,
    @ColumnInfo(name="calorieBurned")
    var calorie:Int

)
