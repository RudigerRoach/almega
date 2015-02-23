package info.androidhive.slidingmenu;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ManageBookingsFragment extends Fragment {
    ActionBar.Tab tab1, tab2, tab3;
    Fragment createBookingFragment;
    Fragment viewBookingsFragment;
    Fragment updateBookingFragment;

    public ManageBookingsFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_manage_bookings, container, false);
        initializeTabs();
        return rootView;
    }

    private void initializeTabs(){
        createBookingFragment = new CreateBookingFragment();
        viewBookingsFragment = new ViewBookingsFragment();
        updateBookingFragment = new UpdateBookingFragment();

        ActionBar actionBar = getActivity().getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tab1 = actionBar.newTab().setText("Create a Booking");
        tab2 = actionBar.newTab().setText("View Bookings");
        tab3 = actionBar.newTab().setText("Update a Booking");

        tab1.setTabListener(new AppTabListener(createBookingFragment));
        tab2.setTabListener(new AppTabListener(viewBookingsFragment));
        tab3.setTabListener(new AppTabListener(updateBookingFragment));

        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
        actionBar.addTab(tab3);
    }
}

