package co.sgupta.listviewwithbaseadapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    ArrayList<SingleRow> mRows;
    Context mContext;

    public CustomAdapter(Context c) {
        mContext  = c;
        mRows = new ArrayList<SingleRow>();
        Resources resources = c.getResources();
        String[] titles = resources.getStringArray(R.array.titles);
        String[] descriptions = resources.getStringArray(R.array.descriptions);
        int[] images = {R.drawable.meme_1,R.drawable.meme_2,R.drawable.meme_3,R.drawable.meme_4,R.drawable.meme_5,R.drawable.meme_6
                ,R.drawable.meme_7,R.drawable.meme_8,R.drawable.meme_9,R.drawable.meme_10};

        for (int i=0;i<10;i++){
            mRows.add(new SingleRow(titles[i],descriptions[i],images[i]));
        }

    }

    @Override
    public int getCount() {
        return mRows.size();
    }

    @Override
    public Object getItem(int i) {
        return mRows.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        MyViewHolder holder = null;
        View row = convertView;

        if(row==null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row,viewGroup,false);
            holder = new MyViewHolder(row);

            row.setTag(holder);
        }
        else {
            holder = (MyViewHolder) row.getTag();
        }

        SingleRow singleRow = mRows.get(i);

        holder.imageView.setImageResource(singleRow.image);
        holder.imageView.setTag(singleRow);
        holder.textView1.setText(singleRow.title);
        holder.textView1.setTag(singleRow);
        holder.textView2.setText(singleRow.Description);
        holder.textView2.setTag(singleRow);
        return row;
    }
}
