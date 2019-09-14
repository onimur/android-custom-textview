package com.onimus.customtextview;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

public class ConfigActivity extends AppCompatActivity {

    public static final String FONTFAMILY = "fontfamily";
    public static final String USER_FONTFAMILY = "user_fontfamily";
    public static final String CASUAL = "Casual";
    public static final String CURSIVA = "Cursiva";
    public static final String BASTAO = "Bastão";

    private Spinner spinner;
    private Button buttonSave;
    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        spinner = findViewById(R.id.spinner);
        buttonSave = findViewById(R.id.button3);
        preferences = getSharedPreferences(USER_FONTFAMILY, MODE_PRIVATE);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedItem = (String) spinner.getSelectedItem();

                if (selectedItem != null) {
                    SharedPreferences.Editor editor = preferences.edit();
                    switch (selectedItem) {
                        case (CASUAL): {
                            editor.putString(FONTFAMILY, CASUAL);
                            break;
                        }
                        case (CURSIVA): {
                            editor.putString(FONTFAMILY, CURSIVA);
                            break;
                        }
                        case (BASTAO): {
                            editor.putString(FONTFAMILY, BASTAO);
                            break;
                        }
                    }
                    editor.apply();

                }
            }
        });
    }
}
