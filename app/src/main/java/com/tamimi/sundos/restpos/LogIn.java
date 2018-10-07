package com.tamimi.sundos.restpos;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tamimi.sundos.restpos.BackOffice.MenuRegistration;

import androidx.appcompat.app.AppCompatActivity;

public class LogIn extends AppCompatActivity {

    ImageView lock;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0;
    Button clear, logIn;
    TextView t1, t2, t3, t4;
    TextView[] arrayOfText;
    int index = 0;
    MediaPlayer mp ;

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.log_in);

        mp = MediaPlayer.create(this, R.raw.unlock_sound);
        initialize();
        arrayOfText = new TextView[]{t1, t2, t3, t4};

        showUserNameDialog();

    }

    OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            if (index < 4) {
                Button button = (Button) view;
                arrayOfText[index].setText(button.getText().toString());
                index++;
            }
        }

    };

    OnClickListener onClickListener2 = new OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {

                case R.id.b_clear:
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    index = 0;
                    break;

                case R.id.b_login:
                    if (index == 4) {
                        String password = t1.getText().toString() + t2.getText().toString() + t3.getText().toString() + t4.getText().toString();

                        if (isCorrect(Integer.parseInt(password))) {
                            Settings.password = Integer.parseInt(password);
                            logIn();
                        } else
                            Toast.makeText(LogIn.this, "Incorrect Password", Toast.LENGTH_LONG).show();
                    }
                    break;
            }
        }

    };

    void showUserNameDialog() {

        dialog = new Dialog(LogIn.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.user_name_dialog);
        dialog.setCanceledOnTouchOutside(false);

        Window window = dialog.getWindow();
        window.setLayout(460, 220);

        final EditText userNameEditText = (EditText) dialog.findViewById(R.id.user_name);
        Button buttonDone = (Button) dialog.findViewById(R.id.b_done);

        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!userNameEditText.getText().toString().equals("")) {
                    if(true){
                        Settings.user_name = userNameEditText.getText().toString();
                        Settings.POS_number = 1;
                        Settings.store_number = 7;
                        Settings.shift_name = "B";
                        Settings.shift_number = 2;
                    }
                    dialog.dismiss();
                } else {
                    Toast.makeText(LogIn.this, "Please Enter your user name", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog.show();
    }

    public boolean isCorrect(int password) {
        return password == 5555;
    }

    public void logIn(){
        lock.setBackgroundResource(R.drawable.unlock);
        mp.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent mainIntent = new Intent(LogIn.this, Main.class);
                startActivity(mainIntent);
                finish();
            }
        }, 500);
    }

    void initialize(){
        lock = (ImageView) findViewById(R.id.lock);
        t1 = (TextView) findViewById(R.id.num1);
        t2 = (TextView) findViewById(R.id.num2);
        t3 = (TextView) findViewById(R.id.num3);
        t4 = (TextView) findViewById(R.id.num4);

        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);
        b0 = (Button) findViewById(R.id.b0);

        clear = (Button) findViewById(R.id.b_clear);
        logIn = (Button) findViewById(R.id.b_login);

        b1.setOnClickListener(onClickListener);
        b2.setOnClickListener(onClickListener);
        b3.setOnClickListener(onClickListener);
        b4.setOnClickListener(onClickListener);
        b5.setOnClickListener(onClickListener);
        b6.setOnClickListener(onClickListener);
        b7.setOnClickListener(onClickListener);
        b8.setOnClickListener(onClickListener);
        b9.setOnClickListener(onClickListener);
        b0.setOnClickListener(onClickListener);

        clear.setOnClickListener(onClickListener2);
        logIn.setOnClickListener(onClickListener2);
    }
}
