package cn.xfn.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<MyEntity> myEntityList = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        myEntityList.clear();
        //添加第一遍数据
        MyEntity myEntity = new MyEntity(R.drawable.img1, "title1", "content1");
        MyEntity myEntity2 = new MyEntity(R.drawable.img2, "title2", "content2");
        MyEntity myEntity3 = new MyEntity(R.drawable.img3, "title3", "content3");
        MyEntity myEntity4 = new MyEntity(R.drawable.img4, "title4", "content4");
        MyEntity myEntity5 = new MyEntity(R.drawable.img5, "title5", "content5");
        MyEntity myEntity6 = new MyEntity(R.drawable.img6, "title6", "content6");
        MyEntity myEntity7 = new MyEntity(R.drawable.img7, "title7", "content7");
        myEntityList.add(myEntity);
        myEntityList.add(myEntity2);
        myEntityList.add(myEntity3);
        myEntityList.add(myEntity4);
        myEntityList.add(myEntity5);
        myEntityList.add(myEntity6);
        myEntityList.add(myEntity7);

        //添加第二遍遍数据
        MyEntity myEntity8 = new MyEntity(R.drawable.img1, "title8", "content8");
        MyEntity myEntity9 = new MyEntity(R.drawable.img2, "title9", "content9");
        MyEntity myEntity10 = new MyEntity(R.drawable.img3, "title10", "content10");
        MyEntity myEntity11 = new MyEntity(R.drawable.img4, "title11", "content11");
        MyEntity myEntity12 = new MyEntity(R.drawable.img5, "title12", "content12");
        MyEntity myEntity13 = new MyEntity(R.drawable.img6, "title13", "content13");
        MyEntity myEntity14 = new MyEntity(R.drawable.img7, "title14", "content14");
        myEntityList.add(myEntity8);
        myEntityList.add(myEntity9);
        myEntityList.add(myEntity10);
        myEntityList.add(myEntity11);
        myEntityList.add(myEntity12);
        myEntityList.add(myEntity13);
        myEntityList.add(myEntity14);
        
        myAdapter.setMyEntityList(myEntityList);
    }

    private void initView() {
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(this, myEntityList);
        recyclerView.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if (myEntityList!=null&&myEntityList.size()>0){
                    if (!myEntityList.get(position).isClick()){
                        //如果定义的变量为false,也就是没点赞
                        myEntityList.get(position).setClick(true);
                    }else {
                        //如果定义的变量为false,也就是点赞
                        myEntityList.get(position).setClick(false);
                    }
                    myAdapter.setMyEntityList(myEntityList);
                }
            }
        });
    }
}