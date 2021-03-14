package com.example.gestiondemploie;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class CvFragment extends Fragment {
    private EditText txtFirstName, txtLastName,txtEmail,txtSector,textExperience;
    private CheckBox cbOLevel, cbBachelor, cbMaster;
    private Button btnSave;
    private String firstName,lastName, degrees,email,sector,experience;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cv, container, false);
        txtFirstName = view.findViewById(R.id.txtFirstName);
        txtLastName = view.findViewById(R.id.txtLastName);
        txtEmail = view.findViewById(R.id.txtEmail);
        txtSector = view.findViewById(R.id.txtSecotor);
        cbOLevel = view.findViewById(R.id.cbOLevel);
        cbBachelor = view.findViewById(R.id.cbBachelor);
        cbMaster = view.findViewById(R.id.cbMaster);
        textExperience = view.findViewById(R.id.txtExperience);
        btnSave = view.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName = txtFirstName.getText().toString().trim();
                lastName = txtLastName.getText().toString().trim();
                email = txtEmail.getText().toString().trim();
                sector = txtSector.getText().toString().trim();
                experience = textExperience.getText().toString().trim();
                degrees = "";
                if (cbOLevel.isChecked())
                {
                    degrees+= cbOLevel.getText().toString()+"";
                }

                if (cbBachelor.isChecked())
                {
                    degrees+= cbBachelor.getText().toString()+"";
                }

                if (cbMaster.isChecked())
                {
                    degrees+= cbMaster.getText().toString();
                }
                if (lastName.isEmpty()||lastName.isEmpty()||email.isEmpty()||sector.isEmpty()||degrees.isEmpty()||experience.isEmpty())
                {
                    Toast.makeText(getActivity(), getString(R.string.error_fields), Toast.LENGTH_SHORT).show();
                }
                else{
                    //recuperation des valeurs
                    String resume= firstName+"\n\n"+lastName+"\n\n"+email+"\n\n"+sector+"\n\n"+degrees+"\n\n"+experience;
                    Toast.makeText(getActivity(), resume, Toast.LENGTH_SHORT).show();
                    //applyServer();
                }
            }
        });

        return view;
    }
}