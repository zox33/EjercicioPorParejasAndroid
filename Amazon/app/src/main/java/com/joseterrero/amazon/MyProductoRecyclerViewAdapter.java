package com.joseterrero.amazon;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyProductoRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.tvTituloProductoSolicitado.setText(holder.mItem.getTituloProductoSolicitado());
        holder.tvTitulo.setText(holder.mItem.getTitulo());
        holder.tvTienda.setText(holder.mItem.getNombreTienda());
        holder.tvPrecio.setText(holder.mItem.getPrecio());
        holder.tvPrime.setText(holder.mItem.getNombreServicioPremium());
        holder.tvFechaLlegada.setText(holder.mItem.getFechaRecibo());
        holder.tvEnvioGratis.setText(holder.mItem.getServicioEnvio());
        holder.tvDisponibilidad.setText(holder.mItem.getDisponibilidad());
        holder.tvComentario.setText("("+holder.mItem.getCantidadComentarios()+")");
        holder.tvVariantes.setText(holder.mItem.getVariantesProductos());
        holder.valoracion.setRating(holder.mItem.getValoracion());

        Glide.with(ctx)
                .load(holder.mItem.getUrlPhoto())
                .into(holder.ivFoto);
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
            ivFoto = view.findViewById(R.id.imageViewFoto);
            ivCheckPrime = view.findViewById(R.id.imageViewCheckPrime);
            tvTituloProductoSolicitado = view.findViewById(R.id.textViewTituloProductoSolicitado);
            tvTitulo = view.findViewById(R.id.textViewTitulo);
            tvTienda = view.findViewById(R.id.textViewTienda);
            tvPrecio = view.findViewById(R.id.textViewPrecio);
            tvPrime = view.findViewById(R.id.textViewPrime);
            tvFechaLlegada = view.findViewById(R.id.textViewFechaLlegada);
            tvEnvioGratis = view.findViewById(R.id.textViewEnvioGratis);
            tvDisponibilidad = view.findViewById(R.id.textViewDisponibilidadEnvioGratis);
            tvComentario = view.findViewById(R.id.textViewComentarios);
            tvVariantes = view.findViewById(R.id.textViewVariantes);
            valoracion = view.findViewById(R.id.ratingBarValoracion);
        }
    }
}
