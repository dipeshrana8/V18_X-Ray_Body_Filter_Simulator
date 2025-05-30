package com.xraysim.bodyfilter.fun.uientry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.xraysim.bodyfilter.fun.R;
import com.xraysim.bodyfilter.fun.databinding.ActivitySkinToneBinding;

public class SkinToneActivity extends MainBaseActivity {

    private ActivitySkinToneBinding lytAct10Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lytAct10Binding = ActivitySkinToneBinding.inflate(getLayoutInflater());
        setContentView(lytAct10Binding.getRoot());


        lytAct10Binding.toolbarLayout.headerTitle.setText("Select Skin Tone");
        lytAct10Binding.toolbarLayout.btnBack.setOnClickListener(v -> handleBackNavigation());

        lytAct10Binding.btnNeutral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lytAct10Binding.imgBackground.setImageResource(R.drawable.img_neutral_select);
            }
        });
        lytAct10Binding.btnCool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lytAct10Binding.imgBackground.setImageResource(R.drawable.img_cool_select);
            }
        });
        lytAct10Binding.btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lytAct10Binding.imgBackground.setImageResource(R.drawable.img_medium_select);
            }
        });
        lytAct10Binding.btnWarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lytAct10Binding.imgBackground.setImageResource(R.drawable.img_warm_selected);
            }
        });
        lytAct10Binding.btnDeep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lytAct10Binding.imgBackground.setImageResource(R.drawable.img_deep_select);
            }
        });


        lytAct10Binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SkinToneActivity.this, UpperActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onBackPressed() {
        handleBackNavigation();
    }
}