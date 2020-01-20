package com.joseterrero.amazon;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joseterrero.amazon.dummy.DummyContent;
import com.joseterrero.amazon.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

public class ProductoFragment extends Fragment {

    // TODO: Customize parameters
    private int mColumnCount = 1;
    private IAmazonListener mListener;
    private MyProductoRecyclerViewAdapter adapter;
    private List<Producto> productosList;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ProductoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_producto_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            productosList = new ArrayList<>();

            productosList.add(new Producto("Amazon's Choice", "Amazon Echo (2º generación) - Altavoz inteligente con Alexa," +
                    "tela de color antracita", "de Amazon", "EUR 99,99", "prime", "Recibelo el jueves, 29 noviembre",
                    "Envio GRATIS", "disponible", 4, 180, "Ver otras variantes",
                    "https://www.electrocosto.com/524404-product_category/amazon-alexa-echo-plus-generacion-2-negro.jpg"));
            productosList.add(new Producto("Amazon's Choice", "Amazon Echo (2º generación) - Altavoz inteligente con Alexa," +
                    "tela de color antracita", "de Amazon", "EUR 99,99", "prime", "Recibelo el jueves, 29 noviembre",
                    "Envio GRATIS", "disponible", 4, 180, "Ver otras variantes",
                    "https://www.electrocosto.com/524404-product_category/amazon-alexa-echo-plus-generacion-2-negro.jpg"));
            productosList.add(new Producto("Amazon's Choice", "Amazon Echo (2º generación) - Altavoz inteligente con Alexa," +
                    "tela de color antracita", "de Amazon", "EUR 99,99", "prime", "Recibelo el jueves, 29 noviembre",
                    "Envio GRATIS","disponible", 4, 180, "Ver otras variantes",
                    "https://www.electrocosto.com/524404-product_category/amazon-alexa-echo-plus-generacion-2-negro.jpg"));

            adapter = new MyProductoRecyclerViewAdapter(
                    context, R.layout.fragment_producto, productosList
            );

            recyclerView.setAdapter(adapter);

        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IAmazonListener) {
            mListener = (IAmazonListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
