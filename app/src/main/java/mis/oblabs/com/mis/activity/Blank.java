package mis.oblabs.com.mis.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import mis.oblabs.com.mis.R;

public class Blank extends AppCompatActivity {








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_leave_request);





        Log.wtf("TAG" , "Logging notwoeking");
        Log.d("TAG" , "Logging notwoeking");



//    initializeView(this.findViewById(android.R.id.content));




    }



    public void exitScreen(View view) {
        finish();
    }
}
