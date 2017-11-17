package com.alacriti.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by amans on 17/11/17.
 */

public class AdminPage extends AppCompatActivity {

    Button invoiceList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_page);
    Button createVendor= findViewById(R.id.createVendor);
        Button vendorDetail= findViewById(R.id.vendorDetail);
        invoiceList= findViewById(R.id.invoiceList);
        Button payVendor= findViewById(R.id.payVendor);
    test();

    }

 public void test(){
      invoiceList.setOnClickListener(new View.OnClickListener() {
          public void onClick(View v)  {
              Toast.makeText(getBaseContext(), "In Invoice List()" , Toast.LENGTH_SHORT ).show();
          }
      });
  }
}
