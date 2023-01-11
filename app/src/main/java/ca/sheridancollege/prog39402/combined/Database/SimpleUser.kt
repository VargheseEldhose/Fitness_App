package ca.sheridancollege.prog39402.combined.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "simple")
data class SimpleUser (@PrimaryKey(autoGenerate = true)
                       var id:Long,
                       @ColumnInfo(name = "Name")
                       var name :String,
                       )
