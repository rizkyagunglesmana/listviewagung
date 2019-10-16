package id.kampuskoding.agung3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter{

    //variables
    Context mContext;
    LayoutInflater inflater;
    List<Model> modellist;
    ArrayList<Model> arrayList;

    //constructor
    public ListViewAdapter(Context context, List<Model> modellist) {
        mContext = context;
        this.modellist = modellist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modellist);
    }

    public class ViewHolder{
        TextView mTitleTv, mDescTv;
        ImageView mIconIv;
    }

    @Override
    public int getCount() {
        return modellist.size();
    }

    @Override
    public Object getItem(int i) {
        return modellist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int postition, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row, null);

            //locate the views in row.xml
            holder.mTitleTv = view.findViewById(R.id.mainTitle);
            holder.mDescTv = view.findViewById(R.id.mainDesc);
            holder.mIconIv = view.findViewById(R.id.mainIcon);

            view.setTag(holder);

        }
        else {
            holder = (ViewHolder)view.getTag();
        }
        //set the results into textviews
        holder.mTitleTv.setText(modellist.get(postition).getTitle());
        holder.mDescTv.setText(modellist.get(postition).getDesc());
        //set the result in imageview
        holder.mIconIv.setImageResource(modellist.get(postition).getIcon());

        //listview item clicks
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code later
                if (modellist.get(postition).getTitle().equals("Bapak Soekarno")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Bapak Soekarno");
                    intent.putExtra("contentTv", "Presiden Republik Indonesia 1");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Bapak Soeharto")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Bapak Soeharto");
                    intent.putExtra("contentTv", "Presiden Republik Indonesia 2");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Bapak B. J. Habibie")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Bapak B. J. Habibie");
                    intent.putExtra("contentTv", "Presiden Republik Indonesia 3");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Bapak Abdurrahman Wahid")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Bapak Abdurrahman Wahid");
                    intent.putExtra("contentTv", "Presiden Republik Indonesia 4");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Ibu Megawati Soekarnoputri")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Ibu Megawati Soekarnoputri");
                    intent.putExtra("contentTv", "Presiden Republik Indonesia 5");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Bapak Susilo Bambang Yudhoyono")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Bapak Susilo Bambang Yudhoyono");
                    intent.putExtra("contentTv", "Presiden Republik Indonesia 6");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Bapak Joko Widodo")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Bapak Joko Widodo");
                    intent.putExtra("contentTv", "Presiden Republik Indonesia 7");
                    mContext.startActivity(intent);
                }
            }
        });


        return view;
    }
    //filter
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        modellist.clear();
        if (charText.length()==0){
            modellist.addAll(arrayList);
        }
        else {
            for (Model model : arrayList){
                if (model.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    modellist.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }
}