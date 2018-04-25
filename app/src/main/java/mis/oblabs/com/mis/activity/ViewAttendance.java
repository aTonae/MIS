package mis.oblabs.com.mis.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import java.util.Calendar;
import java.util.List;

import mis.oblabs.com.mis.R;
import mis.oblabs.com.mis.adapter.LAAttendance;
import mis.oblabs.com.mis.dialog.filter.FilterAttendance;
import mis.oblabs.com.mis.models.ModelAttendance;
import mis.oblabs.com.mis.network.ApiRestAdapter;
import mis.oblabs.com.mis.utils.Helper;
import mis.oblabs.com.mis.utils.SelectArrayCallback;
import mis.oblabs.com.mis.utils.SharedPreference;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ViewAttendance extends BaseListView {



    LAAttendance adapter;

    String URL_MONTH = "";
    String URL_YEAR = "";


    public Context getContext(){
        return this;
    }
    @Override
    public void itemClicked(int position) {
        Toast.makeText(getContext() , "Item Clicked : "+position , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addClicked() {
        Toast.makeText(getContext() , "Add Clicked" , Toast.LENGTH_SHORT).show();
    }


    @Override
    public void search(View view) {
        FilterAttendance filter = new FilterAttendance();
        filter.setCallback(new SelectArrayCallback() {
            @Override
            public void selectedItem(String... items) {
               Helper.showToast(getContext() , "Month : "+items[0]);

               // Helper.showToast(getContext() , "Year : "+items[1]);

                URL_MONTH =items[0];
                URL_YEAR = items[1];

                loadData();



            }
        });
        filter.show(getSupportFragmentManager() , "filter");
    }



    @Override
    public void initAdapter() {

        listView.setDividerHeight(0);
        adapter = new LAAttendance(getContext() , R.layout.e_attendance);
//        listView.setAdapter(adapter);

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) +1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        URL_MONTH = String.valueOf(month);
        URL_YEAR= String.valueOf(year);
        Log.d("View Attendance" , "Month is : "+month);

        loadData();
    }

    @Override
    public void setHeaderTitle() {

        headerTitle.setText("Attendance Details");
    }

    private void loadData() {


        // layoutLoad.setVisibility(View.VISIBLE);

        Helper.showLoading(getContext() , "Loading Attendance...");


//        String userId = new SharedPreference().getValueWithKey(getContext() , "userId");
        String userId = "1";


        Call<List<ModelAttendance>> getAttendance =  new ApiRestAdapter().attendance(URL_MONTH, URL_YEAR , userId);

        getAttendance.enqueue(new Callback<List<ModelAttendance>>() {



            @Override
            public void onResponse(Call<List<ModelAttendance>> call, Response<List<ModelAttendance>> response) {

//                layoutLoad.setVisibility(View.GONE);
                Helper.hideLoading();
                if(response.code() == 200){


                    Helper.showToast(getContext() , "Success");
                    adapter.setListItemCount(response.body());
                    listView.setAdapter(adapter);


                }else if(response.code()==500){
                    Helper.showToast(getContext() , "No Record Found");

                }else{
                    Helper.showToast(getContext() , "Invalid Inputs");

                }

            }

            @Override
            public void onFailure(Call<List<ModelAttendance>> call, Throwable t) {

//                layoutLoad.setVisibility(View.GONE);
                Helper.hideLoading();
                Helper.showToast(getContext() , "Failed : "+t.getMessage());

            }


        });



    }









}
