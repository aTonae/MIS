package mis.oblabs.com.mis.dialog.selectors;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;


import java.util.ArrayList;
import java.util.List;

import mis.oblabs.com.mis.R;
import mis.oblabs.com.mis.models.ModelAttendance;
import mis.oblabs.com.mis.models.ModelAttendanceType;
import mis.oblabs.com.mis.models.ModelDateRange;
import mis.oblabs.com.mis.models.ModelState;
import mis.oblabs.com.mis.network.ApiRestAdapter;
import mis.oblabs.com.mis.utils.Helper;
import mis.oblabs.com.mis.utils.SelectCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ato on 16/03/17.
 */

public class SelectItem2 extends DialogFragment {



    SelectCallback callback;

    public void setCallback(SelectCallback callback) {
        this.callback = callback;
    }

    ListView listView;
    ProgressBar progressBar;
    ArrayAdapter<String> arrayAdapter;
    
    int selectCode;

    List<Object> fetchedData;




    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.d_select_item , null);
        builder.setView(view);
        listView = (ListView)view.findViewById(R.id.listview);
        progressBar = (ProgressBar)view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                loadData();
//            }
//        },30);
        loadData();
        return builder.create();

    }

    private AdapterView.OnItemClickListener listItemClicked(final Object[] body) {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String strName = arrayAdapter.getItem(position);
                callback.selectedItemName(strName);
                if(selectCode !=0) {
//                    Helper.showToast(getContext() ,fetchedData.get(position).getState_Idno() );
                    switch (selectCode){
                        case 8811:{
                            callback.selectedItemId(((ModelState)body[position]).getState_Idno());

                            break;
                        }
                        //get date ranges
                        case 8812:{
                            callback.selectedItemId(((ModelDateRange)body[position]).getId());

                            break;
                        }
                        //get attendance type
                        case 8813:{
                            callback.selectedItemId(((ModelAttendanceType)body[position]).getId());

                            break;
                        }
                        default: {
                            break;
                        }
                    }
                }
                dismiss();
            }
        };
    }

    private void loadData() {
        
        
        switch (selectCode){
            //get all the state data
            case 8811:{
                getStatesData();
                break;
            }
            //get date ranges
            case 8812:{
                getDateRange();
                break;
            }
            //get attendance type
            case 8813:{
                getAttendanceType();
                break;
            }
            //get all expenses type
            case 8814:{
                getExpenseType();
                break;
            }
            default: {
                getDummyData();
                break;
            }
        }
    }

    private void getExpenseType() {
    }

    private void getAttendanceType() {



        ModelAttendanceType model1 = new ModelAttendanceType("1" , "Present");
        ModelAttendanceType model2 = new ModelAttendanceType("2" , "Absent");

        List<ModelAttendanceType>  data = new ArrayList<>();
        data.add(model1);
        data.add(model2);

        arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.select_dialog_singlechoice);

        listView.setOnItemClickListener(listItemClicked(data.toArray()));

            arrayAdapter.add("Present");
        arrayAdapter.add("Absent");




//
        progressBar.setVisibility(View.INVISIBLE);


        listView.setAdapter(arrayAdapter);

    }


    private void getDummyData() {

        arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.select_dialog_singlechoice);
        arrayAdapter.add("Data 1");
        arrayAdapter.add("Data 2");
        arrayAdapter.add("Data 3");
        arrayAdapter.add("Data 4");
        arrayAdapter.add("Data 5");

        progressBar.setVisibility(View.INVISIBLE);
        listView.setAdapter(arrayAdapter);



    }

    private void getDateRange() {

        Call<List<ModelDateRange>> call = new ApiRestAdapter().getDateRange();

        call.enqueue(new Callback<List<ModelDateRange>>() {
            @Override
            public void onResponse(Call<List<ModelDateRange>> call, Response<List<ModelDateRange>> response) {
                listView.setOnItemClickListener(listItemClicked(response.body().toArray()));

                progressBar.setVisibility(View.INVISIBLE);

                if(response.code() ==200){



//                    fetchedData = response.body();
                    arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.select_dialog_singlechoice);

                    for (ModelDateRange range: response.body()) {

                        arrayAdapter.add(range.getDateRange());


                    }

//

                    listView.setAdapter(arrayAdapter);




                }else{
                    Helper.showToast(getContext() , "Try Again");

                }

            }

            @Override
            public void onFailure(Call<List<ModelDateRange>> call, Throwable t) {

            }
        });

    }

    private void getStatesData() {


        Call<List<ModelState>> call = new ApiRestAdapter().getSates();
        
        call.enqueue(new Callback<List<ModelState>>() {
            @Override
            public void onResponse(Call<List<ModelState>> call, Response<List<ModelState>> response) {
                listView.setOnItemClickListener(listItemClicked(response.body().toArray()));

                progressBar.setVisibility(View.INVISIBLE);

                if(response.code() ==200){

//                    fetchedData = response.body();
                    arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.select_dialog_singlechoice);

                    for (ModelState state: response.body()) {

                        arrayAdapter.add(state.getState_Name());

                        
                    }

//

                    listView.setAdapter(arrayAdapter);
                    
                    
                    
                    
                }else{
                    Helper.showToast(getContext() , "Try Again");

                }
            }

            @Override
            public void onFailure(Call<List<ModelState>> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);

                Helper.showToast(getContext() , "Failed : "+t.getMessage());
            }
        });
    }

    @Override
    public void onPause() {
        dismiss();
        super.onPause();
    }
    
    public void selectItemCode(int code){
        
        selectCode = code;
        
    }



}
