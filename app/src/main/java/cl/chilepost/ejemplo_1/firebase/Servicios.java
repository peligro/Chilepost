package cl.chilepost.ejemplo_1.firebase;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.app.PendingIntent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import cl.chilepost.ejemplo_1.R;

public class Servicios extends FirebaseMessagingService
{
    //en este método procesamos los parámetros que vienen del PUSH a través de la clase modelo
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage)
    {
        super.onMessageReceived(remoteMessage);
        //recibo y formateo los parámetros que vienen del PUSH
        NotificationModel notificationModel=new NotificationModel();
        notificationModel.setId(remoteMessage.getFrom());//grupo 1
        notificationModel.setTitle(remoteMessage.getNotification().getTitle());//grupo 2
        notificationModel.setDescription(remoteMessage.getNotification().getBody());// grupo 2
        //notificationModel.setUrl(remoteMessage.getData().get(PARAMETRO_URL));//grupo 3
        getPush(notificationModel,remoteMessage);
    }
    //acá se construye la gráfica de la notificación PUSH
    public void getPush(NotificationModel notificationModel,RemoteMessage remoteMessage)
    {
        Intent intent=new Intent(remoteMessage.getNotification().getClickAction());//ésto seria PushActivity
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //intent.putExtra(PARAMETRO_URL,notificacion.getUrl());

         PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);

          NotificationCompat.Builder builder = new  NotificationCompat.Builder(this)
                                                    .setSmallIcon(R.drawable.ic_launcher_web)
                                                    .setContentTitle(notificationModel.getTitle())
                                                    .setContentText(notificationModel.getDescription())
                                                    .setAutoCancel(true)
                                                    .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                                                    .setContentIntent(pendingIntent);
          //setVibrate(new long[] { 1000, 1000});
       // .setSound(defaultSounUri)
        //Uri defaultSounUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.fyf1);
          //  .setSound(Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + getPackageName() + "/raw/fyf1"))
        NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,builder.build());


    }
}
