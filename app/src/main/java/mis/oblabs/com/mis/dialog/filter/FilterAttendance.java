package mis.oblabs.com.mis.dialog.filter;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

import mis.oblabs.com.mis.R;
import mis.oblabs.com.mis.dialog.selectors.SelectItem2;
import mis.oblabs.com.mis.dialog.selectors.SelectMonth;
import mis.oblabs.com.mis.dialog.selectors.SelectYear;
import mis.oblabs.com.mis.utils.DatePicker;
import mis.oblabs.com.mis.utils.Helper;
import mis.oblabs.com.mis.utils.SelectArrayCallback;
import mis.oblabs.com.mis.utils.SelectCallback;
import mis.oblabs.com.mis.utils.SelectSingleItemCallback;


/**
 * Created by ato on 12/03/17.
 */

public class FilterAttendance extends DialogFragment {

    TextView mMonth;
    LinearLayout mType;
    TextView mYear;


    View footer;

    SelectArrayCallback callback;

    String monthId;

    boolean monthCheck =false , yearCheck = false;

    public void setCallback(SelectArrayCallback callback) {
        this.callback = callback;
    }




    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = View.inflate(getContext() , R.layout.f_attendance ,null);
        builder.setView(view);

        initializeView(view);

        return builder.create();
    }

    private void initializeView(View view) {


        mMonth = (TextView)view.findViewById(R.id.tv_month);
        mYear = (TextView)view.findViewById(R.id.tv_year);
        mMonth.setOnClickListener(selectMonth());
        mYear.setOnClickListener(selectYear());


        footer = view.findViewById(R.id.footer);
        initFooter();
    }

    private View.OnClickListener selectYear() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectYear year = new SelectYear();
                year.setCallback(new SelectCallback() {
                    @Override
                    public void selectedItemName(String name) {
                        mYear.setText(name);
                        yearCheck = true;
                    }

                    @Override
                    public void selectedItemId(String id) {


                        Helper.showToast(getContext() ,"Year Id : "+id );

                    }
                });

                year.show(getFragmentManager() , "year");
            }
        };
    }

    private View.OnClickListener selectMonth() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectMonth month = new SelectMonth();
                month.setCallback(new SelectCallback() {
                    @Override
                    public void selectedItemName(String name) {

                        mMonth.setText(name);

                    }

                    @Override
                    public void selectedItemId(String id) {
                        monthCheck = true;

                        monthId = id;
                        Helper.showToast(getContext() ,"Id : "+id );

                    }
                });

                month.show(getFragmentManager() , "month");
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
//                Toast.makeText(getContext() , "Negative Clicked" , Toast.LENGTH_SHORT).show();
                dismiss();
            }
        };
    }

    private View.OnClickListener clickPos() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(yearCheck && monthCheck) {

                    callback.selectedItem(monthId, mYear.getText().toString());
                }
                dismiss();


//                updateData();
            }
        };
    }

    private void updateData() {




    }

    private View.OnClickListener selectType() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectItem2 select = new SelectItem2();
                select.selectItemCode(8813);
                select.setCallback(new SelectCallback() {
                    @Override
                    public void selectedItemName(String name) {
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


}
