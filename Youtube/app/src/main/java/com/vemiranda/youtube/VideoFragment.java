package com.vemiranda.youtube;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vemiranda.youtube.dummy.DummyContent;
import com.vemiranda.youtube.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

public class VideoFragment extends Fragment {

    // TODO: Customize parameters
    private int mColumnCount = 1;
    private IYoutubeListener mListener;
    private MyVideoRecyclerViewAdapter adapter;
    private List<Video> videosList;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public VideoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            videosList = new ArrayList<>();
            videosList.add(new Video("https://i.ytimg.com/vi/-mELletSqNk/maxresdefault.jpg",
                    "7 Second Challenge (ft Dan Howell) Tyler Oakley","Tyler Oakley","data:image/jpeg;base64,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",
                    "1M views","7.3min"));

            adapter = new MyVideoRecyclerViewAdapter(
                    context,
                    R.layout.fragment_video,
                    videosList);

            recyclerView.setAdapter(adapter);        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IYoutubeListener) {
            mListener = (IYoutubeListener) context;
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
