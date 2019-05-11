package com.targetcompetitions.retrofittutorial;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private List<Post> posts;

    public PostAdapter(List<Post> posts){
        this.posts = posts;
    }


    @Override
    public int getItemCount(){
        return posts.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        CardView view = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.post_layout, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        CardView view = holder.getView();
        TextView postNumber = view.findViewById(R.id.postNumber);
        TextView titleView = view.findViewById(R.id.titleView);
        ImageView photoView = view.findViewById(R.id.photoView);
        TextView bodyView = view.findViewById(R.id.bodyView);

        Post post = posts.get(position);
        postNumber.setText(String.valueOf(post.getId()));
        titleView.setText(post.getTitle());
        bodyView.setText(post.getBody());

        String imageName = "pic" + String.valueOf(post.getUserId());
        int resId = getResId(imageName, R.drawable.class );
        photoView.setImageResource(resId);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private CardView view;

        public ViewHolder(CardView cardView){
            super(cardView);
            view = cardView;
        }

        public CardView getView(){
            return this.view;
        }
    }

    private static int getResId(String resName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
