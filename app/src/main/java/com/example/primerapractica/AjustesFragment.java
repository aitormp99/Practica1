package com.example.primerapractica;


import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

public class AjustesFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener{

    private ListPreference idioma,tema;
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preferencias);


        idioma = (ListPreference) findPreference("idioma");
        tema = (ListPreference) findPreference("tema");

        SharedPreferences sharedPreferences =  PreferenceManager.getDefaultSharedPreferences(this.getContext());

        actualizarCampo(sharedPreferences,"idioma");
        actualizarCampo(sharedPreferences,"tema");

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        guardarDato(sharedPreferences,key);
        actualizarCampo(sharedPreferences,key);
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    private void actualizarCampo(SharedPreferences sharedPreferences,String key){
        if(key.equals("idioma"))
            idioma.setSummary(idioma.getEntry());
        if(key.equals("tema"))
            tema.setSummary(tema.getEntry());
    }


    private void guardarDato(SharedPreferences sharedPreferences, String key){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(key.equals("idioma")) {
            editor.putString("idioma", idioma.getValue());
        }
        else if(key.equals("tema")){
            editor.putString("tema",tema.getValue());

        }
        reiniciar();
        editor.apply();
        reiniciar();
    }

    public void reiniciar(){
        if(getActivity() instanceof Preferencias ){
            Preferencias preferencias = (Preferencias) getActivity();
            preferencias.reload();
        }
    }


    }

