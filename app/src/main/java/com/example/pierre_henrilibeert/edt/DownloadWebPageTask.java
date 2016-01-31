package com.example.pierre_henrilibeert.edt;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by Nicolas on 07/01/2016.
 */

class DownloadWebPageTask extends AsyncTask<String, String, String> {

    private DownloadListener listener; // L'objet à prévenir à la fin du téléchargement.

    /***
     * Créé la tache de téléchargement.
     * @param listener A chaque fin de téléchargement, la méthode onDownload du listener sera appelée
     */
    public DownloadWebPageTask(DownloadListener listener) {
        this.listener = listener;
    }

    /***
     * Télécharge le fichier texte présent à une URL donnée.
     * @param urls seule la première url est utilisée.
     * @return le fichier (texte) téléchargé
     */
    @Override
    protected String doInBackground(String... urls) {
        String line, file;
        file = "";

        try {
            URL url = new URL(urls[0]);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            while ((line = reader.readLine()) != null) {
                file += line + "\n";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    /***
     * Appelle le listener
     * @param result contenu (texte) du fichier téléchargé
     */
    @Override
    protected void onPostExecute(String result) {
        listener.onDownload(result);
    }
}