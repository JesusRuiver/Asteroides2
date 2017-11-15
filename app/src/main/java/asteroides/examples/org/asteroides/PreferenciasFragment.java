package asteroides.examples.org.asteroides;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by Vespertino on 08/11/2017.
 */

public class PreferenciasFragment extends PreferenceFragment{

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);
    }
}
