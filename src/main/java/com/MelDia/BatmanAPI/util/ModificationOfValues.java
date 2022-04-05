package com.MelDia.BatmanAPI.util;

import com.MelDia.BatmanAPI.model.Batman;
import com.MelDia.BatmanAPI.model.BatmanModification;

public class ModificationOfValues {

    public static void setValuesMovie(Batman batman, BatmanModification batMod) {
        if ( batMod.getMovie_name() != null ) {
            batman.setMovie_name(batMod.getMovie_name());
        }
        
        if ( batMod.getRelease_date() != null ) {
            batman.setRelease_date(batMod.getRelease_date());
        }
        
        if ( batMod.getDirector() != null ) {
            batman.setDirector(batMod.getDirector());
        }
        
        if ( batMod.getProtagonist() != null ) {
            batman.setProtagonist(batMod.getProtagonist());
        }
    }
}
