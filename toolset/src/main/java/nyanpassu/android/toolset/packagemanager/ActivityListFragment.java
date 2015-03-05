package nyanpassu.android.toolset.packagemanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import nyanpassu.android.toolset.R;

/**
 * Created by 丢猫 on 2015/3/3.
 */
public class ActivityListFragment extends Fragment {

    public static final String ACTION = "action";
    public static final String CATEGORY = "category";

    List<String> mLabelList;
    List<Intent> mIntentList;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ListView view = (ListView) inflater.inflate(R.layout.fragment_activities_list, container, false);

        GetActivities.Result result = GetActivities.getPackageActivity(
                getActivity(),
                getArguments().getString(ACTION),
                getArguments().getString(CATEGORY),
                getActivity().getPackageName());
        mLabelList = result.activitiesLabelList;
        mIntentList = result.activitiesIntentList;

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.item_activities_list, mLabelList);
        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = mIntentList.get(position);
                getActivity().startActivity(intent);
            }
        });
        view.setAdapter(adapter);

        return view;
    }
}
