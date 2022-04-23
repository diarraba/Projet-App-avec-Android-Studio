package com.example.inp_hb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class administration extends AppCompatActivity {
    private Button mailadmi;
    private Button contactadmi;
    private Button communityadmi;
    private Button agendaadmi;
    private Button actu;
    private Button etudiant;
    private Button administration;
    private Button partenaire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administration);
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
        this.agendaadmi= (Button) findViewById(R.id.agendaadmi);
        agendaadmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent agendaadmi=new Intent(getApplicationContext(), com.example.inp_hb.Agenda.class);
                startActivity(agendaadmi);
                finish();
            }
        });
        this.communityadmi= (Button) findViewById(R.id.communityadmi);
        communityadmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent communityadmi=new Intent(getApplicationContext(), com.example.inp_hb.INPcommunity.class);
                startActivity(communityadmi);
                finish();
            }
        });
        this.contactadmi= (Button) findViewById(R.id.contactadmi);
        contactadmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contactadmi=new Intent(getApplicationContext(), com.example.inp_hb.INPcontact.class);
                startActivity(contactadmi);
                finish();
            }
        });
        this.mailadmi= (Button) findViewById(R.id.mailadmi);
        mailadmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mailadmi=new Intent(getApplicationContext(), MailInstitutionnelle.class);
                startActivity(mailadmi);
                finish();
            }
        });
    }
}