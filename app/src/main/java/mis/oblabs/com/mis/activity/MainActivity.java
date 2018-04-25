package mis.oblabs.com.mis.activity;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;


import java.util.List;

import mis.oblabs.com.mis.R;
import mis.oblabs.com.mis.models.ObjectLogin;
import mis.oblabs.com.mis.network.ApiRestAdapter;
import mis.oblabs.com.mis.utils.Helper;
import mis.oblabs.com.mis.utils.SharedPreference;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {




    EditText eUsername , ePassword;
    TextView tForgotPass;
    Button bLogin;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.wtf("TAG" , "Logging notwoeking");
        Log.d("TAG" , "Logging notwoeking");




        eUsername = (EditText) findViewById(R.id.etUsername);

        ePassword = (EditText) findViewById(R.id.etPassword);

        tForgotPass = (TextView) findViewById(R.id.tvForgotPass);

        bLogin = (Button) findViewById(R.id.bttnLogin);

        progressBar = (ProgressBar) findViewById(R.id.progressLogin);


        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(eUsername.getText().toString().equals("")){
                    eUsername.setError("Please enter username");
                    return;
                }


                if(ePassword.getText().toString().equals("")){
                    ePassword.setError("Please enter password");
                    return;
                }

                tryLogin();
            }
        });



















    }

    private void tryLogin() {

        progressBar.setVisibility(View.VISIBLE);


        Call<List<ObjectLogin>>  login =  new ApiRestAdapter().login(eUsername.getText().toString() , ePassword.getText().toString());

        login.enqueue(new Callback<List<ObjectLogin>>() {
            @Override
            public void onResponse(Call<List<ObjectLogin>> call, Response<List<ObjectLogin>> response) {

                progressBar.setVisibility(View.GONE);
                if(response.code()== 200){
                    Log.d("tag" ,"cehck logging");
                    Helper.showToast(MainActivity.this , "Login Successful");

                    ObjectLogin loginDetails = response.body().get(0);
                    SharedPreference session = new SharedPreference();
                    session.saveValueWithKey(MainActivity.this , "email" , eUsername.getText().toString());
                    session.saveValueWithKey(MainActivity.this , "mobile" , loginDetails.getMobile_No());

                    session.saveValueWithKey(MainActivity.this , "userId" , loginDetails.getUser_Idno());




                    startActivity(new Intent(MainActivity.this , DrawerActivity.class));

                }else if(response.code()== 500){
                    Helper.showToast(MainActivity.this , "Invalid Login Details");

                }







            }

            @Override
            public void onFailure(Call<List<ObjectLogin>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Helper.showToast(MainActivity.this , "Failed"+t.getMessage());


            }
        });
    }

}
