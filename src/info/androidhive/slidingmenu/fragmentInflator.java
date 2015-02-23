package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by rudiger on 2014/12/19.
 */
public class fragmentInflator extends Fragment {
    int layout;

    public fragmentInflator(int layout){
        this.layout = layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(layout,container,false);

        return view;
    }
}
