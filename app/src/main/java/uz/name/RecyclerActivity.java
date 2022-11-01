package uz.name;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerActivity extends AppCompatActivity {
    private RecyclerAdapter recyclerAdapter;
    private ArrayList<Name> nameList = new ArrayList<>();
    private String[] letters = {"a", "b", "d"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        try {
            InputStream inputStream = getAssets().open("merged.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer, 0, size);

            String jsonContent = new String(buffer);
            inputStream.close();

            Gson gson = new Gson();
            ArrayList<Name> names = gson.fromJson(jsonContent, new TypeToken<List<Name>>() {
            }.getType());

            nameList = new ArrayList<>();
            for (Name n : names) {
                nameList.add(n);
            }

            ArrayList<NameAdapter> nameAdapters = new ArrayList<>();
            for (int i = 0; i < letters.length; i++) {
                ArrayList<Name> sortedList = new ArrayList<>();
                for (Name name : nameList
                ) {
                    if (name.getName().toLowerCase(Locale.ROOT).startsWith(letters[i])) {
                        sortedList.add(name);
                    }
                }
                NameAdapter nameAdapter = new NameAdapter(sortedList, RecyclerActivity.this);
                nameAdapters.add(nameAdapter);
            }
            recyclerAdapter = new RecyclerAdapter(nameAdapters, RecyclerActivity.this);
            recyclerView.setAdapter(recyclerAdapter);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
