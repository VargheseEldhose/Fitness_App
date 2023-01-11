package sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "PreLoadedExercise")
data class LoadedExeEntity ( @PrimaryKey(autoGenerate = true)
                             var id:Long,
                             @ColumnInfo(name = "Name")
                             var name :String,
                             @ColumnInfo(name="Image")
                             var image:Int,
                             @ColumnInfo(name="Minute")
                             var minute:Int,
                             @ColumnInfo(name="calorieBurnt")
                             var caloriesburnt:Int,
                             @ColumnInfo(name="Description")
                             var description:String,
                             @ColumnInfo(name="Distance")
                             var distance:Double
                             )


