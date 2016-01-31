package com.example.pierre_henrilibeert.edt;

/**
 * Created by Nicolas on 07/01/2016.
 */

    public interface DownloadListener {

        /***
         * Méthode appelée lors du téléchargement d'un fichier
         * @param result le contenu du fichier
         */
        public void onDownload(String result);
    }

