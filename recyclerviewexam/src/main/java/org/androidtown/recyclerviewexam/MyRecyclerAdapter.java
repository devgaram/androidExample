package org.androidtown.recyclerviewexam;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {
    private final List<CardItem> mDataList;
    private MyRecyclerViewClickListener mListener;
    public MyRecyclerAdapter(List<CardItem> dataList) {
        Log.i("로그","생성자");
        mDataList = dataList;
    }
    // 최초에 레이아웃을 생성하고 뷰 홀더에 보관하는 부분
    // BaseAdapter의 getView() 메서드에서 currentView가 null일 때 작성하는 부분에 대응한다.
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("로그","oncreateviewholder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    // 뷰 홀더에 데이터를 설정하는 부분
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.i("로그","onbindviewholder"+position+",이전["+holder.title.getText().toString()+"]");
        CardItem item = mDataList.get(position);
        Log.i("로그","지금["+item.getTitle()+"]");
        holder.title.setText(item.getTitle());
        holder.contents.setText(item.getContents());
        //holder.pastPosition = position;

        if (mListener != null) {
            final int pos = position;
            holder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    mListener.onItemClicked(pos);
                }
            });
            holder.share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onShareButtonClicked(pos);
                }
            });
            holder.more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onLearnMoreButtonClicked(pos);
                }
            });
        }

    }

    // 아이템 수
    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    // 각각의 아이템의 레퍼런스를 저장할 뷰 홀더 클래스
    // 반드시 RecyclerView.ViewHolder를 상속해야 함.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView contents;
        Button share;
        Button more;
        //int pastPosition;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title_text);
            contents = (TextView) itemView.findViewById(R.id.contents_text);
            share = (Button) itemView.findViewById(R.id.share_button);
            more = (Button) itemView.findViewById(R.id.more_button);
        }

    }
    public void setOnClickListener(MyRecyclerViewClickListener listener) {
        mListener = listener;
    }

    public interface MyRecyclerViewClickListener {
        void onItemClicked(int position);

        void onShareButtonClicked(int position);

        void onLearnMoreButtonClicked(int position);
    }

    public void removeItem(int position) {
        mDataList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mDataList.size());
    }
    public void addItem(int position, CardItem item) {
        mDataList.add(position, item);
        notifyItemInserted(position);
        notifyItemRangeChanged(position, mDataList.size());
    }
}
