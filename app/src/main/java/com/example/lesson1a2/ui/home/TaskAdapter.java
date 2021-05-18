package com.example.lesson1a2.ui.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson1a2.R;
import com.example.lesson1a2.models.Task;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    private ArrayList<Task>list = new ArrayList<>();
    View view;
    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_task,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TaskAdapter.ViewHolder holder, int position) {
        holder.bind(list.get(position));
        if (position % 2 == 0) {
            view.setBackgroundColor(Color.GREEN);

        } else {
            view.setBackgroundColor(Color.YELLOW);
        }
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());
                alert.setMessage("Do you want to delete?");
                alert.setTitle("Warning!");
                alert.setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        list.remove(position);
                        notifyDataSetChanged();
                    }
                });
                alert.setNegativeButton("No!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alert.show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addItem(Task task) {
        list.add(task);
      notifyItemInserted(list.indexOf(task));
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textTitle;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
        }

        public void bind(Task task) {
            textTitle.setText(task.getTitle());
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(view.getContext(),getAdapterPosition()+":"+task.getTitle(),Toast.LENGTH_SHORT).show();

                }
            });
        }
    }
}
