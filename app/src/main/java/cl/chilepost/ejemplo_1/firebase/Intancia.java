package cl.chilepost.ejemplo_1.firebase;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class Intancia extends FirebaseInstanceIdService
{
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        //Log.d("mama=", FirebaseInstanceId.getInstance().getToken());


    }



}

