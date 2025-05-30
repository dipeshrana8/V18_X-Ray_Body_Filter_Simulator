package com.xraysim.bodyfilter.fun.uientry;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.xraysim.bodyfilter.fun.R;
import com.xraysim.bodyfilter.fun.databinding.ActivityPriviewBinding;

import java.io.IOException;
import java.io.OutputStream;

public class PriviewActivity extends MainBaseActivity {

    private static final int CREATE_FILE_REQUEST_CODE = 1001;
    ActivityPriviewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPriviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbarLayout.headerTitle.setText("Select Body Area");
        binding.toolbarLayout.btnBack.setOnClickListener(v -> handleBackNavigation());

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String name = sharedPreferences.getString("category", "btnFace");

        if (name.equals("btnFace")) {
            binding.toolbarLayout.headerTitle.setText("Face Scan");
            binding.imgChange.setImageResource(R.drawable.img_pr_face);
        } else if (name.equals("btnChest")) {
            binding.toolbarLayout.headerTitle.setText("Chest Scan");
            binding.imgChange.setImageResource(R.drawable.img_pr_chest);
        } else if (name.equals("btnHand")) {
            binding.toolbarLayout.headerTitle.setText("Hand Scan");
            binding.imgChange.setImageResource(R.drawable.img_pr_hand);
        } else if (name.equals("btnLeg")) {
            binding.toolbarLayout.headerTitle.setText("Leg Scan");
            binding.imgChange.setImageResource(R.drawable.img_pr_leg);
        } else if (name.equals("btnFoot")) {
            binding.toolbarLayout.headerTitle.setText("Foot Scan");
            binding.imgChange.setImageResource(R.drawable.img_pr_foot);
        }

        binding.btnScan.setOnClickListener(v -> {

            String type = sharedPreferences.getString("type", "btnMuscular");

            int newImageResId = getImageResource(type, name);
            binding.imgChange.setImageResource(newImageResId);

            binding.btnScan.setVisibility(View.GONE);
            binding.btnDonwload.setVisibility(View.VISIBLE);
        });

        binding.btnDonwload.setOnClickListener(v -> {


            binding.imgChange.post(() -> {
                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                    createImageFile();
                }, 300);
            });
        });
    }

    private int getImageResource(String type, String name) {
        switch (type) {
            case "btnMuscular":
                switch (name) {
                    case "btnFace":
                        return R.drawable.muscular_face;
                    case "btnChest":
                        return R.drawable.muscular_cheast;
                    case "btnHand":
                        return R.drawable.muscular_hand;
                    case "btnLeg":
                        return R.drawable.muscular_leg;
                    case "btnFoot":
                        return R.drawable.muscular_foot;
                }
                break;
            case "btnNervous":
                switch (name) {
                    case "btnFace":
                        return R.drawable.nervous_face;
                    case "btnChest":
                        return R.drawable.nervous_cheast;
                    case "btnHand":
                        return R.drawable.nervous_hand;
                    case "btnLeg":
                        return R.drawable.nervous_leg;
                    case "btnFoot":
                        return R.drawable.nervous_foot;
                }
                break;
            case "btnVascular":
                switch (name) {
                    case "btnFace":
                        return R.drawable.vascular_face;
                    case "btnChest":
                        return R.drawable.vascular_cheast;
                    case "btnHand":
                        return R.drawable.vascular_hand;
                    case "btnLeg":
                        return R.drawable.vascular_leg;
                    case "btnFoot":
                        return R.drawable.vascular_foot;
                }
                break;
            case "btnSkeletal":
                switch (name) {
                    case "btnFace":
                        return R.drawable.skeletal_face;
                    case "btnChest":
                        return R.drawable.skeletal_cheast;
                    case "btnHand":
                        return R.drawable.skeletal_hand;
                    case "btnLeg":
                        return R.drawable.skeletal_leg;
                    case "btnFoot":
                        return R.drawable.skeletal_foot;
                }
                break;
        }
        return R.drawable.img_app_intro; // fallback
    }

    private void createImageFile() {
        Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/png");
        intent.putExtra(Intent.EXTRA_TITLE, "scanned_image_" + System.currentTimeMillis() + ".png");
        startActivityForResult(intent, CREATE_FILE_REQUEST_CODE);
    }

    // Step 2: Save the FrameLayout as Bitmap
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CREATE_FILE_REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();
            saveFrameLayoutAsImage(uri);
        }
    }

    private void saveFrameLayoutAsImage(Uri uri) {
        FrameLayout frameLayout = binding.frameFace;

        // Capture layout into bitmap
        Bitmap bitmap = Bitmap.createBitmap(
                frameLayout.getWidth(),
                frameLayout.getHeight(),
                Bitmap.Config.ARGB_8888
        );
        Canvas canvas = new Canvas(bitmap);
        frameLayout.draw(canvas);

        // Save to chosen URI
        try (OutputStream out = getContentResolver().openOutputStream(uri)) {
            if (out != null) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
                Toast.makeText(this, "Image downloaded successfully", Toast.LENGTH_SHORT).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to save image", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        handleBackNavigation();
    }
}