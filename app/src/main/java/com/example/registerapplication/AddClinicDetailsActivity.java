package com.example.registerapplication;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AddClinicDetailsActivity extends AppCompatActivity {

    ImageView back_arrow_img;

    //27/11/2020

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private ArrayList<Friend> friendArrayList;
    private FloatingActionButton fab;
    //private boolean gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_clinic_details);

        friendArrayList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyle_view_id);
        fab = (FloatingActionButton) findViewById(R.id.fab_id);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        setRecyclerViewData(); //adding data to array list
        adapter = new RecyclerAdapter(this, friendArrayList);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(onAddingListener());

        back_arrow_img = (ImageView)findViewById(R.id.icure_clinic_imgeView);
        back_arrow_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddClinicDetailsActivity.this, IcureClinicHome.class);
                startActivity(i);
                finish();
            }
        });

       /* Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

    }


    private void setRecyclerViewData() {
        friendArrayList.add(new Friend("Phan Thanh", "2020/10/01", "2020/11/22",  "He is Goog"));
        friendArrayList.add(new Friend("Nguyen Tuan", "2019/10/19", "2020/01/02","He is Good"));
        friendArrayList.add(new Friend("Tran Van Minh", "2018/07/06", "2019/02/01","He is Good"));
        friendArrayList.add(new Friend("Pham Mai Anh", "2015/01/01", "2017/01/01","He is Bad"));
        friendArrayList.add(new Friend("Nguyen Quynh Trang", "2014/07/09", "2016/07/09","He is bad"));
        friendArrayList.add(new Friend("Hoang Dinh Cuong", "2017/070/08", "2018/03/03","He is Good"));
        friendArrayList.add(new Friend("Tran Cong Bach", "2016/07/08", "2017/07/07","He is Bad"));
        friendArrayList.add(new Friend("Vu Van Duong", "2017/06/06", "2018/03/09","He is Good"));
    }

    private View.OnClickListener onAddingListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(AddClinicDetailsActivity.this);
                dialog.setContentView(R.layout.dialog_add); //layout for dialog
                dialog.setTitle("Add a new friend");
                dialog.setCancelable(false); //none-dismiss when touching outside Dialog

                // set the custom dialog components - texts and image
                EditText name = (EditText) dialog.findViewById(R.id.name);
                EditText attended_date = (EditText) dialog.findViewById(R.id.attended_date);
                EditText next_clinic_date = (EditText) dialog.findViewById(R.id.next_clinic_date);
                EditText doctor_comment = (EditText) dialog.findViewById(R.id.doctor_comment);

                View btnAdd = dialog.findViewById(R.id.btn_ok);
                View btnCancel = dialog.findViewById(R.id.btn_cancel);

                //set spinner adapter
              /*  ArrayList<String> gendersList = new ArrayList<>();
                gendersList.add("Male");
                gendersList.add("Female");
                ArrayAdapter<String> spnAdapter = new ArrayAdapter<String>(AddClinicDetailsActivity.this,
                        android.R.layout.simple_dropdown_item_1line, gendersList);
                spnGender.setAdapter(spnAdapter);*/

                //set handling event for 2 buttons and spinner
               // spnGender.setOnItemSelectedListener(onItemSelectedListener());
                btnAdd.setOnClickListener(onConfirmListener(name,attended_date,next_clinic_date, doctor_comment,dialog));
                btnCancel.setOnClickListener(onCancelListener(dialog));

                dialog.show();
            }
        };
    }

   /* private AdapterView.OnItemSelectedListener onItemSelectedListener() {
        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                if (position == 0) {
                    gender = true;
                } else {
                    gender = false;
                }
            }

            @Override
            public void onNothingSelected(AdapterView parent) {

            }
        };
    }
*/
    private View.OnClickListener onConfirmListener(final EditText name, final EditText attended_date,final EditText next_clinic_date,final EditText doctor_comment, final Dialog dialog) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Friend friend = new Friend(name.getText().toString().trim(), attended_date.getText().toString().trim(),next_clinic_date.getText().toString().trim(),doctor_comment.getText().toString().trim() );

                //adding new object to arraylist
                friendArrayList.add(friend);

                //notify data set changed in RecyclerView adapter
                adapter.notifyDataSetChanged();

                //close dialog after all
                dialog.dismiss();
            }
        };
    }

    private View.OnClickListener onCancelListener(final Dialog dialog) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        };
    }
}