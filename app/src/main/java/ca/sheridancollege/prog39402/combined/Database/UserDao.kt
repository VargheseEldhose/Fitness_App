package sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: UserEntity)
     @Query("SELECT * FROM user WHERE userName= :name")
     fun getAll(name:String):List<UserEntity>

}