package com.douncoding.guaranteedanp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.douncoding.guaranteedanp.dto.Lesson;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LessonListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LessonListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LessonListFragment extends Fragment {
    public static final String TAG = LessonListFragment.class.getSimpleName();

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    RecyclerView mLessonListView;
    LinearLayoutManager mLayoutManager;
    LessonListAdapter mAdapter;

    public LessonListFragment() { }

    public static LessonListFragment newInstance(String param1, String param2) {
        LessonListFragment fragment = new LessonListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new LessonListAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lesson_list, container, false);

        mLessonListView = (RecyclerView)view.findViewById(R.id.lesson_list);
        mLessonListView.setLayoutManager(mLayoutManager);
        mLessonListView.setAdapter(mAdapter);

        generateDummyData();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
        void onNavigateToDetailView();
    }

    public void generateDummyData() {
        List<Lesson> dummy = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Lesson lesson = new Lesson();
            lesson.setName("Android Basic #1");
            dummy.add(lesson);
        }

        mAdapter.addItem(dummy);
    }



    class LessonListAdapter extends RecyclerView.Adapter<LessonListAdapter.ViewHolder> {

        ArrayList<Lesson> mDataset = new ArrayList<>();

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_lesson, parent, false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Lesson item = mDataset.get(position);

            holder.mNameText.setText(item.getName());
        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }

        public void addItem(List<Lesson> lessons) {
            mDataset.addAll(lessons);
            notifyDataSetChanged();
        }

        public class ViewHolder extends RecyclerView.ViewHolder
                implements View.OnClickListener {

            TextView mNameText;

            public ViewHolder(View itemView) {
                super(itemView);

                mNameText = (TextView)itemView.findViewById(R.id.lesson_name);

                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onNavigateToDetailView();
                }
            }
        }
    }
}
