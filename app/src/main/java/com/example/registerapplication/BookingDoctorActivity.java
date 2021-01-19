package com.example.registerapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookingDoctorActivity extends AppCompatActivity {

//    ImageView back_imageView;

    Button btn_one;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_doctor);
        btn_one = (Button)findViewById(R.id.btn_change);
        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new  Intent(BookingDoctorActivity.this , FindDoctorActivity.class);
                startActivity(i);
                finish();

            }
        });

       /* back_imageView = (ImageView)findViewById(R.id.check_your_back_id);
        back_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BookingDoctorActivity.this, FindDoctorActivity.class);
                startActivity(i);
                finish();
            }
        });*/
        // get the listview
        expListView = (ExpandableListView)findViewById(R.id.booking_doctor);

        // preparing list data

        prepareListData();
        //  TextView textView = new TextView(ThirdFragment.this.getActivity());

        listAdapter = new ExpandableListAdapter(BookingDoctorActivity.this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        return ;

    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Dr.Sujeewa Amarasighe");
        listDataHeader.add("Dr.Nayana Wikramasinghe");
        listDataHeader.add("Dr.Chalukya Karunasinha ");
        listDataHeader.add("Dr.Upendra Samaraweera");
        listDataHeader.add("Dr.Lakmi Kodithuwakku");
        listDataHeader.add("Dr.Rupika Gunawardana");
        listDataHeader.add("Dr.Kavishaka Kumarasiri");
        listDataHeader.add("Dr.Nihal Pathmasiri");
        listDataHeader.add("Dr.Ashela Devapriya");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("Hospital Name : Asiri Hospital");
        top250.add("Address: 181, Kirula Road, Colombo 5");
        top250.add("Contact Number: 0114523300");
       /* top250.add("Pulp Fiction");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");*/

        List<String> top251 = new ArrayList<String>();
        top251.add("Hospital Name : Asiri Surgical Hospital");
        top251.add("21, Kirimandala Mawatha, Colombo 5");
        top251.add("Contact Number: 0114524400");

        List<String> top252 = new ArrayList<String>();
        top252.add("Hospital Name :The Central");
        top252.add("Address: 114, Noris Canal Road, Colombo 10");
        top252.add("Contact Number: 0114665500");

        List<String> top253 = new ArrayList<String>();
        top253.add("Hospital Name :The Central");
        top253.add("Address: 114, Noris Canal Road, Colombo 10");
        top253.add("Contact Number: 0114665500");

        List<String> top254 = new ArrayList<String>();
        top254.add("Hospital Name :Borella Private Hostpital");
        top254.add("Address: 114, 75, Kotta Road, Colombo8");
        top254.add("Contact Number: 0112692753");
/////////////////////
       /* List<String> top255 = new ArrayList<String>();
        top255.add("Hospital Name :Ceylinco Halthcare center");
        top255.add("Address:60, Park Street, Colombo 2");
        top255.add("Contact Number:0112490290");

        List<String> top256 = new ArrayList<String>();
        top256.add("Hospital Name :Ceymed Health care");
        top256.add("Address:132, S. De jayasinghe Mawatha, Nugegoda");
        top256.add("Contact Number: 0114308877");

        List<String> top257 = new ArrayList<String>();
        top257.add("Hospital Name :Durdans Hospital");
        top257.add("Address: 3, Alfred Place, Colombo 3");
        top257.add("Contact Number: 1344 or 0112140000");

        List<String> top258 = new ArrayList<String>();
        top258.add("Hospital Name :Golden Key Eye and ENT Hospital");
        top258.add("Address: 1175, Cotta Road, Rajagiriya");
        top258.add("Contact Number: 0112880288");

        List<String> top259 = new ArrayList<String>();
        top259.add("Hospital Name :Grandpass Nursing Home");
        top259.add("Address: 34,54 Grandpass Road, Colombo 14");
        top259.add("Contact Number: 0112422184-6");*/

        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), top251);
        listDataChild.put(listDataHeader.get(2), top252);
        listDataChild.put(listDataHeader.get(3), top253);
        listDataChild.put(listDataHeader.get(4), top254);



       /* listDataChild.put(listDataHeader.get(6), top256);
        listDataChild.put(listDataHeader.get(7), top257);
        listDataChild.put(listDataHeader.get(8), top258);
        listDataChild.put(listDataHeader.get(9), top259);*/

    }
}