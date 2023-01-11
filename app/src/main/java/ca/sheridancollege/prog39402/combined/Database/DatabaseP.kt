package sheridancollege.prog39402.Varghese991588959.Zawad991583646.Database

import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ca.sheridancollege.prog39402.combined.Database.SimpleDao
import ca.sheridancollege.prog39402.combined.Database.SimpleUser

@Database(entities=[ExerciseEntity::class, SimpleUser::class, DietEntity::class, UserEntity::class, LoadedExeEntity::class, LoadedDietEntity::class], version = 1)
abstract class DatabaseP:RoomDatabase(){


    abstract fun ExerciseDao(): ExerciseDao

    abstract fun DietDao(): DietDao
    abstract fun LoadedDietDao(): LoadedDietDao
    abstract fun LoadedExeDao(): LoadedExeDao
    abstract fun UserDao(): UserDao
    abstract  fun SimpleDao(): SimpleDao
    companion object{
        // @Volatile
        private  var INSTANCE: DatabaseP?=null
        fun getInstance(context: Context): DatabaseP
        {
            if(INSTANCE ==null)
                INSTANCE =Room.databaseBuilder(context, DatabaseP::class.java,"project.db").allowMainThreadQueries().build()
            return  INSTANCE as DatabaseP
        }
    }}