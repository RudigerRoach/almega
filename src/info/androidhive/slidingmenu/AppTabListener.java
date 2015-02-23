package info.androidhive.slidingmenu;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;

/**
 * Created by rudiger on 2014/12/16.
 */
public class AppTabListener implements ActionBar.TabListener {
    Fragment fragment;

    public AppTabListener(Fragment fragment){
        this.fragment = fragment;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        ft.replace(R.id.frame_container,fragment);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        ft.remove(fragment);
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
