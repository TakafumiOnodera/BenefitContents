package com.example.onoderat.benefitcontents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] comments = {"案件を問題なく回し切る", "BPにかける時間を意識する",
                "BP新規参加？", "人数が増えた状態でも問題なく回し切る","ここで成果を見せる"};

        List<Map<String, String>> data = new ArrayList<>();
        for (int i=0; i<comments.length; i++){
            Map<String, String> item = new HashMap<>();
            item.put("Title", String.valueOf(i + 5) + "月");
            item.put("Comment", comments[i]);
            data.add(item);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, data,
                android.R.layout.simple_list_item_2,
                new String[] {"Title", "Comment"},
                new int[] { android.R.id.text1, android.R.id.text2});

        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg = position + "番目のアイテムがクリックされました";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }
}
