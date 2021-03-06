package com.mnnit.athleticmeet.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mnnit.athleticmeet.R;
import com.mnnit.athleticmeet.adapters.Schedule_Adapter;

import java.util.ArrayList;
import java.util.List;

public class Discuss_Throw extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discuss__throw);

        //start
        RecyclerView rv= findViewById(R.id.listviewdiscuss);
        List<DataWinner> list=fill();
        Schedule_Adapter sa=new Schedule_Adapter(list,getApplicationContext());
        rv.setAdapter(sa);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        //end

    }

    public List<DataWinner> fill(){
        List<DataWinner> list=new ArrayList<>();
        list.add(new DataWinner("Feb 8:: 10:30 a.m.(InterCollege)\nDiscuss Throw (Boys)"));
        list.add(new DataWinner( "Feb 8:: 10:45 a.m.(IntraCollege)\n Discuss Throw (Boys)"));
        list.add(new DataWinner("Feb 8:: 11:00 a.m.(InterCollege)\n Discuss Throw (Girls)"));
        list.add(new DataWinner("Feb 8:: 11:15 a.m.(IntraCollege)\n Discuss Throw (Girls)"));

        return  list;
    }
}
