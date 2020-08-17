package rp.edu.sg.c346.id19020438.rpwebsites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spnCat;
    Spinner spnSCat;
    Button btnGo;
    ArrayList<String> alWebPage;
    ArrayAdapter<String> aaWebPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnCat = findViewById(R.id.spinnerCategory);
        spnSCat = findViewById(R.id.spinnerSubCategory);
        btnGo = findViewById(R.id.buttonGo);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.category_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCat.setAdapter(adapter);

        alWebPage = new ArrayList<>();
        aaWebPage = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alWebPage);
        spnSCat.setAdapter(aaWebPage);

        spnCat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        alWebPage.clear();
                        String[] RPWebPages = getResources().getStringArray(R.array.sub_category_RP);
                        alWebPage.addAll(Arrays.asList(RPWebPages));
                        spnSCat.setAdapter(aaWebPage);
                        break;
                    case 1:
                        alWebPage.clear();
                        String[] SOIWebPages = getResources().getStringArray(R.array.sub_category_SOI);
                        alWebPage.addAll(Arrays.asList(SOIWebPages));
                        spnSCat.setAdapter(aaWebPage);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.rp.edu.sg/";

                int pos = spnCat.getSelectedItemPosition();
                int position = spnSCat.getSelectedItemPosition();

                if (pos == 0){
                    if (position == 0){
                        url = "https://www.rp.edu.sg/";
                    }
                    else{
                        url = "https://www.rp.edu.sg/student_life";
                    }
                } else{
                    if (position == 0){
                        url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
                    }
                    else{
                        url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";
                    }
                }

                Intent intent = new Intent(MainActivity.this, DisplayWeb.class);
                intent.putExtra("WebPage URL", url);
                startActivity(intent);
            }
        });
    }
}
