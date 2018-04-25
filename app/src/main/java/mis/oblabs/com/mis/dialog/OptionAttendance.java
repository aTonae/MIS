package mis.oblabs.com.mis.dialog;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

import mis.oblabs.com.mis.R;
import mis.oblabs.com.mis.activity.LeaveApply;
import mis.oblabs.com.mis.activity.ViewAttendance;


public class OptionAttendance extends DialogFragment {




    View apply , view;

    TextView tApply , tView;


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = View.inflate(getContext() , R.layout.option_leave ,null);
        builder.setView(view);

        initializeView(view);

        return builder.create();
    }

 private void initializeView(View view) {


     apply = view.findViewById(R.id.apply);


     tApply = (TextView)view.findViewById(R.id.tvApply);
     tView = (TextView)view.findViewById(R.id.tvView);
     tApply.setText("Mark Attendance");
     tView.setText("View Attendance");

     apply.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

//             startActivity(new Intent(getContext() , LeaveApply.class));

             new AddAttendance().show(getFragmentManager() , "add attendance");
             dismiss();

         }
     });

     view = view.findViewById(R.id.view);

     view.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
                          startActivity(new Intent(getContext() , ViewAttendance.class));

             dismiss();

         }
     });



 }







}