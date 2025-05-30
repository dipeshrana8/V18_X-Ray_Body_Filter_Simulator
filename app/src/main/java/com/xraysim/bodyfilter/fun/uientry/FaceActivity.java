package com.xraysim.bodyfilter.fun.uientry;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.xraysim.bodyfilter.fun.R;
import com.xraysim.bodyfilter.fun.databinding.ActivityFaceBinding;

public class FaceActivity extends MainBaseActivity {

    private ActivityFaceBinding lytAct10Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lytAct10Binding = ActivityFaceBinding.inflate(getLayoutInflater());
        setContentView(lytAct10Binding.getRoot());


        lytAct10Binding.toolbarLayout.headerTitle.setText("Select Body Area");
        lytAct10Binding.toolbarLayout.btnBack.setOnClickListener(v -> handleBackNavigation());

        lytAct10Binding.btnFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("category", "btnFace");
                editor.apply();

                lytAct10Binding.imgBackground.setImageResource(R.drawable.img_face_scan_selected);
            }
        });
        lytAct10Binding.btnChest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("category", "btnChest");
                editor.apply();
                lytAct10Binding.imgBackground.setImageResource(R.drawable.img_chest_scan);
            }
        });
        lytAct10Binding.btnHand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("category", "btnHand");
                editor.apply();
                lytAct10Binding.imgBackground.setImageResource(R.drawable.img_hand_scan_selected);
            }
        });
        lytAct10Binding.btnLeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("category", "btnLeg");
                editor.apply();
                lytAct10Binding.imgBackground.setImageResource(R.drawable.img_leg_scan);
            }
        });
        lytAct10Binding.btnFoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("category", "btnFoot");
                editor.apply();
                lytAct10Binding.imgBackground.setImageResource(R.drawable.img_foot_scan_selected);
            }
        });


        lytAct10Binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FaceActivity.this, PriviewActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onBackPressed() {
        handleBackNavigation();
    }
}