package com.joseterrero.amazon;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class MyProductoRecyclerViewAdapter extends RecyclerView.Adapter<MyProductoRecyclerViewAdapter.ViewHolder> {

    private final List<Producto> mValues;
    private Context ctx;
    private int layout;

    public MyProductoRecyclerViewAdapter(Context ctx, int layout, List<Producto> objects) {
        this.ctx = ctx;
        this.layout = layout;
        mValues = objects;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_producto, parent, false);
        return new ViewHolder(view, ivFoto, ivCheckPrime, tvTituloProductoSolicitado, tvTitulo, tvTienda, tvPrecio, tvPrime, tvFechaLlegada, tvEnvioGratis, tvDisponibilidad, tvComentario, tvVariantes, valoracion);
    }

    @Override
    public void onBindViewHolder(final MyProductoRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView ivFoto, ivCheckPrime;
        public final TextView tvTituloProductoSolicitado, tvTitulo, tvTienda, tvPrecio, tvPrime, tvFechaLlegada, tvEnvioGratis, tvDisponibilidad, tvComentario, tvVariantes;
        public final RatingBar valoracion;
        public Producto mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ivFoto = view.findViewById(R.id.);
            ivCheckPrime = view.findViewById(R.id.);
            tvTituloProductoSolicitado = view.findViewById(R.id.);
            tvTitulo = view.findViewById(R.id.);
            tvTienda = view.findViewById(R.id.);
            tvPrecio = view.findViewById(R.id.);
            tvPrime = view.findViewById(R.id.);
            tvFechaLlegada = view.findViewById(R.id.);
            tvEnvioGratis = view.findViewById(R.id.);
            tvDisponibilidad = view.findViewById(R.id.);
            tvComentario = view.findViewById(R.id.);
            tvVariantes = view.findViewById(R.id.);
            valoracion = view.findViewById(R.id.);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
