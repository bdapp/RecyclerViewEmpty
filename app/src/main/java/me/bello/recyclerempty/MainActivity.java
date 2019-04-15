package me.bello.recyclerempty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<MyData> mList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.add_btn).setOnClickListener(this);
        findViewById(R.id.clear_btn).setOnClickListener(this);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        adapter = new MyAdapter(mList);
        recyclerView.setAdapter(adapter);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_btn:
                addData();
                break;

            case R.id.clear_btn:
                clearData();
                break;
        }
    }

    private void clearData() {
        mList.clear();
        adapter.notifyDataSetChanged();
    }

    private void addData() {

        mList.add(new MyData());
        mList.add(new MyData());
        mList.add(new MyData());

        adapter.notifyDataSetChanged();

    }


}
