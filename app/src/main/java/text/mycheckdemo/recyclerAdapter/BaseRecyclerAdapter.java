package text.mycheckdemo.recyclerAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import text.mycheckdemo.R;

/**
 * Created by jh on 2018/2/27.
 */

public class BaseRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int TYPE_HEADER  = 0;//头部
    private int TYPE_FOOTER  = 1;//脚部
    private int TYPE_NORMORE = 2;//中间

    private View headerView;
    private View footerView;


    private List<String> list;
    public BaseRecyclerAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(headerView!=null&&viewType == TYPE_HEADER){
            return new ViewHolder(headerView);
        }

        if(footerView!=null && viewType == TYPE_FOOTER){
            return new ViewHolder(footerView);

        }


        View itemView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return  new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if(getItemViewType(position) == TYPE_NORMORE){
                if (holder instanceof ViewHolder){
                 ((ViewHolder)holder).tv_ItemTitle.setText(list.get(position-1));
                }
            }
    }

    @Override
    public int getItemCount() {
        if(headerView!=null&&footerView!=null){
            return list.size()+2;
        }else if(headerView!=null && footerView == null) {
            return list.size()+1;
        }else if(headerView==null && footerView != null) {
            return list.size()+1;
        }else{
            return list.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return TYPE_HEADER;
        }else if(position == getItemCount()-1){
            return TYPE_FOOTER;
        }else{
            return TYPE_NORMORE;
        }
    }



    public void setHeaderView(View view){
        this.headerView = view;
        notifyItemInserted(0);
    }


    public void setFooterView(View view){
        this.footerView = view;
        notifyItemInserted(getItemCount()-1);
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_ItemTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            if(itemView == headerView)
                return;
            if(itemView == footerView)
                return;

             tv_ItemTitle = itemView.findViewById(R.id.tv_Item);
        }
    }
}
