package text.mycheckdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import text.mycheckdemo.recyclerAdapter.BaseRecyclerAdapter;
import text.mycheckdemo.recyclerAdapter.PullUpScrollListener;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BaseRecyclerAdapter adapter;

    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);

        initData();
        adapter = new BaseRecyclerAdapter(list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        recyclerView.setOnScrollListener(new PullUpScrollListener(linearLayoutManager) {
            @Override
            public void onPullUpLoadMore(int currentPage) {
                loadMoreData();
                Log.e("OnScrolled","上啦加载更多.......");
            }

            @Override
            public void onPullDownLoadMore() {
                Log.e("OnScrolled","下啦刷新数据.......");
            }
        });

        setHeaderView();
        setFooterView();
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add("item"+i);
        }
    }

    private void loadMoreData(){
        for (int i =0; i < 10; i++){
            list.add("嘿，我是“上拉加载”生出来的"+i);
            adapter.notifyDataSetChanged();
        }
    }




    private void setHeaderView(){
        View headerview = LayoutInflater.from(this)
                .inflate(R.layout.header_view,recyclerView,false);
        adapter.setHeaderView(headerview);
    }


    private void setFooterView(){
        View footerView = LayoutInflater.from(this)
                .inflate(R.layout.footer_view,recyclerView,false);
        adapter.setFooterView(footerView);
    }
}
