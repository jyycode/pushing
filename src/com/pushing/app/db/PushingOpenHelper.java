package com.pushing.app.db;

import android.content.Context;
import android.database.*;
import android.database.sqlite.*;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.*;

public class PushingOpenHelper extends SQLiteOpenHelper {
	/**
	* Province�������
	*/
	public static final String CREATE_INFO = "create table Info ("
	+ "id integer primary key autoincrement, "
	+ "title text, "
	+ "content text,"
	+ "date date)";
	
	public PushingOpenHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_INFO); // �����������������Ϣ��Info��
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){}
	

}
