package org.androidtown.recyclerviewexam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyRecyclerAdapter.MyRecyclerViewClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private MyRecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        //RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        List<CardItem> dataList = new ArrayList<>();
        dataList.add(new CardItem("이것은 첫번째 아이템", "안드로이드 보이라고 합니다."));
        dataList.add(new CardItem("이것은 두번째 아이템", "두줄 입력하자 \n 보이라고 합니다."));
        dataList.add(new CardItem("이것은 세번째 아이템", "세줄입력 ㄱㄱ \ndddddd\n"));
        dataList.add(new CardItem("이것은 네번째 아이템", "굿굿굿"));
        dataList.add(new CardItem("이것은 다섯번째 아이템", "야호~~~~~"));

        adapter = new MyRecyclerAdapter(dataList);
        adapter.setOnClickListener(this);

        DefaultItemAnimator animator = new DefaultItemAnimator();
        animator.setAddDuration(1000);
        animator.setRemoveDuration(1000);
        animator.setMoveDuration(1000);
        animator.setChangeDuration(1000);
        recyclerView.setItemAnimator(animator);

        DividerItemDecoration decoration = new DividerItemDecoration(this, ((LinearLayoutManager) layoutManager).getOrientation());
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClicked(int position) {
        Log.d(TAG,"onItemClicked: " + position);
    }

    @Override
    public void onShareButtonClicked(int position) {
        Log.d(TAG, "onShareButtonCliced: "+position);
        adapter.addItem(position, new CardItem("추가됨", "추가됨"));
    }

    @Override
    public void onLearnMoreButtonClicked(int position) {
        Log.d(TAG, "onLearnMoreButtonClicked: "+position);
        adapter.removeItem(position);
    }
}
