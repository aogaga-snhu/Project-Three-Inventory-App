package com.example.inventoryapp;
import android.content.*;import android.database.*;import android.database.sqlite.*;import java.util.*;import java.security.*;import java.nio.charset.StandardCharsets;
public class InventoryDatabase extends SQLiteOpenHelper {
 public InventoryDatabase(Context c){super(c,"inventory.db",null,1);}
 @Override public void onCreate(SQLiteDatabase d){d.execSQL("CREATE TABLE users(id INTEGER PRIMARY KEY, username TEXT UNIQUE NOT NULL COLLATE NOCASE, salt TEXT NOT NULL, hash TEXT NOT NULL)");d.execSQL("CREATE TABLE items(id INTEGER PRIMARY KEY, owner INTEGER NOT NULL, name TEXT NOT NULL, quantity INTEGER NOT NULL CHECK(quantity>=0))");}
 @Override public void onUpgrade(SQLiteDatabase d,int old,int current){}
 private String digest(String salt,String password){try{byte[] bytes=MessageDigest.getInstance("SHA-256").digest((salt+password).getBytes(StandardCharsets.UTF_8));StringBuilder b=new StringBuilder();for(byte x:bytes)b.append(String.format(Locale.US,"%02x",x&255));return b.toString();}catch(Exception e){throw new IllegalStateException(e);}}
 public long register(String name,String password){byte[] bytes=new byte[16];new SecureRandom().nextBytes(bytes);StringBuilder salt=new StringBuilder();for(byte x:bytes)salt.append(String.format(Locale.US,"%02x",x&255));ContentValues v=new ContentValues();v.put("username",name);v.put("salt",salt.toString());v.put("hash",digest(salt.toString(),password));return getWritableDatabase().insert("users",null,v);}
 public long login(String name,String password){try(Cursor c=getReadableDatabase().query("users",new String[]{"id","salt","hash"},"username=?",new String[]{name},null,null,null)){if(!c.moveToFirst())return -1;return MessageDigest.isEqual(digest(c.getString(1),password).getBytes(StandardCharsets.UTF_8),c.getString(2).getBytes(StandardCharsets.UTF_8))?c.getLong(0):-1;}}
 public static class Item{public long id;public String name;public int quantity;Item(long i,String n,int q){id=i;name=n;quantity=q;}}
 public List<Item> all(long owner){List<Item> out=new ArrayList<>();try(Cursor c=getReadableDatabase().query("items",new String[]{"id","name","quantity"},"owner=?",new String[]{""+owner},null,null,"name COLLATE NOCASE")){while(c.moveToNext())out.add(new Item(c.getLong(0),c.getString(1),c.getInt(2)));}return out;}
 public long add(long owner,String name,int qty){ContentValues v=new ContentValues();v.put("owner",owner);v.put("name",name);v.put("quantity",qty);return getWritableDatabase().insert("items",null,v);}
 public int update(long owner,long id,int qty){ContentValues v=new ContentValues();v.put("quantity",qty);return getWritableDatabase().update("items",v,"id=? AND owner=?",new String[]{""+id,""+owner});}
 public int delete(long owner,long id){return getWritableDatabase().delete("items","id=? AND owner=?",new String[]{""+id,""+owner});}
}
