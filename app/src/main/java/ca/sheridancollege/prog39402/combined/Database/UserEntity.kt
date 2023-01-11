package sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "user")
data class UserEntity ( @PrimaryKey(autoGenerate = true)
                        var id:Long,
                        @ColumnInfo(name = "userName")
                        var username :String,
                        @ColumnInfo(name="age")
                        var age:Int,
                        @ColumnInfo(name="weight")
                        var weight:Double,
    @ColumnInfo (name="height")
    var height:Int,
  /*  @ColumnInfo(name="BMR")
    var BMR:Int,
    @ColumnInfo(name="DietTarget")
    var DietTarget:Int,
    @ColumnInfo(name="WorkoutTarget")
    var WokroutTarget:Int,*/
    @ColumnInfo(name="DailyCalorie")
    var Dailycalorie:Int,
          @ColumnInfo(name="WorkoutJournal")
var WorkoutJournal:String,

           @ColumnInfo(name="DietJournal")
           var DietJournal:String)

