package comorgsminorproj.httpsgithub.jobber;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Krrish on 11/27/2017.
 */
public class MainAdapter extends  RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private ArrayList<Job> mDataset;

    public MainAdapter(ArrayList<Job> mDataset) {
        this.mDataset = mDataset;
    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, null);

        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, int position) {

        Job job = mDataset.get(position);

        holder.desg.setText(job.getDesg());
        holder.salary.setText(job.getSalary());
        holder.qual.setText(job.getQualification());

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView desg,salary,qual;

        public ViewHolder(View itemView) {
            
            super(itemView);
            desg = (TextView) itemView.findViewById(R.id.desg);
            salary = (TextView) itemView.findViewById(R.id.salary);
            qual = (TextView) itemView.findViewById(R.id.qual);
        }
    }
}
