package org.androidtown.callbackexam;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class ColorListFragment extends ListFragment {
    private OnColorSelectedListener mListener;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<String> colorList = Arrays.asList("Red", "Green", "Blue");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, colorList);
        setListAdapter(adapter);
    }

    interface OnColorSelectedListener {
        void onColorSelected(int color);
    }

    // 일반적인 뷰와 같은 이벤트 리스너 연결방법
    public void setOnColorSelectedListener(OnColorSelectedListener listener) {
        mListener = listener;
    }

    // 이벤트 리스너 구현을 반드시 해야할 때
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnColorSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(((Activity) context).getLocalClassName()+" 는 OnColorSelectedListener를 구현해야 합니다.");
        }
    }

    // ListFragment가 제공하는 리스트 항목을 클릭했을 때 호출되는 콜백 메서드
    /*
    * 클릭된 리스트 뷰에 설정된 getAdapter()로 어댑터를 얻고 각 위치의 아이템을 getItem()으로 얻어온다.
    * */
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) l.getAdapter();
        String colorString = adapter.getItem(position);
        int color = Color.RED;
        switch (colorString) {
            case "Red":
                color = Color.RED;
                break;
            case "Green":
                color = Color.GREEN;
                break;
            case "Blue":
                color = Color.BLUE;
                break;
        }

        if (mListener != null) {
            mListener.onColorSelected(color);
        }
    }
}
