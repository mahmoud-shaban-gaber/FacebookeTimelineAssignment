package com.amazone.myfirstapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
                                                              //هنا بديله ال ViewHolder ال انا عملنه عشان يقدر يكريت ال items و ي adapt ويحط الداتا فيه ويضبط كل حاجه
public class PostsRecyclerAdapter extends RecyclerView.Adapter<PostsRecyclerAdapter.ViewHolder>{
    List<PostDM> postsList;

                        //بياخد ال list ال فيها ال posts data ف constructor بتاعه عشان يعملها adaptation ويحطها ف ال view
    PostsRecyclerAdapter(List<PostDM> postsList) {
        this.postsList = postsList;
    }

    @NonNull
    @Override                            //parent--->my recyclarView, viewType--->if RV has more than type of views or items
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View itemView=inflater.inflate(R.layout.activity_post,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PostDM postDM =postsList.get(position);
        holder.bind(postDM);
        holder.image.setOnClickListener(v -> {
            onImageClickListener.onItemClick(postDM,position);
        });

    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }


    public void setOnImageClickListener(OnItemClickListener onImageClickListener) {
        this.onImageClickListener = onImageClickListener;
    }


    OnItemClickListener onImageClickListener;


    interface OnItemClickListener{
        void onItemClick(PostDM postDM, int position);
    }
static class ViewHolder extends RecyclerView.ViewHolder{
      TextView acountName;
      ImageView profileIcon;
      ImageView shareIcon;
      TextView date;
      ImageView audience;
      TextView caption;
      ImageView image;
      TextView likesNumber;
      TextView sharesNumber;

      ImageView emptyLike;
      ViewHolder(View postView){
          super(postView);
          profileIcon=postView.findViewById(R.id.profile_icon_imv);
          shareIcon=postView.findViewById(R.id.shareicon_imv);
          acountName=postView.findViewById(R.id.acount_name_tv);
          date=postView.findViewById(R.id.posting_time_tv);
          audience=postView.findViewById(R.id.audience_imv);
          caption=postView.findViewById(R.id.caption_tv);
          image=postView.findViewById(R.id.post_imv);
          likesNumber=postView.findViewById(R.id.likes_number_tv);
          sharesNumber=postView.findViewById(R.id.shares_number_tv);
          emptyLike =postView.findViewById(R.id.empty_like_imv);
      }

      void bind(PostDM postDM){
          profileIcon.setImageResource(postDM.profileIconImageResourse);
          shareIcon.setImageResource(postDM.profileIconImageResourse);
          acountName.setText(postDM.acountName);
          date.setText(postDM.date);
          audience.setImageResource(postDM.audience);
          caption.setText(postDM.caption);
          image.setImageResource(postDM.postImageRes);
          likesNumber.setText(postDM.likesNumber);
          sharesNumber.setText(postDM.sharesNumber);
      }

    }

}

