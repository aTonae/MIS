package mis.oblabs.com.mis.dialog.selectors;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.Calendar;

import mis.oblabs.com.mis.R;
import mis.oblabs.com.mis.utils.SelectCallback;


/**
 * Created by ato on 16/03/17.
 */

public class SelectYear extends DialogFragment {



    SelectCallback callback;

    public void setCallback(SelectCallback callback) {
        this.callback = callback;
    }

    ListView listView;
    ProgressBar progressBar;
    ArrayAdapter<String> arrayAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.d_select_item , container , false);

        listView = (ListView)view.findViewById(R.id.listview);
        listView.setOnItemClickListener(listItemClicked());
        progressBar = (ProgressBar)view.findViewById(R.id.progressBar);
      //  progressBar.setVisibility(View.VISIBLE);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                loadData();
//            }
//        },3000);
        loadData();
        return view;
    }

    private AdapterView.OnItemClickListener listItemClicked() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String strName = arrayAdapter.getItem(position);
                callback.selectedItemName(strName);
                callback.selectedItemId(String.valueOf(position));
                dismiss();
            }
        };
    }

    private void loadData() {
        progressBar.setVisibility(View.INVISIBLE);
        arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.select_dialog_singlechoice);
        final Calendar c = Calendar.getInstance();

        int year = c.get(Calendar.YEAR);

        for (int i=0 ; i<12 ; i++){
            arrayAdapter.add(String.valueOf(year));
            year--;
        }




        listView.setAdapter(arrayAdapter);
    }

    @Override
    public void onPause() {
        dismiss();
        super.onPause();
    }
}
