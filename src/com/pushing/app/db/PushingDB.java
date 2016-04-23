package com.pushing.app.db;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.pushing.app.model.Info;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PushingDB {
	/**
	* ���ݿ���
	*/
	public static final String DB_NAME = "cool_weather";
	/**
	* ���ݿ�汾
	*/
	public static final int VERSION = 1;
	private static PushingDB pushingDB;
	private SQLiteDatabase db;
	/**
	* �����췽��˽�л�
	*/
	private PushingDB(Context context) {
		PushingOpenHelper dbHelper = new PushingOpenHelper(context,DB_NAME, null, VERSION);
		db = dbHelper.getWritableDatabase();
	}
	/**
	* ��ȡPushingDB��ʵ����
	*/
	public synchronized static PushingDB getInstance(Context context) {
	if (pushingDB == null) {
	pushingDB = new PushingDB(context);
	}
	return pushingDB;
	}
	/**
	* ��Infoʵ���洢�����ݿ⡣
	*/
	public void saveInfo(Info info) {
	if (info != null) {
	ContentValues values = new ContentValues();
	values.put("title", info.getTitle());
	values.put("content", info.getContent());
	values.put("date", info.getDate().toString());
	db.insert("Info", null, values);
	}
	}
	/**
	* �����ݿ��ȡInfoȫ����Ϣ�� 
	*/
	public List<Info> loadInfo() throws ParseException {
	List<Info> list = new ArrayList<Info>();
	Cursor cursor = db.query("Info", null, null, null, null, null, null);
	if (cursor.moveToFirst()) {
	do {
	Info info = new Info();
	info.setid(cursor.getInt(cursor.getColumnIndex("id")));
	info.setTitle(cursor.getString(cursor.getColumnIndex("Title")));
	info.setContent(cursor.getString(cursor.getColumnIndex("content")));
	info.setDate(cursor.getString(cursor.getColumnIndex("date")));
	list.add(info);
	} while (cursor.moveToNext());
	}
	return list;
	}
	
	
}
