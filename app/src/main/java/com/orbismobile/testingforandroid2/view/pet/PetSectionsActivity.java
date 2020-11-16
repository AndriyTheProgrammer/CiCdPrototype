package com.orbismobile.testingforandroid2.view.pet;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

import com.orbismobile.testingforandroid2.R;
import com.orbismobile.testingforandroid2.model.entities.PetEntity;
import com.orbismobile.testingforandroid2.model.entities.PetSectionEntity;

import java.util.ArrayList;
import java.util.List;

public class PetSectionsActivity extends AppCompatActivity {

    private List<PetSectionEntity> petSectionEntities = new ArrayList<>();
    private PetSectionAdapter petSectionAdapter;

    private List<PetEntity> petEntities;

    public PetSectionsActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_sections);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView rcvPetSections = findViewById(R.id.rcvPetSections);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        for (int i = 0; i < 100; i++) {
            petEntities = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                petEntities.add(new PetEntity("pet " +i+" - "+ j));
            }
            petSectionEntities.add(new PetSectionEntity(i,"TITLE " + i, petEntities));
        }

        petSectionAdapter = new PetSectionAdapter(petSectionEntities);
        rcvPetSections.setAdapter(petSectionAdapter);

    }
}
