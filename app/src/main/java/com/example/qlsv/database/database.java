package com.example.qlsv.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.qlsv.model.Class;
import com.example.qlsv.model.Student;

import java.util.ArrayList;

public class database extends SQLiteOpenHelper {

    private Context context;

    private static final String DB_NAME = "qlsv";

    public static final String TABLE_STU = "tbl_student";

    private static final String STU_ID = "id";
    private static final String STU_NAME = "name";
    private static final String STU_BIR = "birthday";
    private static final String STU_HOME = "home";
    private static final String STU_YEAR = "year";

    public static final String TABLE_CLA = "tbl_class";

    private static final String CLA_ID = "id";
    private static final String CLA_NAME = "name";
    private static final String CLA_DELTAIL = "detail";

    public static final String TABLE_DK = "tbl_register";

    private static final String DK_STU_ID = "stu_id";
    private static final String DK_CLA_ID = "cla_id";
    private static final String DK_TERM = "term";
    private static final String DK_CREDIT = "credit";

    private String SQLQuery1 = "CREATE TABLE " + TABLE_STU + " ("
            + STU_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + STU_NAME + " TEXT,"
            + STU_BIR + " TEXT,"
            + STU_HOME + " TEXT,"
            + STU_YEAR + " TEXT)";

    private String SQLQuery2 = "CREATE TABLE " + TABLE_CLA + " ("
            + CLA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + CLA_NAME + " TEXT,"
            + CLA_DELTAIL + " TEXT)";

    private String SQLQuery3 = "CREATE TABLE " + TABLE_DK + " ("
            + DK_STU_ID + " INTEGER ,"
            + DK_CLA_ID + " INTEGER,"
            + DK_TERM + " INTEGER,"
            + DK_CREDIT + " INTEGER)";

    // Thêm sinh viên
    private String SQLQuery4 = "INSERT INTO tbl_student VAlUES (null,'Tran Huu Binh','1999','Nam Dinh', 'Nam 4')";
    private String SQLQuery5 = "INSERT INTO tbl_student VAlUES (null,'Nguyen Thi Ngoc Lan','1999','Hai Duong', 'Nam 4')";
    private String SQLQuery6 = "INSERT INTO tbl_student VAlUES (null,'Vu Duc Manh','1999','Thai Binh', 'Nam 4')";
    private String SQLQuery7 = "INSERT INTO tbl_student VAlUES (null,'Nguyen Kieu Trang','2002','Ninh Binh', 'Nam 1')";
    private String SQLQuery8 = "INSERT INTO tbl_student VAlUES (null,'Nguyen Van Nam','2001','Ha Nam', 'Nam 2')";

    // Thêm lớp
    private String SQLQuery9 = "INSERT INTO tbl_class VAlUES (null,'Android','Kip 1 thu 2')";
    private String SQLQuery10 = "INSERT INTO tbl_class VAlUES (null,'ReactJS','Kip 2 thu 4')";
    private String SQLQuery11 = "INSERT INTO tbl_class VAlUES (null,'NodeJS','Kip 5 thu 6')";

    public database(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLQuery1);
        db.execSQL(SQLQuery2);
        db.execSQL(SQLQuery3);
        db.execSQL(SQLQuery4);
        db.execSQL(SQLQuery5);
        db.execSQL(SQLQuery6);
        db.execSQL(SQLQuery7);
        db.execSQL(SQLQuery8);
        db.execSQL(SQLQuery9);
        db.execSQL(SQLQuery10);
        db.execSQL(SQLQuery11);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STU);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DK);
        onCreate(db);
    }

    // lấy tất cả sinh viên
    public ArrayList<Student> getAllStudent() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Student> studentArrayList = new ArrayList<>();
        String sqlcode = "SELECT * FROM " + TABLE_STU;
        Cursor cursor = db.rawQuery(sqlcode, null);
        if (cursor.moveToFirst()) {
            do {
                Student student = new Student(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4));
                studentArrayList.add(student);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return studentArrayList;
    }

    // Lấy tất cả lớp
    public ArrayList<Class> getAllClass() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Class> classArrayList = new ArrayList<>();
        String sqlcode = "SELECT * FROM " + TABLE_CLA;
        Cursor cursor = db.rawQuery(sqlcode, null);
        if (cursor.moveToFirst()) {
            do {
                Class aClass = new Class(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2));
                classArrayList.add(aClass);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return classArrayList;
    }

    // Thêm sinh viên
    public void addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(STU_NAME, student.getName());
        values.put(STU_BIR, student.getBirthday());
        values.put(STU_HOME, student.getHome());
        values.put(STU_YEAR, student.getYear());

        db.insert(TABLE_STU, null, values);
        db.close();
    }
}
