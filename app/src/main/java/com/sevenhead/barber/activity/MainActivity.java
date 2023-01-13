package com.sevenhead.barber.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sevenhead.barber.Domain.CutstyleDomain;
import com.sevenhead.barber.R;
import com.sevenhead.barber.adapter.AlertDialogManager;
import com.sevenhead.barber.adapter.CutstyleAdaptor;
import com.sevenhead.barber.session.SessionManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AlertDialogManager alert = new AlertDialogManager();
    SessionManager session;
    Button btnLogout;
    RecyclerView.Adapter adapter;
    RecyclerView recyclerViewCutList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new SessionManager(getApplicationContext());
        session.checkLogin();

        btnLogout = findViewById(R.id.out);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Anda yakin ingin keluar ?")
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                session.logoutUser();
                            }
                        })
                        .setNegativeButton("Tidak", null)
                        .create();
                dialog.show();
            }
        });

        recyclerViewCut();
    }

    private void recyclerViewCut() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCutList=findViewById(R.id.RV);
        recyclerViewCutList.setLayoutManager(linearLayoutManager);

        ArrayList<CutstyleDomain> cutList=new ArrayList<>();
        cutList.add(new CutstyleDomain("Model 1", "ic_m1"));
        cutList.add(new CutstyleDomain("Model 2", "ic_m2"));
        cutList.add(new CutstyleDomain("Model 3", "ic_m9"));
        cutList.add(new CutstyleDomain("Model 4", "ic_m10"));
        cutList.add(new CutstyleDomain("Model 5", "ic_m5"));
        cutList.add(new CutstyleDomain("Model 6", "ic_m6"));
        cutList.add(new CutstyleDomain("Model 7", "ic_m7"));
        cutList.add(new CutstyleDomain("Model 8", "ic_m8"));

        adapter=new CutstyleAdaptor(cutList);
        recyclerViewCutList.setAdapter(adapter);
    }

    public void profileMenu(View v) {
        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
    }

    public void historyMenu(View v) {
        Intent i = new Intent(this, HistoryActivity.class);
        startActivity(i);
    }

    public void bookingMenu(View v) {
        Intent i = new Intent(this, BookingActivity.class);
        startActivity(i);
    }

    public void messagemenu(View v) {
        Toast.makeText(getApplicationContext(), "Mohon maaf, sistem sedang dalam pengembangan.", Toast.LENGTH_LONG).show();
    }
}
