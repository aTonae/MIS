package mis.oblabs.com.mis.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import mis.oblabs.com.mis.R;
import mis.oblabs.com.mis.dialog.OptionAttendance;
import mis.oblabs.com.mis.dialog.OptionCH;
import mis.oblabs.com.mis.dialog.OptionLeave;
import mis.oblabs.com.mis.utils.SharedPreference;


public class DrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {



    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;

    View cardLeave , cardRfa , cardAttendance , cardRollout , cardRfaAgainSalary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        initView();



        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        View headerView =  navigationView.getHeaderView(0);

        TextView tEmail = (TextView)headerView.findViewById(R.id.tvEmail);
        tEmail.setText(new SharedPreference().getValueWithKey(this , "email"));


    }

    private void initView() {

        cardLeave = findViewById(R.id.view_leave_request);
        cardLeave.setOnClickListener(dashboradOption(1));

        cardAttendance = findViewById(R.id.view_attendance);
        cardAttendance.setOnClickListener(dashboradOption(2));



        cardRfa = findViewById(R.id.view_rfa);
        cardRfa.setOnClickListener(dashboradOption(3));


        cardRollout = findViewById(R.id.view_rollout_create);
        cardRollout.setOnClickListener(dashboradOption(4));

        cardRfaAgainSalary = findViewById(R.id.view_rfa_against_salary);
        cardRfaAgainSalary.setOnClickListener(dashboradOption(5));
    }

    private View.OnClickListener dashboradOption(final int option) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (option){
                    case 1:{

                        new OptionLeave().show(getSupportFragmentManager() , "leaveOption");


                        break;
                    }
                    case 2:{

                        new OptionAttendance().show(getSupportFragmentManager() , "attendanceOption");


                        break;
                    }
                    case 3:{
                        new OptionCH().show(getSupportFragmentManager() , "ch option");


                        break;
                    }
                    case 4:{

                        startActivity(new Intent(DrawerActivity.this , RolloutCreate.class));

                        break;
                    }
                    case 5:{

                        startActivity(new Intent(DrawerActivity.this , RfaAgainstSalary.class));

                        break;
                    }
                }


            }
        };
    }

    private void showOptionView() {



    }

    @Override
    public void onBackPressed() {


        setTitle("Dashboard");
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();


        switch (id){


//            case R.id.nav_attendance:{
//                setTitle("Attendance Info");
//                getSupportFragmentManager().beginTransaction().add(R.id.container , new AttendanceList() , "attendance").addToBackStack(null).commit();
//                    break;
//            }
//            case R.id.nav_leave:{
//                setTitle("Leave Info");
//                getSupportFragmentManager().beginTransaction().add(R.id.container , new LeaveRequestList() , "leave").addToBackStack(null).commit();
//                break;
//            }
//            case R.id.nav_rfa_approved:{
//                setTitle("RFA Approval List");
//                getSupportFragmentManager().beginTransaction().add(R.id.container , new RFAApprovalList() , "rfa_approved").addToBackStack(null).commit();
//                break;
//            } case R.id.nav_rollout:{
//                setTitle("Add Rollout");
//                getSupportFragmentManager().beginTransaction().add(R.id.container , new Rollout() , "rollout").addToBackStack(null).commit();
//                break;
//            }
        }
        drawer.closeDrawer(Gravity.START);

        return true;

    }


}
