package com.example.talhamughal.studentinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList StdData = new ArrayList();
    int ID = 0;

    final Button btnSubmit = findViewById(R.id.btnSubmit);
    final TextView TxtShow = findViewById(R.id.txtShow);
    final TextView TxtEsc =  findViewById(R.id.txtEsc);
    final RelativeLayout R_Layout = findViewById(R.id.R_Layout);
    final RelativeLayout Show_R_Layout = findViewById(R.id.Show_R_Layout);
    final Button btnSearch = findViewById(R.id.btnSearch);
    final Button btnBack = findViewById(R.id.btnBack);

    EditText TxtFName = findViewById(R.id.TxtFName);
    EditText TxtLName = findViewById(R.id.TxtLName);
    EditText TxtEmail = findViewById(R.id.TxtEmail);
    EditText TxtContact = findViewById(R.id.TxtContact);
    EditText TxtAddress = findViewById(R.id.TxtAddress);
    RadioGroup Gender = findViewById(R.id.radio);

    TextView txtSearch = findViewById(R.id.txtSearch);
    final TextView TxtShowFname = findViewById(R.id.TxtShowFname);
    final TextView TxtShowLname = findViewById(R.id.TxtShowLname);
    final TextView TxtShowEmail = findViewById(R.id.TxtShowEmail);
    final TextView TxtShowContact = findViewById(R.id.TxtShowContact);
    final TextView TxtShowAddress = findViewById(R.id.TxtShowAddress);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Listeners();

    }



    void Listeners()
    {


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(CheckTextBoxes() == true) {
                    Toast.makeText(MainActivity.this,"Plz Fill All Requirements",Toast.LENGTH_LONG).show();
                }
                else
                {
                    ID++;
                    StdData.add(String.valueOf(ID));
                    StdData.add(TxtFName.getText().toString());
                    StdData.add(TxtLName.getText().toString());
                    StdData.add(TxtEmail.getText().toString());
                    StdData.add(TxtContact.getText().toString());
                    StdData.add(TxtAddress.getText().toString());

                    btnSubmit.setVisibility(View.INVISIBLE);
                    ClearTextBoxes();
                    TxtShow.setVisibility(View.VISIBLE);
                    TxtEsc.setVisibility(View.VISIBLE);
                }
            }
        });

        TxtShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                R_Layout.setVisibility(View.GONE);
                Show_R_Layout.setVisibility(View.VISIBLE);
                txtSearch.setText("");

                int id = StdData.indexOf(String.valueOf(ID));

                TxtShowFname.setText(StdData.get(++id).toString());
                TxtShowLname.setText(StdData.get(++id).toString());
                TxtShowEmail.setText(StdData.get(++id).toString());
                TxtShowContact.setText(StdData.get(++id).toString());
                TxtShowAddress.setText(StdData.get(++id).toString());

            }
        });

        TxtEsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClearTextBoxes();
                btnSubmit.setVisibility(View.VISIBLE);
            }
        });


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int id = StdData.indexOf(txtSearch.getText().toString());

                    TxtShowFname.setText(StdData.get(++id).toString());
                    TxtShowLname.setText(StdData.get(++id).toString());
                    TxtShowEmail.setText(StdData.get(++id).toString());
                    TxtShowContact.setText(StdData.get(++id).toString());
                    TxtShowAddress.setText(StdData.get(++id).toString());
                }
                catch(Exception ex)
                {
                    Toast.makeText(MainActivity.this,"Error! Id Record Not Fouond",Toast.LENGTH_SHORT ).show();
                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Show_R_Layout.setVisibility(View.GONE);
                R_Layout.setVisibility(View.VISIBLE);
                ClearTextBoxes();
                TxtShow.setVisibility(View.INVISIBLE);
                TxtEsc.setVisibility(View.INVISIBLE);
                btnSubmit.setVisibility(View.VISIBLE);
            }
        });



    }

    void ClearTextBoxes()
    {
        TxtFName.setText("");
        TxtLName.setText("");
        TxtEmail.setText("");
        TxtContact.setText("");
        TxtAddress.setText("");
        Gender.clearCheck();
    }
    boolean CheckTextBoxes()
    {
        if(TxtFName.getText().toString().equals("") || TxtLName.getText().toString().equals("") || TxtEmail.getText().toString().equals("") || TxtContact.getText().toString().equals("") || TxtAddress.getText().toString().equals("") || Gender.getCheckedRadioButtonId() == -1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
