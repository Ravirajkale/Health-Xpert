package com.example.a24health;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1={
            {"Doctor Name : Raviraj Kale","Hospital Address : Solapur","Exp : 5yrs","Mobile No:9518352815","600"},
            {"Doctor Name : Akshay Mashle","Hospital Address : Pimpri","Exp : 3yrs","Mobile No:9818952815","700"},
            {"Doctor Name : Nagesh Mali","Hospital Address : Pune","Exp : 6yrs","Mobile No:8518752815","900"},
            {"Doctor Name : Athrva chavan","Hospital Address : Dholkpur","Exp : 2yrs","Mobile No:8917652815","600"},
            {"Doctor Name : Tushar gadgade","Hospital Address : Nashik","Exp : 9yrs","Mobile No:8866352815","900"}
    };
    private String[][] doctor_details2={
            {"Doctor Name : dipak Kale","Hospital Address : Solapur","Exp : 5yrs","Mobile No:9518352815","600"},
            {"Doctor Name : naveen lavle","Hospital Address : Pimpri","Exp : 3yrs","Mobile No:9818952815","700"},
            {"Doctor Name : ashish more","Hospital Address : Pune","Exp : 6yrs","Mobile No:8518752815","900"},
            {"Doctor Name : mandar chari","Hospital Address : Dholkpur","Exp : 2yrs","Mobile No:8917652815","600"},
            {"Doctor Name : Tushar gadgade","Hospital Address : Nashik","Exp : 9yrs","Mobile No:8866352815","900"}
    };
    private String[][] doctor_details3={
            {"Doctor Name : ganesh kale","Hospital Address : Solapur","Exp : 5yrs","Mobile No:9518352815","600"},
            {"Doctor Name : chetan sule","Hospital Address : Pimpri","Exp : 3yrs","Mobile No:9818952815","700"},
            {"Doctor Name : om Mali","Hospital Address : Pune","Exp : 6yrs","Mobile No:8518752815","900"},
            {"Doctor Name : pushkar chavan","Hospital Address : Dholkpur","Exp : 2yrs","Mobile No:8917652815","600"},
            {"Doctor Name : ambinath gadgade","Hospital Address : Nashik","Exp : 9yrs","Mobile No:8866352815","900"}
    };
    private String[][] doctor_details4={
            {"Doctor Name : yash kassa","Hospital Address : Solapur","Exp : 5yrs","Mobile No:9518352815","600"},
            {"Doctor Name : kdjajd kjd","Hospital Address : Pimpri","Exp : 3yrs","Mobile No:9818952815","700"},
            {"Doctor Name : tom hardy","Hospital Address : Pune","Exp : 6yrs","Mobile No:8518752815","900"},
            {"Doctor Name : salman khan","Hospital Address : Dholkpur","Exp : 2yrs","Mobile No:8917652815","600"},
            {"Doctor Name : naresh simha","Hospital Address : Nashik","Exp : 9yrs","Mobile No:8866352815","900"}
    };
    private String[][] doctor_details5={
            {"Doctor Name : bahubali ambe","Hospital Address : Solapur","Exp : 5yrs","Mobile No:9518352815","600"},
            {"Doctor Name : channu sinnur","Hospital Address : Pimpri","Exp : 3yrs","Mobile No:9818952815","700"},
            {"Doctor Name : akshay kumar","Hospital Address : Pune","Exp : 6yrs","Mobile No:8518752815","900"},
            {"Doctor Name : binod kamble","Hospital Address : Dholkpur","Exp : 2yrs","Mobile No:8917652815","600"},
            {"Doctor Name : paraya insan","Hospital Address : Nashik","Exp : 9yrs","Mobile No:8866352815","900"}
    };
    TextView tv;
    String[][] doctor_detail={};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button bt;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        getSupportActionBar().hide();
        //Showing relevant title
        tv=findViewById(R.id.textviewLTDTitle);
        Intent it= getIntent();
        String title = it.getStringExtra("Title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_detail=doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_detail=doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_detail=doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_detail=doctor_details4;
        else
            doctor_detail=doctor_details5;


            //back button action
        bt=findViewById(R.id.buttonODBack);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });
        list = new ArrayList();
        for (int i=0;i<doctor_detail.length;i++){
            item= new HashMap<String,String>();
            item.put("line1",doctor_detail[i][0]);
            item.put("line2",doctor_detail[i][1]);
            item.put("line3",doctor_detail[i][2]);
            item.put("line4",doctor_detail[i][3]);
            item.put("line5","Cons fee:"+doctor_detail[i][4]+"/-");
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.listViewCl);
        lst.setAdapter(sa);
        //going to book appointment activity on clicking doctor item
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_detail[i][0]);
                it.putExtra("text3",doctor_detail[i][1]);
                it.putExtra("text4",doctor_detail[i][3]);
                it.putExtra("text5",doctor_detail[i][4]);
                startActivity(it);
            }
        });
    }
}