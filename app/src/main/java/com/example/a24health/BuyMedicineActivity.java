package com.example.a24health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {

    private String[][] packages=
            {
                    {"uprise-d3 10001 Capsule","","","","50"},
                    {"Healthvit Chronium 200mcg Capsule","","","","305"},
                    {"Vitamin B Complex Capsule","","","","448"},
                    {"Inlife Vitamin E Wheat Germ Oil Capsule","","","","539"},
                    {"DOLO 658 Tablet","","","","245"},
                    {"Cenarest Tablet","","","","100"},
                    {"Crocine 650 Advance Tablet","","","","50"},
                    {"Tata 1mg Calcium + vitaminD3","","","","30"},
                    {"Feronia-XT Tablet","","","","130"}
            };
    private String[] package_details={
      "Building and Keepind Bones Strong\n"+
           "Reducing Fatigue/stress and Muscular pain\n"
           +
      "Boosting immunity and resistance against infection\n "+
              "Chrocium plays important role in helping insulin Regulation\n"+
              "Provides relifef from Vitamin D Deficencies\n"+
              "Helps in formation of red blood cells\n"+
              "it promotes health aswell as skin benifit\n"+
              "Helps in reduce skin Blemish and pigmentation\n"+
              "Helps reduce pain and fever"

    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoToCart,btnBack;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);
        getSupportActionBar().hide();


        btnGoToCart = findViewById(R.id.buttonBMGotoCart);
        btnBack = findViewById(R.id.buttonBMBack);
        listView= findViewById(R.id.listViewBM);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });
        list = new ArrayList();
        for (int i=0;i<packages.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total cost:"+packages[i][4]+"/-");
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });
    }
}