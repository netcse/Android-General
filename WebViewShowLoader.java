import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class WebViewShowLoader extends Activity {

    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_web_view);
        webview = (WebView) findViewById(R.id.webView1);
        startWebView("http://www.bing.com");
    }

    private void startWebView(String url) {
        webview.setWebViewClient(new WebViewClient() {
            ProgressDialog progressDialog;


            public void onLoadResource(WebView view, String url) {
                if (progressDialog == null) {
                    progressDialog = new ProgressDialog(WebViewShowLoader.this);
                    progressDialog.setMessage("Loading....");
                    progressDialog.show();
                }
            }

            public void onPageFinished(WebView view, String url) {
                try {
                    if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl(url);

    }

    public void onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack();
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_show_web_view, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                actionItem();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void actionItem() {
        Context context = getApplicationContext();
        CharSequence text = "Action Settings!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
