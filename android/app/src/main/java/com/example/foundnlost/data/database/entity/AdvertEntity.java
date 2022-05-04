package com.example.foundnlost.data.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class AdvertEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "advert_id")
    public int advert_id;
    @ColumnInfo(name = "user_id")
    public String user_id;
    @ColumnInfo(name = "title")
    public String title;
    @ColumnInfo(name = "location")
    public String location;
    @ColumnInfo(name = "date")
    public String date;
    @ColumnInfo(name = "description")
    public String description;

}
