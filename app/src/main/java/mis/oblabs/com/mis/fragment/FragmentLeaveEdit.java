package mis.oblabs.com.mis.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import mis.oblabs.com.mis.R;
import mis.oblabs.com.mis.activity.LeaveApply;
import mis.oblabs.com.mis.dialog.selectors.SelectItem2;
import mis.oblabs.com.mis.models.ModelLeave;
import mis.oblabs.com.mis.models.ObjectSendLeaveRequest;
import mis.oblabs.com.mis.network.ApiRestAdapter;
import mis.oblabs.com.mis.utils.DatePicker;
import mis.oblabs.com.mis.utils.Helper;
import mis.oblabs.com.mis.utils.SelectCallback;
import mis.oblabs.com.mis.utils.SelectSingleItemCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentLeaveEdit extends Fragment {

    TextView  mTvDate;
    TextView  mTvName;
    TextView  mTvDepartment;
    TextView  mTvEmail;
    TextView  mTvLeaveFrom;
    TextView  mTvLeaveTo;
    TextView mTvType;
    TextView mTvLeaveData;

    Button bttnInfo;

    TextView tvHead;

    EditText mEtRfl , mEtNod;

    View footer;

    static ModelLeave data;

    public static FragmentLeaveEdit newInstance(ModelLeave in) {
        FragmentLeaveEdit fragment = new FragmentLeaveEdit();

        data = in;
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fragment_leave_edit, container, false);
        initializeView(view);
        return view;
    }

    private void initializeView(View view) {






        mTvDate =  (TextView) view.findViewById(R.id.tv_date);
        mTvDate.setText(data.getSubmitDate());
       // mTvDate.setTag("date");
       // mTvDate.setOnClickListener(selectDate(mTvDate));


        tvHead = (TextView)view.findViewById(R.id.tvHead);

        tvHead.setText("Edit leave request");









        mTvLeaveFrom =  (TextView) view.findViewById(R.id.tv_leave_from);
        mTvLeaveFrom.setTag("from");
        mTvLeaveFrom.setText(data.getLeaveFrom());
        mTvLeaveFrom.setOnClickListener(selectDate(mTvLeaveFrom));

        mTvLeaveTo =  (TextView) view.findViewById(R.id.tv_leave_to);
        mTvLeaveTo.setTag("to");
        mTvLeaveTo.setText(data.getLeaveTO());
        mTvLeaveTo.setOnClickListener(selectDate(mTvLeaveTo));

        mTvType =  (TextView) view.findViewById(R.id.tv_type);
        mTvType.setTag("type");

        if(data.getLeaveType().equals("1")) {
            mTvType.setText("Paid Leave");
        }else{
            mTvType.setText("CH");

        }

       // mTvType.setOnClickListener(selectType(mTvType));






        mEtRfl = (EditText)view.findViewById(R.id.et_rol);

        mEtRfl.setText(data.getLeaveReason());

        mEtNod = (EditText)view.findViewById(R.id.et_nod);

        mEtNod.setText(data.getNofDays());



        footer = view.findViewById(R.id.footer);
        initFooter();

    }



    private void initFooter() {

        Button bttnPos = (Button)footer.findViewById(R.id.bttn_positive);
        Button bttnNeg = (Button)footer.findViewById(R.id.bttn_negative);

        bttnPos.setOnClickListener(clickPos());
        bttnNeg.setOnClickListener(clickNeg());
    }

    private View.OnClickListener clickNeg() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStackImmediate();
//                Toast.makeText(LeaveApply.this , "Negative Clicked" , Toast.LENGTH_SHORT).show();
            }
        };
    }

    private View.OnClickListener clickPos() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(LeaveApply.this , "Positive Clicked" , Toast.LENGTH_SHORT).show();
                submitData();
            }
        };
    }

    private View.OnClickListener selectType(final TextView tv) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectItem2 select = new SelectItem2();
                select.setCallback(new SelectCallback() {
                    @Override
                    public void selectedItemName(String name) {
                        tv.setText(name);
                    }

                    @Override
                    public void selectedItemId(String id) {

                    }
                });
                select.show(getFragmentManager() , "select");
            }
        };
    }

    private View.OnClickListener selectDate(final TextView tv) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePicker datePicker =  new DatePicker();
                datePicker.setCallback(new SelectSingleItemCallback() {
                    @Override
                    public void selectedItem(String item) {
                        tv.setText(item);
                    }
                });
                datePicker.show(getFragmentManager() , "date");
            }
        };
    }

    public void submitData(){



        //      String userId =  new SharedPreference().getValueWithKey(getContext() , "userId");


        String userId = "7";
        String submitDate = mTvDate.getText().toString();
        String leaveFrom =mTvLeaveFrom.getText().toString();
        String leaveTo =mTvLeaveTo.getText().toString();
        String daysCount = mEtNod.getText().toString() ;
//        String leaveType =mTvType.getTag().toString();
        String leaveType = "4";

        String leaveReason = mEtRfl.getText().toString() ;
        String isAccepted = "3" ;
        String yearId = "6";

        String leaveId = data.getLeaveIdno();

        Call<List<ObjectSendLeaveRequest>> call = new ApiRestAdapter().updateLeaveRequest(userId , submitDate , leaveFrom , leaveTo , daysCount , leaveType , leaveReason , isAccepted , yearId , leaveId);
        Helper.showLoading(getContext() , "Updating Leave");
        call.enqueue(new Callback<List<ObjectSendLeaveRequest>>() {
            @Override
            public void onResponse(Call<List<ObjectSendLeaveRequest>> call, Response<List<ObjectSendLeaveRequest>> response) {

                Helper.hideLoading();

                if(response.code() == 200) {
                    Helper.showToast(getContext(), "Success");
                    String msg =  response.body().get(0).getMsg();

                    Helper.showToast(getContext() , msg);




                }else{
                    Helper.showToast(getContext(), "Try Again : "+response.code());

                }
            }

            @Override
            public void onFailure(Call<List<ObjectSendLeaveRequest>> call, Throwable t) {

                Helper.hideLoading();
                Helper.showToast(getContext() , "Failed : "+t.getMessage());

            }
        });

    }


    public void exitScreen(View view) {
        getFragmentManager().popBackStackImmediate();
    }




}
