package com.example.contactaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.contactaapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ArrayList<Contact> contactList;
    private ContactsAdapter contactsAdapter;
    private AppDatabase appDatabase;
    private ContactDao contactDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View viewRoot =binding.getRoot();
        setContentView(viewRoot);
        binding.rvContacts.setLayoutManager(new LinearLayoutManager(this));
        contactList=new ArrayList<Contact>();
        contactsAdapter=new ContactsAdapter(contactList);
        binding.rvContacts.setAdapter(contactsAdapter);
        contactList.add(new Contact("Nguyen Van A","0123456778","vanA@gmail.com"));
        contactList.add(new Contact("Nguyen Van B","012345699","vanB@gmail.com"));
        contactList.add(new Contact("Nguyen Van C","0123456888","vanC@gmail.com"));



        contactsAdapter.notifyDataSetChanged();
        appDatabase=AppDatabase.getInstance(this);
        contactDao=appDatabase.contactDao();
        contactDao.insert(new Contact("Nguyen Van A","0123456778","vanA@gmail.com"));;
    }
}