/**
 * Created by ajaythakur on 6/16/15.
 */
package mis.oblabs.com.mis.network;

import android.util.Log;



import java.util.List;

import mis.oblabs.com.mis.models.ModelAttendance;
import mis.oblabs.com.mis.models.ModelDateRange;
import mis.oblabs.com.mis.models.ModelLeave;
import mis.oblabs.com.mis.models.ModelRfaApproval;
import mis.oblabs.com.mis.models.ModelState;
import mis.oblabs.com.mis.models.ObjectAddRollout;
import mis.oblabs.com.mis.models.ObjectCH;
import mis.oblabs.com.mis.models.ObjectExpenses;
import mis.oblabs.com.mis.models.ObjectLogin;
import mis.oblabs.com.mis.models.ObjectSendLeaveRequest;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiRestAdapter {

    protected final String TAG = getClass().getSimpleName();
    protected Retrofit mRestAdapter;
    protected RestApi mApi;

    static final String MIS_URL ="http://apimisnew.cogxim.com/";

    public ApiRestAdapter() {








        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();






        mRestAdapter = new Retrofit.Builder()
                .baseUrl(MIS_URL)

               .addConverterFactory(GsonConverterFactory.create())
                .client(client)

                .build();
        mApi = mRestAdapter.create(RestApi.class); // create the interface

        Log.d(TAG, "MIS -- created");
    }










    //login
    public Call<List<ObjectLogin>> login(String username , String password ){
       return mApi.login(username , password  , "1");
    }


    //attendance
    public Call<List<ModelAttendance>> attendance(String month , String year , String user ){
        return mApi.attendanceList(month , year  , user);
    }

    //Employee for CH
    public Call<List<Object>> employeeCh(){
        return mApi.employeeForCh();
    }


    //Get States
    public Call<List<ModelState>> getSates(){
        return mApi.getStates();
    }

    //Get emp by dept
    public Call<List<Object>> getEmpByDept(String deptId , String srcId  ){
        return mApi.getEmpByDept(deptId , srcId );
    }

    //Get emp leave detail
    public Call<List<ModelLeave>> getEmpLeave(String startDate , String endDate , String leaveStatus , String email , String empId  ){
        return mApi.getEmpLeave(startDate , endDate , leaveStatus , email , empId );
    }


    //get rfa approval list
    public Call<List<ModelRfaApproval>> getRfaApprovalList(String dateTo , String dateFrom , String rolloutPlanId , String empId , String rolloutTypeId){
        return mApi.getRfaApprovalList(dateTo , dateFrom , rolloutPlanId , empId , rolloutTypeId);
    }

    public Call<List<ObjectAddRollout>> addRollout(String userId , String stateFrom , String cityFrom , String stateTo , String cityTo , String dateFrom , String dateTo, String remark , String totalDays , String onSiteDays , String yearId , String baseDays) {
        return mApi.addRollout(userId , stateFrom , cityFrom , stateTo , cityTo , dateFrom , dateTo , remark , totalDays , onSiteDays , yearId , baseDays);
    }

    public Call<List<ObjectSendLeaveRequest>> sendLeaveRequest(String userId , String submitDate , String leaveFrom , String leaveTo , String daysCount , String leaveType , String leaveReason , String isAccepted , String yearId) {

        return mApi.sendLeaveRequest(userId , submitDate , leaveFrom , leaveTo , daysCount , leaveType , leaveReason , isAccepted , yearId);
    }

    public Call<List<ObjectSendLeaveRequest>> updateLeaveRequest(String userId , String submitDate , String leaveFrom , String leaveTo , String daysCount , String leaveType , String leaveReason , String isAccepted , String yearId , String leaveId) {

        return mApi.updateLeaveRequest(userId , submitDate , leaveFrom , leaveTo , daysCount , leaveType , leaveReason , isAccepted , yearId , leaveId);
    }


    public Call<List<ModelDateRange>> getDateRange(){
        return mApi.getDateRange();
    }


    public Call<List<ObjectAddRollout>>  chrequest(String chidNo , String chDate , String submitDate , String empId , String yearId , String status , String remark){
        return  mApi.sendChRequest(chidNo , chDate , submitDate , empId , yearId , status , remark);
    }

//   // public Call<List<CodeDetail>> myCodes(String mobile){
//        return mApi.myCodes(mobile);
//    }

    public Call<List<ObjectExpenses>> optionExpense(){
        return mApi.optionExpense("0");
    }


    public Call<List<ObjectCH>> getChList(String submitDate , String dateTo , String empId , String empEmail , String status , String yearId){
        return mApi.getCHList(submitDate , dateTo , empId , empEmail , status , yearId);
    }








}


