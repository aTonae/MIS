package mis.oblabs.com.mis.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import mis.oblabs.com.mis.R;

public class BaseListView extends AppCompatActivity {



    LinearLayout llFilter, llAdd;
    ListView listView;
    RelativeLayout layoutLoad;

    Button bttnPositive , bttnNegative;

    TextView headerTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_base_list_view);

        initView(this.findViewById(android.R.id.content));
    }

    public void setHeaderTitle(){

    }

    private void initView(View view) {

        listView = (ListView)view.findViewById(R.id.listview);
        listView.setOnItemClickListener(itemClickListener());
        listView.setDividerHeight(0);

        headerTitle = (TextView)view.findViewById(R.id.tvTitle);
        setHeaderTitle();


//        llFilter = (LinearLayout)view.findViewById(R.id.ll_filter);
//        llFilter.setOnClickListener(filterClickListener());
//
//        llAdd = (LinearLayout)view.findViewById(R.id.ll_add);
//        llAdd.setOnClickListener(addClickListener());


        bttnNegative = (Button)view.findViewById(R.id.bttn_negative) ;

        bttnNegative.setOnClickListener(filterClickListener());

        bttnPositive = (Button)view.findViewById(R.id.bttn_positive) ;
        bttnPositive.setOnClickListener(addClickListener());

        layoutLoad = (RelativeLayout)view.findViewById(R.id.layoutLoad);


        initAdapter();

    }

    public void initAdapter() {

    }

    private View.OnClickListener addClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addClicked();
            }
        };
    }

    public void addClicked() {

    }

    private View.OnClickListener filterClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterClicked();
            }
        };
    }

    public void filterClicked() {
    }

    private AdapterView.OnItemClickListener itemClickListener() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemClicked(position);
            }
        };
    }

    public void itemClicked(int position) {


    }


    public void toggleLoadView(boolean show){
        if(show)
        {
            layoutLoad.setVisibility(View.VISIBLE);

        }else{
            layoutLoad.setVisibility(View.GONE);

        }
    }

    public void exitScreen(View view) {

        finish();
    }

    public void search(View view) {

    }
}
