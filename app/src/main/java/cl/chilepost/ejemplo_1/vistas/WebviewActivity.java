package cl.chilepost.ejemplo_1.vistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.HashMap;
import java.util.Map;

import cl.chilepost.ejemplo_1.R;

public class WebviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        showToolbar("Ejemplo web view",true);
        showWebView();
    }
    public void showWebView()
    {
        final WebView webView=(WebView)findViewById(R.id.webview);
        webView.getSettings().setSupportMultipleWindows(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.clearCache(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        final Map<String, String> cabeceros = new HashMap<>();
        cabeceros.put("Token","123456");
        /*
        //con ésto nos aseguramos de que se envíen los cabeceros, sólo usar en caso de que se haya comprobado que el envío fale
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl(url, cabeceros);
                return false;
            }
        });
        */
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url)
            {
                webView.loadUrl("javascript:(function() { " +
                        "document.cookie = 'gerardo=hola ñandú; expires=Thu, 18 Dec 2020 12:00:00 UTC';" +
                        "console.log(document.cookie); " +
                        "})()");
            }
        });
        //hola=1&
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                Log.d("maria: ", consoleMessage.message() + " -- en la línea "
                        + consoleMessage.lineNumber() + " of "
                        + consoleMessage.sourceId());
                return super.onConsoleMessage(consoleMessage);
            }
        });
        webView.loadUrl("http://www.manosenelcodigo.cl/soporte_android/mapas/mapa_1.php",cabeceros);

    }

    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }
}
