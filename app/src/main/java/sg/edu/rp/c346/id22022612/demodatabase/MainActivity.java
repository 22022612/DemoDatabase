package sg.edu.rp.c346.id22022612.demodatabase;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnGetTasks;
    ListView lv;
    TextView tvResults;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        btnGetTasks = findViewById(R.id.btnGetTasks);
        lv = findViewById(R.id.lv);
        tvResults = findViewById(R.id.tvResults);
        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertTask("Submit RJ", "25 Apr 2021");

            }
        });
        btnGetTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                ArrayList myList = db.getTasks();
                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,myList);
                lv.setAdapter(adapter);

                // Insert a task
                //ArrayList<String> data = db.getTaskContent();
                db.close();

//                String txt = "";
//                for (int i = 0; i < data.size(); i++) {
//                    Log.d("Database Content", i + ". " + data.get(i));
//                    txt += i + ". " + data.get(i) + "\n";
//                }

            }
        });
//        btnGetTasks.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Create the DBHelper object, passing in the
//                // activity's Context
//                DBHelper db = new DBHelper(MainActivity.this);
//
//                // Insert a task
//                ArrayList<String> data = db.getTaskContent();
//                db.close();
//
//                String txt = "";
//                for (int i = 0; i < data.size(); i++) {
//                    Log.d("Database Content", i + ". " + data.get(i));
//                    txt += i + ". " + data.get(i) + "\n";
//                }
//                tvResults.setText(txt);
//            }
//        });
    }
}