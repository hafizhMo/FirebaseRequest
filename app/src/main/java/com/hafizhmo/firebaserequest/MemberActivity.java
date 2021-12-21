package com.hafizhmo.firebaserequest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.hafizhmo.firebaserequest.databinding.ActivityMemberBinding;

import java.util.ArrayList;

public class MemberActivity extends AppCompatActivity {

    private ActivityMemberBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMemberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        ArrayList<Member> members = new ArrayList<>();

        firestore.collection("everglowDB").get().addOnSuccessListener(queryDocumentSnapshots -> {
            for (QueryDocumentSnapshot fish : queryDocumentSnapshots) {
                members.add(
                        new Member(
                                fish.getData().get("name").toString(),
                                fish.getData().get("role").toString(),
                                fish.getData().get("image").toString()
                        )
                );
            }
            binding.rvMain.setAdapter(new MemberAdapter(this, members));
            binding.rvMain.setLayoutManager(new LinearLayoutManager(this));
        }).addOnFailureListener(e -> {
            Toast.makeText(this, "Failure to load data: " + e.toString(), Toast.LENGTH_SHORT).show();
        });
    }
}