package com.example.lakhbir.fragmnttofragmentcommunication;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MessageFragment.OnMessageSendListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null){

            if(savedInstanceState != null) {
                return;
            }

            MessageFragment messageFragment = new MessageFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, messageFragment, null).commit();
        }

    }

    @Override
    public void onMessageSend(String message) {

        DisplayFragment displayFragment = new DisplayFragment();

        // Send data to this fragment so create object of Bundle class.
        Bundle bundle = new Bundle();
        bundle.putString("message", message);

        // Now Add bundle object to fragment.
        displayFragment.setArguments(bundle);

        //Now replac the Firsy FRagment with Second one.

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, displayFragment, null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();



    }
}
