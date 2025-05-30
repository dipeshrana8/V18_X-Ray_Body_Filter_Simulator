package com.xraysim.bodyfilter.fun.uientry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.xraysim.bodyfilter.fun.R;
import com.xraysim.bodyfilter.fun.databinding.SidebodyBinding;

public class SideBodyActivity extends MainBaseActivity {

    private SidebodyBinding lytAct10Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lytAct10Binding = SidebodyBinding.inflate(getLayoutInflater());
        setContentView(lytAct10Binding.getRoot());


        lytAct10Binding.toolbarLayout.headerTitle.setText("Select Body Side");
        lytAct10Binding.toolbarLayout.btnBack.setOnClickListener(v -> handleBackNavigation());

        lytAct10Binding.btnFront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lytAct10Binding.imgBackground.setImageResource(R.drawable.img_front_selected);
            }
        });
        lytAct10Binding.btnBackSide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lytAct10Binding.imgBackground.setImageResource(R.drawable.img_back_selected);
            }
        });
        lytAct10Binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SideBodyActivity.this, MuscularActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onBackPressed() {
        handleBackNavigation();
    }
}