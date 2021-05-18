package com.example.lesson1a2;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;
public class ProfileFragment extends Fragment {
    private ImageView imgView;

    ActivityResultLauncher<String> launcher = registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri uri) {
                imgView.setImageURI(uri);
            }
        });
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       imgView = view.findViewById(R.id.image_view);
       imgView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               launcher.launch("image/*");
           }
       });
    }
}