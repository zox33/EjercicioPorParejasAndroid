package com.vemiranda.youtube;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vemiranda.youtube.VideoFragment.OnListFragmentInteractionListener;
import com.vemiranda.youtube.dummy.DummyContent.DummyItem;

import java.util.List;

public class MyVideoRecyclerViewAdapter extends RecyclerView.Adapter<MyVideoRecyclerViewAdapter.ViewHolder> {

    private final List<Video> mValues;
    private Context ctx;
    private int layout;


    public MyVideoRecyclerViewAdapter(Context ctx, int layout, List<Video> objects) {
        this.ctx = ctx;
        this.layout = layout;
        mValues = objects;
    }

    @Override
    public MyVideoRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_video, parent, false);
        return new MyVideoRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyVideoRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.tvTitulo.setText(holder.mItem.getTitulo());
        holder.tvUsuario.setText(holder.mItem.getUsuario());
        holder.tvVisualizaciones.setText(holder.mItem.getVisualizaciones());
        holder.tvDuracion.setText(holder.mItem.getDuracion());

        Glide.with(ctx)
                .load(holder.mItem.getUrlPhoto())
                .centerCrop()
                .into(holder.ivFoto);

            Glide.with(ctx)
            .load(holder.mItem.getPhotoUsuario())
            .centerCrop()
                .into(holder.ivFotoUsuario);
}

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView ivFoto;
        public final ImageView ivFotoUsuario;
        public final TextView tvTitulo;
        public final TextView tvUsuario;
        public final TextView tvVisualizaciones;
        public final TextView tvDuracion;
        public Video mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ivFoto = view.findViewById(R.id.imageViewFoto);
            tvTitulo = view.findViewById(R.id.textViewTitulo);
            tvUsuario = view.findViewById(R.id.textViewUsuario);
            ivFotoUsuario = view.findViewById(R.id.textViewUsuario);
            tvVisualizaciones = view.findViewById(R.id.textViewVisualizaciones);
            tvDuracion = view.findViewById(R.id.textViewDuracion);
        }
    }
}
