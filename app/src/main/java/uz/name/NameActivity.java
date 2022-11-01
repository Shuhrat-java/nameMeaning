package uz.name;

import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class NameActivity extends AppCompatActivity {
    private NameAdapter nameAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
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

            ArrayList<Name> nameList = new ArrayList<>();
            for (Name n : names) {
                nameList.add(n);
            }
            nameAdapter = new NameAdapter(nameList, NameActivity.this);
            recyclerView.setAdapter(nameAdapter);
        } catch (IOException e) {
            e.printStackTrace();
        }




    }

}
