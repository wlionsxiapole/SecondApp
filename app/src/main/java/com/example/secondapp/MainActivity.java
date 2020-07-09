package com.example.secondapp;


import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.view.KeyEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;




public class MainActivity extends AppCompatActivity {
    private ListView Lv = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lv = (ListView) findViewById(R.id.Lv);

        final String[] name = new String[] { "1号", "2号", "3号", "4号" };
        final String[] message = new String[] {
                "张钧甯1号",
                "张钧甯2号",
                "张钧甯3号",
                "张钧甯4号"};
        final int[] photo = new int[] { R.drawable.p1, R.drawable.p2, R.drawable.p3,R.drawable.p3 };
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("photo", R.drawable.p1);
        map1.put("name", name[0]);
        data.add(map1);

        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("photo", R.drawable.p2);
        map2.put("name", name[1]);
        data.add(map2);

        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("photo", R.drawable.p3);
        map3.put("name", name[2]);
        data.add(map3);

        Map<String, Object> map4 = new HashMap<String, Object>();
        map4.put("photo", R.drawable.p4);
        map4.put("name", name[3]);
        data.add(map4);

        Lv.setAdapter(new SimpleAdapter(this, data, R.layout.item,new String[] { "photo", "name" }, new int[] { R.id.iv,R.id.tv_name }));
        Lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {

                Bundle bundle = new Bundle();
                bundle.putInt("photo", photo[arg2]);
                bundle.putString("message", message[arg2]);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(MainActivity.this, MoveList.class);
                Log.i("message", message[arg2]);
                startActivity(intent);
            }
        });












//        final EditText editText=(EditText)findViewById(R.id.edit_text);
//        //监听回车键
//        editText.setOnEditorActionListener(new OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                Toast.makeText(MainActivity.this, String.valueOf(actionId), Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
//        //获取EditText文本
//        Button getValue=(Button)findViewById(R.id.btn_get_value);
//        getValue.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        //让EditText全选
//        Button all=(Button)findViewById(R.id.btn_all);
//        all.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                editText.selectAll();
//            }
//        });
//
//        //获取选中的文本
//        Button getSelect=(Button)findViewById(R.id.btn_get_select);
//        getSelect.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int start=editText.getSelectionStart();
//                int end=editText.getSelectionEnd();
//                CharSequence selectText=editText.getText().subSequence(start, end);
//                Toast.makeText(MainActivity.this, selectText, Toast.LENGTH_SHORT).show();
//            }
//        });



            View view = getWindow().getDecorView();
            // 遍历要遍历的的父视图，并返回视图集合
            List<View> viewList = getAllChildViews(view);
            for (int i = 0; i < viewList.size(); i++) {
                View v = viewList.get(i);
                if (v != null) {
                    // 拦截监听触摸事件
                    v.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            switch (event.getAction()) {
                                case MotionEvent.ACTION_DOWN:
                                    break;
                                case MotionEvent.ACTION_MOVE:
                                    break;
                                case MotionEvent.ACTION_UP:
                                    break;
                            }
                            return false;
                        }
                    });
                }
            }

    }
    /**
     * 获取传入指定视图下的所有子视图
     *
     * @param view
     * @return
     */
    private List<View> getAllChildViews(View view) {
        List<View> allChildViews = new ArrayList<>();
        if (view != null && view instanceof ViewGroup) {
            ViewGroup vp = (ViewGroup) view;
            for (int i = 0; i < vp.getChildCount(); i++) {
                View viewChild = vp.getChildAt(i);
                // 添加视图
                allChildViews.add(viewChild);
                // 方法递归
                allChildViews.addAll(getAllChildViews(viewChild));
            }
        }
        return allChildViews;
    }


    /**
     * 交换两个索引
     * @param start 开始索引
     * @param end 结束索引
     */
    protected void switchIndex(int start, int end) {
        int temp=start;
        start=end;
        end=temp;
    }

}