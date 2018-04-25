package mis.oblabs.com.mis.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mis.oblabs.com.mis.R;
import mis.oblabs.com.mis.dialog.selectors.SelectItem2;
import mis.oblabs.com.mis.models.ObjectRfaTable;
import mis.oblabs.com.mis.utils.DatePicker;
import mis.oblabs.com.mis.utils.SelectCallback;
import mis.oblabs.com.mis.utils.SelectSingleItemCallback;
import mis.oblabs.com.mis.utils.TimePicker;

public class RfaAgainstSalary extends AppCompatActivity {

    TextView mTvType;
    TextView mTvPlan;
    TextView mTvSfrom;
    TextView mTvSto;
    EditText mTvCfrom;
    EditText mTvCto;
    TextView mTvDepDate;
    TextView mTvDepTime;
    TextView mTvArrDate;
    TextView mTvArrTime;
    TableLayout mTablelayout;
    Button mBttnAdd;
    Button mBttnAttach;
    EditText mEtRemark;


    TextView mTvDateRange;

    TextView eDate , eType;
    EditText eDescription , eAmount;

    View footer;

    List<ObjectRfaTable> tableData;

    public static  int ROW_COUNT = 1;


    public Context getContext(){
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_rfa_againstsalary);

        tableData = new ArrayList<>();

        initializeView(this.findViewById(android.R.id.content));

    }

    private void initializeView(View view) {

        mTvType = (TextView) view.findViewById(R.id.tv_type);
        mTvType.setTag("type");
        mTvType.setOnClickListener(selectType(mTvType));

        mTvPlan = (TextView) view.findViewById(R.id.tv_plan);
        mTvPlan.setTag("plan");
        mTvPlan.setOnClickListener(selectType(mTvPlan));

        mTvSfrom = (TextView) view.findViewById(R.id.tv_sfrom);
        mTvSfrom.setTag("sfrom");
        mTvSfrom.setOnClickListener(selectType(mTvSfrom));

        mTvSto = (TextView) view.findViewById(R.id.tv_sto);
        mTvSto.setTag("sto");
        mTvSto.setOnClickListener(selectType(mTvSto));

        mTvCfrom = (EditText) view.findViewById(R.id.et_cfrom);
//        mTvCfrom.setTag("cfrom");
//        mTvCfrom.setOnClickListener(selectType(mTvCfrom));

        mTvCto = (EditText) view.findViewById(R.id.et_cto);
//        mTvCto.setTag("cto");
//        mTvCto.setOnClickListener(selectType(mTvCto));

        mTvDepDate = (TextView) view.findViewById(R.id.tv_dep_date);
        mTvDepDate.setTag("depdate");
        mTvDepDate.setOnClickListener(selectDate(mTvDepDate));

        mTvDepTime = (TextView) view.findViewById(R.id.tv_dep_time);
        mTvDepTime.setTag("deptime");
        mTvDepTime.setOnClickListener(selectTime(mTvDepTime));

        mTvArrDate = (TextView) view.findViewById(R.id.tv_arr_date);
        mTvArrDate.setTag("arrdate");
        mTvArrDate.setOnClickListener(selectDate(mTvArrDate));

        mTvArrTime = (TextView) view.findViewById(R.id.tv_arr_time);
        mTvArrTime.setTag("arrtime");
        mTvArrTime.setOnClickListener(selectTime(mTvArrTime));

        mTablelayout = (TableLayout) view.findViewById(R.id.tablelayout);

        mBttnAdd = (Button) view.findViewById(R.id.bttnExpenseEntry);
        mBttnAdd.setOnClickListener(addRowToTable());


        mBttnAttach = (Button) view.findViewById(R.id.bttn_attach);

        mEtRemark = (EditText)view.findViewById(R.id.et_remark);


        footer = view.findViewById(R.id.footer);
        initFooter();

    }

    private View.OnClickListener addRowToTable() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createRow();
            }
        };
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
                Toast.makeText(getContext() , "Negative Clicked" , Toast.LENGTH_SHORT).show();
            }
        };
    }

    private View.OnClickListener clickPos() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext() , "Positive Clicked" , Toast.LENGTH_SHORT).show();
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
                select.show(getSupportFragmentManager() , "select");
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
                datePicker.show(getSupportFragmentManager() , "date");
            }
        };
    }

    private View.OnClickListener selectTime(final TextView tv){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePicker timePicker = new TimePicker();
                timePicker.setCallback(new SelectSingleItemCallback() {
                    @Override
                    public void selectedItem(String item) {
                        tv.setText(item);
                    }
                });
                timePicker.show(getSupportFragmentManager() , "time");
            }
        };
    }

    public void createRow(){

        TableRow row1= new TableRow(getContext());
        row1.setTag(ROW_COUNT);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.WRAP_CONTENT , 1f);
        row1.setLayoutParams(lp);

//        row1.setWeightSum(5);



        TableRow.LayoutParams lpp;
        lpp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f);
        lpp.weight = 1; //column weight

        TextView textView12 = new TextView(getContext());
        //textView12.setText("Product"+ROW_COUNT);

        textView12.setText("12-12-2012");
        textView12.setTextColor(getResources().getColor(R.color.colorPrimary));

        // textView12.setTextColor(R.color.colorPrimary);

        //textView12.setPadding(4,4,2,4);
        textView12.setGravity(Gravity.CENTER);


        textView12.setLayoutParams(lpp);

        TableRow.LayoutParams lpp1;
        lpp1 = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f);
        lpp1.weight = 1; //column weight
        TextView textView11 = new TextView(getContext());
        textView11.setText("Expense");
        textView11.setTextColor(getResources().getColor(R.color.colorPrimary));
        textView11.setGravity(Gravity.CENTER);
        textView11.setLayoutParams(lpp1);
        //textView11.setPadding(2,4,2,4);

        TableRow.LayoutParams lpp2;
        lpp2 = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f);
        lpp2.weight = 1; //column weight
        TextView textView21 = new TextView(getContext());
        textView21.setText("5000");
        textView21.setTextColor(getResources().getColor(R.color.colorPrimary));

        textView21.setGravity(Gravity.CENTER);
        textView21.setLayoutParams(lpp2);
        //textView21.setPadding(2,4,2,4);

        TableRow.LayoutParams lpp3;
        lpp3 = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f);
        lpp3.weight = 1; //column weight
        TextView textView31 = new TextView(getContext());
        textView31.setText("Price"+ROW_COUNT);
        textView31.setGravity(Gravity.CENTER);
        textView31.setLayoutParams(lpp3);
        //textView31.setPadding(2,4,2,4);

        TableRow.LayoutParams lpp4;
        lpp4 = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1f);
        lpp4.weight = 1; //column weight
        lpp4.gravity = Gravity.CENTER;
       // lpp4.width = 24;
//        Button button = new Button(getContext());
//        button.setOnClickListener(removeRowClick(ROW_COUNT));
//        button.setText(""+ROW_COUNT);
//        button.setGravity(Gravity.CENTER);
//        button.setLayoutParams(lpp4);
//        button.setBackgroundResource(R.drawable.white_cross);

        ImageView image = new ImageView(getContext());
        image.setImageResource(R.drawable.white_cross);
        image.setOnClickListener(removeRowClick(ROW_COUNT));
        image.setLayoutParams(lpp4);

        row1.addView(textView12);
        row1.addView(textView11);
        row1.addView(textView21);
        //row1.addView(textView31);
//        row1.addView(button);
        row1.addView(image);

        mTablelayout.addView(row1);

        ROW_COUNT++;


    }

    private View.OnClickListener removeRowClick(final int rowCount) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Log.d("RFAEXPENSEENTRY" , "Row Count : "+mTablelayout.getChildCount());
                mTablelayout.removeView(mTablelayout.findViewWithTag(rowCount));

            }
        };
    }
}
