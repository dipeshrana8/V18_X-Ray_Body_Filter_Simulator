package com.xraysim.bodyfilter.fun.uientry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.xraysim.bodyfilter.fun.databinding.PrivacyPolBinding;

public class PrivacyActivity extends MainBaseActivity {

    PrivacyPolBinding lytAct19Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lytAct19Binding = PrivacyPolBinding.inflate(getLayoutInflater());
        setContentView(lytAct19Binding.getRoot());
        lytAct19Binding.btnPrivacyCLick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrivacyActivity.this, A4_PrivacyActivity.class);
                startActivity(intent);
            }
        });

        lytAct19Binding.btnNext.setOnClickListener(v -> {

            Intent intent = new Intent(PrivacyActivity.this, StartActivity.class);
            startActivity(intent);
        });


    }

    @Override
    public void onBackPressed() {
        handleBackNavigation();
    }
}