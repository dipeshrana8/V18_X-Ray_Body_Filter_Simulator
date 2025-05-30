package com.xraysim.bodyfilter.fun.uientry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.xraysim.bodyfilter.fun.R;
import com.xraysim.bodyfilter.fun.databinding.UpperBinding;

public class UpperActivity extends MainBaseActivity {

    private UpperBinding lytAct10Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lytAct10Binding = UpperBinding.inflate(getLayoutInflater());
        setContentView(lytAct10Binding.getRoot());


        lytAct10Binding.toolbarLayout.headerTitle.setText("Select Body Area");
        lytAct10Binding.toolbarLayout.btnBack.setOnClickListener(v -> handleBackNavigation());

        lytAct10Binding.btnUpper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lytAct10Binding.imgBackground.setImageResource(R.drawable.img_upper_select);
            }
        });
        lytAct10Binding.btnLower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lytAct10Binding.imgBackground.setImageResource(R.drawable.img_lower_select);
            }
        });
        lytAct10Binding.btnFull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lytAct10Binding.imgBackground.setImageResource(R.drawable.img_full_body_scan_select);
            }
        });
        lytAct10Binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpperActivity.this, SideBodyActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onBackPressed() {
        handleBackNavigation();
    }
}