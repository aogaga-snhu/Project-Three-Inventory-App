package com.example.inventoryapp;
import android.app.*;import android.os.*;import android.content.*;import android.widget.*;
public class MainActivity extends Activity{
 private EditText user,pass;private InventoryDatabase db;
 @Override public void onCreate(Bundle b){super.onCreate(b);setContentView(R.layout.activity_main);db=new InventoryDatabase(this);user=findViewById(R.id.usernameText);pass=findViewById(R.id.passwordText);findViewById(R.id.buttonLogin).setOnClickListener(v->submit(false));findViewById(R.id.buttonCreateAccount).setOnClickListener(v->submit(true));}
 private void submit(boolean create){String u=user.getText().toString().trim(),p=pass.getText().toString();if(u.isEmpty()||p.length()<6){Toast.makeText(this,"Enter username and password (6+ characters)",Toast.LENGTH_LONG).show();return;}long id=create?db.register(u,p):db.login(u,p);if(id<0){Toast.makeText(this,create?"Username already exists":"Invalid credentials",Toast.LENGTH_LONG).show();return;}getSharedPreferences("session",0).edit().putLong("id",id).apply();startActivity(new Intent(this,InventoryActivity.class));finish();}
}
