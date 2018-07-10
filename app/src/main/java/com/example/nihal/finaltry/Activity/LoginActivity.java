package com.example.nihal.finaltry.Activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.nihal.finaltry.R;
import com.facebook.accountkit.AccountKitLoginResult;
import com.facebook.accountkit.ui.AccountKitActivity;
import com.facebook.accountkit.ui.AccountKitConfiguration;
import com.facebook.accountkit.ui.LoginType;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginActivity extends AppCompatActivity {

    ImageView logo;
    Button signUp;
    RelativeLayout layout1;
    RelativeLayout layout2;
    private final static int REQUEST_CODE=999;



    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            //ImageView iv = (ImageView) findViewById(R.id.left);
//            int height = 150;
//
//            logo.getLayoutParams().height = 200;
//
//            logo.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;

            layout1.setVisibility(View.VISIBLE);
            layout2.setVisibility(View.VISIBLE);

        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       // printKeyHash();
        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        logo = findViewById(R.id.logo);
        signUp = findViewById(R.id.signup);

        handler.postDelayed(runnable, 2000);




        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startLoginPage(LoginType.PHONE);



            }
        });

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode==REQUEST_CODE){

            AccountKitLoginResult result = data.getParcelableExtra(AccountKitLoginResult.RESULT_KEY);
            if(result.getError()!=null){
                Toast.makeText(this, ""+result.getError().getErrorType().getMessage(), Toast.LENGTH_SHORT).show();
                return;
            }
            else if(result.wasCancelled()){

                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
                return;
            }
            else{
                //Toast.makeText(this, "Success ! %s"+result.getAuthorizationCode().substring(0,10), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,MainActivity.class));
            }
        }
    }


    private void startLoginPage(LoginType loginType) {

        Intent intent =new Intent(LoginActivity.this, AccountKitActivity.class);
        AccountKitConfiguration.AccountKitConfigurationBuilder configurationBuilder=new AccountKitConfiguration.AccountKitConfigurationBuilder(LoginType.PHONE,AccountKitActivity.ResponseType.TOKEN);

        intent.putExtra(AccountKitActivity.ACCOUNT_KIT_ACTIVITY_CONFIGURATION,configurationBuilder.build());
        startActivityForResult(intent,REQUEST_CODE);



    }


    private void printKeyHash() {

        try {
            PackageInfo info = getPackageManager().getPackageInfo("com.example.hp.facebooklogin", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }



}
