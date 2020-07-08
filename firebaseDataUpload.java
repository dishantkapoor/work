package com.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class UploadDataFirebase extends AppCompatActivity {
    Button upload;
    FirebaseFirestore firebaseFirestore;
    EditText EventName, EventLocation, EventData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_data_firebase);
        EventName = findViewById(R.id.eveName);
        EventLocation = findViewById(R.id.eveLocation);
        EventData = findViewById(R.id.eveData);
        upload = findViewById(R.id.upload);
        firebaseFirestore = FirebaseFirestore.getInstance();

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String EveName = EventName.getText().toString().trim();
                String EveLocation = EventLocation.getText().toString().trim();
                String EveData = EventData.getText().toString().trim();

                if (EveName.isEmpty()) {
                    EventName.setError("Enter Event Name");

                } else if (EveLocation.isEmpty()) {
                    EventLocation.setError("Enter Event Location");
                } else if (EveData.isEmpty()) {
                    EventData.setError("Enter Event Data");
                } else {
                    Map<String, Object> map = new HashMap<>();
                    map.put("EventName", EveName);
                    map.put("EventLocation", EveLocation);
                    map.put("EventData", EveData);
                    firebaseFirestore.collection("EventData").document().set(map);

                }
            }
        });


    }
}
