package com.example.inp_hb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button inpbt;
    private Button edubt;
    private Button decouverte;
    private Button people;
    private Button forum;
    private Button actu;
    private Button etudiant;
    private Button administration;
    private Button partenaire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.actu= (Button) findViewById(R.id.actu);
        actu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent actu=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(actu);
                finish();
            }
        });this.etudiant= (Button) findViewById(R.id.etudiant);
        etudiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent etudiant=new Intent(getApplicationContext(), etudiant.class);
                startActivity(etudiant);
                finish();
            }
        });this.administration= (Button) findViewById(R.id.administration);
        administration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent administration=new Intent(getApplicationContext(), administration.class);
                startActivity(administration);
                finish();
            }
        });
        this.partenaire= (Button) findViewById(R.id.partenaire);
        partenaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent partenaire=new Intent(getApplicationContext(), partenaire.class);
                startActivity(partenaire);
                finish();
            }
        });
        this.forum= (Button) findViewById(R.id.forum);
        forum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forum=new Intent(getApplicationContext(), inpforum.class);
                startActivity(forum);
                finish();
            }
        });
        this.inpbt= (Button) findViewById(R.id.inpbt);
        inpbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inpbt=new Intent(getApplicationContext(), inp.class);
                startActivity(inpbt);
                finish();
            }
        });
        this.edubt= (Button) findViewById(R.id.edubt);
        edubt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent edubt=new Intent(getApplicationContext(), EDUCATION.class);
                startActivity(edubt);
                finish();
            }
        });
        this.decouverte= (Button) findViewById(R.id.inpspaceadm);
        decouverte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent decouverte=new Intent(getApplicationContext(), com.example.inp_hb.decouverte.class);
                startActivity(decouverte);
                finish();
            }
        });
        this.people= (Button) findViewById(R.id.people1);
        people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent people=new Intent(getApplicationContext(), People.class);
                startActivity(people);
                finish();
            }
        });
    }
}
