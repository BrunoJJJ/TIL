package com.example.practice.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0, // autoGenerate 자동 생성
    @ColumnInfo("name") val name: String, // 변수명 같으면 ColumInfo()만 써도됨
    @ColumnInfo("phone") val phone: String? = null, // 기본 값도 넣어줌
    @ColumnInfo("email") val email: String? = null,
    @ColumnInfo("age") val age: Int? = null,  // 0으로 넣으면 0살이라는 중의 표현될 수 있으니 null
)
