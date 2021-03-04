package live.syslyncerp.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class Dashboard extends AppCompatActivity {
    //Initialize variable
    MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //Assign variable
        bottomNavigation = findViewById(R.id.bottom_navigation);

        //Add menu item
        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.home_icon));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.add_icon));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.history_icon));
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.profile_icon));

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                //Initialize fragment
                Fragment fragment = null;

                switch (item.getId()){
                    case 1:
                        fragment = new HomeFragment();
                        break;
                    case 2:
                        fragment = new CreateFragment();
                        break;
                    case 3:
                        fragment = new StatusFragment();
                        break;
                    case 4:
                        fragment = new ProfileFragment();
                        break;
                }
                //Load fragment
                loadFragment(fragment);
            }
        });

        //Set notification count
        //bottomNavigation.setCount(1,"10");
        //Set home fragment initially selected
        bottomNavigation.show(1,true);

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        //Replace fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.dashboard_layout,fragment).commit();
    }
}