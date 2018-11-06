package com.tamimi.sundos.restpos;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tamimi.sundos.restpos.BackOffice.BackOfficeActivity;
import com.tamimi.sundos.restpos.BackOffice.EmployeeRegistration;
import com.tamimi.sundos.restpos.Models.EmployeeRegistrationModle;
import com.tamimi.sundos.restpos.Models.Tables;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;


public class DineIn extends AppCompatActivity {


    ArrayList<Tables> currentList, list0, list1, list2, list3, list4, list5;

    Dialog dialog;
    Button save;
    Button mainF, firstF, secondF, thirdF, fourthF, fifthF;
    LinearLayout add, rightBorder;
    ViewGroup land;

    GestureDetector gestureDetector;

    int tableNumber = 1;
    int current = 0;
    String waiter ;

    DatabaseHandler mHandler;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dine_in);

        mHandler = new DatabaseHandler(DineIn.this);
        gestureDetector = new GestureDetector(this, new SingleTapConfirm());

        initialize();

        //_________________________________________________________________________________

        currentList = new ArrayList<Tables>();
        list0 = mHandler.getRequestedTables(0);
        list1 = mHandler.getRequestedTables(1);
        list2 = mHandler.getRequestedTables(2);
        list3 = mHandler.getRequestedTables(3);
        list4 = mHandler.getRequestedTables(4);
        list5 = mHandler.getRequestedTables(5);

        switch (current) {
            case 0:
                currentList = list0;
            case 1:
                currentList = list1;
            case 2:
                currentList = list2;
            case 3:
                currentList = list3;
            case 4:
                currentList = list4;
            case 5:
                currentList = list5;
        }

        fillMainFloor(); // when open the activity the main floor is active by default
    }

    OnClickListener onFloorClickListener = new OnClickListener() {
        @Override
        public void onClick(View view) {

            freeze();
            unfocusFloors();
            removeTables();

            switch (view.getId()) {

                case R.id.main:
                    current = 0;
                    currentList = list0;
                    mainF.setBackgroundColor(getResources().getColor(R.color.dark_blue));
                    break;

                case R.id.first_f:
                    current = 1;
                    currentList = list1;
                    firstF.setBackgroundColor(getResources().getColor(R.color.dark_blue));
                    break;

                case R.id.second_f:
                    current = 2;
                    currentList = list2;
                    secondF.setBackgroundColor(getResources().getColor(R.color.dark_blue));
                    break;

                case R.id.third_f:
                    current = 3;
                    currentList = list3;
                    thirdF.setBackgroundColor(getResources().getColor(R.color.dark_blue));
                    break;

                case R.id.fourth_f:
                    current = 4;
                    currentList = list4;
                    fourthF.setBackgroundColor(getResources().getColor(R.color.dark_blue));
                    break;

                case R.id.fifth_f:
                    current = 5;
                    currentList = list5;
                    fifthF.setBackgroundColor(getResources().getColor(R.color.dark_blue));
                    break;

            }

            for (int i = 0; i < currentList.size(); i++) {
                LinearLayout linearLayout = new LinearLayout(DineIn.this);
                ImageView imageView = new ImageView(DineIn.this);
                TextView textView = new TextView(DineIn.this);

                imageView.setBackgroundResource(currentList.get(i).getImageResource());
                imageView.setTag(currentList.get(i).getImageResource());
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(currentList.get(i).getHeight() - 20, currentList.get(i).getWidth());
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(currentList.get(i).getHeight(), currentList.get(i).getWidth());

                RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(50, 15);
                textView.setLayoutParams(params2);
                textView.setText("" + i);
                textView.setTextColor(getResources().getColor(R.color.text_color));
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f);

                linearLayout.setOnClickListener(onTableClickListener);
                linearLayout.addView(imageView);
                linearLayout.addView(textView);
                imageView.setLayoutParams(param);
                linearLayout.setX(currentList.get(i).getMarginLeft());
                linearLayout.setY(currentList.get(i).getMarginTop());
                linearLayout.setLayoutParams(params);
                land.addView(linearLayout);

            }

        }

    };

    OnClickListener onTableClickListener = new OnClickListener() {
        @Override
        public void onClick(View view) {

            dialog = new Dialog(DineIn.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.pick_waiter_dialog);
            dialog.setCanceledOnTouchOutside(true);

            LinearLayout linearLayout = dialog.findViewById(R.id.linear);
            Button done = dialog.findViewById(R.id.b_done);

            ArrayList<EmployeeRegistrationModle> employees = mHandler.getAllEmployeeRegistration();

            for(int i=0 ; i<employees.size() ; i++){
                if(employees.get(i).getEmployeeType() == 1){

                    final TextView textView = new TextView(DineIn.this);
                    textView.setText(employees.get(i).getEmployeeName());
                    textView.setTextColor(getResources().getColor(R.color.text_color));
                    textView.setTextSize(22);
                    textView.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            waiter = textView.getText().toString();
                        }
                    });
                    linearLayout.addView(textView);
                }
            }

            done.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    
                }
            });

            dialog.show();


//            if (!clicked) {
//                focused = (LinearLayout) view;
//                view.setBackgroundResource(R.drawable.green_light);
//                clicked = true;
//            } else {
//                view.setBackgroundDrawable(null);
//                clicked = false;
//            }
        }
    };

    public void freeze() {
        currentList.clear();
        for (int i = 0; i < land.getChildCount(); i++) {

            LinearLayout linearLayout = (LinearLayout) land.getChildAt(i);
            ImageView imageView1 = (ImageView) linearLayout.getChildAt(0);
            TextView textView1 = (TextView) linearLayout.getChildAt(1);

            int width = linearLayout.getHeight();
            int height = linearLayout.getWidth();
            float left = linearLayout.getX();
            float top = linearLayout.getY();
            int resource = (int) imageView1.getTag();
            int tableNumber = Integer.parseInt(textView1.getText().toString());

            Tables table = new Tables(height, width, resource, left, top, tableNumber);
            currentList.add(table);
        }
        setList();
    }

    public void removeTables() {
        land.removeAllViews();
    }

    public void setList() {

        switch (current) {
            case 0:
                list0 = currentList;
                break;
            case 1:
                list1 = currentList;
                break;
            case 2:
                list2 = currentList;
                break;
            case 3:
                list3 = currentList;
                break;
            case 4:
                list4 = currentList;
                break;
            case 5:
                list5 = currentList;
                break;
        }
    }

    public void unfocusFloors() {
        mainF.setBackgroundColor(getResources().getColor(R.color.gray));
        firstF.setBackgroundColor(getResources().getColor(R.color.gray));
        secondF.setBackgroundColor(getResources().getColor(R.color.gray));
        thirdF.setBackgroundColor(getResources().getColor(R.color.gray));
        fourthF.setBackgroundColor(getResources().getColor(R.color.gray));
        fifthF.setBackgroundColor(getResources().getColor(R.color.gray));
    }

    public void fillMainFloor() {
        current = 0;
        currentList = list0;
        mainF.setBackgroundColor(getResources().getColor(R.color.dark_blue));

        for (int i = 0; i < currentList.size(); i++) {
            LinearLayout linearLayout = new LinearLayout(DineIn.this);
            ImageView imageView = new ImageView(DineIn.this);
            TextView textView = new TextView(DineIn.this);

            imageView.setBackgroundResource(currentList.get(i).getImageResource());
            imageView.setTag(currentList.get(i).getImageResource());
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);

            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(currentList.get(i).getHeight() - 20, currentList.get(i).getWidth());
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(currentList.get(i).getHeight(), currentList.get(i).getWidth());

            RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(50, 15);
            textView.setLayoutParams(params2);
            textView.setText("" + i);
            textView.setTextColor(getResources().getColor(R.color.text_color));
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f);

            linearLayout.setOnClickListener(onTableClickListener);
            linearLayout.addView(imageView);
            linearLayout.addView(textView);
            imageView.setLayoutParams(param);
            linearLayout.setX(currentList.get(i).getMarginLeft());
            linearLayout.setY(currentList.get(i).getMarginTop());
            linearLayout.setLayoutParams(params);
            land.addView(linearLayout);

        }
    }

    private class SingleTapConfirm extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onSingleTapUp(MotionEvent event) {
            return true;
        }
    }

    void initialize() {
        save = (Button) findViewById(R.id.save);
        mainF = (Button) findViewById(R.id.main);
        firstF = (Button) findViewById(R.id.first_f);
        secondF = (Button) findViewById(R.id.second_f);
        thirdF = (Button) findViewById(R.id.third_f);
        fourthF = (Button) findViewById(R.id.fourth_f);
        fifthF = (Button) findViewById(R.id.fifth_f);
        add = (LinearLayout) findViewById(R.id.add_table_list);
        rightBorder = (LinearLayout) findViewById(R.id.rightBorder);
        land = (ViewGroup) findViewById(R.id.land);

        add.setVisibility(View.INVISIBLE);

        mainF.setOnClickListener(onFloorClickListener);
        firstF.setOnClickListener(onFloorClickListener);
        secondF.setOnClickListener(onFloorClickListener);
        thirdF.setOnClickListener(onFloorClickListener);
        fourthF.setOnClickListener(onFloorClickListener);
        fifthF.setOnClickListener(onFloorClickListener);
    }
}
