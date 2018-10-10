package com.tamimi.sundos.restpos;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.tamimi.sundos.restpos.BackOffice.MenuRegistration;
import com.tamimi.sundos.restpos.Models.ItemWithModifier;
import com.tamimi.sundos.restpos.Models.Items;
import com.tamimi.sundos.restpos.Models.Modifier;
import com.tamimi.sundos.restpos.Models.OrderHeader;
import com.tamimi.sundos.restpos.Models.OrderTransactions;
import com.tamimi.sundos.restpos.Models.PayMethod;
import com.tamimi.sundos.restpos.Models.UsedCategories;
import com.tamimi.sundos.restpos.Models.UsedItems;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Order extends AppCompatActivity {

    Button modifier, void_, delivery, discount, lDiscount, split, priceChange;
    TextView total, lineDisCount, disCount, deliveryCharge, subTotal, service, tax, amountDue;
    Button pay, order;
    TextView orderType, tableNo, check, date, user;
    LinearLayout categoriesLinearLayout;
    TableLayout tableLayout;
    GridView gv;

    int orderTypeFlag;
    int currentColor;
    FoodAdapter1 foodAdapter;
    int tableLayoutPosition;
    Double lineDiscountValue;
    Double discountValue;
    double totalItemsWithDiscount = 0.0;

    int voucherSerial;
    public static String OrderType, today, yearMonth, voucherNo;

    int tableNumber, sectionNumber;
    ArrayList<Items> wantedItems;
    List<UsedCategories> usedCategoriesList;
    List<Items> items = new ArrayList<>();
    ArrayList<Double> lineDiscount;

    TableRow focused = null;
    int selectedModifier = -1;

    Dialog dialog;
    private DatabaseHandler mDbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.order);

        mDbHandler = new DatabaseHandler(Order.this);
        items = mDbHandler.getAllItems();
        wantedItems = new ArrayList<>();
        usedCategoriesList = new ArrayList<>();
        lineDiscount = new ArrayList<Double>();

        orderTypeFlag = 0;
        tableLayoutPosition = 0;
        currentColor = ContextCompat.getColor(this, R.color.layer2);

        initialize();

        setDateAndVoucherNumber();

        setOrder(orderTypeFlag);

        fillCategories();

        OrderType = orderType.getText().toString();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.pay:
                    Intent intentPay = new Intent(Order.this, PayMethods.class);
                    startActivity(intentPay);
                    break;

                case R.id.order:
                    saveInOrderTransaction();
                    saveInOrderHeader();
                    break;

                case R.id.modifier:
                    showModifierDialog();
                    break;

                case R.id.void_:
                    deleteRaw(focused);
                    break;

                case R.id.delivery_b:
                    showDeliveryChangeDialog();
                    break;

                case R.id.discount_b:
                    showDiscountDialog();
                    break;

                case R.id.line_discount_b:
                    showLineDiscountDialog();
                    break;
            }
        }
    };

    View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (view.getId()) {
                case R.id.pay:
                    if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        pay.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                    } else if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        pay.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryLight));
                    }
                    break;

                case R.id.order:
                    if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        order.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.exit));
                    } else if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        order.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.exit_hover));
                    }
                    break;

                case R.id.modifier:
                case R.id.void_:
                    break;

                case R.id.delivery_b:
                    break;

                case R.id.split:
                case R.id.discount:
                    break;

                case R.id.line_discount_b:
                    break;

                case R.id.price_change:
                    if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        view.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.light_blue));
                    } else if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        view.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.layer2));
                    }
                    break;

            }
            return false;
        }
    };

    void setOrder(int flag) {
        if (flag == 0) {
            orderType.setText("Take Away");
            tableNo.setText("Table:  " + "-");
            tableNumber = -1;
            sectionNumber = -1;
        } else {
            orderType.setText("Dine In");
            tableNo.setText("Table:  " + 0);
            tableNumber = 0;
            sectionNumber = 0;
        }

        date.setText(today);
        user.setText(Settings.user_name);
    }

    void setDateAndVoucherNumber() {
        Date currentTimeAndDate = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        today = df.format(currentTimeAndDate);

        SimpleDateFormat df2 = new SimpleDateFormat("yyyyMM");
        yearMonth = df2.format(currentTimeAndDate);

        List<OrderTransactions> transactions = mDbHandler.getAllOrderTransactions();
        int voucherSerial;
        if (transactions.size() > 0)
            voucherSerial = transactions.get(transactions.size() - 1).getVoucherSerial();
        else
            voucherSerial = 0;

        voucherNo = yearMonth + "-" + voucherSerial;
    }

    void fillCategories() {
        usedCategoriesList = mDbHandler.getUsedCategories();
        categoriesLinearLayout.removeAllViews();

        for (int i = 0; i < usedCategoriesList.size(); i++) {

            final Button button = new Button(Order.this);

            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 50);
            param.setMargins(0, 1, 0, 1);

            button.setLayoutParams(param);
            button.setText(usedCategoriesList.get(i).getCategoryName());
            button.setBackgroundColor(usedCategoriesList.get(i).getBackground());
            button.setTextColor(usedCategoriesList.get(i).getTextColor());
            button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);
            button.setTag(usedCategoriesList.get(i).getNumberOfItems());

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changeClickedButtonBackground(button);
                    fillGridView(button.getText().toString());
                }
            });
            categoriesLinearLayout.addView(button);
        }
    }

    void fillGridView(String categoryName) {

        ArrayList<UsedItems> subList = mDbHandler.getRequestedItems(categoryName);

        Toast.makeText(Order.this, "size " + subList.size(), Toast.LENGTH_SHORT).show();

        if (subList.size() != 0) {
            List<Items> items = mDbHandler.getAllItems();
            final ArrayList<Items> requestedItems = new ArrayList<>();

            for (int i = 0; i < subList.size(); i++) {
                if (Character.isDigit(subList.get(i).getitemName().charAt(0))) { // no data in this position
                    requestedItems.add(new Items("", "", "", 0, 0, "", "",
                            0, 0, 0, "", 0, 0, 0, 0,
                            "", "", 0, 0, 0, null, subList.get(i).getBackground(),
                            subList.get(i).getBackground(), 0));
                } else {
                    for (int j = 0; j < items.size(); j++) {
                        if (subList.get(i).getitemName().equals(items.get(j).getMenuName()))
                            requestedItems.add(new Items(categoryName, items.get(j).getMenuName(), items.get(j).getFamilyName(),
                                    items.get(j).getTax(), items.get(j).getTaxType(), items.get(j).getSecondaryName(), items.get(j).getKitchenAlias(),
                                    items.get(j).getItemBarcode(), items.get(j).getStatus(), items.get(j).getItemType(), items.get(j).getInventoryUnit(),
                                    items.get(j).getWastagePercent(), items.get(j).getDiscountAvailable(), items.get(j).getPointAvailable(),
                                    items.get(j).getOpenPrice(), items.get(j).getKitchenPrinter(), items.get(j).getDescription(), items.get(j).getPrice(),
                                    items.get(j).getUsed(), items.get(j).getShowInMenu(), items.get(j).getPic(), subList.get(i).getBackground(),
                                    subList.get(i).getTextColor(), subList.get(i).getPosition()));
                    }
                }
            }
            foodAdapter = new FoodAdapter1(Order.this, requestedItems);
            gv.setAdapter(foodAdapter);

            gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    if (!requestedItems.get(i).getMenuName().equals("")) {
                        boolean exist = false;
                        int index = 0;
                        for (int k = 0; k < tableLayout.getChildCount(); k++) {
                            TableRow tableRow = (TableRow) tableLayout.getChildAt(k);
                            TextView textViewName = (TextView) tableRow.getChildAt(1);
                            if (textViewName.getText().toString().equals(requestedItems.get(i).getMenuName())) {
                                exist = true;
                                index = k;
                                break;
                            }
                        }

                        if (!exist) {
                            wantedItems.add(requestedItems.get(i));
                            lineDiscount.add(0.0);
                            insertItemRaw(requestedItems.get(i));
                        } else {
                            TableRow tableRow = (TableRow) tableLayout.getChildAt(index);
                            TextView textViewQty = (TextView) tableRow.getChildAt(0);
                            TextView textViewPrice = (TextView) tableRow.getChildAt(2);
                            TextView textViewTotal = (TextView) tableRow.getChildAt(3);

                            int qty = Integer.parseInt(textViewQty.getText().toString());
                            double price = Double.parseDouble(textViewPrice.getText().toString());

                            textViewQty.setText("" + (qty + 1));
                            textViewTotal.setText("" + (price * (qty + 1)));
                            calculateTotal();
                        }
                    } else
                        Toast.makeText(Order.this, "No Item", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    void insertItemRaw(Items item) {
        final TableRow row = new TableRow(Order.this);

        TableLayout.LayoutParams lp = new TableLayout.LayoutParams();
        lp.setMargins(2, 0, 2, 0);
        row.setLayoutParams(lp);

        for (int i = 0; i < 5; i++) {
            TextView textView = new TextView(Order.this);

            switch (i) {
                case 0:
                    textView.setText("1");
                    break;
                case 1:
                    textView.setText(item.getMenuName());
                    break;
                case 2:
                    textView.setText("" + item.getPrice());
                    break;
                case 3:
                    textView.setText("" + item.getPrice());
                    break;
                case 4:
                    textView.setText("0"); // line discount
                    break;
            }

            textView.setTextColor(ContextCompat.getColor(Order.this, R.color.text_color));
            textView.setGravity(Gravity.CENTER);

            if(i != 4){
                TableRow.LayoutParams lp1 = new TableRow.LayoutParams(0, TableRow.LayoutParams.MATCH_PARENT, 1.0f);
                textView.setLayoutParams(lp1);
            } else {
                TableRow.LayoutParams lp2 = new TableRow.LayoutParams(0, TableRow.LayoutParams.MATCH_PARENT, 0.00001f);
                textView.setLayoutParams(lp2);
            }

            row.addView(textView);
            row.setTag(tableLayoutPosition);

            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    focused = row;
                    setRawFocused(row);
                }
            });

            row.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    focused = row;
                    setRawFocused(row);
                    return true;
                }
            });
        }
        tableLayout.addView(row);
        tableLayoutPosition++;

        calculateTotal();
    }

    void insertModifierRaw(String modifierText) {
        final TableRow row = new TableRow(Order.this);

        TableLayout.LayoutParams lp = new TableLayout.LayoutParams();
        lp.setMargins(2, 0, 2, 0);
        row.setLayoutParams(lp);

        for (int i = 0; i < 5; i++) {
            TextView textView = new TextView(Order.this);

            switch (i) {
                case 0:
                    textView.setText("*");
                    break;
                case 1:
                    textView.setText(modifierText);
                    break;
                case 2:
                    textView.setText("-");
                    break;
                case 3:
                    textView.setText("-");
                    break;
                case 4:
                    textView.setText(""); // line discount
                    break;
            }

            textView.setTextColor(ContextCompat.getColor(Order.this, R.color.exit));
            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);

            if(i != 4){
                TableRow.LayoutParams lp1 = new TableRow.LayoutParams(0, TableRow.LayoutParams.MATCH_PARENT, 1.0f);
                textView.setLayoutParams(lp1);
            } else {
                TableRow.LayoutParams lp2 = new TableRow.LayoutParams(0, TableRow.LayoutParams.MATCH_PARENT, 0.00001f);
                textView.setLayoutParams(lp2);
            }

            row.addView(textView);
            row.setTag(tableLayoutPosition);

            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    focused = row;
                    setRawFocused(row);
                }
            });

            row.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    focused = row;
                    setRawFocused(row);
                    return true;
                }
            });
        }
        tableLayout.addView(row , Integer.parseInt(focused.getTag().toString()) +1);
        tableLayoutPosition++;
        resetPosition();

    }

    void setRawFocused(TableRow raw) {
        for (int k = 0; k < tableLayout.getChildCount(); k++) {
            TableRow tableRow = (TableRow) tableLayout.getChildAt(k);
            tableRow.setBackgroundDrawable(null);
        }
        raw.setBackgroundColor(getResources().getColor(R.color.layer4));
    }

    void deleteRaw(final TableRow row) {
        if (focused != null) {
            row.setBackgroundColor(getResources().getColor(R.color.layer4));
            AlertDialog.Builder builder = new AlertDialog.Builder(Order.this);
            builder.setTitle("Do you want to delete this recipe ?");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    tableLayout.removeView(row);
                    wantedItems.remove(Integer.parseInt(row.getTag().toString()));
                    lineDiscount.remove(Integer.parseInt(row.getTag().toString()));
                    tableLayoutPosition--;
                    resetPosition();
                    calculateTotal();
                }
            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    row.setBackgroundDrawable(null);
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        } else
            Toast.makeText(Order.this, " Please choose item to be deleted", Toast.LENGTH_SHORT).show();
    }

    void resetPosition() {
        for (int i = 0; i < tableLayout.getChildCount(); i++) {
            TableRow tableRow = (TableRow) tableLayout.getChildAt(i);
            tableRow.setTag("" + i);
        }
    }

    void showModifierDialog() {

        dialog = new Dialog(Order.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.pick_modifier_dialog);
        dialog.setCanceledOnTouchOutside(true);

        final Button extra = dialog.findViewById(R.id.extra);
        final Button no = dialog.findViewById(R.id.no);
        final Button little = dialog.findViewById(R.id.little);
        final Button half = dialog.findViewById(R.id.half);
        final Button save = dialog.findViewById(R.id.save);
        final Button exit = dialog.findViewById(R.id.exit);
        final GridView gridView = dialog.findViewById(R.id.modifiers);

        int itemBarcode = wantedItems.get(Integer.parseInt(focused.getTag().toString())).getItemBarcode();
        Log.e("hi" , "********" + itemBarcode);
        final ArrayList<ItemWithModifier> modifiers = mDbHandler.getAllItemWithModifiers(itemBarcode);
        final ArrayList<String> modifiersName = new ArrayList<>();

        for (int i = 0; i < modifiers.size(); i++) {
            modifiersName.add("(" + modifiers.get(i).getModifierNo() + ") " + modifiers.get(i).getModifierText());
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(Order.this, R.layout.grid_style, modifiersName);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                for (int j = 0; j < gridView.getChildCount(); j++) {
                    gridView.getChildAt(j).setBackgroundDrawable(null);
                }
                gridView.getChildAt(i).setBackgroundDrawable(getResources().getDrawable(R.drawable.focused_table));
                selectedModifier = i;
            }
        });

        extra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedModifier != -1) {
                    if (!modifiersName.get(selectedModifier).contains("*  Extra")) { // if contain the same string
                        if (!modifiersName.get(selectedModifier).contains("*")) { // if contain another string
                            modifiersName.set(selectedModifier, modifiersName.get(selectedModifier) + " \n " + "  *  Extra");
                            adapter.notifyDataSetChanged();
                        } else { // if it has another string it will extract it and add the new one
                            modifiersName.set(selectedModifier, modifiersName.get(selectedModifier).substring(0, modifiersName.get(selectedModifier).indexOf('*') - 1) + " *  Extra");
                            adapter.notifyDataSetChanged();
                        }
                    }
                } else
                    Toast.makeText(Order.this, "Please select a modifier ", Toast.LENGTH_SHORT).show();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedModifier != -1) {
                    if (!modifiersName.get(selectedModifier).contains("*  No")) { // if contain the same string
                        if (!modifiersName.get(selectedModifier).contains("*")) { // if contain another string
                            modifiersName.set(selectedModifier, modifiersName.get(selectedModifier) + " \n " + "  *  No");
                            adapter.notifyDataSetChanged();
                        } else { // if it has another string it will extract it and add the new one
                            modifiersName.set(selectedModifier, modifiersName.get(selectedModifier).substring(0, modifiersName.get(selectedModifier).indexOf('*') - 1) + " *  No");
                            adapter.notifyDataSetChanged();
                        }
                    }
                } else
                    Toast.makeText(Order.this, "Please select a modifier ", Toast.LENGTH_SHORT).show();
            }
        });
        little.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedModifier != -1) {
                    if (!modifiersName.get(selectedModifier).contains("*  Little")) { // if contain the same string
                        if (!modifiersName.get(selectedModifier).contains("*")) { // if contain another string
                            modifiersName.set(selectedModifier, modifiersName.get(selectedModifier) + " \n " + "  *  Little");
                            adapter.notifyDataSetChanged();
                        } else { // if it has another string it will extract it and add the new one
                            modifiersName.set(selectedModifier, modifiersName.get(selectedModifier).substring(0, modifiersName.get(selectedModifier).indexOf('*') - 1) + " *  Little");
                            adapter.notifyDataSetChanged();
                        }
                    }
                } else
                    Toast.makeText(Order.this, "Please select a modifier ", Toast.LENGTH_SHORT).show();
            }
        });
        half.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedModifier != -1) {
                    if (!modifiersName.get(selectedModifier).contains("*  Half")) { // if contain the same string
                        if (!modifiersName.get(selectedModifier).contains("*")) { // if contain another string
                            modifiersName.set(selectedModifier, modifiersName.get(selectedModifier) + " \n " + "  *  Half");
                            adapter.notifyDataSetChanged();
                        } else { // if it has another string it will extract it and add the new one
                            modifiersName.set(selectedModifier, modifiersName.get(selectedModifier).substring(0, modifiersName.get(selectedModifier).indexOf('*') - 1) + " *  Half");
                            adapter.notifyDataSetChanged();
                        }
                    }
                } else
                    Toast.makeText(Order.this, "Please select a modifier ", Toast.LENGTH_SHORT).show();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < modifiersName.size(); i++) {
                    if (modifiersName.get(i).contains("*")) {
                        insertModifierRaw( modifiersName.get(i).substring(modifiersName.get(selectedModifier).indexOf('-')+1,
                                modifiersName.get(selectedModifier).indexOf('-')+10) + "..");
                        wantedItems.add( Integer.parseInt(focused.getTag().toString()) +1 ,
                                new Items("modifier",modifiers.get(i).getModifierText(),"",0,
                                0,"","",0,0,0,"",0,
                                0,0,0,"","",0,0,0,null));
                        lineDiscount.add(0.0);
                        focused.setBackgroundDrawable(null);
                    }
                }
                selectedModifier = -1;
                dialog.dismiss();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedModifier = -1;
                focused.setBackgroundDrawable(null);
                dialog.dismiss();
            }
        });

        dialog.show();

    }

    void showDeliveryChangeDialog() {

        dialog = new Dialog(Order.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.delivery_change_dialog);
        dialog.setCanceledOnTouchOutside(true);

        Window window = dialog.getWindow();
        window.setLayout(460, 220);

        final EditText addDeliveryEditText = (EditText) dialog.findViewById(R.id.add_delivery);
        Button buttonDone = (Button) dialog.findViewById(R.id.b_done);

        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!addDeliveryEditText.getText().toString().equals("")) {
                    deliveryCharge.setText(addDeliveryEditText.getText().toString());
                    calculateTotal();
                    dialog.dismiss();
                } else {
                    Toast.makeText(Order.this, "Please Enter Delivery", Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog.show();
    }

    void showLineDiscountDialog() {

        if (wantedItems.get(Integer.parseInt(focused.getTag().toString())).discountAvailable == 1) {
            dialog = new Dialog(Order.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.line_discount_dialog);
            dialog.setCanceledOnTouchOutside(true);

            Window window = dialog.getWindow();
            window.setLayout(470, 280);

            final EditText addLineDiscountEditText = (EditText) dialog.findViewById(R.id.add_line_discount);
            Button buttonDone = (Button) dialog.findViewById(R.id.b_done);
            final CheckBox radioButton = (CheckBox) dialog.findViewById(R.id.discount_perc);

            buttonDone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!addLineDiscountEditText.getText().toString().equals("")) {
                        lineDiscountValue = Double.parseDouble(addLineDiscountEditText.getText().toString());

                        if (radioButton.isChecked()) {
                            lineDiscountValue = (Double.parseDouble(addLineDiscountEditText.getText().toString())) *
                                    (Double.parseDouble(total.getText().toString())) / 100;
                        }
                        lineDiscount.set(Integer.parseInt(focused.getTag().toString()), Double.parseDouble(addLineDiscountEditText.getText().toString()));
                        calculateTotal();
                        dialog.dismiss();
                    } else {
                        Toast.makeText(Order.this, "Please Enter Line Discount", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            dialog.show();
        } else
            Toast.makeText(Order.this, "Discount is not available for this item", Toast.LENGTH_SHORT).show();
    }

    void showDiscountDialog() {

        dialog = new Dialog(Order.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.discount_dialog);
        dialog.setCanceledOnTouchOutside(true);

        Window window = dialog.getWindow();
        window.setLayout(470, 280);

        final EditText addDiscountEditText = (EditText) dialog.findViewById(R.id.add_discount);
        Button buttonDone = (Button) dialog.findViewById(R.id.b_done);
        final CheckBox radioButton = (CheckBox) dialog.findViewById(R.id.discount_perc);

        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!addDiscountEditText.getText().toString().equals("")) {
                    discountValue = Double.parseDouble(addDiscountEditText.getText().toString());

                    if (radioButton.isChecked()) {
                        discountValue = (Double.parseDouble(addDiscountEditText.getText().toString())) *
                                (Double.parseDouble(total.getText().toString())) / 100;
                    }

                    disCount.setText(addDiscountEditText.getText().toString());
                    calculateTotal();
                    dialog.dismiss();
                } else {
                    Toast.makeText(Order.this, "Please Enter Discount", Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog.show();
    }

    void calculateTotal() {

        totalItemsWithDiscount = 0.0;
        double lineDisCountValue = 0.0;
        double disCountValue = Double.parseDouble(disCount.getText().toString());
        double deliveryChargeValue = Double.parseDouble(deliveryCharge.getText().toString());

        double sum = 0;
        for (int k = 0; k < tableLayout.getChildCount(); k++) {
            TableRow tableRow = (TableRow) tableLayout.getChildAt(k);
            TextView textViewTotal = (TextView) tableRow.getChildAt(3);
            TextView firstText = (TextView) tableRow.getChildAt(0);

            if(!firstText.getText().toString().contains("*")) {
                sum += Double.parseDouble(textViewTotal.getText().toString());
                lineDisCountValue += lineDiscount.get(k);

                if (wantedItems.get(k).getDiscountAvailable() == 1) // items have discount available
                    totalItemsWithDiscount += Double.parseDouble(textViewTotal.getText().toString()) - lineDiscount.get(k);
            }
        }

        double subTotalValue = sum - (lineDisCountValue + disCountValue) + deliveryChargeValue;
        double serviceValue = sum * (Settings.service_value / 100);
        double serviceTax = serviceValue * (Settings.service_tax / 100);
        double taxValue = 0 + serviceTax;
        double amountDueValue = subTotalValue + serviceValue + taxValue;

        total.setText("" + sum);
        lineDisCount.setText("" + lineDisCountValue);
        disCount.setText("" + disCountValue);
        deliveryCharge.setText("" + deliveryChargeValue);
        subTotal.setText("" + subTotalValue);
        service.setText("" + serviceValue);
        tax.setText("" + taxValue);
        amountDue.setText("" + amountDueValue);
    }

    void saveInOrderTransaction() {
        for (int k = 0; k < tableLayout.getChildCount(); k++) {
            TableRow tableRow = (TableRow) tableLayout.getChildAt(k);
            TextView textViewQty = (TextView) tableRow.getChildAt(0);
            TextView textViewTotal = (TextView) tableRow.getChildAt(3);
            TextView textLineDiscount = (TextView) tableRow.getChildAt(4);

            double totalLine = Double.parseDouble(textViewTotal.getText().toString());
            double lineDiscount_ = lineDiscount.get(k);
            double taxValue = wantedItems.get(k).getPrice() * wantedItems.get(k).getTax();
            double disc = Double.parseDouble(disCount.getText().toString());
            double serviceTax = Double.parseDouble(service.getText().toString()) * Settings.service_tax;

            double discount = 0.0;
            if (wantedItems.get(k).getDiscountAvailable() == 1)
                discount = (disc / totalItemsWithDiscount) * (totalLine - lineDiscount_);

            Log.e("here", "******" + disc + "/" + totalItemsWithDiscount + "*" + totalLine + "-" + lineDiscount_);

            mDbHandler.addOrderTransaction(new OrderTransactions(orderTypeFlag, 0, today, Settings.POS_number, Settings.store_number,
                    voucherNo, voucherSerial, "" + wantedItems.get(k).getItemBarcode(), wantedItems.get(k).getMenuName(),
                    wantedItems.get(k).getSecondaryName(), wantedItems.get(k).getKitchenAlias(), wantedItems.get(k).getMenuCategory(),
                    wantedItems.get(k).getFamilyName(), Integer.parseInt(textViewQty.getText().toString()), wantedItems.get(k).getPrice(),
                    totalLine, discount, lineDiscount_, discount + lineDiscount_, taxValue,
                    wantedItems.get(k).getTax(), 0, Double.parseDouble(service.getText().toString()), serviceTax,
                    tableNumber, sectionNumber, Settings.shift_number, Settings.shift_name));
        }
    }

    void saveInOrderHeader() {

        double disc = Double.parseDouble(disCount.getText().toString());
        double ldisc = Double.parseDouble(lineDisCount.getText().toString());
        double serviceTax = Double.parseDouble(service.getText().toString()) * Settings.service_tax;

        mDbHandler.addOrderHeader(new OrderHeader(orderTypeFlag, 0, today, Settings.POS_number, Settings.store_number,
                voucherNo, voucherSerial, Double.parseDouble(total.getText().toString()), ldisc, disc, disc + ldisc,
                Settings.service_value, Double.parseDouble((tax.getText().toString())), serviceTax, Double.parseDouble((subTotal.getText().toString())),
                Double.parseDouble(amountDue.getText().toString()), Double.parseDouble(deliveryCharge.getText().toString()), tableNumber,
                sectionNumber, PayMethods.cashValue, PayMethods.creditCardValue, PayMethods.chequeValue, PayMethods.creditValue,
                PayMethods.giftCardValue, PayMethods.pointValue, Settings.shift_name, Settings.shift_number));
    }

    void changeClickedButtonBackground(View view) {

        for (int i = 0; i < categoriesLinearLayout.getChildCount(); i++) {
            categoriesLinearLayout.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.dark_blue));
        }
        view.setBackgroundColor(getResources().getColor(R.color.floor));

//        category1.setBackgroundColor(getResources().getColor(R.color.dark_blue));
//        category2.setBackgroundColor(getResources().getColor(R.color.dark_blue));
//        category3.setBackgroundColor(getResources().getColor(R.color.dark_blue));
//        category4.setBackgroundColor(getResources().getColor(R.color.dark_blue));
//        category5.setBackgroundColor(getResources().getColor(R.color.dark_blue));
//        category6.setBackgroundColor(getResources().getColor(R.color.dark_blue));
//        category7.setBackgroundColor(getResources().getColor(R.color.dark_blue));
//        category8.setBackgroundColor(getResources().getColor(R.color.dark_blue));
//        category9.setBackgroundColor(getResources().getColor(R.color.dark_blue));
//        category10.setBackgroundColor(getResources().getColor(R.color.dark_blue));
    }

    @SuppressLint("ClickableViewAccessibility")
    void initialize() {

        categoriesLinearLayout = (LinearLayout) findViewById(R.id.categories);
        tableLayout = (TableLayout) findViewById(R.id.tableLayout);
        gv = (GridView) findViewById(R.id.GridViewItems);
        orderType = (TextView) findViewById(R.id.orderType);
        tableNo = (TextView) findViewById(R.id.tableNumber);
        check = (TextView) findViewById(R.id.checkNumber);
        date = (TextView) findViewById(R.id.date);
        user = (TextView) findViewById(R.id.user);

        pay = (Button) findViewById(R.id.pay);
        order = (Button) findViewById(R.id.order);
        modifier = (Button) findViewById(R.id.modifier);
        void_ = (Button) findViewById(R.id.void_);
        delivery = (Button) findViewById(R.id.delivery_b);
        split = (Button) findViewById(R.id.split);
        discount = (Button) findViewById(R.id.discount_b);
        lDiscount = (Button) findViewById(R.id.line_discount_b);
        priceChange = (Button) findViewById(R.id.price_change);

        total = (TextView) findViewById(R.id.total);
        disCount = (TextView) findViewById(R.id.discount);
        lineDisCount = (TextView) findViewById(R.id.line_discount);
        deliveryCharge = (TextView) findViewById(R.id.delivery);
        subTotal = (TextView) findViewById(R.id.sub_total);
        tax = (TextView) findViewById(R.id.tax);
        service = (TextView) findViewById(R.id.service);
        amountDue = (TextView) findViewById(R.id.amount_due);

        pay.setOnTouchListener(onTouchListener);
        order.setOnTouchListener(onTouchListener);
        modifier.setOnTouchListener(onTouchListener);
        void_.setOnTouchListener(onTouchListener);
        deliveryCharge.setOnTouchListener(onTouchListener);
        split.setOnTouchListener(onTouchListener);
        discount.setOnTouchListener(onTouchListener);
        priceChange.setOnTouchListener(onTouchListener);

        pay.setOnClickListener(onClickListener);
        order.setOnClickListener(onClickListener);
        modifier.setOnClickListener(onClickListener);
        void_.setOnClickListener(onClickListener);
        delivery.setOnClickListener(onClickListener);
        discount.setOnClickListener(onClickListener);
        lDiscount.setOnClickListener(onClickListener);

    }
}
