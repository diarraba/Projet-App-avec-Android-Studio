package com.example.inp_hb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class partenaire extends AppCompatActivity {
    private Button mailpart;
    private Button contactpart;
    private Button communitypart;
    private Button agendapart;
    private Button actu;
    private Button etudiant;
    private Button administration;
    private Button partenaire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partenaire);
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
        this.agendapart= (Button) findViewById(R.id.agendapart);
        agendapart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent agendapart=new Intent(getApplicationContext(), com.example.inp_hb.Agenda.class);
                startActivity(agendapart);
                finish();
            }
        });
        this.communitypart= (Button) findViewById(R.id.communitypart);
        communitypart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent communitypart=new Intent(getApplicationContext(), com.example.inp_hb.INPcommunity.class);
                startActivity(communitypart);
                finish();
            }
        });
        this.contactpart= (Button) findViewById(R.id.contactpart);
        contactpart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contactpart=new Intent(getApplicationContext(), com.example.inp_hb.INPcontact.class);
                startActivity(contactpart);
                finish();
            }
        });
        this.mailpart= (Button) findViewById(R.id.mailpart);
        mailpart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mailpart=new Intent(getApplicationContext(), MailInstitutionnelle.class);
                startActivity(mailpart);
                finish();
            }
        });
    }
}