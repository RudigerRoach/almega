package info.androidhive.slidingmenu;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import javax.xml.datatype.Duration;
import java.util.List;

public class MangeClientsFragment extends Fragment {
	private Context context;

    private Logic logic = null;

	public MangeClientsFragment(){}

    ActionBar.Tab addClientTab, updateClientTab;
    Fragment addClientFragment, updateClientFragment;

/*
    private String searchName = "";
    private String searchSurname = "";
    private String searchCell = "";

    private void updateListBox(View view){
        List<Client> clientList = logic.getClients(searchName, searchSurname, searchCell);
        ListView listView = (ListView)view.findViewById(R.id.searchListView);
    }

*/
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final View rootView = inflater.inflate(R.layout.fragment_manage_clients, container, false);

        this.context = rootView.getContext();
        logic = Logic.getInstance();

        initializeTabs();

/*
        TabHost tabs = (TabHost)rootView.findViewById(R.id.tabHost);
        tabs.setup();

        TabHost.TabSpec spec=tabs.newTabSpec("tag1");

        spec.setContent(R.id.tab1);
        spec.setIndicator("Add Client");
        tabs.addTab(spec);

        spec = tabs.newTabSpec("tag2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Update Client");
        tabs.addTab(spec);



        Button btn = (Button)rootView.findViewById(R.id.SubmitNewClient);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ((EditText)rootView.findViewById(R.id.NewPersonName)).getText().toString();
                String surname = ((EditText)rootView.findViewById(R.id.NewPersonSurname)).getText().toString();
                String cell = ((EditText)rootView.findViewById(R.id.NewPersonCellphone)).getText().toString();
                String comments = ((EditText)rootView.findViewById(R.id.NewPersonComments)).getText().toString();
                String email = ((EditText)rootView.findViewById(R.id.NewPersonEmail)).getText().toString();
                String vehicleRegNo = ((EditText)rootView.findViewById(R.id.NewPersonVehicleRegNo)).getText().toString();
                Client client = new Client(name,surname,cell,vehicleRegNo,comments,email);
                logic.addClient(client);
            }
        });


        EditText txtPersonName = (EditText)rootView.findViewById(R.id.SearchPersonName);
        txtPersonName.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable s) {
                //Toast.makeText(context,s,Toast.LENGTH_LONG).show();
                searchName = s.toString();
                //updateListBox(getView());
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

        EditText txtPersonSurname = (EditText)rootView.findViewById(R.id.SearchPersonSurname);
        txtPersonName.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable s) {
                //Toast.makeText(context,s,Toast.LENGTH_LONG).show();
                searchSurname = s.toString();
                //updateListBox(getView());
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });

        EditText txtPersonCell = (EditText)rootView.findViewById(R.id.SearchPersonCellphone);
        txtPersonName.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable s) {
                //Toast.makeText(context,s,Toast.LENGTH_LONG).show();
                searchCell = s.toString();
                //updateListBox(getView());
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });
*/
        return rootView;
    }

    private void initializeTabs(){
        addClientFragment = new AddClientsFragment();
        updateClientFragment = new UpdateClientFragment();

        ActionBar actionBar = getActivity().getActionBar();
        actionBar.setNavigationMode(actionBar.NAVIGATION_MODE_TABS);

        addClientTab = actionBar.newTab().setText("Add Client");
        addClientTab.setTabListener(new AppTabListener(addClientFragment));
        actionBar.addTab(addClientTab);

        updateClientTab = actionBar.newTab().setText("Update Client");
        updateClientTab.setTabListener(new AppTabListener(updateClientFragment));
        actionBar.addTab(updateClientTab);
    }
}
