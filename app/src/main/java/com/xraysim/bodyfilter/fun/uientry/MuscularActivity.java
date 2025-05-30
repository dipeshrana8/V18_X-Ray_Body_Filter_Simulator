package com.xraysim.bodyfilter.fun.uientry;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.xraysim.bodyfilter.fun.R;
import com.xraysim.bodyfilter.fun.databinding.ActivityMuscularBinding;

public class MuscularActivity extends MainBaseActivity {

    private ActivityMuscularBinding lytAct10Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lytAct10Binding = ActivityMuscularBinding.inflate(getLayoutInflater());
        setContentView(lytAct10Binding.getRoot());


        lytAct10Binding.toolbarLayout.headerTitle.setText("Select Scanner Type");
        lytAct10Binding.toolbarLayout.btnBack.setOnClickListener(v -> handleBackNavigation());

        lytAct10Binding.btnMuscular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("type", "btnMuscular");
                editor.apply();
                lytAct10Binding.imgBackground.setImageResource(R.drawable.img_muschular_selected);
            }
        });
        lytAct10Binding.btnNervous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("type", "btnNervous");
                editor.apply();
                lytAct10Binding.imgBackground.setImageResource(R.drawable.img_nervous_type_selected);
            }
        });
        lytAct10Binding.btnVascular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("type", "btnVascular");
                editor.apply();
                lytAct10Binding.imgBackground.setImageResource(R.drawable.img_vescular_selected);
            }
        });
        lytAct10Binding.btnSkeletal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("type", "btnSkeletal");
                editor.apply();
                lytAct10Binding.imgBackground.setImageResource(R.drawable.img_skeletal_type);
            }
        });


        lytAct10Binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MuscularActivity.this, FaceActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onBackPressed() {
        handleBackNavigation();
    }
}