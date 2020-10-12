package com.abada.roomtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestHolder> {
    List<Test> tests;

    public TestAdapter(List<Test> tests) {
        this.tests = tests;
    }

    @NonNull
    @Override
    public TestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout cl = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new TestHolder(cl);

    }

    @Override
    public void onBindViewHolder(@NonNull TestHolder holder, int position) {
        Test test = tests.get(position);
        holder.name.setText(test.getName());
        holder.number.setText(test.getNubmer());
    }

    @Override
    public int getItemCount() {
        int n = 0;
        try {
            n = tests.size();
        } finally {
            return n;
        }
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
        notifyDataSetChanged();
    }

    public static class TestHolder extends RecyclerView.ViewHolder {
        TextView name, number;

        public TestHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
            number = itemView.findViewById(R.id.item_number);
        }
    }
}
