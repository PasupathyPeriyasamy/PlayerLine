package com.example.playerline.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playerline.R;
import com.example.playerline.domain.api.NewsApi;
import com.example.playerline.model.NewsList;
import com.example.playerline.ui.adapter.NewsListAdapter;
import com.example.playerline.utils.CustomDialogs;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class AllNewsFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private NewsListAdapter newsListAdapter;
    private NewsList newsList = new NewsList();
    private KProgressHUD pDialog;
    private NewsApi newsApi = new NewsApi();

    public AllNewsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_main, container, false);
        initView(view);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_UP
                    && keyCode == KeyEvent.KEYCODE_BACK) {
            }
            return true;
        });
        return view;
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getActivity().getDrawable(R.drawable.recycler_view_divider));

        recyclerView.addItemDecoration(dividerItemDecoration);
        newsListAdapter = new NewsListAdapter(getActivity(), this, newsList);
        recyclerView.setAdapter(newsListAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            // for this tutorial, this is the ONLY method that we need, ignore the rest
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    if (!recyclerView.canScrollVertically(RecyclerView.FOCUS_DOWN)) {
                        loadMore();
                    }
                }
            }
        });
        new NewsListLoader(0).execute();
    }

    private void loadMore() {
        new NewsListLoader(1).execute();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public class NewsListLoader extends AsyncTask<String, String, String> {

        String status = null;
        int pageNo = 0;

        public NewsListLoader(int pageNo) {
            this.pageNo = pageNo;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = CustomDialogs.getProgressDialog(getActivity(), "News", "Loading..", false);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                newsList = newsApi.getNewsList(pageNo);
            } catch (Exception e) {
                e.printStackTrace();
                status = e.getMessage();
            }
            return status;
        }

        protected void onPostExecute(String status) {
            // dismiss the dialog once product deleted
            if (pDialog.isShowing()) {
                pDialog.dismiss();
            }
            if (newsList != null) {
                newsListAdapter.setNewsList(newsList);
            }
            if (status != null) {
                Toast.makeText(getActivity(), status, Toast.LENGTH_SHORT);
            }
        }
    }
}