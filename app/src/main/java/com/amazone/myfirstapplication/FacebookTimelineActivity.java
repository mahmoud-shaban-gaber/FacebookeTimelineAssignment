package com.amazone.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FacebookTimelineActivity extends AppCompatActivity {
    RecyclerView postsRecycler;
    PostsRecyclerAdapter adapter;
    List<PostDM> postDMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_facebook_posts_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initRecycler();

    }

    private void initRecycler(){
        postsRecycler=findViewById(R.id.posts_rv);
        createTestPosts();
        adapter=new PostsRecyclerAdapter(postDMS);
        adapter.setOnImageClickListener((postDM, position) -> {
            intentToFullImage(postDM);
        });

        postsRecycler.setAdapter(adapter);
    }

    private void intentToFullImage(PostDM postDM) {
        Intent intent=new Intent(this, FullScreenImageActivity.class);
        intent.putExtra("image", postDM.postImageRes);
        startActivity(intent);
    }

    private void createTestPosts() {
        postDMS =new ArrayList<>();
        postDMS.add(new PostDM(R.drawable.yello,"unblast","2 hrs.",R.drawable.public_audience_ic, "Buckle up, because change is coming to WordPress",R.drawable.yello,"12","1 Share"));
        postDMS.add(new PostDM(R.drawable.zamalek_logo,"Zamalek SC","5 hrs.",R.drawable.public_audience_ic, "Our eternal love",R.drawable.zamalek_image,"12","1 Share"));
        postDMS.add(new PostDM(R.drawable.city_logo,"Manchester City","12 hrs.",R.drawable.friends_audience_ic, "family",R.drawable.city_team,"12","1 Share"));
        postDMS.add(new PostDM(R.drawable.madrid_logo,"Real Madrid C.F.","February 1 at 10:24 PM.",R.drawable.public_audience_ic, "\uD83E\uDDE1 ¡HALA MADRID! \uD83E\uDDE1",R.drawable.madrid_team,"12","1 Share"));
        postDMS.add(new PostDM(R.drawable.liver,"Liverpool FC","February 1 at 8:59 PM.",R.drawable.public_audience_ic, "Our legend",R.drawable.salah,"12","1 Share"));
        postDMS.add(new PostDM(R.drawable.yello,"unblast","2 hrs.",R.drawable.public_audience_ic, "Buckle up, because change is coming to WordPress",R.drawable.yello,"12","1 Share"));
        postDMS.add(new PostDM(R.drawable.zamalek_logo,"Zamalek SC","5 hrs.",R.drawable.public_audience_ic, "Our eternal love",R.drawable.zamalek_image,"12","1 Share"));
        postDMS.add(new PostDM(R.drawable.city_logo,"Manchester City","12 hrs.",R.drawable.friends_audience_ic, "family",R.drawable.city_team,"12","1 Share"));
        postDMS.add(new PostDM(R.drawable.liver,"Liverpool FC","February 1 at 8:59 PM.",R.drawable.public_audience_ic, "Our legend",R.drawable.salah,"12","1 Share"));
        postDMS.add(new PostDM(R.drawable.madrid_logo,"Real Madrid C.F.","February 1 at 10:24 PM.",R.drawable.public_audience_ic, "\uD83E\uDDE1 ¡HALA MADRID! \uD83E\uDDE1",R.drawable.madrid_team,"12","1 Share"));
        postDMS.add(new PostDM(R.drawable.top_shadow,"ahmed","5 hrs.",R.drawable.friends_audience_ic, "I'm here",R.drawable.yello,"12","1 Share"));
        postDMS.add(new PostDM(R.drawable.public_audience_ic,"mahmoud","2 hrs.",R.drawable.friends_audience_ic,"it's my birthday",R.drawable.top_shadow,"65","4 Share"));
        postDMS.add(new PostDM(R.drawable.public_audience_ic,"mostafa","12 hrs.",R.drawable.friends_audience_ic,"hi",R.drawable.ic_launcher_background,"105","2 Share"));
        postDMS.add(new PostDM(R.drawable.public_audience_ic,"Mahmoud Shaban","2 hrs.",R.drawable.friends_audience_ic,"mashallah",R.drawable.salah,"120","0 Share"));

    }

}