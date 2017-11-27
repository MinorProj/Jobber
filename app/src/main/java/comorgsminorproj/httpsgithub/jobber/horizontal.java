package comorgsminorproj.httpsgithub.jobber;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Krrish on 11/27/2017.
 */

public class horizontal extends RecyclerView.Adapter<horizontal.HorizontalViewHolder> {

    private String[]items;

    public horizontal(String[] items) {
        this.items = items;
    }

    @Override
    public HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item,parent,false);
        return  new HorizontalViewHolder(view);


    }

    @Override
    public void onBindViewHolder(HorizontalViewHolder holder, int position) {
        holder.txt.setText(items[position]);

    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {
        TextView txt;
        public HorizontalViewHolder(View itemView) {
            super(itemView);
            txt= (TextView) itemView.findViewById(R.id.item_id);
        }
    }
}