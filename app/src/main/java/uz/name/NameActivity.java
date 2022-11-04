package uz.name;

import android.content.res.AssetFileDescriptor;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

public class NameActivity extends AppCompatActivity {
    private NameAdapter nameAdapter;
    private EditText searchView;
    private ArrayList<Name> nameList, searchList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.searchView);
        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onTextChanged(CharSequence enteredText, int i, int i1, int i2) {
                searchList.clear();
                if (enteredText.toString() != "") {
                    for (Name name : nameList) {
                        if (name.getName().toLowerCase(Locale.ROOT).contains(enteredText.toString().toLowerCase(Locale.ROOT))) {
                            searchList.add(name);
                        }
                    }
                    nameAdapter = new NameAdapter(searchList, NameActivity.this);
                } else {
                    nameAdapter = new NameAdapter(nameList, NameActivity.this);
                }
                recyclerView.setAdapter(nameAdapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        try {
            InputStream inputStream = getAssets().open("merged.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer, 0, size);

            String jsonContent = new String(buffer);
            inputStream.close();

            Gson gson = new Gson();
            nameList = gson.fromJson(jsonContent, new TypeToken<List<Name>>() {
            }.getType());

            nameAdapter = new NameAdapter(nameList, NameActivity.this);
            recyclerView.setAdapter(nameAdapter);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
