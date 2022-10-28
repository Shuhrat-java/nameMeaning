package uz.name;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class NameActivity extends AppCompatActivity {
    private NameAdapter nameAdapter;
    String[] list = {"Mustafo","Muhammad","Imron","Zubayr","Ali","Abdulloh","Umar","Muhammadali","Muhammadyusuf","Abubakr","Muhammadamin","Ibrohim","Aziz","Bilol","Usmon","Amir","Shohrux","Kamron","Ayub","Firdavs","Islom","Asad","Yasin","Akbar","Abduaziz","Behruz","Sardor","Habib","Diyor","Samir","Abdurahmon","Javohir","Mironshoh","Yahyo","Shahzoda","Bobur","Abbos","Muhammadumar","Sanjar","Akobir","Ulug‘bek","Salohiddin","Jahongir","Jamshid","Ahmad","Farruh","Abror","Muhammadrizo","Sarvar","Humoyun","Muhammadziyo","Samandar","Doniyor","Muxtasar","Shahzod","Temir","Shohjahon","Jalol","Said","Mahmud","Abdumalik","Daler","Otabek","Axiy","Murod","Dovud","Farhod","Sherzod","Jasur","Damir","Akmal","Asilbek","Shahriyor","Anvar","Davron","Dilshod","Shahboz","Ismoil","A’zam","Isfandiyor","Oybek","Rustam","Laziz","Bekzod","Alisher","Nodir","Umid","Muslim","Halid","Rasul","Doston","Sulaymon","Ilyos","Shohruz","Yunus","Azim","Bahrom","Ruslan","Muhammadamir","Muhammadayub"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        ArrayList<String> nameList = new ArrayList<>();
        for (String n : list) {
            nameList.add(n);
        }
        nameAdapter = new NameAdapter(nameList, NameActivity.this);
        recyclerView.setAdapter(nameAdapter);

    }

}
