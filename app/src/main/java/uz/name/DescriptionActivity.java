package uz.name;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DescriptionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);
        TextView textView = findViewById(R.id.description_tv);
        String olinganIsm =getIntent().getStringExtra("name");
        textView.setText("Description: "+olinganIsm);
    }
}
