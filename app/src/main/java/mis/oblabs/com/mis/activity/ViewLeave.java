package mis.oblabs.com.mis.activity;


import android.content.Context;
import android.widget.Toast;

import java.util.List;

import mis.oblabs.com.mis.R;
import mis.oblabs.com.mis.adapter.LALeaveRequest;
import mis.oblabs.com.mis.fragment.FragmentLeaveEdit;
import mis.oblabs.com.mis.models.ModelLeave;
import mis.oblabs.com.mis.network.ApiRestAdapter;
import mis.oblabs.com.mis.utils.Helper;
import mis.oblabs.com.mis.utils.SharedPreference;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewLeave extends BaseListView {


    LALeaveRequest adapter;


    public Context getContext(){

        return this;
    }




    @Override
    public void itemClicked(int position) {
        Toast.makeText(getContext() , "Item Clicked : "+position , Toast.LENGTH_SHORT).show();


        ModelLeave data = (ModelLeave)    adapter.getListItemCount().get(position);
        getSupportFragmentManager().beginTransaction().add(R.id.content , new FragmentLeaveEdit().newInstance(data)).addToBackStack("leave edit").commit();
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


        adapter = new LALeaveRequest(getContext() , R.layout.e_leave_request);


        loadData();
    }




    private void loadData() {

        String userId = new SharedPreference().getValueWithKey(getContext() , "userId");
        String email = new SharedPreference().getValueWithKey(getContext() , "email");

        String startDate = "15-08-2017";
        String endDate = "26-11-2017";
        String leaveStatus = "1";
        email = "shersingh.rathore@cogxim.com";
        userId = "106";


        Call<List<ModelLeave>> call = new ApiRestAdapter().getEmpLeave(startDate,endDate,leaveStatus , email , userId);
//        layoutLoad.setVisibility(View.VISIBLE);
        Helper.showLoading(getContext() , "Loading Leave Requests...");


        call.enqueue(new Callback<List<ModelLeave>>() {


            @Override
            public void onResponse(Call<List<ModelLeave>> call, Response<List<ModelLeave>> response) {
//                layoutLoad.setVisibility(View.GONE);
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
            public void onFailure(Call<List<ModelLeave>> call, Throwable t) {
//                layoutLoad.setVisibility(View.GONE);

                Helper.hideLoading();

                Helper.showToast(getContext() , "Failed : "+t.getMessage());

            }
        });
    }







}
