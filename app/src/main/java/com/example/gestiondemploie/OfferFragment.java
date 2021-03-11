package com.example.gestiondemploie;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class OfferFragment extends Fragment {
    private ListView listOffer;
    private String [] tabOffer,tabDetails;
    private String  details;
    public static String offer;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_offer, container, false);
        listOffer = view.findViewById(R.id.listOffer);//Recuperation de la liste
        tabOffer = getResources().getStringArray(R.array.tab_Offer);
        tabDetails = getResources().getStringArray(R.array.tab_Offer);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,tabOffer);
        listOffer.setAdapter(arrayAdapter);//chargement des donnees
        listOffer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                offer = tabOffer [position];
                details = tabDetails [position];

                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());//builder parceque ya deux button
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setTitle(offer);
                dialog.setMessage(details);
                dialog.setNegativeButton(getString(R.string.cancel), null);
                dialog.setPositiveButton(getString(R.string.apply), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //appel du fragment apply(postuler) apres le click sur le button apply
                        getFragmentManager().beginTransaction()
                                .replace(R.id.nav_host_fragment, new ApplyFragment())
                                .addToBackStack(null)
                                .commit();

                    }
                });
                 dialog.show();//






            }
        });

        return view;
    }
}