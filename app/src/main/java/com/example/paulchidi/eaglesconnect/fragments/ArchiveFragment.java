package com.example.paulchidi.eaglesconnect.fragments;


        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.v4.app.ListFragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

        import com.example.paulchidi.eaglesconnect.R;
        import com.example.paulchidi.eaglesconnect.activities.WebViewActivity;


/**
 * A simple {@link } subclass.
 */
public class ArchiveFragment extends ListFragment {


    public ArchiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_archive, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.messages, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if (position == 0) {
            Intent intent = new Intent(getActivity(), WebViewActivity.class);
            intent.setData(Uri.parse("https://www.youtube.com/results?search_query=shiloh+messages"));
            startActivity(intent);
        }
        if (position == 1) {
            Intent intent = new Intent(getActivity(), WebViewActivity.class);
            intent.setData(Uri.parse("https://www.youtube.com/results?search_query=covenant+hour+of+prayer"));
            startActivity(intent);
        }
        if (position == 2) {
            Intent intent = new Intent(getActivity(), WebViewActivity.class);
            intent.setData(Uri.parse("https://www.youtube.com/results?search_query=winners+chapel+sunday+services"));
            startActivity(intent);
        }
        if (position == 3) {
            Intent intent = new Intent(getActivity(), WebViewActivity.class);
            intent.setData(Uri.parse("http://stackoverflow.com/"));
            startActivity(intent);
        }
        if (position == 4) {
            Intent intent = new Intent(getActivity(), WebViewActivity.class);
            intent.setData(Uri.parse("http://stackoverflow.com/"));
            startActivity(intent);
        }
        if (position == 5) {
            Intent intent = new Intent(getActivity(), WebViewActivity.class);
            intent.setData(Uri.parse("http://stackoverflow.com/"));
            startActivity(intent);
        }


    }
}