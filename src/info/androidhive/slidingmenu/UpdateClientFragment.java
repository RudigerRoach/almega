package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rudiger on 2014/12/19.
 */
public class UpdateClientFragment extends Fragment {
    private String cell = "";
    private String name = "";
    private String surname = "";
    private long clientId = -1;
    private View thisView;
    Logic logic = Logic.getInstance();

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_update_client,container,false);
        thisView = view;

        final EditText searchCell = (EditText)view.findViewById(R.id.SearchPersonCellphone);
        searchCell.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cell = s.toString();
                updateSearchList();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        final EditText searchName = (EditText)view.findViewById(R.id.SearchPersonName);
        searchName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                name = s.toString();
                updateSearchList();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        final EditText searchSurname = (EditText)view.findViewById(R.id.SearchPersonSurname);
        searchSurname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                surname = s.toString();
                updateSearchList();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        final ListView list = (ListView)view.findViewById(R.id.listView);

        ListView.OnItemClickListener listener = new ListView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String client = list.getItemAtPosition(position).toString();
                logic.notify(client+" selected...");
                String selectedCell = client.substring(0,client.indexOf('|')-1);
                client = client.substring(client.indexOf('|')+2);
                String selectedName = client.substring(0,client.indexOf('|')-1);
                client = client.substring(client.indexOf('|')+2);
                String selectedSurname = client;

                Client toUpdate = logic.getClient(selectedCell,selectedName,selectedSurname);
                populateForm(toUpdate);
            }
        };
        list.setOnItemClickListener(listener);

        Button applyChanges = (Button)view.findViewById(R.id.btnSubmitClientChanges);
        applyChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clientId != -1){
                    Client client = getFormInfo();
                    logic.updateClient(client);
                }else{
                    logic.notify("Select a client first");
                }

            }
        });
        return view;
    }

    private void updateSearchList(){
        List<Client> clients = logic.getClients();
        ArrayAdapter<String> listAdapter ;

        listAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simplerow);
        LinkedList<Integer> toDelete = new LinkedList<Integer>();
        for (int index = 0; index < clients.size(); index++){
            Client c = clients.get(index);
            if (!c.getCell().contains(cell)) toDelete.add(index);
            else if (!c.getSurname().contains(surname)) toDelete.add(index);
            else if (!c.getName().contains(name)) toDelete.add(index);
            else listAdapter.add(c.toShortString());
        }

        ListView lv = (ListView)thisView.findViewById(R.id.listView);
        lv.setAdapter(listAdapter);
    }

    private void populateForm(Client client){
        clientId = client.getId();
        ((EditText)thisView.findViewById(R.id.UpdatePersonName)).setText(client.getName());
        ((EditText)thisView.findViewById(R.id.UpdatePersonSurname)).setText(client.getSurname());
        ((EditText)thisView.findViewById(R.id.UpdatePersonCell)).setText(client.getCell());
        ((EditText)thisView.findViewById(R.id.UpdatePersonEmail)).setText(client.getEmail());
        ((EditText)thisView.findViewById(R.id.UpdatePersonVehicle)).setText(client.getVehicle());
        ((EditText)thisView.findViewById(R.id.UpdatePersonComments)).setText(client.getComment());
    }

    private Client getFormInfo(){
        Client client = new Client();
        client.setId(clientId);
        client.setName(((EditText) thisView.findViewById(R.id.UpdatePersonName)).getText().toString());
        client.setSurname(((EditText) thisView.findViewById(R.id.UpdatePersonSurname)).getText().toString());
        client.setCell(((EditText) thisView.findViewById(R.id.UpdatePersonCell)).getText().toString());
        client.setEmail(((EditText) thisView.findViewById(R.id.UpdatePersonEmail)).getText().toString());
        client.setVehicle(((EditText) thisView.findViewById(R.id.UpdatePersonVehicle)).getText().toString());
        client.setComment(((EditText) thisView.findViewById(R.id.UpdatePersonComments)).getText().toString());
        return client;
    }
}
