package mis.oblabs.com.mis.network;








import java.util.List;

import mis.oblabs.com.mis.models.ModelAttendance;
import mis.oblabs.com.mis.models.ModelDateRange;
import mis.oblabs.com.mis.models.ModelLeave;
import mis.oblabs.com.mis.models.ModelRfaApproval;
import mis.oblabs.com.mis.models.ModelRolloutCU;
import mis.oblabs.com.mis.models.ModelState;
import mis.oblabs.com.mis.models.ObjectAddRollout;
import mis.oblabs.com.mis.models.ObjectCH;
import mis.oblabs.com.mis.models.ObjectExpense;
import mis.oblabs.com.mis.models.ObjectExpenses;
import mis.oblabs.com.mis.models.ObjectLogin;
import mis.oblabs.com.mis.models.ObjectSendLeaveRequest;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by kmagrawal on 05/11/17.
 */

public interface RestApi {



//    //login
//    @FormUrlEncoded
//    @POST("login")
//    Call<String> login(@Field("username") String userId, @Field("passw") String password);


    //login
    @GET("API/login")
    Call<List<ObjectLogin>> login(@Query("username") String username, @Query("password") String password, @Query("opt") String option);


    //Get attendance
    @GET("APIAttendanceList/AttendanceList")
    Call<List<ModelAttendance>> attendanceList(@Query("mnth") String month,
                                               @Query("year") String year,
                                               @Query("user") String user);






//    http://apimisnew.cogxim.com/APIBindDropdownLists/AttendanceType
    @GET("APIBindDropdownLists/AttendanceType")
    Call<List<Object>> getAttendanceType();

    //http://apimisnew.cogxim.com/APIBindDropdownLists/ALLEmployeeForCHList
    //Employee with CH list
    @GET("APIBindDropdownLists/ALLEmployeeForCHList")
    Call<List<Object>> employeeForCh();



//    http://apimisnew.cogxim.com/APIBindDropdownLists/GetDateRange
    @GET("APIBindDropdownLists/GetDateRange")
    Call<List<ModelDateRange>> getDateRange();


    //http://apimisnew.cogxim.com/APIBindDropdownLists/GetAllState
    //Get All states
    @GET("APIBindDropdownLists/GetAllState")
    Call<List<ModelState>> getStates();


    //http://apimisnew.cogxim.com/APIBindDropdownLists/GetEmployeeByDept?
    // deptid=0B93D12B-7652-46AE-98B2-EEB13FCF1C65&
    // srcid=2F854C1A-AAD6-4BED-8510-BF23F0AF1969
    //Get employee by department
    @GET("APIBindDropdownLists/GetEmployeeByDept")
    Call<List<Object>> getEmpByDept(@Query("deptid") String deptId, @Query("srcid") String srcId);

    //http://apimisnew.cogxim.com/APILeaveApp/LeaveApplication?
    // sdt=15-08-2017&
    // dtto=30-08-2017&
    // lstatus=2&
    // email=shersingh.rathore@cogxim.com&
    // empid=106

    //Get leave detail
    @GET("APILeaveApp/LeaveApplication")
    Call<List<ModelLeave>> getEmpLeave(@Query("sdt") String startDate,
                                       @Query("dtto") String endDate,
                                       @Query("lstatus") String leaveStatus,
                                       @Query("email") String email,
                                       @Query("empid") String empId);




//    http://apimisnew.cogxim.com/APIRequestForDAAdvanceList/DAAdvanceList?
//    DateTo=26-11-2017&
//    DateFrom=01-04-2016&
//    RolloutPlanId=1267&
//    EmpId=18&
//    RollOutTypeID=1
    //get rfa approval list
    @GET("APIRequestForDAAdvanceList/DAAdvanceList")
    Call<List<ModelRfaApproval>> getRfaApprovalList(@Query("DateTo") String dateTo, @Query("DateFrom") String dateFrom,
                                                    @Query("RolloutPlanId") String rolloutPlanId,
                                                    @Query("EmpId") String empId,
                                                    @Query("RollOutTypeID") String rolloutTypeId);




    //http://apimisnew.cogxim.com/APIRollOutPlan/AddRolloutPlan?uid=30&stid=32&cityf=Jaipur&stid=32&cityf=Ajmer&dtfrm=20-11-2017&dtfrm=21-11-2017&rema=notmyfault&td=2&od=4&yid=6&bld=4
    // Add new rollout

    @GET("APIRollOutPlan/AddRolloutPlan")
    Call<List<ObjectAddRollout>> addRollout(@Query("uid") String userId,
                                            @Query("stid") String stateFrom,
                                            @Query("cityf") String cityFrom,
                                            @Query("stid") String stateTo,
                                            @Query("cityf") String cityTo,
                                            @Query("dtfrm") String dateFrom,
                                            @Query("dtfrm") String dateTo,
                                            @Query("rema") String remark,
                                            @Query("td") String totalDays,
                                            @Query("od") String onsiteDays,
                                            @Query("yid") String yearId,
                                            @Query("bld") String baseDays);

    //http://apimisnew.cogxim.com/APIRollOutPlan/UpdRolloutPlan?
    // uid=30&
    // stid=32&
    // cityf=Jaipur&
    // stid=32&
    // cityf=Ajmer&
    // dtfrm=20-11-2017&
    // dtfrm=21-11-2017&
    // rema=notmyfault&
    // td=2&
    // od=4&
    // yid=6&
    // bld=4&
    // rid=1987

    //  update Rollout
    @GET("APIRollOutPlan/UpdRolloutPlan")
    Call<List<ModelRolloutCU>> updateRollout(@Query("uid") String userId,
                                             @Query("stid") String stateFrom,
                                             @Query("cityf") String cityFrom,
                                             @Query("stid") String stateTo,
                                             @Query("cityf") String cityTo,
                                             @Query("dtfrm") String dateFrom,
                                             @Query("dtfrm") String dateTo,
                                             @Query("rema") String remark,
                                             @Query("td") String totalDays,
                                             @Query("od") String onsiteDays,
                                             @Query("yid") String yearId,
                                             @Query("bld") String baseDays,
                                             @Query("rid") String rolloutId);



//    http://apimisnew.cogxim.com/APIRequestForCHList/CHList?
    // SubmitDate=01-04-2017&
    // DateTo=21-11-2017&
    // EmpIdno=&
    // EmpEmail=&
    // Status=&
    // YearIdno=

    @GET("APIRequestForCHList/CHList")
    Call<List<ObjectCH>> getCHList(@Query("SubmitDate") String submitDate,
                                   @Query("DateTo") String dateTo,
                                   @Query("EmpIdno") String empId,
                                   @Query("EmpEmail") String empEmail,
                                   @Query("Status") String status,
                                   @Query("YearIdno") String yearId);

//    http://apimisnew.cogxim.com/APIRollOutPlan/SearchRollOutPlan?
//    uid=30&
//    stid=32&
    // stid=32&
    // dtfrm=15-08-2017&
    // dtfrm=15-08-2017&
    // yid=6

    @GET("APIRollOutPlan/SearchRollOutPlan")
    Call<List<Object>> searchRollout(@Query("uid") String uId,
                                     @Query("stid") String stateFrom,
                                     @Query("stid") String stateTo,
                                     @Query("dtfrm") String dateFrom,
                                     @Query("dtfrm") String dateTo,
                                     @Query("yid") String yearId);




//    http://apimisnew.cogxim.com/APIRequestForCH/UpdateCHRequest?
// chIdno=AC893AC4-34D0-430C-AB62-1C20B4040B76&
// CHDate=21-08-2017&
// SubmitDate=22-11-2017&
// empIdno=7&
// YearIdno=6&
// Status=1&
// Remark=ch todaystaturday

    @GET("APIRequestForCH/UpdateCHRequest")
    Call<List<Object>> updateCHRequest(@Query("chIdno") String chIdNo,
                                       @Query("CHDate") String chDate,
                                       @Query("SubmitDate") String submitDate,
                                       @Query("empIdno") String empId,
                                       @Query("YearIdno") String yearId,
                                       @Query("Status") String status,
                                       @Query("Remark") String remark);


//    http://apimisnew.cogxim.com/APIRequestForCH/SendCHRequest?
// chIdno=AC893AC4-34D0-430C-AB62-1C20B4040B76&
// CHDate=21-08-2017&
// SubmitDate=22-11-2017&
// empIdno=7&
// YearIdno=6&
// Status=1&
// Remark=ch todaystaturday

    @GET("APIRequestForCH/SendCHRequest")
    Call<List<ObjectAddRollout>> sendChRequest(@Query("chIdno") String chIdNo,
                                     @Query("CHDate") String chDate,
                                     @Query("SubmitDate") String submitDate,
                                     @Query("empIdno") String empId,
                                     @Query("YearIdno") String yearId,
                                     @Query("Status") String status,
                                     @Query("Remark") String remark);

//    http://apimisnew.cogxim.com/APILeaveRequest/UpdateLeaveRequest?
// UserIdno=7&
// SubmitDate=23-11-2017&
// LeaveFrom=25-11-2017&
// LeaveTo=25-11-2017&
// NoDays=1&
// LeaveType=4&
// LeaveReason=aamir&
// IsAccepted=3&
// Year_Idno=6&
// Leave_Idno=1304

    @GET("APILeaveRequest/UpdateLeaveRequest")
    Call<List<ObjectSendLeaveRequest>> updateLeaveRequest(@Query("UserIdno") String userId,
                                          @Query("SubmitDate") String submitDate,
                                          @Query("LeaveFrom") String leaveFrom,
                                          @Query("LeaveTo") String leaveTo,
                                          @Query("NoDays") String daysCount,
                                          @Query("LeaveType") String leaveType,
                                          @Query("LeaveReason") String leaveReason,
                                          @Query("IsAccepted") String isAccepted,
                                          @Query("Year_Idno") String yearId,
                                          @Query("Leave_Idno") String leaveId);


//    http://apimisnew.cogxim.com/APILeaveRequest/SendLeaveRequest?
// UserIdno=7&
// SubmitDate=23-11-2017&
// LeaveFrom=25-11-2017&
// LeaveTo=25-11-2017&
// NoDays=1&
// LeaveType=4&
// LeaveReason=aamir&
// IsAccepted=3&
// Year_Idno=6

    @GET("APILeaveRequest/SendLeaveRequest")
    Call<List<ObjectSendLeaveRequest>> sendLeaveRequest(@Query("UserIdno") String userId,
                                                        @Query("SubmitDate") String submitDate,
                                                        @Query("LeaveFrom") String leaveFrom,
                                                        @Query("LeaveTo") String leaveTo,
                                                        @Query("NoDays") String daysCount,
                                                        @Query("LeaveType") String leaveType,
                                                        @Query("LeaveReason") String leaveReason,
                                                        @Query("IsAccepted") String isAccepted,
                                                        @Query("Year_Idno") String yearId);

    //http://apimisnew.cogxim.com/APIBindDropdownLists/GetExpenseList?internal=0

    @GET("APIBindDropdownLists/GetExpenseList")
    Call<List<ObjectExpenses>> optionExpense(@Query("internal") String code);











}


