package com.example.consultants.week2_weekend.View;

import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.consultants.week2_weekend.Database.CustomerDatabase;
import com.example.consultants.week2_weekend.Model.Customer;
import com.example.consultants.week2_weekend.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomerRecyclerViewActivity extends AppCompatActivity {

    private static final String TAG = CustomerRecyclerViewActivity.class.getSimpleName() + "_TAG";
    @BindView(R.id.etPersonName)
    EditText etPersonName;
    @BindView(R.id.etPersonAge)
    EditText etPersonAge;
    @BindView(R.id.etPersonNumber)
    EditText etPersonNumber;

    private RecyclerView rvCustomerList;
    private RecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

//    private CustomerDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_recycler_view);

        Log.d(TAG, "onCreate: ");

        getIntent();
        ButterKnife.bind(this);

        bindRecyclerView();

    }

    //TODO need to bind the info into the recycler
    private void bindRecyclerView() {
        Log.d(TAG, "bindRecyclerView: ");
        CustomerDatabase db = new CustomerDatabase(getApplicationContext());
        List<Customer> customerList = db.getCustomer();

        rvCustomerList = findViewById(R.id.rvCustomerList);
        adapter = new RecyclerViewAdapter(customerList);
        layoutManager = new LinearLayoutManager(this);
        rvCustomerList.setAdapter(adapter);
        rvCustomerList.setLayoutManager(layoutManager);
    }

    public void onAddCustomer(View view) {

        Customer person = new Customer(etPersonName.getText().toString(),
                etPersonNumber.getText().toString(),
                etPersonAge.getText().toString());

        adapter.add(person);

        //reset the textbox
        etPersonAge.setText("");
        etPersonName.setText("");
        etPersonNumber.setText("");

        Toast.makeText(this, "Success!", Toast.LENGTH_LONG).show();
    }

    public void onListCustomer(View view) {
        bindRecyclerView();
    }
}
