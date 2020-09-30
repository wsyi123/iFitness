package com.siyi.fitness.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;


public class ListViewWithScrollView extends ListView {
    public ListViewWithScrollView(Context context) {
        super(context);
    }

    public ListViewWithScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListViewWithScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //important
        //MeasureSpec.AT_MOST = wrap_content
        //Integer.MAX_VALUE >> 2 是使用最大值的意思,也就表示的无边界模式
        //Integer.MAX_VALUE >> 2 父布局能够给他提供的大小
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
