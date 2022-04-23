package com.example.inp_hb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class etudiant extends AppCompatActivity {
    private Button plan;
    private Button word;
    private Button excel;
    private Button mail;
    private Button contact;
    private Button community;
    private Button agen;
    private Button afai;
    private Button infoetudiant;
    private Button actu;
    private Button etudiant;
    private Button administration;
    private Button partenaire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etudiant);
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
        this.infoetudiant= (Button) findViewById(R.id.infoetudiant);
        infoetudiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infoetudiant=new Intent(getApplicationContext(), InfoEtud.class);
                startActivity(infoetudiant);
                finish();
            }
        });
        this.afai= (Button) findViewById(R.id.afai);
        afai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent afai=new Intent(getApplicationContext(), com.example.inp_hb.AFaire.class);
                startActivity(afai);
                finish();
            }
        });
        this.agen= (Button) findViewById(R.id.agen);
        agen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent agen=new Intent(getApplicationContext(), com.example.inp_hb.Agenda.class);
                startActivity(agen);
                finish();
            }
        });
        this.community= (Button) findViewById(R.id.community);
        community.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent community=new Intent(getApplicationContext(), com.example.inp_hb.INPcommunity.class);
                startActivity(community);
                finish();
            }
        });
        this.contact= (Button) findViewById(R.id.contact);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contact=new Intent(getApplicationContext(), com.example.inp_hb.INPcontact.class);
                startActivity(contact);
                finish();
            }
        });
        this.mail= (Button) findViewById(R.id.mail);
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mail=new Intent(getApplicationContext(), MailInstitutionnelle.class);
                startActivity(mail);
                finish();
            }
        });
        this.excel= (Button) findViewById(R.id.excel);
        excel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent excel=new Intent(getApplicationContext(), com.example.inp_hb.MonExcel.class);
                startActivity(excel);
                finish();
            }
        });
        this.word= (Button) findViewById(R.id.word);
        word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent word=new Intent(getApplicationContext(), com.example.inp_hb.MonWord.class);
                startActivity(word);
                finish();
            }
        });
        this.plan= (Button) findViewById(R.id.plan);
        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent plan=new Intent(getApplicationContext(), com.example.inp_hb.Planificateur.class);
                startActivity(plan);
                finish();
            }
        });
    }
}