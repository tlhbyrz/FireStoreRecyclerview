package com.talhababa.firestorerecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Add_note_Activity extends AppCompatActivity {

    EditText title,description;
    NumberPicker numberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note_);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        numberPicker = findViewById(R.id.numberPicker);

        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemSave:
                saveNote();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void saveNote() {
        String _title = title.getText().toString();
        String _description = description.getText().toString();
        int _priority = numberPicker.getValue();

        CollectionReference reference = FirebaseFirestore.getInstance()
                .collection("Notebook");

        reference.add(new CardviewNotes(_title,_description,_priority)).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                Toast.makeText(Add_note_Activity.this, "Notes added", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
