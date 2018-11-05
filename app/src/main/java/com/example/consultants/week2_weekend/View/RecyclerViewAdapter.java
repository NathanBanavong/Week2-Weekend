package com.example.consultants.week2_weekend.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.consultants.week2_weekend.Model.Customer;
import com.example.consultants.week2_weekend.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = RecyclerViewAdapter.class.getSimpleName() + "_TAG";

    List<Customer> customerList;

    public RecyclerViewAdapter(List<Customer> customerList){
        this.customerList = customerList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        int itemViewLayout;

        itemViewLayout = R.layout.listview_customer;

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(itemViewLayout,viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int position) {
        Log.d(TAG, "onBindViewHolder: ");

        Customer customer = customerList.get(position);

        viewHolder.tvPersonName.setText(customer.getName());
        viewHolder.tvPersonAge.setText(customer.getAge());
        viewHolder.tvPersonNumber.setText(customer.getPhone());

    }

    //TODO do i need something in this method
    @Override
    public int getItemCount() {
        return customerList.size();
    }

    public void add(Customer person) {
        customerList.add(person);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvPersonName;
        private final TextView tvPersonAge;
        private final TextView tvPersonNumber;

        ViewHolder(View itemView) {
            super(itemView);
            tvPersonName = itemView.findViewById(R.id.tvPersonName);
            tvPersonAge = itemView.findViewById(R.id.tvPersonAge);
            tvPersonNumber = itemView.findViewById(R.id.tvPersonNumber);
        }

    }
}
