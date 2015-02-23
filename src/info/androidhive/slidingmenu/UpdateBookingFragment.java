package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

/**
 * Created by rudiger on 2014/12/19.
 */
public class UpdateBookingFragment extends Fragment {
    private View thisView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_update_booking,container,false);
        thisView = view;

        CalendarView fromDate = (CalendarView)view.findViewById(R.id.dateFrom);
        fromDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                updateTotalDays();
            }
        });

        CalendarView toDate = (CalendarView)thisView.findViewById(R.id.dateTo);
        toDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                updateTotalDays();
            }
        });
        return view;
    }

    void updateTotalDays(){
        CalendarView fromDate = (CalendarView)thisView.findViewById(R.id.dateFrom);
        CalendarView toDate = (CalendarView)thisView.findViewById(R.id.dateTo);

        long fromCalDate = fromDate.getDate();
        long toCalDate = toDate.getDate();

        long deltaDate = toCalDate - fromCalDate;
        long days = deltaDate / (24 * 60 * 60 * 1000) +1;

        ((TextView)thisView.findViewById(R.id.totalDays)).setText("Total: "+days+" Days");
    }
}
