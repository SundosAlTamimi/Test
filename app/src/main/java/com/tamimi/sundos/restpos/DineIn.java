package com.tamimi.sundos.restpos;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tamimi.sundos.restpos.BackOffice.BackOfficeActivity;
import com.tamimi.sundos.restpos.BackOffice.EmployeeRegistration;
import com.tamimi.sundos.restpos.BackOffice.MenuRegistration;
import com.tamimi.sundos.restpos.Models.EmployeeRegistrationModle;
import com.tamimi.sundos.restpos.Models.OrderTransactions;
import com.tamimi.sundos.restpos.Models.PayMethod;
import com.tamimi.sundos.restpos.Models.Tables;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;


public class DineIn extends AppCompatActivity {


    ArrayList<Tables> currentList, list0, list1, list2, list3, list4, list5;

    Dialog dialog;
    Button addIcon , save;
    Button mainF, firstF, secondF, thirdF, fourthF, fifthF;
    TextView move , merge , reservation , takeAway , close , cashDrawer , refund , checkOut , reprint;
    LinearLayout add, rightBorder;
    ViewGroup land;

    LinearLayout focused = null;
    GestureDetector gestureDetector;

    int tableNumber;
    int current = 0;
    String waiter;

    List<OrderTransactions> greenTables;
    DatabaseHandler mHandler;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dine_in);

        mHandler = new DatabaseHandler(DineIn.this);
        greenTables = mHandler.getAllOrderTransactionsTemp();
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

    OnClickListener onRightListListener = new OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {

                case R.id.move:
                    break;

                case R.id.merge:
                    break;

                case R.id.reservation:
                    break;

                case R.id.takeAway:
                    break;

                case R.id.close:
                    break;

                case R.id.cash_drawer:
                    break;

                case R.id.refund:
                    break;

                case R.id.checkOut:
                    openCheckOutDialog();
                    break;

                case R.id.reprint:
                    mHandler.deleteAllOrders();
                    break;
            }
        }
    };

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
                if(checkGreen(textView.getText().toString() , current)){
                    linearLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.green_light));
                }
                land.addView(linearLayout);

            }

        }

    };

    boolean checkGreen(String tableNo , int section){
        for (int i = 0; i < greenTables.size(); i++)
            if(greenTables.get(i).getSectionNo() == section && greenTables.get(i).getTableNo() == Integer.parseInt(tableNo))
                return true;

        return false;
    }

    OnClickListener onTableClickListener = new OnClickListener() {
        @Override
        public void onClick(View view) {

            if(view.getBackground() == null) { // not green
                dialog = new Dialog(DineIn.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.pick_waiter_dialog);
                dialog.setCanceledOnTouchOutside(true);

                final LinearLayout linearLayout = dialog.findViewById(R.id.linear);
                Button done = dialog.findViewById(R.id.b_done);

                ArrayList<EmployeeRegistrationModle> employees = mHandler.getAllEmployeeRegistration();

                for (int i = 0; i < employees.size(); i++) {
                    if (employees.get(i).getEmployeeType() == 1) {

                        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT , 40);

                        final TextView textView = new TextView(DineIn.this);
                        textView.setText(" " + employees.get(i).getEmployeeName());
                        textView.setTextColor(getResources().getColor(R.color.text_color));
                        textView.setTextSize(22);
                        textView.setGravity(Gravity.BOTTOM);
                        textView.setLayoutParams(lp);

                        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(50 , 40);
                        lp2.setMargins(3, 5, 7, 5);

                        final ImageView imageView = new ImageView(DineIn.this);
                        imageView.setBackgroundDrawable(getResources().getDrawable(R.drawable.waiter));
                        imageView.setLayoutParams(lp2);

                        final LinearLayout linearLayout1 = new LinearLayout(DineIn.this);
                        linearLayout1.addView(imageView);
                        linearLayout1.addView(textView);
                        linearLayout1.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                waiter = textView.getText().toString();
                                setTableBackground(linearLayout, linearLayout1);
                            }
                        });

                        linearLayout.addView(linearLayout1);
                    }
                }
                done.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        openSeatsNumberDialog();
                    }
                });
                dialog.show();

                focused = (LinearLayout) view;
                TextView textView = (TextView) focused.getChildAt(1);
                tableNumber = Integer.parseInt(textView.getText().toString());

            } else {
                focused = (LinearLayout) view;
                TextView textView = (TextView) focused.getChildAt(1);
                tableNumber = Integer.parseInt(textView.getText().toString());

                Intent intent = new Intent(DineIn.this, Order.class);
                intent.putExtra("flag", "1");
                intent.putExtra("tableNo", tableNumber);
                intent.putExtra("sectionNo", current);
                startActivity(intent);
            }
        }
    };

    public void openSeatsNumberDialog() {
        dialog = new Dialog(DineIn.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.seats_number_dialog);
        dialog.setCanceledOnTouchOutside(true);

        final EditText seatsNo = dialog.findViewById(R.id.seatsNo);
        final EditText male = dialog.findViewById(R.id.male);
        final EditText female = dialog.findViewById(R.id.female);
        final EditText children = dialog.findViewById(R.id.children);
        Button ok = dialog.findViewById(R.id.okay);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String males = ((male.getText().toString().equals(""))? "0" : male.getText().toString());
                String females = ((female.getText().toString().equals(""))? "0" : female.getText().toString());
                String childrens = ((children.getText().toString().equals(""))? "0" : children.getText().toString());

                int sum =(int) Double.parseDouble(males) +
                        (int) Double.parseDouble(females) +
                        (int) Double.parseDouble(childrens);
                seatsNo.setText(""+sum);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        male.addTextChangedListener(textWatcher);
        female.addTextChangedListener(textWatcher);
        children.addTextChangedListener(textWatcher);

        ok.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (seatsNo.getText().toString() != "" && male.getText().toString() != "" && female.getText().toString() != "" && children.getText().toString() != "") {
                    int sum = (int) Double.parseDouble(male.getText().toString()) +
                            (int) Double.parseDouble(female.getText().toString()) +
                            (int) Double.parseDouble(children.getText().toString());

                    if ((int) Double.parseDouble(seatsNo.getText().toString()) == sum) {

                        dialog.dismiss();

                        Intent intent = new Intent(DineIn.this, Order.class);
                        intent.putExtra("flag", "1");
                        intent.putExtra("tableNo", tableNumber);
                        intent.putExtra("sectionNo", current);
                        intent.putExtra("waiter", waiter);
                        intent.putExtra("seatNo", sum);
                        startActivity(intent);

                    } else {
                        Toast.makeText(DineIn.this, "Number of seats doesn't machs number of people", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(DineIn.this, "Please fill all requested fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog.show();
    }

    public void openCheckOutDialog() {
        dialog = new Dialog(DineIn.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.check_out_dialog);
        dialog.setCanceledOnTouchOutside(true);

        final TextView sectionNo = dialog.findViewById(R.id.section);
        final Spinner tableNo = dialog.findViewById(R.id.tableNo);
        Button done = dialog.findViewById(R.id.b_done);

        switch (current){
            case 0:
                sectionNo.setText("Main Floor");
                break;
            case 1:
                sectionNo.setText("1st Floor");
                break;
            case 2:
                sectionNo.setText("2nd Floor");
                break;
            case 3:
                sectionNo.setText("3rd Floor");
                break;
            case 4:
                sectionNo.setText("4th Floor");
                break;
            case 5:
                sectionNo.setText("5th Floor");
                break;
        }

        List<String> tablesNo = mHandler.getAllOrderedTables(current);
        ArrayAdapter<String> tableNoAdapter = new ArrayAdapter<>(DineIn.this, R.layout.spinner_style, tablesNo);
        tableNo.setAdapter(tableNoAdapter);

        done.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                List<OrderTransactions> orderTransTemp = mHandler.getOrderTransactionsTemp(""+current , tableNo.getSelectedItem().toString());
                if(orderTransTemp.size() != 0) {
                    Intent intent = new Intent(DineIn.this, PayMethods.class);
                    intent.putExtra("sectionNo", "" + current);
                    intent.putExtra("tableNo", tableNo.getSelectedItem().toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(DineIn.this , "This table has no order !" , Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog.show();
    }

    private void setTableBackground(LinearLayout linearLayout, LinearLayout linearLayout1) {
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            LinearLayout linear = (LinearLayout) linearLayout.getChildAt(i);
            linear.setBackgroundColor(getResources().getColor(R.color.layer3));
        }
        linearLayout1.setBackgroundColor(getResources().getColor(R.color.layer4));
    }

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
            if(checkGreen(textView.getText().toString() , current)){
                linearLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.green_light));
            }
            land.addView(linearLayout);

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        greenTables = mHandler.getAllOrderTransactionsTemp();
        if(focused != null)
            focused.setBackgroundDrawable(getResources().getDrawable(R.drawable.green_light));
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
        addIcon = (Button) findViewById(R.id.add_icon);
        add = (LinearLayout) findViewById(R.id.add_table_list);
        rightBorder = (LinearLayout) findViewById(R.id.rightBorder);
        land = (ViewGroup) findViewById(R.id.land);

        move = (TextView) findViewById(R.id.move);
        merge = (TextView) findViewById(R.id.merge);
        reservation = (TextView) findViewById(R.id.reservation);
        takeAway = (TextView) findViewById(R.id.takeAway);
        close = (TextView) findViewById(R.id.close);
        cashDrawer = (TextView) findViewById(R.id.cashDrawer);
        refund = (TextView) findViewById(R.id.refund);
        checkOut = (TextView) findViewById(R.id.checkOut);
        reprint = (TextView) findViewById(R.id.reprint);

        addIcon.setVisibility(View.INVISIBLE);
        add.setVisibility(View.INVISIBLE);

        mainF.setOnClickListener(onFloorClickListener);
        firstF.setOnClickListener(onFloorClickListener);
        secondF.setOnClickListener(onFloorClickListener);
        thirdF.setOnClickListener(onFloorClickListener);
        fourthF.setOnClickListener(onFloorClickListener);
        fifthF.setOnClickListener(onFloorClickListener);

        move.setOnClickListener(onRightListListener);
        merge.setOnClickListener(onRightListListener);
        reservation.setOnClickListener(onRightListListener);
        takeAway.setOnClickListener(onRightListListener);
        close.setOnClickListener(onRightListListener);
        cashDrawer.setOnClickListener(onRightListListener);
        refund.setOnClickListener(onRightListListener);
        checkOut.setOnClickListener(onRightListListener);
        reprint.setOnClickListener(onRightListListener);
    }
}
