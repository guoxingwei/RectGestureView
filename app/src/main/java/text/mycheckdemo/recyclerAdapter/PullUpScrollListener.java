package text.mycheckdemo.recyclerAdapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

/**
 * Created by jh on 2018/2/28.
 */

public abstract class PullUpScrollListener extends RecyclerView.OnScrollListener {

    private LinearLayoutManager linearLayoutManager;
    private int currentPage;

    public PullUpScrollListener(LinearLayoutManager linearLayoutManager) {
        this.linearLayoutManager = linearLayoutManager;
    }

    private int totalItemCount;   //总的item
    private int visibleItemCount; //屏幕可见的总数
    private int firstVisibleItem; //屏幕可见的第一个

    //主要用来存储上一个totalItemCount
    private int previousTotal = 0;

    private boolean loading = true;

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        if (!recyclerView.canScrollVertically(-1)) {
//            onScrolledToTop();
            Log.e("OnScrolled","滑动到顶部.......");
        } else if (!recyclerView.canScrollVertically(1)) {
//            onScrolledToBottom();
            Log.e("OnScrolled","滑动到底部.......");
        } else if (dy < 0) {
//            onScrolledUp();
//            Log.e("OnScrolled","向上滑动");
        } else if (dy > 0) {
//            onScrolledDown();
//            Log.e("OnScrolled","向下滑动");
        }


//        visibleItemCount = recyclerView.getChildCount();
//        totalItemCount = linearLayoutManager.getItemCount();
//        firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();
////        firstPostion = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
//
//        if(loading){
//
//            Log.e("OnScrolled","firstVisibleItem: " +firstVisibleItem);
//            Log.e("OnScrolled","totalPageCount:" +totalItemCount);
//            Log.e("OnScrolled", "visibleItemCount:" + visibleItemCount);
//
//            if(totalItemCount>previousTotal){
//                //数据加载结束
//                loading = false;
//                previousTotal = totalItemCount;
//            }
//        }
//
//        if (!loading && totalItemCount-visibleItemCount <= firstVisibleItem){
//            currentPage++;
//            onPullUpLoadMore(currentPage);
//            loading = true;
//        }

//        if(!loading && firstVisibleItem == recyclerView.get){
//            onPullDownLoadMore();
//            loading = true;
//        }
    }

    public abstract void onPullUpLoadMore(int currentPage);

    public abstract void onPullDownLoadMore();
}
