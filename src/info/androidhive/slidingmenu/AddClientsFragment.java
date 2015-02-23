package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by rudiger on 2014/12/11.
 */
public class AddClientsFragment extends Fragment {
    private Logic logic;

    public AddClientsFragment(){
        logic = Logic.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_add_client,container,false);
        logic.setContext(view.getContext());

        Button submitButton = (Button)view.findViewById(R.id.SubmitNewClient);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ((EditText)view.findViewById(R.id.NewPersonName)).getText().toString();
                String surname = ((EditText)view.findViewById(R.id.NewPersonSurname)).getText().toString();
                String cell = ((EditText)view.findViewById(R.id.NewPersonCellphone)).getText().toString();
                String comments = ((EditText)view.findViewById(R.id.NewPersonComments)).getText().toString();
                String email = ((EditText)view.findViewById(R.id.NewPersonEmail)).getText().toString();
                String vehicleRegNo = ((EditText)view.findViewById(R.id.NewPersonVehicleRegNo)).getText().toString();
                Client client = new Client(name,surname,cell,vehicleRegNo,comments,email);
                logic.addClient(client);
                logic.notify("Client added...");
            }
        });

        return view;
    }

}
