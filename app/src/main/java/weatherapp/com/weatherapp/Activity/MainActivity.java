package weatherapp.com.weatherapp.Activity;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import weatherapp.com.weatherapp.Fragments.MainViewFragment;
import weatherapp.com.weatherapp.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String MAIN_VIEW_FRAG = "mainViewFrag";
    public static final String MAIN_VIEW_DETAIL_FRAG = "mainViewDetailFrag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addMainViewFragment();
    }

    public void addMainViewFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, new MainViewFragment(), MAIN_VIEW_FRAG);
        transaction.commit();
    }

}
