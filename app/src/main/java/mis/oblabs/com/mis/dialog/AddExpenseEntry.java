package mis.oblabs.com.mis.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import mis.oblabs.com.mis.R;
import mis.oblabs.com.mis.dialog.selectors.SelectItem2;
import mis.oblabs.com.mis.utils.DatePicker;
import mis.oblabs.com.mis.utils.SelectArrayCallback;
import mis.oblabs.com.mis.utils.SelectCallback;
import mis.oblabs.com.mis.utils.SelectSingleItemCallback;


/**
 * Created by ato on 12/03/17.
 */

public class AddExpenseEntry extends DialogFragment {

    TextView mDate;
    LinearLayout mType;
    TextView mExpense;

    EditText eDescription , eAmount;

    //date expense description amount


    View footer;

    SelectArrayCallback callback;



    boolean monthCheck =false , yearCheck = false;

    public void setCallback(SelectArrayCallback callback) {
        this.callback = callback;
    }




    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = View.inflate(getContext() , R.layout.d_expense_entry ,null);
        builder.setView(view);

        initializeView(view);

        return builder.create();
    }

    private void initializeView(View view) {
        mDate = (TextView)view.findViewById(R.id.tv_date);
        mExpense = (TextView)view.findViewById(R.id.tv_expense);

        eDescription = (EditText)view.findViewById(R.id.et_description);
        eAmount = (EditText)view.findViewById(R.id.et_amount);

        mDate.setOnClickListener(selectDate());
        mExpense.setOnClickListener(selectType());



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
//                Toast.makeText(getContext() , "Negative Clicked" , Toast.LENGTH_SHORT).show();
                dismiss();
            }
        };
    }

    private View.OnClickListener clickPos() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext() , "No API yet" , Toast.LENGTH_SHORT).show();

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
                        mExpense.setText(name);
                    }

                    @Override
                    public void selectedItemId(String id) {

                    }
                });
                select.show(getFragmentManager() , "select");
            }
        };
    }

    private View.OnClickListener selectDate() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               DatePicker datePicker =  new DatePicker();
                datePicker.setCallback(new SelectSingleItemCallback() {
                    @Override
                    public void selectedItem(String item) {
                        mDate.setText(item);
                    }
                });
                datePicker.show(getFragmentManager() , "date");

            }
        };
    }


}
