package com.example.lenovo.gezgindostum.fragments;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.lenovo.gezgindostum.R;
import com.example.lenovo.gezgindostum.activities.AddNoteActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyNotesFragment extends Fragment {

    ArrayList<String> myNotesList;
    String myPlaces;
    ListView mynotesListview;
    ArrayAdapter<String> arrayAdapter;
    private ProgressDialog progressDialog;

    public MyNotesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View mynotesView = inflater.inflate(R.layout.fragment_my_notes, container, false);

        Button addNotesBTN = mynotesView.findViewById(R.id.buttonNot);
        addNotesBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addNoteIntent = new Intent(getContext(), AddNoteActivity.class);
            }
        });

        mynotesListview = mynotesView.findViewById(R.id.listViewNot);
        arrayAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, android.R.id.Simple, myNotesList);
        mynotesListview.setAdapter(arrayAdapter);
        return mynotesView;
    }

    private ArrayList<String> getMtNotes() {
        showProgressDialog();
        final ArrayList<String> myNotes = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference().child("Gezdiğimyerler");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                progressDialog.dismiss();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    myPlaces = ds.child("Sehiradi").getValue().toString();
                    myNotes.add(myPlaces);
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressDialog.dismiss();
            }
        });
        return myNotes;
    }
    private void showProgressDialog(){
        progressDialog=new ProgressDialog(getContext());
        progressDialog.setMessage("Yükleniyor..");
        progressDialog.setCancelable((false));
        progressDialog.show();
    }
}
