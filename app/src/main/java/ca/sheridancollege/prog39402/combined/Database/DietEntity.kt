package sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "DietJournal")
data class DietEntity ( @PrimaryKey(autoGenerate = true)
                        var id:Long,
                        @ColumnInfo(name = "Name")
                        var name :String,
                        @ColumnInfo(name = "UserName")
                        var username :String,

                        @ColumnInfo(name="caloriesConsumed")
                        var caloriesConsumed:Int,
                        @ColumnInfo(name="Type")
                        var type:String
)

