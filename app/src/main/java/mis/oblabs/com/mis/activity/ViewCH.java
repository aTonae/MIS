package mis.oblabs.com.mis.activity;


import android.content.Context;
import android.widget.Toast;

import java.util.List;

import mis.oblabs.com.mis.R;
import mis.oblabs.com.mis.adapter.LALeaveRequest;
import mis.oblabs.com.mis.adapter.LAch;
import mis.oblabs.com.mis.models.ModelLeave;
import mis.oblabs.com.mis.models.ObjectCH;
import mis.oblabs.com.mis.network.ApiRestAdapter;
import mis.oblabs.com.mis.utils.Helper;
import mis.oblabs.com.mis.utils.SharedPreference;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewCH extends BaseListView {


    LAch adapter;


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

//        getFragmentManager().beginTransaction().add(R.id.container , new LeaveRequestF()).addToBackStack("leave form").commit();
    }

    @Override
    public void filterClicked() {
        Toast.makeText(getContext() , "Filter Clicked" , Toast.LENGTH_SHORT).show();

//        new LeaveRequest().show(getFragmentManager() , "filter");
    }

    @Override
    public void initAdapter() {

        headerTitle.setText("Leave Requests");


        adapter = new LAch(getContext() , R.layout.e_ch_request);


        loadData();
    }




    private void loadData() {

        String empId = new SharedPreference().getValueWithKey(getContext() , "userId");
        String empEmail = new SharedPreference().getValueWithKey(getContext() , "email");

        String submitDate = "01-04-2017";
        String dateTo = "21-11-2017";
        String status = "";
        String yearId = "6";
        empEmail = "";
        empId = "88";

        Call<List<ObjectCH>> data  = new ApiRestAdapter().getChList(submitDate , dateTo , empId , empEmail , status , yearId);


        Helper.showLoading(getContext() , "Loading CH Requests...");

        data.enqueue(new Callback<List<ObjectCH>>() {
            @Override
            public void onResponse(Call<List<ObjectCH>> call, Response<List<ObjectCH>> response) {
                Helper.hideLoading();


                if(response.code() == 200) {
                    Helper.showToast(getContext(), "Success");

                    adapter.setListItemCount(response.body());
                    listView.setAdapter(adapter);
                }else{
                    Helper.showToast(getContext(), "Try Again");

                }

            }

            @Override
            public void onFailure(Call<List<ObjectCH>> call, Throwable t) {

                Helper.hideLoading();

                Helper.showToast(getContext() , "Failed : "+t.getMessage());

            }
        });






    }







}
