package live.syslyncerp.com;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CreateFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreateFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreateFragment newInstance(String param1, String param2) {
        CreateFragment fragment = new CreateFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    DatePickerDialog picker;
    EditText etext,stext,replaceTxt;
    TextView replacedtxt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private ImageButton imageButton;

    List<String> leaveTypes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_create, container, false);

        stext = (EditText) rootview.findViewById(R.id.etEndDate);
        etext = (EditText) rootview.findViewById(R.id.etStartDate);
        etext.setInputType(InputType.TYPE_NULL);
        stext.setInputType(InputType.TYPE_NULL);
        stext.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);

                picker = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        stext.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                },year,month,day);
                picker.show();
            }
        });
        etext.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);

                picker = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        etext.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                },year,month,day);
                        picker.show();
            }
        });

        replacedtxt = (TextView) rootview.findViewById(R.id.replaceby);
        replacedtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(getContext(), v);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.replaced_popup_menu, popup.getMenu());
                popup.show();
            }
        });


        Spinner spinner = (Spinner) rootview.findViewById(R.id.leave_type);

        leaveTypes = new ArrayList<>();

        leaveTypes.add("Sick Leave");
        leaveTypes.add("Annual Leave");
        leaveTypes.add("Casual Leave");
        leaveTypes.add("Medical Leave");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),R.layout.simple_spinner_text,leaveTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        return rootview;
    }

}