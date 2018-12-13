package com.tamimi.sundos.restpos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.tamimi.sundos.restpos.Models.BlindClose;
import com.tamimi.sundos.restpos.Models.BlindCloseDetails;
import com.tamimi.sundos.restpos.Models.BlindShift;
import com.tamimi.sundos.restpos.Models.Cashier;
import com.tamimi.sundos.restpos.Models.CategoryWithModifier;
import com.tamimi.sundos.restpos.Models.Cheque;
import com.tamimi.sundos.restpos.Models.ClockInClockOut;
import com.tamimi.sundos.restpos.Models.CreditCard;
import com.tamimi.sundos.restpos.Models.CustomerPayment;
import com.tamimi.sundos.restpos.Models.CustomerRegistrationModel;
import com.tamimi.sundos.restpos.Models.EmployeeRegistrationModle;
import com.tamimi.sundos.restpos.Models.ForceQuestions;
import com.tamimi.sundos.restpos.Models.ItemWithFq;
import com.tamimi.sundos.restpos.Models.ItemWithModifier;
import com.tamimi.sundos.restpos.Models.Items;
import com.tamimi.sundos.restpos.Models.JobGroup;
import com.tamimi.sundos.restpos.Models.MemberShipGroup;
import com.tamimi.sundos.restpos.Models.Modifier;
import com.tamimi.sundos.restpos.Models.Money;
import com.tamimi.sundos.restpos.Models.OrderHeader;
import com.tamimi.sundos.restpos.Models.OrderTransactions;
import com.tamimi.sundos.restpos.Models.Pay;
import com.tamimi.sundos.restpos.Models.PayMethod;
import com.tamimi.sundos.restpos.Models.Recipes;
import com.tamimi.sundos.restpos.Models.Shift;
import com.tamimi.sundos.restpos.Models.Tables;
import com.tamimi.sundos.restpos.Models.UsedCategories;
import com.tamimi.sundos.restpos.Models.UsedItems;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    //hellohjtgdgdg
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "RestPos";
    static SQLiteDatabase db;
    //___________________________________________________________________________________
    private static final String ITEMS = "ITEMS";

    private static final String MENU_CATEGORY = "MENU_CATEGORY";
    private static final String MENU_NAME = "MENU_NAME";
    private static final String FAMILY_NAME = "FAMILY_NAME";
    private static final String PRICE = "PRICE";
    private static final String TAX_TYPE = "TAX_TYPE";
    private static final String TAX_PERCENT = "TAX_PERCENT";
    private static final String SECONDARY_NAME = "SECONDARY_NAME";
    private static final String KITCHEN_ALIAS = "KITCHEN_NAME";
    private static final String ITEM_BARCODE = "ITEM_BARCODE";
    private static final String STATUS = "STATUS";
    private static final String ITEM_TYPE = "ITEM_TYPE";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final String INVENTORY_UNIT = "INVENTORY_UNIT";
    private static final String WASTAGE_PERCENT = "WASTAGE_PERCENT";
    private static final String DISCOUNT_AVAILABLE = "DISCOUNT_AVAILABLE";
    private static final String POINT_AVAILABLE = "POINT_AVAILABLE";
    private static final String OPEN_PRICE = "OPEN_PRICE";
    private static final String KITCHEN_PRINTER_TO_USE = "KITCHEN_PRINTER_TO_USE";
    private static final String USED = "USED";
    private static final String SHOW_IN_MENU = "SHOW_IN_MENU";
    private static final String ITEM_PICTURE = "ITEM_PICTURE";

    //___________________________________________________________________________________
    private static final String RECIPES = "RECIPES";

    private static final String BARCODE = "BARCODE";
    private static final String ITEM = "ITEM";
    private static final String UNIT = "UNIT";
    private static final String QTY = "QTY";
    private static final String COST = "COST";

    //___________________________________________________________________________________
    private static final String USED_CATEGORIES = "USED_CATEGORIES";

    private static final String CATEGORY_NAME = "CATEGORY_NAME";
    private static final String NUMBER_OF_ITEMS = "NUMBER_OF_ITEMS";
    private static final String CATEGORY_BACKGROUND = "CATEGORY_BACKGROUND";
    private static final String CATEGORY_TEXT_COLOR = "CATEGORY_TEXT_COLOR";
    private static final String CATEGORY_POSITION = "CATEGORY_POSITION";

    //___________________________________________________________________________________
    private static final String USED_ITEMS = "USED_ITEMS";

    private static final String CATEGORY_NAME2 = "CATEGORY_NAME2";
    private static final String ITEM_NAME = "ITEM_NAME";
    private static final String ITEM_BACKGROUND = "ITEM_BACKGROUND";
    private static final String ITEM_TEXT_COLOR = "ITEM_TEXT_COLOR";
    private static final String ITEM_POSITION = "ITEM_POSITION";

    //___________________________________________________________________________________
    private static final String TABLES = "TABLES";

    private static final String HEIGHT = "HEIGHT";
    private static final String WIDTH = "WIDTH";
    private static final String IMAGE_RESOURCE = "IMAGE_RESOURCE";
    private static final String MARGIN_LEFT = "MARGIN_LEFT";
    private static final String MARGIN_TOP = "MARGIN_TOP";
    private static final String FLOOR = "FLOOR";
    private static final String TABLE_NUMBER = "TABLE_NUMBER";

    //___________________________________________________________________________________
    private static final String MONEY_CATEGORIES = "MONEY_CATEGORIES";

    private static final String SERIAL1 = "SERIAL";
    private static final String CATEGORY_NAME1 = "CATEGORY_NAME";
    private static final String CATEGORY_VALUE1 = "CATEGORY_VALUE";
    private static final String SHOW1 = "SHOW";
    private static final String PICTURE1 = "PICTURE1";

    //___________________________________________________________________________________
    private static final String CASHIER_IN_OUT = "CASHIER_IN_OUT";

    private static final String CASHIER_NAME3 = "CASHIER_NAME";
    private static final String DATE3 = "DATE";
    private static final String CATEGORY_NAME3 = "CATEGORY_NAME";
    private static final String CATEGORY_VALUE3 = "CATEGORY_VALUE";
    private static final String CATEGORY_QTY3 = "CATEGORY_QTY";

    //___________________________________________________________________________________
    private static final String PAY_IN_OUT = "PAY_IN_OUT";

    private static final String TRANS_TYPE = "TRANS_TYPE";
    private static final String POS_NO = "POS_NO";
    private static final String USER_NO = "USER_NO";
    private static final String USER_NAME = "USER_NAME";
    private static final String TRANS_DATE = "TRANS_DATE";
    private static final String VALUE = "VALUE";
    private static final String REMARK = "REMARK";
    private static final String SHEFT_NO = "SHIFT_NO";
    private static final String SHEFT_NAME = "SHIFT_NAME";

    //___________________________________________________________________________________
    private static final String CREDIT_CARDS = "CREDIT_CARDS";

    private static final String SERIAL = "SERIAL";
    private static final String CARD_NAME = "CARD_NAME";
    private static final String ACC_CODE = "ACC_CODE";

    //___________________________________________________________________________________
    private static final String CHEQUES = "CHEQUES";

    private static final String SERIAL_CHEEK = "SERIAL_CHEEK";
    private static final String BANK_NAME = "BANK_NAME";
    private static final String CHEQUE_NUMBER = "CHEQUE_NUMBER";
    private static final String RECIVIDE = "RECIVIDE";

    //___________________________________________________________________________________
    private static final String ORDER_TRANSACTIONS = "ORDER_TRANSACTIONS";
    private static final String ORDER_TRANSACTIONS_TEMP = "ORDER_TRANSACTIONS_TEMP";

    private static final String ORDER_TYPE1 = "ORDER_TYPE";
    private static final String ORDER_KIND1 = "ORDER_KIND";
    private static final String VOUCHER_DATE1 = "VOUCHER_DATE";
    private static final String POS_NO1 = "POS_NO";
    private static final String STORE_NO1 = "STORE_NO";
    private static final String VOUCHER_NO1 = "VOUCHER_NO";
    private static final String VOUCHER_SERIAL1 = "VOUCHER_SERIAL";
    private static final String ITEM_BARCODE1 = "ITEM_BARCODE1";
    private static final String ITEM_NAME1 = "ITEM_NAME";
    private static final String SECONDARY_NAME1 = "SECONDARY_NAME";
    private static final String KITCHEN_ALIAS1 = "KITCHEN_ALIAS";
    private static final String ITEM_CATEGORY1 = "ITEM_CATEGORY";
    private static final String ITEM_FAMILY1 = "ITEM_FAMILY";
    private static final String QTY1 = "QTY";
    private static final String PRICE1 = "PRICE";
    private static final String TOTAL1 = "TOTAL";
    private static final String DISCOUNT1 = "DISCOUNT";
    private static final String L_DISCOUNT1 = "L_DISCOUNT";
    private static final String TOTAL_DISCOUNT1 = "TOTAL_DISCOUNT";
    private static final String TAX_VLUE1 = "TAX_VLUE";
    private static final String TAX_PERC1 = "TAX_PERC";
    private static final String TAX_KIND1 = "TAX_KIND";
    private static final String SERVICE1 = "SERVICE";
    private static final String SERVICE_TAX1 = "SERVICE_TAX";
    private static final String TABLE_NO1 = "TABLE_NO";
    private static final String SECTION_NO1 = "SECTION_NO";
    private static final String SHIFT_NO1 = "SHIFT_NO";
    private static final String SHIFT_NAME1 = "SECTION_NAME";

    //____________________________________________________________________________________
    private static final String PAY_METHOD = "PAY_METHOD";

    private static final String ORDER_TYPE = "ORDER_TYPE";
    private static final String ORDER_KIND = "ORDER_KIND";
    private static final String VOUCHER_DATE = "VOUCHER_DATE";
    private static final String POINT_OF_SALE_NUMBER = "POINT_OF_SALE_NUMBER";
    private static final String STORE_NUMBER = "STORE_NUMBER";
    private static final String VOUCHER_NUMBER = "VOUCHER_NUMBER";
    private static final String VOUCHER_SERIAL = "VOUCHER_SERIAL";
    private static final String PAY_TYPE = "PAY_TYPE";
    private static final String PAY_VALUE = "PAY_VALUE";
    private static final String PAY_NUMBER = "PAY_NUMBER";
    private static final String PAY_NAME = "PAY_NAME";
    private static final String SHIFT_NO = "SHIFT_NO";
    private static final String SHIFT_NAME = "SHIFT_NAME";

    //________________________________________________________________________________________
    private static final String ORDER_HEADER = "ORDER_HEADER";
    private static final String ORDER_HEADER_TEMP = "ORDER_HEADER_TEMP";

    private static final String ORDER_TYPE2 = "ORDER_TYPE";
    private static final String ORDER_KIND2 = "ORDER_KIND";
    private static final String VOUCHER_DATE2 = "VOUCHER_DATE";
    private static final String POINT_OF_SALE_NUMBER2 = "POINT_OF_SALE_NUMBER";
    private static final String STORE_NUMBER2 = "STORE_NUMBER";
    private static final String VOUCHER_NUMBER2 = "VOUCHER_NUMBER";
    private static final String VOUCHER_SERIAL2 = "VOUCHER_SERIAL";
    private static final String TOTAL2 = "TOTAL";
    private static final String TOTAL_DISCOUNT2 = "TOTAL_DISCOUNT";
    private static final String TOTAL_LINE_DISCOUNT2 = "TOTAL_LINE_DISCOUNT";
    private static final String ALL_DISCOUNT2 = "ALL_DISCOUNT";
    private static final String TOTAL_SERVICES2 = "TOTAL_SERVICES";
    private static final String TOTAL_TAX2 = "TOTAL_TAX";
    private static final String AMOUNT_DUE2 = "AMOUNT_DUE";
    private static final String SUB_TOTAL2 = "SUB_TOTAL";
    private static final String TOTAL_SERVICES_TAX2 = "TOTAL_SERVICES_TAX";
    private static final String DELIVERY_CHARGE2 = "DELIVERY_CHARGE";
    private static final String TABLE_NUMBER2 = "TABLE_NUMBER";
    private static final String SECTION_NUMBER2 = "SECTION_NUMBER";
    private static final String CASH_VALUE2 = "CASH_VALUE";
    private static final String CARDS_VALUE2 = "CARDS_VALUE";
    private static final String CHEQUE_VALUE2 = "CHEQUE_VALUE";
    private static final String COUPON_VALUE2 = "COUPON_VALUE";
    private static final String GIFT_VALUE2 = "GIFT_VALUE";
    private static final String POINT_VALUE2 = "POINT_VALUE";
    private static final String SHIFT_NO2 = "SHIFT_NUMBER";
    private static final String SHIFT_NAME2 = "SHIFT_NAME";
    private static final String WAITER2 = "WAITER";
    private static final String SEATS_NUMBER2 = "SEATS_NUMBER";

    //___________________________________________________________________________________
    private static final String FORCE_QUESTIONS = "FORCE_QUESTIONS";

    private static final String QUESTION_NO = "QUESTION_NO";
    private static final String QUESTION_TEXT = "QUESTION_TEXT";
    private static final String MULTIPLE_ANSWER = "MULTIPLE_ANSWER";
    private static final String ANSWER = "ANSWER";

    //___________________________________________________________________________________
    private static final String MODIFIER = "MODIFIER";

    private static final String MODIFIER_NO1 = "MODIFIER_NO";
    private static final String MODIFIER_NAME1 = "MODIFIER_NAME";
    private static final String ACTIVE1 = "ACTIVE";

    //___________________________________________________________________________________
    private static final String CATEGORY_WITH_MODIFIER = "CATEGORY_WITH_MODIFIER";

    private static final String MODIFIER_NAME2 = "MODIFIER_NAME";
    private static final String CATEGORY2 = "CATEGORY";

    //___________________________________________________________________________________
    private static final String ITEM_WITH_MODIFIER = "ITEM_WITH_MODIFIER";

    private static final String ITEM_CODE = "ITEM_CODE";
    private static final String MODIFIER_NO = "MODIFIER_NO";
    private static final String MODIFIER_TEXT = "MODIFIER_TEXT";

    //___________________________________________________________________________________
    private static final String ITEM_WITH_FQ = "ITEM_WITH_FQ";

    private static final String ITEM_CODE2 = "ITEM_CODE";
    private static final String QUESTION_NO2 = "QUESTION_NO";
    private static final String QUESTION_TEXT2 = "QUESTION_TEXT";

    //__________________________________________________________________________________

    private static final String CUSTOMER_PAYMENT = "CUSTOMER_PAYMENT";

    private static final String POINT_OF_SALE_NUMBER3 = "POINT_OF_SALE_NUMBER";
    private static final String USER_NAME3 = "USER_NAME";
    private static final String USER_NO3 = "USER_NO";
    private static final String CUSTOMER_NO3 = "CUSTOMER_NO";
    private static final String CUSTOMER_NAME3 = "CUSTOMER_NAME";
    private static final String CUSTOMER_BALANCE3 = "CUSTOMER_BALANCE";
    private static final String TRANS_NO3 = "TRANS_NO";
    private static final String TRANS_DATE3 = "TRANS_DATE";
    private static final String PAYMENT_TYPE3 = "PAYMENT_TYPE";
    private static final String VALUE3 = "VALUE";
    private static final String SHIFT_NUMBER3 = "SHIFT_NUMBER";
    private static final String SHIFT_NAME3 = "SHIFT_NAME";
    //__________________________________________________________________

    private static final String CLOCK_IN_CLOCK_OUT = "CLOCK_IN_CLOCK_OUT";

    private static final String POINT_OF_SALE_NUMBER4 = "POINT_OF_SALE_NUMBER";
    private static final String DATE4 = "DATE";
    private static final String USER_NO4 = "USER_NO";
    private static final String USER_NAME4 = "USER_NAME";
    private static final String TRANS_TYPE4 = "TRANS_TYPE";
    private static final String DATE_CARD4 = "DATE_CARD";
    private static final String TIME_CARD4 = "TIME_CARD";
    private static final String REMARK4 = "REMARK";
    private static final String SHIFT_NUMBER4 = "SHIFT_NUMBER";
    private static final String SHIFT_NAME4 = "SHIFT_NAME";
    //__________________________________________________________________________________
    private static final String JOB_GROUP_TABLE = "JOB_GROUP_TABLE";

    private static final String JOB_GROUP5 = "JOB_GROUP";
    private static final String USER_NAME5 = "USER_NAME";
    private static final String USER_NO5 = "USER_NO";
    private static final String IN_DATE5 = "IN_DATE";
    private static final String ACTIVE5 = "ACTIVE";
    private static final String SHIFT_NO5 = "SHIFT_NO";
    private static final String SHIFT_NAME5 = "SHIFT_NAME";
    //____________________________________________________________________________________
    private static final String MEMBER_SHIP_GROUP_MANAGEMENT_TABLE = "MEMBER_SHIP_GROUP_MANAGEMENT_TABLE";

    private static final String MEMBER_SHIP_GROUP = "MEMBER_SHIP_GROUP";
    private static final String USER_NAME6 = "USER_NAME";
    private static final String USER_NO6 = "USER_NO";
    private static final String IN_DATE6 = "IN_DATE";
    private static final String SHIFT_NO6 = "SHIFT_NO";
    private static final String SHIFT_NAME6 = "SHIFT_NAME";
    private static final String ACTIVE6 = "ACTIVITY";

    //____________________________________________________________________________________
    private static final String SHIFT_REGISTRATION = "SHIFT_REGISTRATION";

    private static final String SHIFT_NO9 = "SHIFT_NO";
    private static final String SHIFT_NAME9 = "SHIFT_NAME";
    private static final String FROM_TIME9 = "FROM_TIME";
    private static final String TO_TIME9 = "TO_TIME";

    //____________________________________________________________________________________
    private static final String BLIND_SHIFT_IN = "BLIND_SHIFT_IN";

    private static final String DATE10 = "DATE";
    private static final String TIME10 = "TIME";
    private static final String POS_NO10 = "POS_NO";
    private static final String SHIFT_NO10 = "SHIFT_NO";
    private static final String SHIFT_NAME10 = "SHIFT_NAME";
    private static final String USER_NO10 = "USER_NO";
    private static final String USER_NAME10 = "USER_NAME";
    private static final String STATUS10 = "STATUS";

    //____________________________________________________________________________________
    private static final String BLIND_CLOSE = "BLIND_CLOSE";

    private static final String TRANS_NO11 = "TRANS_NO";
    private static final String DATE11 = "DATE";
    private static final String TIME11 = "TIME";
    private static final String POS_NO11 = "POS_NO";
    private static final String SHIFT_NO11 = "SHIFT_NO";
    private static final String SHIFT_NAME11 = "SHIFT_NAME";
    private static final String USER_NO11 = "USER_NO";
    private static final String USER_NAME11 = "USER_NAME";
    private static final String SYS_SALES11 = "SYS_SALES";
    private static final String USER_SALES11 = "USER_SALES";
    private static final String SALES_DIFF11 = "SALES_DIFF";
    private static final String SYS_CASH11 = "SYS_CASH";
    private static final String USER_CASH11 = "USER_CASH";
    private static final String CASH_DIFF11 = "CASH_DIFF";
    private static final String SYS_OTHER_PAYMENTS11 = "SYS_OTHER_PAYMENTS";
    private static final String USER_OTHER_PAYMENTS11 = "USER_OTHER_PAYMENTS";
    private static final String OTHER_PAYMENTS_DIFF11 = "OTHER_PAYMENTS_DIFF";
    private static final String TILL_OK11 = "TILL_OK";
    private static final String TRANS_TYPE11 = "TRANS_TYPE";

    //____________________________________________________________________________________
    private static final String BLIND_CLOSE_DETAILS = "BLIND_CLOSE_DETAILS";

    private static final String TRANS_NO12 = "TRANS_NO";
    private static final String DATE12 = "DATE";
    private static final String TIME12 = "TIME";
    private static final String POS_NO12 = "POS_NO";
    private static final String SHIFT_NO12 = "SHIFT_NO";
    private static final String SHIFT_NAME12 = "SHIFT_NAME";
    private static final String USER_NO12 = "USER_NO";
    private static final String USER_NAME12 = "USER_NAME";
    private static final String CAT_NAME12 = "CAT_NAME";
    private static final String CAT_QTY12 = "CAT_QTY";
    private static final String CAT_VALUE12 = "CAT_VALUE";
    private static final String CAT_TOTAL12 = "CAT_TOTAL";
    private static final String TYPE12 = "TYPE";
    private static final String UPDATE_DATE12 = "UPDATE_DATE";
    private static final String UPDATE_TIME12 = "UPDATE_TIME";
    private static final String UPDATE_USER_NO12 = "UPDATE_USER_NO";
    private static final String UPDATE_USER_NAME12 = "UPDATE_USER_NAME";

    //________________________________________________________________________________________
    private static final String EMPLOYEE_REGISTRATION_TABLE = "EMPLOYEE_REGISTRATION_TABLE";

    private static final String JOB_GROUP7 = "JOB_GROUP";
    private static final String EMPLOYEE_NAME7 = "EMPLOYEE_NAME";
    private static final String EMPLOYEE_NO7 = "EMPLOYEE_NO";
    private static final String MOBILE_NO7 = "MOBILE_NO";
    private static final String SECURITY_LEVEL7 = "SECURITY_LEVEL";
    private static final String USER_PASSWORD7 = "USER_PASSWORD";
    private static final String ACTIVE7 = "ACTIVE";
    private static final String HIRE_DATA7 = "HIRE_DATA";
    private static final String TERMINATION_DATE7 = "TERMINATION_DATE";
    private static final String PAY_BASIC7 = "PAY_BASIC";
    private static final String PAY_RATE7 = "PAY_RATE";
    private static final String HOLIDAY_PAY7 = "HOLIDAY_PAY";
    private static final String EMPLOYEE_TYPE7 = "EMPLOYEE_TYPE";
    private static final String SHIFT_NO7 = "SHIFT_NO";
    private static final String SHIFT_NAME7 = "SHIFT_NAME";

    //________________________________________________________________________________________
    private static final String CUSTOMER_REGISTRATION_TABLE = "CUSTOMER_REGISTRATION_TABLE";

    private static final String MEMBER_SHIP_GROUP8 = "MEMBER_SHIP_GROUP";
    private static final String CUSTOMER_NAME8 = "CUSTOMER_NAME";
    private static final String CUSTOMER_CODE8 = "CUSTOMER_CODE";
    private static final String MEMBER_SHIP_CARD8 = "MEMBER_SHIP_CARD";
    private static final String GENDER8 = "GENDER";
    private static final String REMARK8 = "REMARK";
    private static final String STREET_NO_NAME8 = "STREET_NO_NAME";
    private static final String CITY8 = "CITY";
    private static final String PHONE_NO8 = "PHONE_NO";
    private static final String MOBILE_NO8 = "MOBILE_NO";
    private static final String NAME_SHOW8 = "NAME_SHOW";
    private static final String BIRTHDAY8 = "BIRTHDAY";
    private static final String ANNIVERSARY8 = "ANNIVERSARY";
    private static final String OCCUPATION8 = "OCCUPATION";
    private static final String EMAIL8 = "EMAIL";
    private static final String TOTAL_POINT8 = "TOTAL_POINT";
    private static final String REDEEMED_POINT8 = "REDEEMED_POINT";
    private static final String REMAINING_POINT8 = "REMAINING_POINT";
    private static final String SHIFT_NO8 = "SHIFT_NO";
    private static final String SHIFT_NAME8 = "SHIFT_NAME";


    //____________________________________________________________________________________


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Create tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        createTables(db);
    }

    void createTables(SQLiteDatabase db) {
        String CREATE_TABLE_ITEMS = "CREATE TABLE " + ITEMS + "("
                + MENU_CATEGORY + " TEXT,"
                + MENU_NAME + " TEXT,"
                + FAMILY_NAME + " TEXT,"
                + PRICE + " INTEGER,"
                + TAX_TYPE + " INTEGER,"
                + TAX_PERCENT + " INTEGER,"
                + SECONDARY_NAME + " TEXT,"
                + KITCHEN_ALIAS + " TEXT,"
                + ITEM_BARCODE + " TEXT,"
                + STATUS + " INTEGER,"
                + ITEM_TYPE + " INTEGER,"
                + DESCRIPTION + " TEXT,"
                + INVENTORY_UNIT + " TEXT,"
                + WASTAGE_PERCENT + " INTEGER,"
                + DISCOUNT_AVAILABLE + " INTEGER,"
                + POINT_AVAILABLE + " INTEGER,"
                + OPEN_PRICE + " INTEGER,"
                + KITCHEN_PRINTER_TO_USE + " TEXT,"
                + USED + " INTEGER,"
                + SHOW_IN_MENU + " INTEGER,"
                + ITEM_PICTURE + " BLOB" + ")";
        db.execSQL(CREATE_TABLE_ITEMS);
        //___________________________________________________________________________________

        String CREATE_TABLE_RECIPES = "CREATE TABLE " + RECIPES + "("
                + BARCODE + " INTEGER,"
                + ITEM + " TEXT,"
                + UNIT + " TEXT,"
                + QTY + " INTEGER,"
                + COST + " INTEGER" + ")";
        db.execSQL(CREATE_TABLE_RECIPES);

        //___________________________________________________________________________________

        String CREATE_TABLE_USED_CATEGORIES = "CREATE TABLE " + USED_CATEGORIES + "("
                + CATEGORY_NAME + " TEXT,"
                + NUMBER_OF_ITEMS + " INTEGER,"
                + CATEGORY_BACKGROUND + " INTEGER,"
                + CATEGORY_TEXT_COLOR + " INTEGER,"
                + CATEGORY_POSITION + " INTEGER" + ")";
        db.execSQL(CREATE_TABLE_USED_CATEGORIES);

        //___________________________________________________________________________________

        String CREATE_TABLE_USED_ITEMS = "CREATE TABLE " + USED_ITEMS + "("
                + CATEGORY_NAME2 + " TEXT,"
                + ITEM_NAME + " TEXT,"
                + ITEM_BACKGROUND + " INTEGER,"
                + ITEM_TEXT_COLOR + " INTEGER,"
                + ITEM_POSITION + " INTEGER" + ")";
        db.execSQL(CREATE_TABLE_USED_ITEMS);

        //___________________________________________________________________________________

        String CREATE_TABLE_TABLES = "CREATE TABLE " + TABLES + "("
                + HEIGHT + " INTEGER,"
                + WIDTH + " INTEGER,"
                + IMAGE_RESOURCE + " INTEGER,"
                + MARGIN_LEFT + " INTEGER,"
                + MARGIN_TOP + " INTEGER,"
                + FLOOR + " INTEGER,"
                + TABLE_NUMBER + " INTEGER" + ")";
        db.execSQL(CREATE_TABLE_TABLES);

        //___________________________________________________________________________________

        String CREATE_TABLE_MONEY_CATEGORIES = "CREATE TABLE " + MONEY_CATEGORIES + "("
                + SERIAL1 + " INTEGER,"
                + CATEGORY_NAME1 + " TEXT,"
                + CATEGORY_VALUE1 + " INTEGER,"
                + SHOW1 + " INTEGER,"
                + PICTURE1 + " BLOB" + ")";
        db.execSQL(CREATE_TABLE_MONEY_CATEGORIES);

        //___________________________________________________________________________________

        String CREATE_TABLE_CASHIER_IN_OUT = "CREATE TABLE " + CASHIER_IN_OUT + "("
                + CASHIER_NAME3 + " TEXT,"
                + DATE3 + " TEXT,"
                + CATEGORY_NAME3 + " TEXT,"
                + CATEGORY_VALUE3 + " INTEGER,"
                + CATEGORY_QTY3 + " INTEGER" + ")";
        db.execSQL(CREATE_TABLE_CASHIER_IN_OUT);

        //___________________________________________________________________________________

        String CREATE_TABLE_PAY_IN_OUT = "CREATE TABLE " + PAY_IN_OUT + "("
                + TRANS_TYPE + " INTEGER,"
                + POS_NO + " INTEGER,"
                + USER_NO + " INTEGER,"
                + USER_NAME + " TEXT,"
                + TRANS_DATE + " TEXT,"
                + VALUE + " INTEGER,"
                + REMARK + " TEXT,"
                + SHEFT_NO + " INTEGER,"
                + SHEFT_NAME + " TEXT" + ")";
        db.execSQL(CREATE_TABLE_PAY_IN_OUT);

        //___________________________________________________________________________________

        String CREATE_TABLE_CREDIT_CARDS = "CREATE TABLE " + CREDIT_CARDS + "("
                + SERIAL + " INTEGER,"
                + CARD_NAME + " TEXT,"
                + ACC_CODE + " TEXT" + ")";
        db.execSQL(CREATE_TABLE_CREDIT_CARDS);

        //_______________________________________________________________________________

        String CREATE_TABLE_CHEEK = "CREATE TABLE " + CHEQUES + "(" +
                SERIAL_CHEEK + " INTEGER ,"
                + BANK_NAME + " TEXT,"
                + CHEQUE_NUMBER + " TEXT,"
                + RECIVIDE + " INTEGER " + ")";
        db.execSQL(CREATE_TABLE_CHEEK);

        //_______________________________________________________________________________

        String CREATE_TABLE_ORDER_TRANSACTIONS = "CREATE TABLE " + ORDER_TRANSACTIONS + "("
                + ORDER_TYPE1 + " INTEGER,"
                + ORDER_KIND1 + " INTEGER,"
                + VOUCHER_DATE1 + " TEXT,"
                + POS_NO1 + " INTEGER,"
                + STORE_NO1 + " INTEGER,"
                + VOUCHER_NO1 + " TEXT,"
                + VOUCHER_SERIAL1 + " TEXT,"
                + ITEM_BARCODE1 + " TEXT,"
                + ITEM_NAME1 + " TEXT,"
                + SECONDARY_NAME1 + " TEXT,"
                + KITCHEN_ALIAS1 + " TEXT,"
                + ITEM_CATEGORY1 + " TEXT,"
                + ITEM_FAMILY1 + " TEXT,"
                + QTY1 + " INTEGER,"
                + PRICE1 + " INTEGER,"
                + TOTAL1 + " INTEGER,"
                + DISCOUNT1 + " INTEGER,"
                + L_DISCOUNT1 + " INTEGER,"
                + TOTAL_DISCOUNT1 + " INTEGER,"
                + TAX_VLUE1 + " INTEGER,"
                + TAX_PERC1 + " INTEGER,"
                + TAX_KIND1 + " INTEGER,"
                + SERVICE1 + " INTEGER,"
                + SERVICE_TAX1 + " INTEGER,"
                + TABLE_NO1 + " INTEGER,"
                + SECTION_NO1 + " INTEGER,"
                + SHIFT_NO1 + " INTEGER,"
                + SHIFT_NAME1 + " INTEGER" + ")";
        db.execSQL(CREATE_TABLE_ORDER_TRANSACTIONS);

        //_______________________________________________________________________________

        String CREATE_TABLE_ORDER_TRANSACTIONS_TEMP = "CREATE TABLE " + ORDER_TRANSACTIONS_TEMP + "("
                + ORDER_TYPE1 + " INTEGER,"
                + ORDER_KIND1 + " INTEGER,"
                + VOUCHER_DATE1 + " TEXT,"
                + POS_NO1 + " INTEGER,"
                + STORE_NO1 + " INTEGER,"
                + VOUCHER_NO1 + " TEXT,"
                + VOUCHER_SERIAL1 + " TEXT,"
                + ITEM_BARCODE1 + " TEXT,"
                + ITEM_NAME1 + " TEXT,"
                + SECONDARY_NAME1 + " TEXT,"
                + KITCHEN_ALIAS1 + " TEXT,"
                + ITEM_CATEGORY1 + " TEXT,"
                + ITEM_FAMILY1 + " TEXT,"
                + QTY1 + " INTEGER,"
                + PRICE1 + " INTEGER,"
                + TOTAL1 + " INTEGER,"
                + DISCOUNT1 + " INTEGER,"
                + L_DISCOUNT1 + " INTEGER,"
                + TOTAL_DISCOUNT1 + " INTEGER,"
                + TAX_VLUE1 + " INTEGER,"
                + TAX_PERC1 + " INTEGER,"
                + TAX_KIND1 + " INTEGER,"
                + SERVICE1 + " INTEGER,"
                + SERVICE_TAX1 + " INTEGER,"
                + TABLE_NO1 + " INTEGER,"
                + SECTION_NO1 + " INTEGER,"
                + SHIFT_NO1 + " INTEGER,"
                + SHIFT_NAME1 + " INTEGER" + ")";
        db.execSQL(CREATE_TABLE_ORDER_TRANSACTIONS_TEMP);

        //___________________________________________________________________________________

        String CREATE_TABLE_PAYMETHOD = "CREATE TABLE " + PAY_METHOD + "("
                + ORDER_TYPE + " INTEGER ,"
                + ORDER_KIND + " INTEGER,"
                + VOUCHER_DATE + " TEXT,"
                + POINT_OF_SALE_NUMBER + " INTEGER,"
                + STORE_NUMBER + " INTEGER,"
                + VOUCHER_NUMBER + " INTEGER,"
                + VOUCHER_SERIAL + " INTEGER,"
                + PAY_TYPE + " TEXT,"
                + PAY_VALUE + " INTEGER,"
                + PAY_NUMBER + " INTEGER,"
                + PAY_NAME + " TEXT ,"
                + SHIFT_NAME + " TEXT ,"
                + SHIFT_NO + " INTEGER " + ")";
        db.execSQL(CREATE_TABLE_PAYMETHOD);


        //_______________________________________________________________________________________
        String CREATE_TABLE_ORDER_HEADER = "CREATE TABLE " + ORDER_HEADER + "("
                + ORDER_TYPE2 + " INTEGER ,"
                + ORDER_KIND2 + " INTEGER,"
                + VOUCHER_DATE2 + " TEXT,"
                + POINT_OF_SALE_NUMBER2 + " INTEGER,"
                + STORE_NUMBER2 + " INTEGER,"
                + VOUCHER_NUMBER2 + " TEXT,"
                + VOUCHER_SERIAL2 + " INTEGER,"
                + TOTAL2 + " INTEGER,"
                + TOTAL_DISCOUNT2 + " INTEGER,"
                + TOTAL_LINE_DISCOUNT2 + " INTEGER,"
                + ALL_DISCOUNT2 + " INTEGER ,"
                + TOTAL_SERVICES2 + " INTEGER ,"
                + TOTAL_TAX2 + " INTEGER ,"
                + TOTAL_SERVICES_TAX2 + " INTEGER ,"
                + SUB_TOTAL2 + " INTEGER ,"
                + AMOUNT_DUE2 + " INTEGER ,"
                + DELIVERY_CHARGE2 + " INTEGER ,"
                + TABLE_NUMBER2 + " INTEGER ,"
                + SECTION_NUMBER2 + " INTEGER ,"
                + CASH_VALUE2 + " INTEGER ,"
                + CARDS_VALUE2 + " INTEGER ,"
                + CHEQUE_VALUE2 + " INTEGER ,"
                + COUPON_VALUE2 + " INTEGER ,"
                + GIFT_VALUE2 + " INTEGER ,"
                + POINT_VALUE2 + " INTEGER ,"
                + SHIFT_NAME2 + " TEXT ,"
                + SHIFT_NO2 + " INTEGER ,"
                + WAITER2 + " TEXT ,"
                + SEATS_NUMBER2 + " INTEGER " + ")";
        db.execSQL(CREATE_TABLE_ORDER_HEADER);

        //_______________________________________________________________________________________
        String CREATE_TABLE_ORDER_HEADER_TEMP = "CREATE TABLE " + ORDER_HEADER_TEMP + "("
                + ORDER_TYPE2 + " INTEGER ,"
                + ORDER_KIND2 + " INTEGER,"
                + VOUCHER_DATE2 + " TEXT,"
                + POINT_OF_SALE_NUMBER2 + " INTEGER,"
                + STORE_NUMBER2 + " INTEGER,"
                + VOUCHER_NUMBER2 + " TEXT,"
                + VOUCHER_SERIAL2 + " INTEGER,"
                + TOTAL2 + " INTEGER,"
                + TOTAL_DISCOUNT2 + " INTEGER,"
                + TOTAL_LINE_DISCOUNT2 + " INTEGER,"
                + ALL_DISCOUNT2 + " INTEGER ,"
                + TOTAL_SERVICES2 + " INTEGER ,"
                + TOTAL_TAX2 + " INTEGER ,"
                + TOTAL_SERVICES_TAX2 + " INTEGER ,"
                + SUB_TOTAL2 + " INTEGER ,"
                + AMOUNT_DUE2 + " INTEGER ,"
                + DELIVERY_CHARGE2 + " INTEGER ,"
                + TABLE_NUMBER2 + " INTEGER ,"
                + SECTION_NUMBER2 + " INTEGER ,"
                + CASH_VALUE2 + " INTEGER ,"
                + CARDS_VALUE2 + " INTEGER ,"
                + CHEQUE_VALUE2 + " INTEGER ,"
                + COUPON_VALUE2 + " INTEGER ,"
                + GIFT_VALUE2 + " INTEGER ,"
                + POINT_VALUE2 + " INTEGER ,"
                + SHIFT_NAME2 + " TEXT ,"
                + SHIFT_NO2 + " INTEGER ,"
                + WAITER2 + " TEXT ,"
                + SEATS_NUMBER2 + " INTEGER " + ")";
        db.execSQL(CREATE_TABLE_ORDER_HEADER_TEMP);

        //_______________________________________________________________________________
        String CREATE_TABLE_FORCE_QUESTIONS = "CREATE TABLE " + FORCE_QUESTIONS + "("
                + QUESTION_NO + " INTEGER ,"
                + QUESTION_TEXT + " TEXT,"
                + MULTIPLE_ANSWER + " INTEGER,"
                + ANSWER + " TEXT " + ")";
        db.execSQL(CREATE_TABLE_FORCE_QUESTIONS);

        //__________________________________________________________________________________

        String CREATE_TABLE_MODIFIER = "CREATE TABLE " + MODIFIER + " ("
                + MODIFIER_NO1 + " INTEGER ,"
                + MODIFIER_NAME1 + " TEXT ,"
                + ACTIVE1 + " INTEGER " + ")";
        db.execSQL(CREATE_TABLE_MODIFIER);

        //___________________________________________________________________________________
        String CREATE_TABLE_CATEGORY_WITH_MODIFIER = "CREATE TABLE " + CATEGORY_WITH_MODIFIER + " ("
                + MODIFIER_NAME2 + " TEXT ,"
                + CATEGORY2 + " TEXT " + ")";
        db.execSQL(CREATE_TABLE_CATEGORY_WITH_MODIFIER);

        //_______________________________________________________________________________
        String CREATE_TABLE_ITEM_WITH_MODIFIER = "CREATE TABLE " + ITEM_WITH_MODIFIER + "("
                + ITEM_CODE + " INTEGER ,"
                + MODIFIER_NO + " TEXT,"
                + MODIFIER_TEXT + " TEXT " + ")";
        db.execSQL(CREATE_TABLE_ITEM_WITH_MODIFIER);

        //_______________________________________________________________________________
        String CREATE_TABLE_ITEM_WITH_FQ = "CREATE TABLE " + ITEM_WITH_FQ + "("
                + ITEM_CODE2 + " INTEGER ,"
                + QUESTION_NO2 + " TEXT,"
                + QUESTION_TEXT2 + " TEXT " + ")";
        db.execSQL(CREATE_TABLE_ITEM_WITH_FQ);

        //___________________________________________________________________________________
        String CREATE_TABLE_CUSTOMER_PAYMENT = "CREATE TABLE " + CUSTOMER_PAYMENT + "("
                + POINT_OF_SALE_NUMBER3 + " INTEGER ,"
                + USER_NO3 + " INTEGER,"
                + USER_NAME3 + " TEXT,"
                + CUSTOMER_NO3 + " INTEGER,"
                + CUSTOMER_NAME3 + " TEXT,"
                + CUSTOMER_BALANCE3 + " DOUBLE,"
                + TRANS_NO3 + " INTEGER,"
                + TRANS_DATE3 + " TEXT,"
                + PAYMENT_TYPE3 + " TEXT,"
                + SHIFT_NUMBER3 + " INTEGER,"
                + SHIFT_NAME3 + " TEXT,"
                + VALUE3 + " DOUBLE " + ")";
        db.execSQL(CREATE_TABLE_CUSTOMER_PAYMENT);
        //_____________________________________________________________________________________

        String CREATE_TABLE_CLOCK_IN_CLOCK_OUT = "CREATE TABLE " + CLOCK_IN_CLOCK_OUT + "("
                + POINT_OF_SALE_NUMBER4 + " INTEGER ,"
                + DATE4 + " TEXT,"
                + USER_NO4 + " INTEGER,"
                + USER_NAME4 + " TEXT,"
                + TRANS_TYPE4 + " TEXT,"
                + DATE_CARD4 + " TEXT,"
                + TIME_CARD4 + " TEXT,"
                + REMARK4 + " TEXT,"
                + SHIFT_NUMBER4 + " INTEGER,"
                + SHIFT_NAME4 + " TEXT " + ")";
        db.execSQL(CREATE_TABLE_CLOCK_IN_CLOCK_OUT);
        //___________________________________________________________________________________

        String CREATE_JOB_GROUP_TABLES = "CREATE TABLE " + JOB_GROUP_TABLE + "("
                + JOB_GROUP5 + " TEXT,"
                + USER_NAME5 + " TEXT,"
                + USER_NO5 + " INTEGER,"
                + IN_DATE5 + " TEXT,"
                + ACTIVE5 + " INTEGER,"
                + SHIFT_NO5 + " INTEGER,"
                + SHIFT_NAME5 + " TEXT" + ")";
        db.execSQL(CREATE_JOB_GROUP_TABLES);
        //___________________________________________________________________________________

        String CREATE_MEMBER_SHIP_MANAGEMENT_GROUP_TABLES = "CREATE TABLE " + MEMBER_SHIP_GROUP_MANAGEMENT_TABLE + "("
                + MEMBER_SHIP_GROUP + " TEXT,"
                + USER_NAME6 + " TEXT,"
                + USER_NO6 + " INTEGER,"
                + IN_DATE6 + " TEXT,"
                + ACTIVE6 + " INTEGER,"
                + SHIFT_NO6 + " INTEGER,"
                + SHIFT_NAME6 + " TEXT" + ")";
        db.execSQL(CREATE_MEMBER_SHIP_MANAGEMENT_GROUP_TABLES);

        //___________________________________________________________________________________

        String CREATE_TABLE_SHIFT_REGISTRATION = "CREATE TABLE " + SHIFT_REGISTRATION + "("
                + SHIFT_NO9 + " INTEGER,"
                + SHIFT_NAME9 + " TEXT,"
                + FROM_TIME9 + " TEXT,"
                + TO_TIME9 + " TEXT" + ")";
        db.execSQL(CREATE_TABLE_SHIFT_REGISTRATION);

        //___________________________________________________________________________________

        String CREATE_TABLE_BLIND_SHIFT_IN = "CREATE TABLE " + BLIND_SHIFT_IN + "("
                + DATE10 + " TEXT,"
                + TIME10 + " TEXT,"
                + POS_NO10 + " INTEGER,"
                + SHIFT_NO10 + " INTEGER,"
                + SHIFT_NAME10 + " TEXT,"
                + USER_NO10 + " INTEGER,"
                + USER_NAME10 + " TEXT,"
                + STATUS10 + " INTEGER" + ")";
        db.execSQL(CREATE_TABLE_BLIND_SHIFT_IN);

        //___________________________________________________________________________________

        String CREATE_TABLE_BLIND_CLOSE = "CREATE TABLE " + BLIND_CLOSE + "("
                + TRANS_NO11 + " INTEGER,"
                + DATE11 + " TEXT,"
                + TIME11 + " TEXT,"
                + POS_NO11 + " INTEGER,"
                + SHIFT_NO11 + " INTEGER,"
                + SHIFT_NAME11 + " TEXT,"
                + USER_NO11 + " INTEGER,"
                + USER_NAME11 + " TEXT,"
                + SYS_SALES11 + " INTEGER,"
                + USER_SALES11 + " TEXT,"
                + SALES_DIFF11 + " INTEGER,"
                + SYS_CASH11 + " INTEGER,"
                + USER_CASH11 + " INTEGER,"
                + CASH_DIFF11 + " INTEGER,"
                + SYS_OTHER_PAYMENTS11 + " INTEGER,"
                + USER_OTHER_PAYMENTS11 + " INTEGER,"
                + OTHER_PAYMENTS_DIFF11 + " INTEGER,"
                + TILL_OK11 + " INTEGER,"
                + TRANS_TYPE11 + " INTEGER" + ")";
        db.execSQL(CREATE_TABLE_BLIND_CLOSE);

        //___________________________________________________________________________________

        String CREATE_TABLE_BLIND_CLOSE_DETAILS = "CREATE TABLE " + BLIND_CLOSE_DETAILS + "("
                + TRANS_NO12 + " INTEGER,"
                + DATE12 + " TEXT,"
                + TIME12 + " TEXT,"
                + POS_NO12 + " INTEGER,"
                + SHIFT_NO12 + " INTEGER,"
                + SHIFT_NAME12 + " TEXT,"
                + USER_NO12 + " INTEGER,"
                + USER_NAME12 + " TEXT,"
                + CAT_NAME12 + " TEXT,"
                + CAT_QTY12 + " INTEGER,"
                + CAT_VALUE12 + " INTEGER,"
                + CAT_TOTAL12 + " INTEGER,"
                + TYPE12 + " TEXT,"
                + UPDATE_DATE12 + " TEXT,"
                + UPDATE_TIME12 + " TEXT,"
                + UPDATE_USER_NO12 + " INTEGER,"
                + UPDATE_USER_NAME12 + " TEXT" + ")";
        db.execSQL(CREATE_TABLE_BLIND_CLOSE_DETAILS);

        //___________________________________________________________________________________

        String CREATE_TABLE_EMPLOYEE_REGISTRATION_TABLE = "CREATE TABLE " + EMPLOYEE_REGISTRATION_TABLE + "("
                + JOB_GROUP7 + " TEXT ,"
                + EMPLOYEE_NAME7 + " TEXT ,"
                + EMPLOYEE_NO7 + " INTEGER,"
                + MOBILE_NO7 + " INTEGER,"
                + SECURITY_LEVEL7 + " INTEGER,"
                + USER_PASSWORD7 + " INTEGER,"
                + ACTIVE7 + " TEXT,"
                + HIRE_DATA7 + " INTEGER,"
                + TERMINATION_DATE7 + " INTEGER,"
                + PAY_BASIC7 + " INTEGER,"
                + PAY_RATE7 + " INTEGER,"
                + HOLIDAY_PAY7 + " INTEGER ,"
                + EMPLOYEE_TYPE7 + " INTEGER ,"
                + SHIFT_NAME7 + " TEXT ,"
                + SHIFT_NO7 + " INTEGER " + ")";
        db.execSQL(CREATE_TABLE_EMPLOYEE_REGISTRATION_TABLE);

        //___________________________________________________________________________________

        String CREATE_TABLE_CUSTOMER_REGISTRATION_TABLE = "CREATE TABLE " + CUSTOMER_REGISTRATION_TABLE + "("
                + MEMBER_SHIP_GROUP8 + " TEXT ,"
                + CUSTOMER_NAME8 + " TEXT,"
                + CUSTOMER_CODE8 + " TEXT,"
                + MEMBER_SHIP_CARD8 + " TEXT,"
                + GENDER8 + " TEXT,"
                + REMARK8 + " TEXT,"
                + STREET_NO_NAME8 + " TEXT,"
                + CITY8 + " TEXT,"
                + PHONE_NO8 + " INTEGER,"
                + MOBILE_NO8 + " INTEGER,"
                + NAME_SHOW8 + " TEXT ,"
                + BIRTHDAY8 + " TEXT ,"
                + ANNIVERSARY8 + " TEXT ,"
                + OCCUPATION8 + " TEXT ,"
                + EMAIL8 + " TEXT ,"
                + TOTAL_POINT8 + " INTEGER ,"
                + REDEEMED_POINT8 + " INTEGER ,"
                + REMAINING_POINT8 + " INTEGER ,"
                + SHIFT_NAME8 + " TEXT ,"
                + SHIFT_NO8 + " INTEGER " + ")";
        db.execSQL(CREATE_TABLE_CUSTOMER_REGISTRATION_TABLE);

    }


    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + ITEMS); //1
        db.execSQL("DROP TABLE IF EXISTS " + RECIPES); //2
        db.execSQL("DROP TABLE IF EXISTS " + USED_CATEGORIES); //3
        db.execSQL("DROP TABLE IF EXISTS " + USED_ITEMS);  //4
        db.execSQL("DROP TABLE IF EXISTS " + TABLES);  //5
        db.execSQL("DROP TABLE IF EXISTS " + MONEY_CATEGORIES);  //6
        db.execSQL("DROP TABLE IF EXISTS " + CASHIER_IN_OUT);  //7
        db.execSQL("DROP TABLE IF EXISTS " + PAY_IN_OUT);  //8
        db.execSQL("DROP TABLE IF EXISTS " + CREDIT_CARDS);  //9
        db.execSQL("DROP TABLE IF EXISTS " + ORDER_TRANSACTIONS);  //10
        db.execSQL("DROP TABLE IF EXISTS " + PAY_METHOD);  //11
        db.execSQL("DROP TABLE IF EXISTS " + ORDER_HEADER); //12
        db.execSQL("DROP TABLE IF EXISTS " + FORCE_QUESTIONS); //13
        db.execSQL("DROP TABLE IF EXISTS " + MODIFIER); //14
        db.execSQL("DROP TABLE IF EXISTS " + ITEM_WITH_MODIFIER); //15
        db.execSQL("DROP TABLE IF EXISTS " + ITEM_WITH_FQ); //16
        db.execSQL("DROP TABLE IF EXISTS " + CATEGORY_WITH_MODIFIER); //17
        db.execSQL("DROP TABLE IF EXISTS " + CLOCK_IN_CLOCK_OUT);//18
        db.execSQL("DROP TABLE IF EXISTS " + JOB_GROUP_TABLE);//19
        db.execSQL("DROP TABLE IF EXISTS " + EMPLOYEE_REGISTRATION_TABLE);//20
        db.execSQL("DROP TABLE IF EXISTS " + CUSTOMER_REGISTRATION_TABLE);//21
        db.execSQL("DROP TABLE IF EXISTS " + ORDER_TRANSACTIONS_TEMP);  //22
        db.execSQL("DROP TABLE IF EXISTS " + ORDER_HEADER_TEMP); //23
        db.execSQL("DROP TABLE IF EXISTS " + MEMBER_SHIP_GROUP_MANAGEMENT_TABLE); //24
        db.execSQL("DROP TABLE IF EXISTS " + SHIFT_REGISTRATION); //25
        db.execSQL("DROP TABLE IF EXISTS " + BLIND_SHIFT_IN); //26
        db.execSQL("DROP TABLE IF EXISTS " + BLIND_CLOSE); //27
        db.execSQL("DROP TABLE IF EXISTS " + BLIND_CLOSE_DETAILS); //28
        // Create tables again
        onCreate(db);
    }

    //Insert values to the table Items
    public void addItem(Items items) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        byte[] byteImage = {};
        if (items.getPic() != null) {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            items.getPic().compress(Bitmap.CompressFormat.PNG, 0, stream);
            byteImage = stream.toByteArray();
        }
        values.put(MENU_CATEGORY, items.getMenuCategory());
        values.put(MENU_NAME, items.getMenuName());
        values.put(FAMILY_NAME, items.getFamilyName());
        values.put(PRICE, items.getPrice());
        values.put(TAX_TYPE, items.getTaxType());
        values.put(TAX_PERCENT, items.getTax());
        values.put(SECONDARY_NAME, items.getSecondaryName());
        values.put(KITCHEN_ALIAS, items.getKitchenAlias());
        values.put(ITEM_BARCODE, items.getItemBarcode());
        values.put(STATUS, items.getStatus());
        values.put(ITEM_TYPE, items.getItemType());
        values.put(DESCRIPTION, items.getDescription());
        values.put(INVENTORY_UNIT, items.getInventoryUnit());
        values.put(WASTAGE_PERCENT, items.getWastagePercent());
        values.put(DISCOUNT_AVAILABLE, items.getDiscountAvailable());
        values.put(POINT_AVAILABLE, items.getPointAvailable());
        values.put(OPEN_PRICE, items.getOpenPrice());
        values.put(KITCHEN_PRINTER_TO_USE, items.getKitchenPrinter());
        values.put(USED, items.getUsed());
        values.put(SHOW_IN_MENU, items.getShowInMenu());
        values.put(ITEM_PICTURE, byteImage);

        db.insert(ITEMS, null, values);
        db.close();
    }

    public void addRecipe(Recipes recipe) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(BARCODE, recipe.getBarcode());
        values.put(ITEM, recipe.getItem());
        values.put(UNIT, recipe.getUnit());
        values.put(QTY, recipe.getQty());
        values.put(COST, recipe.getCost());

        db.insert(RECIPES, null, values);
        db.close();
    }

    public void addUsedCategory(UsedCategories category) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(CATEGORY_NAME, category.getCategoryName());
        values.put(NUMBER_OF_ITEMS, category.getNumberOfItems());
        values.put(CATEGORY_BACKGROUND, category.getBackground());
        values.put(CATEGORY_TEXT_COLOR, category.getTextColor());
        values.put(CATEGORY_POSITION, category.getPosition());

        db.insert(USED_CATEGORIES, null, values);
        db.close();
    }

    public void addUsedItems(UsedItems item) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(CATEGORY_NAME2, item.getCategoryName());
        values.put(ITEM_NAME, item.getitemName());
        values.put(ITEM_BACKGROUND, item.getBackground());
        values.put(ITEM_TEXT_COLOR, item.getTextColor());
        values.put(ITEM_POSITION, item.getPosition());

        db.insert(USED_ITEMS, null, values);
        db.close();
    }

    public void addTables(ArrayList<Tables> tables, int floor) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        for (int i = 0; i < tables.size(); i++) {
            values.put(HEIGHT, tables.get(i).getHeight());
            values.put(WIDTH, tables.get(i).getWidth());
            values.put(IMAGE_RESOURCE, tables.get(i).getImageResource());
            values.put(MARGIN_LEFT, tables.get(i).getMarginLeft());
            values.put(MARGIN_TOP, tables.get(i).getMarginTop());
            values.put(FLOOR, floor);
            values.put(TABLE_NUMBER, tables.get(i).getTableNumber());

            db.insert(TABLES, null, values);
        }
        db.close();
    }

    public void addMoneyCategory(ArrayList<Money> money) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        byte[] byteImage = {};
        for (int i = 0; i < money.size(); i++) {

            if (money.get(i).getPicture() != null) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                money.get(i).getPicture().compress(Bitmap.CompressFormat.PNG, 0, stream);
                byteImage = stream.toByteArray();
            }

            values.put(SERIAL1, money.get(i).getSerial());
            values.put(CATEGORY_NAME1, money.get(i).getCatName());
            values.put(CATEGORY_VALUE1, money.get(i).getCatValue());
            values.put(SHOW1, money.get(i).getShow());
            values.put(PICTURE1, byteImage);

            db.insert(MONEY_CATEGORIES, null, values);
        }
        db.close();
    }

    public void addCashierInOut(ArrayList<Cashier> cashier) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        for (int i = 0; i < cashier.size(); i++) {

            values.put(CASHIER_NAME3, cashier.get(i).getCashierName());
            values.put(DATE3, cashier.get(i).getCheckInDate());
            values.put(CATEGORY_NAME3, cashier.get(i).getCategoryName());
            values.put(CATEGORY_VALUE3, cashier.get(i).getCategoryValue());
            values.put(CATEGORY_QTY3, cashier.get(i).getCategoryQty());

            db.insert(CASHIER_IN_OUT, null, values);
        }
        db.close();
    }

    public void addBlindClose(BlindClose obj) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(TRANS_NO11, obj.getTransNo());
        values.put(DATE11, obj.getDate());
        values.put(TIME11, obj.getTime());
        values.put(POS_NO11, obj.getPOSNo());
        values.put(SHIFT_NO11, obj.getShiftNo());
        values.put(SHIFT_NAME11, obj.getShiftName());
        values.put(USER_NO11, obj.getUserNo());
        values.put(USER_NAME11, obj.getUserName());
        values.put(SYS_SALES11, obj.getSysSales());
        values.put(USER_SALES11, obj.getUserSales());
        values.put(SALES_DIFF11, obj.getSalesDiff());
        values.put(SYS_CASH11, obj.getSysCash());
        values.put(USER_CASH11, obj.getUserCash());
        values.put(CASH_DIFF11, obj.getCashDiff());
        values.put(SYS_OTHER_PAYMENTS11, obj.getSysOthers());
        values.put(USER_OTHER_PAYMENTS11, obj.getUserOthers());
        values.put(OTHER_PAYMENTS_DIFF11, obj.getOthersDiff());
        values.put(TILL_OK11, obj.getTillOk());
        values.put(TRANS_TYPE11, obj.getTransType());

        db.insert(BLIND_CLOSE, null, values);

        db.close();
    }

    public void addBlindCloseDetails(BlindCloseDetails obj) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(TRANS_NO12, obj.getTransNo());
        values.put(DATE12, obj.getDate());
        values.put(TIME12, obj.getTime());
        values.put(POS_NO12, obj.getPOSNo());
        values.put(SHIFT_NO12, obj.getShiftNo());
        values.put(SHIFT_NAME12, obj.getShiftName());
        values.put(USER_NO12, obj.getUserNo());
        values.put(USER_NAME12, obj.getUserName());
        values.put(CAT_NAME12, obj.getCatName());
        values.put(CAT_QTY12, obj.getCatQty());
        values.put(CAT_VALUE12, obj.getCatValue());
        values.put(CAT_TOTAL12, obj.getCatTotal());
        values.put(TYPE12, obj.getType());
        values.put(UPDATE_DATE12, obj.getUpdateDate());
        values.put(UPDATE_TIME12, obj.getUpdateTime());
        values.put(UPDATE_USER_NO12, obj.getUpdateUserNo());
        values.put(UPDATE_USER_NAME12, obj.getUpdateUserName());

        db.insert(BLIND_CLOSE_DETAILS, null, values);

        db.close();
    }

    public void addPayInOut(Pay pay) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(TRANS_TYPE, pay.getTransType());
        values.put(POS_NO, pay.getPosNo());
        values.put(USER_NO, pay.getUserNo());
        values.put(USER_NAME, pay.getUserName());
        values.put(TRANS_DATE, pay.getTransDate());
        values.put(VALUE, pay.getValue());
        values.put(REMARK, pay.getRemark());
        values.put(SHEFT_NO, pay.getShiftNo());
        values.put(SHEFT_NAME, pay.getShiftName());

        db.insert(PAY_IN_OUT, null, values);

        db.close();
    }

    public void addCreditCard(CreditCard card) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(SERIAL, card.getSerial());
        values.put(CARD_NAME, card.getCardName());
        values.put(ACC_CODE, card.getAccCode());

        db.insert(CREDIT_CARDS, null, values);

        db.close();
    }

    public void addCheque(Cheque cheeks) {

        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(SERIAL_CHEEK, cheeks.getSerialCheque());
        values.put(BANK_NAME, cheeks.getBankName());
        values.put(CHEQUE_NUMBER, cheeks.getChequeNumber());
        values.put(RECIVIDE, cheeks.getReceived());

        db.insert(CHEQUES, null, values);
        db.close();
    }

    public void addOrderTransaction(OrderTransactions items) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(ORDER_TYPE1, items.getOrderType());
        values.put(ORDER_KIND1, items.getOrderKind());
        values.put(VOUCHER_DATE1, items.getVoucherDate());
        values.put(POS_NO1, items.getPosNo());
        values.put(STORE_NO1, items.getStoreNo());
        values.put(VOUCHER_NO1, items.getVoucherNo());
        values.put(VOUCHER_SERIAL1, items.getVoucherSerial());
        values.put(ITEM_BARCODE1, items.getItemBarcode());
        values.put(ITEM_NAME1, items.getItemName());
        values.put(SECONDARY_NAME1, items.getSecondaryName());
        values.put(KITCHEN_ALIAS1, items.getKitchenAlias());
        values.put(QTY1, items.getQty());
        values.put(PRICE1, items.getPrice());
        values.put(TOTAL1, items.getTotal());
        values.put(DISCOUNT1, items.getDiscount());
        values.put(L_DISCOUNT1, items.getlDiscount());
        values.put(TOTAL_DISCOUNT1, items.getTotalDiscount());
        values.put(TAX_VLUE1, items.getTaxValue());
        values.put(TAX_PERC1, items.getTaxPerc());
        values.put(TAX_KIND1, items.getTaxKind());
        values.put(SERVICE1, items.getService());
        values.put(SERVICE_TAX1, items.getServiceTax());
        values.put(ITEM_CATEGORY1, items.getItemCategory());
        values.put(ITEM_FAMILY1, items.getItemFamily());
        values.put(TABLE_NO1, items.getTableNo());
        values.put(SECTION_NO1, items.getSectionNo());
        values.put(SHIFT_NO1, items.getShiftNo());
        values.put(SHIFT_NAME1, items.getShiftName());

        db.insert(ORDER_TRANSACTIONS, null, values);
        db.close();
    }

    public void addOrderTransactionTemp(OrderTransactions items) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(ORDER_TYPE1, items.getOrderType());
        values.put(ORDER_KIND1, items.getOrderKind());
        values.put(VOUCHER_DATE1, items.getVoucherDate());
        values.put(POS_NO1, items.getPosNo());
        values.put(STORE_NO1, items.getStoreNo());
        values.put(VOUCHER_NO1, items.getVoucherNo());
        values.put(VOUCHER_SERIAL1, items.getVoucherSerial());
        values.put(ITEM_BARCODE1, items.getItemBarcode());
        values.put(ITEM_NAME1, items.getItemName());
        values.put(SECONDARY_NAME1, items.getSecondaryName());
        values.put(KITCHEN_ALIAS1, items.getKitchenAlias());
        values.put(QTY1, items.getQty());
        values.put(PRICE1, items.getPrice());
        values.put(TOTAL1, items.getTotal());
        values.put(DISCOUNT1, items.getDiscount());
        values.put(L_DISCOUNT1, items.getlDiscount());
        values.put(TOTAL_DISCOUNT1, items.getTotalDiscount());
        values.put(TAX_VLUE1, items.getTaxValue());
        values.put(TAX_PERC1, items.getTaxPerc());
        values.put(TAX_KIND1, items.getTaxKind());
        values.put(SERVICE1, items.getService());
        values.put(SERVICE_TAX1, items.getServiceTax());
        values.put(ITEM_CATEGORY1, items.getItemCategory());
        values.put(ITEM_FAMILY1, items.getItemFamily());
        values.put(TABLE_NO1, items.getTableNo());
        values.put(SECTION_NO1, items.getSectionNo());
        values.put(SHIFT_NO1, items.getShiftNo());
        values.put(SHIFT_NAME1, items.getShiftName());

        db.insert(ORDER_TRANSACTIONS_TEMP, null, values);
        db.close();
    }

    public void addAllPayMethodItem(PayMethod payMethod) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(ORDER_TYPE, payMethod.getOrderType());
        values.put(ORDER_KIND, payMethod.getOrderKind());
        values.put(VOUCHER_DATE, payMethod.getVoucherDate());
        values.put(POINT_OF_SALE_NUMBER, payMethod.getPointOfSaleNumber());
        values.put(STORE_NUMBER, payMethod.getStoreNumber());
        values.put(VOUCHER_NUMBER, payMethod.getVoucherNumber());
        values.put(VOUCHER_SERIAL, payMethod.getVoucherSerial());
        values.put(PAY_TYPE, payMethod.getPayType());
        values.put(PAY_VALUE, payMethod.getPayValue());
        values.put(PAY_NUMBER, payMethod.getPayNumber());
        values.put(PAY_NAME, payMethod.getPayName());
        values.put(SHIFT_NAME, payMethod.getShiftName());
        values.put(SHIFT_NO, payMethod.getShiftNumber());

        db.insert(PAY_METHOD, null, values);
        db.close();

    }

    public void addOrderHeader(OrderHeader orderHeader) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(ORDER_TYPE2, orderHeader.getOrderType());
        values.put(ORDER_KIND2, orderHeader.getOrderKind());
        values.put(VOUCHER_DATE2, orderHeader.getVoucherDate());
        values.put(POINT_OF_SALE_NUMBER2, orderHeader.getPointOfSaleNumber());
        values.put(STORE_NUMBER2, orderHeader.getStoreNumber());
        values.put(VOUCHER_NUMBER2, orderHeader.getVoucherNumber());
        values.put(VOUCHER_SERIAL2, orderHeader.getVoucherSerial());
        values.put(TOTAL2, orderHeader.getTotal());
        values.put(TOTAL_DISCOUNT2, orderHeader.getTotalDiscount());
        values.put(TOTAL_LINE_DISCOUNT2, orderHeader.getTotalLineDiscount());
        values.put(ALL_DISCOUNT2, orderHeader.getAllDiscount());
        values.put(TOTAL_SERVICES2, orderHeader.getTotalService());
        values.put(TOTAL_TAX2, orderHeader.getTotalTax());
        values.put(SUB_TOTAL2, orderHeader.getSubTotal());
        values.put(TOTAL_SERVICES_TAX2, orderHeader.getTotalServiceTax());
        values.put(AMOUNT_DUE2, orderHeader.getAmountDue());
        values.put(DELIVERY_CHARGE2, orderHeader.getDeliveryCharge());
        values.put(TABLE_NUMBER2, orderHeader.getTableNO());
        values.put(SECTION_NUMBER2, orderHeader.getSectionNO());
        values.put(CASH_VALUE2, orderHeader.getCashValue());
        values.put(CARDS_VALUE2, orderHeader.getCardsValue());
        values.put(CHEQUE_VALUE2, orderHeader.getChequeValue());
        values.put(COUPON_VALUE2, orderHeader.getCouponValue());
        values.put(GIFT_VALUE2, orderHeader.getGiftValue());
        values.put(POINT_VALUE2, orderHeader.getPointValue());
        values.put(SHIFT_NAME2, orderHeader.getShiftName());
        values.put(SHIFT_NO2, orderHeader.getShiftNumber());
        values.put(WAITER2, orderHeader.getWaiter());
        values.put(SEATS_NUMBER2, orderHeader.getSeatsNumber());

        db.insert(ORDER_HEADER, null, values);
        db.close();
    }

    public void addOrderHeaderTemp(OrderHeader orderHeader) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(ORDER_TYPE2, orderHeader.getOrderType());
        values.put(ORDER_KIND2, orderHeader.getOrderKind());
        values.put(VOUCHER_DATE2, orderHeader.getVoucherDate());
        values.put(POINT_OF_SALE_NUMBER2, orderHeader.getPointOfSaleNumber());
        values.put(STORE_NUMBER2, orderHeader.getStoreNumber());
        values.put(VOUCHER_NUMBER2, orderHeader.getVoucherNumber());
        values.put(VOUCHER_SERIAL2, orderHeader.getVoucherSerial());
        values.put(TOTAL2, orderHeader.getTotal());
        values.put(TOTAL_DISCOUNT2, orderHeader.getTotalDiscount());
        values.put(TOTAL_LINE_DISCOUNT2, orderHeader.getTotalLineDiscount());
        values.put(ALL_DISCOUNT2, orderHeader.getAllDiscount());
        values.put(TOTAL_SERVICES2, orderHeader.getTotalService());
        values.put(TOTAL_TAX2, orderHeader.getTotalTax());
        values.put(SUB_TOTAL2, orderHeader.getSubTotal());
        values.put(TOTAL_SERVICES_TAX2, orderHeader.getTotalServiceTax());
        values.put(AMOUNT_DUE2, orderHeader.getAmountDue());
        values.put(DELIVERY_CHARGE2, orderHeader.getDeliveryCharge());
        values.put(TABLE_NUMBER2, orderHeader.getTableNO());
        values.put(SECTION_NUMBER2, orderHeader.getSectionNO());
        values.put(CASH_VALUE2, orderHeader.getCashValue());
        values.put(CARDS_VALUE2, orderHeader.getCardsValue());
        values.put(CHEQUE_VALUE2, orderHeader.getChequeValue());
        values.put(COUPON_VALUE2, orderHeader.getCouponValue());
        values.put(GIFT_VALUE2, orderHeader.getGiftValue());
        values.put(POINT_VALUE2, orderHeader.getPointValue());
        values.put(SHIFT_NAME2, orderHeader.getShiftName());
        values.put(SHIFT_NO2, orderHeader.getShiftNumber());
        values.put(WAITER2, orderHeader.getWaiter());
        values.put(SEATS_NUMBER2, orderHeader.getSeatsNumber());

        db.insert(ORDER_HEADER_TEMP, null, values);
        db.close();
    }

    public void addForceQuestion(ForceQuestions question) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(QUESTION_NO, question.getQuestionNo());
        values.put(QUESTION_TEXT, question.getQuestionText());
        values.put(MULTIPLE_ANSWER, question.getMultipleAnswer());
        values.put(ANSWER, question.getAnswer());

        db.insert(FORCE_QUESTIONS, null, values);
        db.close();
    }

    public void addModifierItem(Modifier modifier) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(MODIFIER_NAME1, modifier.getModifierName());
        values.put(MODIFIER_NO1, modifier.getModifierNumber());
        values.put(ACTIVE1, modifier.getModifierActive());

        db.insert(MODIFIER, null, values);
        db.close();
    }

    public void addCategoriesModifier(CategoryWithModifier categoryModifier) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(MODIFIER_NAME2, categoryModifier.getModifierName());
        values.put(CATEGORY2, categoryModifier.getCategoryName());

        db.insert(CATEGORY_WITH_MODIFIER, null, values);
        db.close();
    }

    public void addItemWithModifier(ItemWithModifier modifier) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(ITEM_CODE, modifier.getItemCode());
        values.put(MODIFIER_NO, modifier.getModifierNo());
        values.put(MODIFIER_TEXT, modifier.getModifierText());

        db.insert(ITEM_WITH_MODIFIER, null, values);
        db.close();
    }

    public void addItemWithFQ(ItemWithFq fq) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(ITEM_CODE2, fq.getItemCode());
        values.put(QUESTION_NO2, fq.getQuestionNo());
        values.put(QUESTION_TEXT2, fq.getQuestionText());

        db.insert(ITEM_WITH_FQ, null, values);
        db.close();
    }

    public void addCustomerPayment(CustomerPayment customerPayment) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(POINT_OF_SALE_NUMBER3, customerPayment.getPointOfSaleNumber());
        values.put(USER_NO3, customerPayment.getUserNO());
        values.put(USER_NAME3, customerPayment.getUserName());
        values.put(CUSTOMER_NO3, customerPayment.getCustomerNo());
        values.put(CUSTOMER_NAME3, customerPayment.getCustomerName());
        values.put(CUSTOMER_BALANCE3, customerPayment.getCustomerBalance());
        values.put(TRANS_NO3, customerPayment.getTransNo());
        values.put(TRANS_DATE3, customerPayment.getTransDate());
        values.put(PAYMENT_TYPE3, customerPayment.getPayMentType());
        values.put(VALUE3, customerPayment.getValue());
        values.put(SHIFT_NUMBER3, customerPayment.getShiftNo());
        values.put(SHIFT_NAME3, customerPayment.getShiftName());

        db.insert(CUSTOMER_PAYMENT, null, values);
        db.close();
    }

    public void addClockInClockOut(ClockInClockOut clockInClockOut) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(POINT_OF_SALE_NUMBER4, clockInClockOut.getPointOfSaleNumber());
        values.put(DATE4, clockInClockOut.getDate());
        values.put(USER_NO4, clockInClockOut.getUserNO());
        values.put(USER_NAME4, clockInClockOut.getUserName());
        values.put(TRANS_TYPE4, clockInClockOut.getTranstype());
        values.put(DATE_CARD4, clockInClockOut.getDateCard());
        values.put(TIME_CARD4, clockInClockOut.getTimeCard());
        values.put(REMARK4, clockInClockOut.getRemark());
        values.put(SHIFT_NUMBER4, clockInClockOut.getShiftNo());
        values.put(SHIFT_NAME4, clockInClockOut.getShiftName());

        db.insert(CLOCK_IN_CLOCK_OUT, null, values);
        db.close();

    }

    public void addJobGroup(JobGroup jobGroup) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(JOB_GROUP5, jobGroup.getJobGroup());
        values.put(USER_NAME5, jobGroup.getUserName());
        values.put(USER_NO5, jobGroup.getUserNo());
        values.put(IN_DATE5, jobGroup.getInDate());
        values.put(ACTIVE5, jobGroup.getActive());
        values.put(SHIFT_NO5, jobGroup.getShiftNo());
        values.put(SHIFT_NAME5, jobGroup.getShiftName());

        db.insert(JOB_GROUP_TABLE, null, values);

        db.close();
    }

    public void addMemberShipGroup(MemberShipGroup memberShipGroup) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(MEMBER_SHIP_GROUP, memberShipGroup.getMemberShipGroup());
        values.put(USER_NAME6, memberShipGroup.getUserName());
        values.put(USER_NO6, memberShipGroup.getUserNo());
        values.put(IN_DATE6, memberShipGroup.getInDate());
        values.put(ACTIVE6, memberShipGroup.getActive());
        values.put(SHIFT_NO6, memberShipGroup.getShiftNo());
        values.put(SHIFT_NAME6, memberShipGroup.getShiftName());

        db.insert(MEMBER_SHIP_GROUP_MANAGEMENT_TABLE, null, values);

        db.close();
    }

    public void addShift(Shift shift) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(SHIFT_NO9, shift.getShiftNo());
        values.put(SHIFT_NAME9, shift.getShiftName());
        values.put(FROM_TIME9, shift.getFromTime());
        values.put(TO_TIME9, shift.getToTime());

        db.insert(SHIFT_REGISTRATION, null, values);

        db.close();
    }

    public void addBlindShiftInOut(BlindShift blindShift) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(DATE10, blindShift.getDate());
        values.put(TIME10, blindShift.getTime());
        values.put(POS_NO10, blindShift.getPosNo());
        values.put(SHIFT_NO10, blindShift.getShiftNo());
        values.put(SHIFT_NAME10, blindShift.getShiftName());
        values.put(USER_NO10, blindShift.getUserNo());
        values.put(USER_NAME10, blindShift.getUserName());
        values.put(STATUS10, blindShift.getStatus());

        db.insert(BLIND_SHIFT_IN, null, values);

        db.close();
    }

    public void addEmployeeRegistration(EmployeeRegistrationModle employeeRegistrationModle) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(JOB_GROUP7, employeeRegistrationModle.getJobGroup());
        values.put(EMPLOYEE_NAME7, employeeRegistrationModle.getEmployeeName());
        values.put(EMPLOYEE_NO7, employeeRegistrationModle.getEmployeeNO());
        values.put(MOBILE_NO7, employeeRegistrationModle.getMobileNo());
        values.put(SECURITY_LEVEL7, employeeRegistrationModle.getSecurityLevel());
        values.put(USER_PASSWORD7, employeeRegistrationModle.getUserPassword());
        values.put(ACTIVE7, employeeRegistrationModle.getActive());
        values.put(HIRE_DATA7, employeeRegistrationModle.getHireDate());
        values.put(TERMINATION_DATE7, employeeRegistrationModle.getTerminationDate());
        values.put(PAY_BASIC7, employeeRegistrationModle.getPayBasic());
        values.put(PAY_RATE7, employeeRegistrationModle.getPayRate());
        values.put(HOLIDAY_PAY7, employeeRegistrationModle.getHolidayPay());
        values.put(EMPLOYEE_TYPE7, employeeRegistrationModle.getEmployeeType());
        values.put(SHIFT_NO7, employeeRegistrationModle.getShiftNo());
        values.put(SHIFT_NAME7, employeeRegistrationModle.getShiftName());

        db.insert(EMPLOYEE_REGISTRATION_TABLE, null, values);

        db.close();
    }

    public void addCustomerRegistration(CustomerRegistrationModel customerRegistrationModel) {
        db = this.getReadableDatabase();
        ContentValues values = new ContentValues();


        values.put(MEMBER_SHIP_GROUP8, customerRegistrationModel.getMemberShipGroup());
        values.put(CUSTOMER_NAME8, customerRegistrationModel.getCustomerName());
        values.put(CUSTOMER_CODE8, customerRegistrationModel.getCustomerCode());
        values.put(MEMBER_SHIP_CARD8, customerRegistrationModel.getMemberShipGroup());
        values.put(GENDER8, customerRegistrationModel.getCoender());
        values.put(REMARK8, customerRegistrationModel.getRemark());
        values.put(STREET_NO_NAME8, customerRegistrationModel.getStreetNoName());
        values.put(CITY8, customerRegistrationModel.getCity());
        values.put(PHONE_NO8, customerRegistrationModel.getPhoneNo());
        values.put(MOBILE_NO8, customerRegistrationModel.getMobileNo());
        values.put(NAME_SHOW8, customerRegistrationModel.getNameShow());
        values.put(BIRTHDAY8, customerRegistrationModel.getBirthday());
        values.put(ANNIVERSARY8, customerRegistrationModel.getAnniversary());
        values.put(OCCUPATION8, customerRegistrationModel.getOccupation());
        values.put(EMAIL8, customerRegistrationModel.getEmail());
        values.put(TOTAL_POINT8, customerRegistrationModel.getTotalPoint());
        values.put(REDEEMED_POINT8, customerRegistrationModel.getRedeemedPoint());
        values.put(REMAINING_POINT8, customerRegistrationModel.getRemainingPoint());
        values.put(SHIFT_NO8, customerRegistrationModel.getShiftNO());
        values.put(SHIFT_NAME8, customerRegistrationModel.getShiftName());

        db.insert(CUSTOMER_REGISTRATION_TABLE, null, values);

        db.close();
    }


    public ArrayList<ClockInClockOut> getAllExistingClockInClockOut() {
        ArrayList<ClockInClockOut> clockInClockOuts = new ArrayList<ClockInClockOut>();

        String selectQuery = "SELECT * FROM " + PAY_METHOD;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst())
            do {
                ClockInClockOut clockInClockOut = new ClockInClockOut();

                clockInClockOut.setPointOfSaleNumber(cursor.getInt(0));
                clockInClockOut.setDate(cursor.getString(1));
                clockInClockOut.setUserNO(cursor.getInt(2));
                clockInClockOut.setUserName(cursor.getString(3));
                clockInClockOut.setTranstype(cursor.getString(4));
                clockInClockOut.setDateCard(cursor.getString(5));
                clockInClockOut.setTimeCard(cursor.getString(6));
                clockInClockOut.setRemark(cursor.getString(7));
                clockInClockOut.setShiftNo(cursor.getInt(8));
                clockInClockOut.setShiftName(cursor.getString(9));

                clockInClockOuts.add(clockInClockOut);

            } while (cursor.moveToNext());

        return clockInClockOuts;

    }

    public List<Items> getAllItems() {
        List<Items> items = new ArrayList<Items>();

        String selectQuery = "SELECT  * FROM " + ITEMS;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Items item = new Items();

                item.setMenuCategory(cursor.getString(0));
                item.setMenuName(cursor.getString(1));
                item.setFamilyName(cursor.getString(2));
                item.setPrice(Double.parseDouble(cursor.getString(3)));
                item.setTaxType(Integer.parseInt(cursor.getString(4)));
                item.setTax(Double.parseDouble(cursor.getString(5)));
                item.setSecondaryName(cursor.getString(6));
                item.setKitchenAlias(cursor.getString(7));
                item.setItemBarcode(Integer.parseInt(cursor.getString(8)));
                item.setStatus(Integer.parseInt(cursor.getString(9)));
                item.setItemType(Integer.parseInt(cursor.getString(10)));
                item.setDescription(cursor.getString(11));
                item.setInventoryUnit(cursor.getString(12));
                item.setWastagePercent(Double.parseDouble(cursor.getString(13)));
                item.setDiscountAvailable(Integer.parseInt(cursor.getString(14)));
                item.setPointAvailable(Integer.parseInt(cursor.getString(15)));
                item.setOpenPrice(Integer.parseInt(cursor.getString(16)));
                item.setKitchenPrinter(cursor.getString(17));
                item.setUsed(Integer.parseInt(cursor.getString(18)));
                item.setShowInMenu(Integer.parseInt(cursor.getString(19)));

                if (cursor.getBlob(20).length == 0)
                    item.setPic(null);
                else
                    item.setPic(BitmapFactory.decodeByteArray(cursor.getBlob(20), 0, cursor.getBlob(20).length));

                // Adding transaction to list
                items.add(item);
            } while (cursor.moveToNext());
        }
        return items;
    }

    public List<String> getAllExistingCategories() {
        List<String> categories = new ArrayList<>();

        String selectQuery = "SELECT DISTINCT MENU_CATEGORY FROM " + ITEMS;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                categories.add(cursor.getString(0));

            } while (cursor.moveToNext());
        }
        return categories;
    }

    public List<UsedCategories> getUsedCategories() {
        List<UsedCategories> categories = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + USED_CATEGORIES;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        if (cursor.moveToFirst()) {
            do {
                UsedCategories UsedCategory = new UsedCategories();

                UsedCategory.setCategoryName(cursor.getString(0));
                UsedCategory.setNumberOfItems(Integer.parseInt(cursor.getString(1)));
                UsedCategory.setBackground(Integer.parseInt(cursor.getString(2)));
                UsedCategory.setTextColor(Integer.parseInt(cursor.getString(3)));
                UsedCategory.setPosition(Integer.parseInt(cursor.getString(4)));
                categories.add(UsedCategory);

            } while (cursor.moveToNext());
        }
        return categories;
    }

    public ArrayList<Pay> getAllPayInOut() {
        ArrayList<Pay> pays = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + PAY_IN_OUT;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Pay pay = new Pay();

                pay.setTransType(Integer.parseInt(cursor.getString(0)));
                pay.setPosNo(Integer.parseInt(cursor.getString(1)));
                pay.setUserNo(Integer.parseInt(cursor.getString(2)));
                pay.setUserName(cursor.getString(3));
                pay.setTransDate(cursor.getString(4));
                pay.setValue(Double.parseDouble(cursor.getString(5)));
                pay.setRemark(cursor.getString(6));
                pay.setShiftNo(Integer.parseInt(cursor.getString(7)));
                pay.setShiftName(cursor.getString(8));
                pays.add(pay);

            } while (cursor.moveToNext());
        }
        return pays;
    }

    public ArrayList<Money> getAllMoneyCategory() {
        ArrayList<Money> items = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + MONEY_CATEGORIES;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Money item = new Money();

                item.setSerial(Integer.parseInt(cursor.getString(0)));
                item.setCatName(cursor.getString(1));
                item.setCatValue(Integer.parseInt(cursor.getString(2)));
                item.setShow(Integer.parseInt(cursor.getString(3)));
                if (cursor.getBlob(4).length == 0)
                    item.setPicture(null);
                else
                    item.setPicture(BitmapFactory.decodeByteArray(cursor.getBlob(4), 0, cursor.getBlob(4).length));
                items.add(item);

            } while (cursor.moveToNext());
        }
        return items;
    }

    public ArrayList<UsedItems> getRequestedItems(String categoryName) {
        ArrayList<UsedItems> items = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + USED_ITEMS + " where CATEGORY_NAME2 = '" + categoryName + "'";
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                UsedItems item = new UsedItems();

                item.setCategoryName(cursor.getString(0));
                item.setitemName(cursor.getString(1));
                item.setBackground(Integer.parseInt(cursor.getString(2)));
                item.setTextColor(Integer.parseInt(cursor.getString(3)));
                item.setPosition(Integer.parseInt(cursor.getString(4)));
                items.add(item);

            } while (cursor.moveToNext());
        }
        return items;
    }

    public List<String> getAllExistingFamilies() {
        List<String> families = new ArrayList<>();

        String selectQuery = "SELECT DISTINCT FAMILY_NAME FROM " + ITEMS;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                families.add(cursor.getString(0));

            } while (cursor.moveToNext());
        }
        return families;
    }

    public List<String> getAllExistingUnits() {
        List<String> units = new ArrayList<>();

        String selectQuery = "SELECT DISTINCT INVENTORY_UNIT FROM " + ITEMS;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                units.add(cursor.getString(0));

            } while (cursor.moveToNext());
        }
        return units;
    }

    public ArrayList<Tables> getRequestedTables(int floor) {
        ArrayList<Tables> tables = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLES + " where FLOOR = '" + floor + "'";
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Tables table = new Tables();

                table.setHeight(Integer.parseInt(cursor.getString(0)));
                table.setWidth(Integer.parseInt(cursor.getString(1)));
                table.setImageResource(Integer.parseInt(cursor.getString(2)));
                table.setMarginLeft(Float.parseFloat(cursor.getString(3)));
                table.setMarginTop(Float.parseFloat(cursor.getString(4)));
                table.setTableNumber(Integer.parseInt(cursor.getString(6)));
                tables.add(table);

            } while (cursor.moveToNext());
        }
        return tables;
    }

    public ArrayList<CreditCard> getAllCreditCards() {
        ArrayList<CreditCard> cards = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + CREDIT_CARDS;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                CreditCard card = new CreditCard();
                card.setSerial(Integer.parseInt(cursor.getString(0)));
                card.setCardName(cursor.getString(1));
                card.setAccCode(cursor.getString(2));

                cards.add(card);

            } while (cursor.moveToNext());
        }
        return cards;
    }

    public ArrayList<Cheque> getAllCheques() {
        ArrayList<Cheque> cheeks_iteam = new ArrayList<Cheque>();

        String selectQuery = "SELECT * FROM " + CHEQUES;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Cheque cheque = new Cheque();

                cheque.setSerialCheque(cursor.getInt(0));
                cheque.setBankName(cursor.getString(1));
                cheque.setChequeNumber(cursor.getInt(2));
                cheque.setReceived(cursor.getInt(3));

                cheeks_iteam.add(cheque);
            } while (cursor.moveToNext());
        }
        return cheeks_iteam;
    }

    public List<OrderTransactions> getAllOrderTransactions() {
        List<OrderTransactions> items = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + ORDER_TRANSACTIONS;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                OrderTransactions item = new OrderTransactions();

                item.setOrderType(Integer.parseInt(cursor.getString(0)));
                item.setOrderKind(Integer.parseInt(cursor.getString(1)));
                item.setVoucherDate(cursor.getString(2));
                item.setPosNo(Integer.parseInt(cursor.getString(3)));
                item.setStoreNo(Integer.parseInt(cursor.getString(4)));
                item.setVoucherNo(cursor.getString(5));
                item.setVoucherSerial(Integer.parseInt(cursor.getString(6)));
                item.setItemBarcode(cursor.getString(7));
                item.setItemName(cursor.getString(8));
                item.setSecondaryName(cursor.getString(9));
                item.setKitchenAlias(cursor.getString(10));
                item.setItemCategory(cursor.getString(11));
                item.setItemFamily(cursor.getString(12));
                item.setQty(Integer.parseInt(cursor.getString(13)));
                item.setPrice(Double.parseDouble(cursor.getString(14)));
                item.setTotal(Double.parseDouble(cursor.getString(15)));
                item.setDiscount(Double.parseDouble(cursor.getString(16)));
                item.setlDiscount(Double.parseDouble(cursor.getString(17)));
                item.setTotalDiscount(Double.parseDouble(cursor.getString(18)));
                item.setTaxValue(Double.parseDouble(cursor.getString(19)));
                item.setTaxPerc(Double.parseDouble(cursor.getString(20)));
                item.setTaxKind(Integer.parseInt(cursor.getString(21)));
                item.setService(Integer.parseInt(cursor.getString(22)));
                item.setServiceTax(Double.parseDouble(cursor.getString(23)));
                item.setTableNo(Integer.parseInt(cursor.getString(24)));
                item.setSectionNo(Integer.parseInt(cursor.getString(25)));
                item.setShiftNo(Integer.parseInt(cursor.getString(26)));
                item.setShiftName(cursor.getString(27));

                items.add(item);
            } while (cursor.moveToNext());
        }
        return items;
    }

    public List<OrderTransactions> getAllOrderTransactionsTemp() {
        List<OrderTransactions> items = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + ORDER_TRANSACTIONS_TEMP;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                OrderTransactions item = new OrderTransactions();

                item.setOrderType(Integer.parseInt(cursor.getString(0)));
                item.setOrderKind(Integer.parseInt(cursor.getString(1)));
                item.setVoucherDate(cursor.getString(2));
                item.setPosNo(Integer.parseInt(cursor.getString(3)));
                item.setStoreNo(Integer.parseInt(cursor.getString(4)));
                item.setVoucherNo(cursor.getString(5));
                item.setVoucherSerial(Integer.parseInt(cursor.getString(6)));
                item.setItemBarcode(cursor.getString(7));
                item.setItemName(cursor.getString(8));
                item.setSecondaryName(cursor.getString(9));
                item.setKitchenAlias(cursor.getString(10));
                item.setItemCategory(cursor.getString(11));
                item.setItemFamily(cursor.getString(12));
                item.setQty(Integer.parseInt(cursor.getString(13)));
                item.setPrice(Double.parseDouble(cursor.getString(14)));
                item.setTotal(Double.parseDouble(cursor.getString(15)));
                item.setDiscount(Double.parseDouble(cursor.getString(16)));
                item.setlDiscount(Double.parseDouble(cursor.getString(17)));
                item.setTotalDiscount(Double.parseDouble(cursor.getString(18)));
                item.setTaxValue(Double.parseDouble(cursor.getString(19)));
                item.setTaxPerc(Double.parseDouble(cursor.getString(20)));
                item.setTaxKind(Integer.parseInt(cursor.getString(21)));
                item.setService(Integer.parseInt(cursor.getString(22)));
                item.setServiceTax(Double.parseDouble(cursor.getString(23)));
                item.setTableNo(Integer.parseInt(cursor.getString(24)));
                item.setSectionNo(Integer.parseInt(cursor.getString(25)));
                item.setShiftNo(Integer.parseInt(cursor.getString(26)));
                item.setShiftName(cursor.getString(27));

                items.add(item);
            } while (cursor.moveToNext());
        }
        return items;
    }

    public List<OrderTransactions> getOrderTransactionsTemp(String sectionNo, String tableNo) {
        List<OrderTransactions> items = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + ORDER_TRANSACTIONS_TEMP + " WHERE SECTION_NO = '" + sectionNo + "' and TABLE_NO = '" + tableNo + "'";
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                OrderTransactions item = new OrderTransactions();

                item.setOrderType(Integer.parseInt(cursor.getString(0)));
                item.setOrderKind(Integer.parseInt(cursor.getString(1)));
                item.setVoucherDate(cursor.getString(2));
                item.setPosNo(Integer.parseInt(cursor.getString(3)));
                item.setStoreNo(Integer.parseInt(cursor.getString(4)));
                item.setVoucherNo(cursor.getString(5));
                item.setVoucherSerial(Integer.parseInt(cursor.getString(6)));
                item.setItemBarcode(cursor.getString(7));
                item.setItemName(cursor.getString(8));
                item.setSecondaryName(cursor.getString(9));
                item.setKitchenAlias(cursor.getString(10));
                item.setItemCategory(cursor.getString(11));
                item.setItemFamily(cursor.getString(12));
                item.setQty(Integer.parseInt(cursor.getString(13)));
                item.setPrice(Double.parseDouble(cursor.getString(14)));
                item.setTotal(Double.parseDouble(cursor.getString(15)));
                item.setDiscount(Double.parseDouble(cursor.getString(16)));
                item.setlDiscount(Double.parseDouble(cursor.getString(17)));
                item.setTotalDiscount(Double.parseDouble(cursor.getString(18)));
                item.setTaxValue(Double.parseDouble(cursor.getString(19)));
                item.setTaxPerc(Double.parseDouble(cursor.getString(20)));
                item.setTaxKind(Integer.parseInt(cursor.getString(21)));
                item.setService(Integer.parseInt(cursor.getString(22)));
                item.setServiceTax(Double.parseDouble(cursor.getString(23)));
                item.setTableNo(Integer.parseInt(cursor.getString(24)));
                item.setSectionNo(Integer.parseInt(cursor.getString(25)));
                item.setShiftNo(Integer.parseInt(cursor.getString(26)));
                item.setShiftName(cursor.getString(27));

                items.add(item);
            } while (cursor.moveToNext());
        }
        return items;
    }

    public List<String> getAllOrderedTables(int sectionNo) {
        List<String> tables = new ArrayList<>();

        String selectQuery = "SELECT  DISTINCT TABLE_NO FROM " + ORDER_TRANSACTIONS_TEMP + " WHERE SECTION_NO = '" + sectionNo + "'";
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                tables.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        return tables;
    }

    public ArrayList<PayMethod> getAllExistingPay() {
        ArrayList<PayMethod> payMethodsList = new ArrayList<PayMethod>();

        String selectQuery = "SELECT * FROM " + PAY_METHOD;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst())
            do {
                PayMethod payMethod = new PayMethod();

                payMethod.setOrderType(cursor.getInt(0));
                payMethod.setOrderKind(cursor.getInt(1));
                payMethod.setVoucherDate(cursor.getString(2));
                payMethod.setPointOfSaleNumber(cursor.getInt(3));
                payMethod.setStoreNumber(cursor.getInt(4));
                payMethod.setVoucherNumber(cursor.getString(5));
                payMethod.setVoucherSerial(cursor.getInt(6));
                payMethod.setPayType(cursor.getString(7));
                payMethod.setPayValue(cursor.getDouble(8));
                payMethod.setPayNumber(cursor.getString(9));
                payMethod.setPayName(cursor.getString(10));
                payMethod.setShiftName(cursor.getString(11));
                payMethod.setShiftNumber(cursor.getInt(12));

                payMethodsList.add(payMethod);

            } while (cursor.moveToNext());

        return payMethodsList;

    }

    public int getMaxSerial(String ColumeName, String TableName) {
        ArrayList<Integer> moneys = new ArrayList<>();
        int max;
        String selectQuery = "SELECT " + ColumeName + " FROM " + TableName;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                moneys.add(cursor.getInt(0));

            } while (cursor.moveToNext());
        }
        if (moneys.isEmpty())
            max = 0;
        else
            max = Collections.max(moneys);
        return max;
    }

    public ArrayList<OrderHeader> getAllOrderHeader() {
        ArrayList<OrderHeader> orderHeaders = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + ORDER_HEADER;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst())
            do {
                OrderHeader order_header = new OrderHeader();

                order_header.setOrderType(cursor.getInt(0));
                order_header.setOrderKind(cursor.getInt(1));
                order_header.setVoucherDate(cursor.getString(2));
                order_header.setPointOfSaleNumber(cursor.getInt(3));
                order_header.setStoreNumber(cursor.getInt(4));
                order_header.setVoucherNumber(cursor.getString(5));
                order_header.setVoucherSerial(cursor.getInt(6));
                order_header.setTotal(cursor.getDouble(7));
                order_header.setTotalLineDiscount(cursor.getDouble(8));
                order_header.setTotalDiscount(cursor.getDouble(9));
                order_header.setAllDiscount(cursor.getDouble(10));
                order_header.setTotalService(cursor.getDouble(11));
                order_header.setTotalTax(cursor.getDouble(12));
                order_header.setTotalServiceTax(cursor.getDouble(13));
                order_header.setSubTotal(cursor.getDouble(14));
                order_header.setAmountDue(cursor.getDouble(15));
                order_header.setDeliveryCharge(cursor.getDouble(16));
                order_header.setTableNO(cursor.getInt(17));
                order_header.setSectionNO(cursor.getInt(18));
                order_header.setCashValue(cursor.getDouble(19));
                order_header.setCardsValue(cursor.getDouble(20));
                order_header.setChequeValue(cursor.getDouble(21));
                order_header.setCouponValue(cursor.getDouble(22));
                order_header.setGiftValue(cursor.getDouble(23));
                order_header.setPointValue(cursor.getDouble(24));
                order_header.setShiftName(cursor.getString(25));
                order_header.setShiftNumber(cursor.getInt(26));

                orderHeaders.add(order_header);

            } while (cursor.moveToNext());
        return orderHeaders;


    }

    public ArrayList<OrderHeader> getAllOrderHeaderTemp() {
        ArrayList<OrderHeader> orderHeaders = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + ORDER_HEADER_TEMP;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst())
            do {
                OrderHeader order_header = new OrderHeader();

                order_header.setOrderType(cursor.getInt(0));
                order_header.setOrderKind(cursor.getInt(1));
                order_header.setVoucherDate(cursor.getString(2));
                order_header.setPointOfSaleNumber(cursor.getInt(3));
                order_header.setStoreNumber(cursor.getInt(4));
                order_header.setVoucherNumber(cursor.getString(5));
                order_header.setVoucherSerial(cursor.getInt(6));
                order_header.setTotal(cursor.getDouble(7));
                order_header.setTotalLineDiscount(cursor.getDouble(8));
                order_header.setTotalDiscount(cursor.getDouble(9));
                order_header.setAllDiscount(cursor.getDouble(10));
                order_header.setTotalService(cursor.getDouble(11));
                order_header.setTotalTax(cursor.getDouble(12));
                order_header.setTotalServiceTax(cursor.getDouble(13));
                order_header.setSubTotal(cursor.getDouble(14));
                order_header.setAmountDue(cursor.getDouble(15));
                order_header.setDeliveryCharge(cursor.getDouble(16));
                order_header.setTableNO(cursor.getInt(17));
                order_header.setSectionNO(cursor.getInt(18));
                order_header.setCashValue(cursor.getDouble(19));
                order_header.setCardsValue(cursor.getDouble(20));
                order_header.setChequeValue(cursor.getDouble(21));
                order_header.setCouponValue(cursor.getDouble(22));
                order_header.setGiftValue(cursor.getDouble(23));
                order_header.setPointValue(cursor.getDouble(24));
                order_header.setShiftNumber(cursor.getInt(25));
                order_header.setShiftName(cursor.getString(26));

                orderHeaders.add(order_header);

            } while (cursor.moveToNext());
        return orderHeaders;


    }

    public ArrayList<OrderHeader> getOrderHeaderTemp(String sectionNo, String tableNo) {
        ArrayList<OrderHeader> orderHeaders = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + ORDER_HEADER_TEMP + " WHERE SECTION_NUMBER = '" + sectionNo + "' and TABLE_NUMBER = '" + tableNo + "'";
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst())
            do {
                OrderHeader order_header = new OrderHeader();

                order_header.setOrderType(cursor.getInt(0));
                order_header.setOrderKind(cursor.getInt(1));
                order_header.setVoucherDate(cursor.getString(2));
                order_header.setPointOfSaleNumber(cursor.getInt(3));
                order_header.setStoreNumber(cursor.getInt(4));
                order_header.setVoucherNumber(cursor.getString(5));
                order_header.setVoucherSerial(cursor.getInt(6));
                order_header.setTotal(cursor.getDouble(7));
                order_header.setTotalDiscount(cursor.getDouble(8));
                order_header.setTotalLineDiscount(cursor.getDouble(9));
                order_header.setAllDiscount(cursor.getDouble(10));
                order_header.setTotalService(cursor.getDouble(11));
                order_header.setTotalTax(cursor.getDouble(12));
                order_header.setTotalServiceTax(cursor.getDouble(13));
                order_header.setSubTotal(cursor.getDouble(14));
                order_header.setAmountDue(cursor.getDouble(15));
                order_header.setDeliveryCharge(cursor.getDouble(16));
                order_header.setTableNO(cursor.getInt(17));
                order_header.setSectionNO(cursor.getInt(18));
                order_header.setCashValue(cursor.getDouble(19));
                order_header.setCardsValue(cursor.getDouble(20));
                order_header.setChequeValue(cursor.getDouble(21));
                order_header.setCouponValue(cursor.getDouble(22));
                order_header.setGiftValue(cursor.getDouble(23));
                order_header.setPointValue(cursor.getDouble(24));
                order_header.setShiftNumber(cursor.getInt(25));
                order_header.setShiftName(cursor.getString(26));

                orderHeaders.add(order_header);

            } while (cursor.moveToNext());
        return orderHeaders;


    }

    public ArrayList<ForceQuestions> getAllForceQuestions() {
        ArrayList<ForceQuestions> questions = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + FORCE_QUESTIONS;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ForceQuestions question = new ForceQuestions();
                question.setQuestionNo(Integer.parseInt(cursor.getString(0)));
                question.setQuestionText(cursor.getString(1));
                question.setMultipleAnswer(Integer.parseInt(cursor.getString(2)));
                question.setAnswer(cursor.getString(3));

                questions.add(question);

            } while (cursor.moveToNext());
        }
        return questions;
    }

    public ArrayList<ForceQuestions> getRequestedForceQuestions(int questionNo) {
        ArrayList<ForceQuestions> questions = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + FORCE_QUESTIONS + " where QUESTION_NO ='" + questionNo + "'";
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ForceQuestions question = new ForceQuestions();
                question.setQuestionNo(Integer.parseInt(cursor.getString(0)));
                question.setQuestionText(cursor.getString(1));
                question.setMultipleAnswer(Integer.parseInt(cursor.getString(2)));
                question.setAnswer(cursor.getString(3));

                questions.add(question);

            } while (cursor.moveToNext());
        }
        return questions;
    }

    public ArrayList<ForceQuestions> getSomeForceQuestions() {
        ArrayList<ForceQuestions> questions = new ArrayList<>();

        String selectQuery = "SELECT distinct QUESTION_NO , QUESTION_TEXT FROM " + FORCE_QUESTIONS;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ForceQuestions question = new ForceQuestions();
                question.setQuestionNo(Integer.parseInt(cursor.getString(0)));
                question.setQuestionText(cursor.getString(1));

                questions.add(question);

            } while (cursor.moveToNext());
        }
        return questions;
    }

    public ArrayList<Modifier> getAllModifiers() {
        ArrayList<Modifier> modifiers = new ArrayList<Modifier>();
        String selectQuery = "SELECT * FROM " + MODIFIER;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst())
            do {
                Modifier modifier = new Modifier();
                modifier.setModifierNumber(cursor.getInt(0));
                modifier.setModifierName(cursor.getString(1));
                modifier.setModifierActive(cursor.getInt(2));

                modifiers.add(modifier);
            } while (cursor.moveToNext());
        return modifiers;
    }

    public ArrayList<CustomerPayment> getAllCustomerPayment() {
        ArrayList<CustomerPayment> customerPayments = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + CUSTOMER_PAYMENT;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                CustomerPayment customerPayment = new CustomerPayment();

                customerPayment.setPointOfSaleNumber(cursor.getInt(0));
                customerPayment.setUserNO(cursor.getInt(1));
                customerPayment.setUserName(cursor.getString(2));
                customerPayment.setCustomerNo(cursor.getInt(3));
                customerPayment.setCustomerName(cursor.getString(4));
                customerPayment.setCustomerBalance(cursor.getDouble(5));
                customerPayment.setTransNo(cursor.getInt(6));
                customerPayment.setTransDate(cursor.getString(7));
                customerPayment.setPayMentType(cursor.getString(8));
                customerPayment.setValue(cursor.getDouble(9));
                customerPayment.setShiftNo(cursor.getInt(10));
                customerPayment.setShiftName(cursor.getString(11));

                customerPayments.add(customerPayment);
            } while (cursor.moveToNext());
        }
        return customerPayments;
    }

    public ArrayList<CategoryWithModifier> getAllCategoryModifier() {
        ArrayList<CategoryWithModifier> categoryModifiers = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + CATEGORY_WITH_MODIFIER;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst())
            do {
                CategoryWithModifier categoryModifier = new CategoryWithModifier();

                categoryModifier.setCategoryName(cursor.getString(0));
                categoryModifier.setModifierName(cursor.getString(1));

                categoryModifiers.add(categoryModifier);
            } while (cursor.moveToNext());
        return categoryModifiers;
    }

    public ArrayList<ItemWithModifier> getItemWithModifiers(int itemBarcode) {
        ArrayList<ItemWithModifier> modifiers = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + ITEM_WITH_MODIFIER + " where ITEM_CODE = '" + itemBarcode + "'";
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ItemWithModifier modifier = new ItemWithModifier();
                modifier.setItemCode(Integer.parseInt(cursor.getString(0)));
                modifier.setModifierNo(Integer.parseInt(cursor.getString(1)));
                modifier.setModifierText(cursor.getString(2));

                modifiers.add(modifier);

            } while (cursor.moveToNext());
        }
        return modifiers;
    }

    public ArrayList<ItemWithFq> getAllItemWithFqs() {
        ArrayList<ItemWithFq> fqs = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + ITEM_WITH_FQ;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ItemWithFq fq = new ItemWithFq();
                fq.setItemCode(Integer.parseInt(cursor.getString(0)));
                fq.setQuestionNo(Integer.parseInt(cursor.getString(1)));
                fq.setQuestionText(cursor.getString(2));

                fqs.add(fq);

            } while (cursor.moveToNext());
        }
        return fqs;
    }

    public ArrayList<ItemWithFq> getItemWithFqs(int itemBarcode) {
        ArrayList<ItemWithFq> fqs = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + ITEM_WITH_FQ + " where ITEM_CODE = '" + itemBarcode + "'";
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ItemWithFq fq = new ItemWithFq();
                fq.setItemCode(Integer.parseInt(cursor.getString(0)));
                fq.setQuestionNo(Integer.parseInt(cursor.getString(1)));
                fq.setQuestionText(cursor.getString(2));

                fqs.add(fq);

            } while (cursor.moveToNext());
        }
        return fqs;
    }

    public ArrayList<JobGroup> getAllJobGroup() {
        ArrayList<JobGroup> jobGroups = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + JOB_GROUP_TABLE;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                JobGroup jobGroup = new JobGroup();

                jobGroup.setJobGroup(cursor.getString(0));
                jobGroup.setUserName(cursor.getString(1));
                jobGroup.setUserNo(Integer.parseInt(cursor.getString(2)));
                jobGroup.setInDate(cursor.getString(3));
                jobGroup.setActive(Integer.parseInt(cursor.getString(4)));
                jobGroup.setShiftNo(Integer.parseInt(cursor.getString(5)));
                jobGroup.setShiftName(cursor.getString(6));
                jobGroups.add(jobGroup);

            } while (cursor.moveToNext());
        }
        return jobGroups;
    }

    public ArrayList<MemberShipGroup> getAllMemberShipGroup() {
        ArrayList<MemberShipGroup> memberShipGroups = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + MEMBER_SHIP_GROUP_MANAGEMENT_TABLE;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                MemberShipGroup memberShipGroup = new MemberShipGroup();

                memberShipGroup.setMemberShipGroup(cursor.getString(0));
                memberShipGroup.setUserName(cursor.getString(1));
                memberShipGroup.setUserNo(Integer.parseInt(cursor.getString(2)));
                memberShipGroup.setInDate(cursor.getString(3));
                memberShipGroup.setActive(Integer.parseInt(cursor.getString(4)));
                memberShipGroup.setShiftNo(Integer.parseInt(cursor.getString(5)));
                memberShipGroup.setShiftName(cursor.getString(6));

                memberShipGroups.add(memberShipGroup);

            } while (cursor.moveToNext());
        }
        return memberShipGroups;
    }

    public ArrayList<Shift> getAllShifts() {
        ArrayList<Shift> shifts = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + SHIFT_REGISTRATION;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Shift shift = new Shift();

                shift.setShiftNo(Integer.parseInt(cursor.getString(0)));
                shift.setShiftName(cursor.getString(1));
                shift.setFromTime(cursor.getString(2));
                shift.setToTime(cursor.getString(3));

                shifts.add(shift);

            } while (cursor.moveToNext());
        }
        return shifts;
    }

    public BlindShift getOpenedShifts(String date, int status) {
        BlindShift shift = new BlindShift();

        String selectQuery = "SELECT * FROM " + BLIND_SHIFT_IN + " where DATE = '" + date + "' and STATUS = '" + status + "'";
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {

            shift.setDate(cursor.getString(0));
            shift.setTime(cursor.getString(1));
            shift.setPosNo(Integer.parseInt(cursor.getString(2)));
            shift.setShiftNo(Integer.parseInt(cursor.getString(3)));
            shift.setShiftName(cursor.getString(4));
            shift.setUserNo(Integer.parseInt(cursor.getString(5)));
            shift.setUserName(cursor.getString(6));
            shift.setStatus(Integer.parseInt(cursor.getString(7)));
        }
        return shift;
    }

    public ArrayList<BlindClose> getAllBlindClose() {
        ArrayList<BlindClose> shifts = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + BLIND_CLOSE;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                BlindClose shift = new BlindClose();

                shift.setTransNo(Integer.parseInt(cursor.getString(0)));
                shift.setDate(cursor.getString(1));
                shift.setTime(cursor.getString(2));
                shift.setPOSNo(Integer.parseInt(cursor.getString(3)));
                shift.setShiftNo(Integer.parseInt(cursor.getString(4)));
                shift.setShiftName(cursor.getString(5));
                shift.setUserNo(Integer.parseInt(cursor.getString(6)));
                shift.setUserName(cursor.getString(7));
                shift.setSysSales(Double.parseDouble(cursor.getString(8)));
                shift.setUserSales(Double.parseDouble(cursor.getString(9)));
                shift.setSalesDiff(Double.parseDouble(cursor.getString(10)));
                shift.setSysCash(Double.parseDouble(cursor.getString(11)));
                shift.setUserCash(Double.parseDouble(cursor.getString(12)));
                shift.setCashDiff(Double.parseDouble(cursor.getString(13)));
                shift.setSysOthers(Double.parseDouble(cursor.getString(14)));
                shift.setUserOthers(Double.parseDouble(cursor.getString(15)));
                shift.setOthersDiff(Double.parseDouble(cursor.getString(16)));
                shift.setTillOk(Integer.parseInt(cursor.getString(17)));
                shift.setTransType(Integer.parseInt(cursor.getString(18)));

                shifts.add(shift);

            } while (cursor.moveToNext());
        }
        return shifts;
    }

    public ArrayList<BlindCloseDetails> getAllBlindCloseDetails() {
        ArrayList<BlindCloseDetails> shifts = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + BLIND_CLOSE_DETAILS;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                BlindCloseDetails shift = new BlindCloseDetails();

                shift.setTransNo(Integer.parseInt(cursor.getString(0)));
                shift.setDate(cursor.getString(1));
                shift.setTime(cursor.getString(2));
                shift.setPOSNo(Integer.parseInt(cursor.getString(3)));
                shift.setShiftNo(Integer.parseInt(cursor.getString(4)));
                shift.setShiftName(cursor.getString(5));
                shift.setUserNo(Integer.parseInt(cursor.getString(6)));
                shift.setUserName(cursor.getString(7));
                shift.setCatName(cursor.getString(8));
                shift.setCatQty(Integer.parseInt(cursor.getString(9)));
                shift.setCatValue(Double.parseDouble(cursor.getString(10)));
                shift.setCatTotal(Double.parseDouble(cursor.getString(11)));
                shift.setType(cursor.getString(12));
                shift.setUpdateDate(cursor.getString(13));
                shift.setUpdateTime(cursor.getString(14));
                shift.setUpdateUserNo(Integer.parseInt(cursor.getString(15)));
                shift.setUpdateUserName(cursor.getString(16));

                shifts.add(shift);

            } while (cursor.moveToNext());
        }
        return shifts;
    }

    public ArrayList<CustomerRegistrationModel> getAllCustomerRegistration() {
        ArrayList<CustomerRegistrationModel> customerRegistrationModels = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + CUSTOMER_REGISTRATION_TABLE;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                CustomerRegistrationModel customerRegistrationModel = new CustomerRegistrationModel();

                customerRegistrationModel.setMemberShipGroup(cursor.getString(0));
                customerRegistrationModel.setCustomerName(cursor.getString(1));
                customerRegistrationModel.setCustomerCode(cursor.getString(2));
                customerRegistrationModel.setMemberShipCardNO(cursor.getInt(3));
                customerRegistrationModel.setCustomerName(cursor.getString(4));
                customerRegistrationModel.setCoender(cursor.getString(5));
                customerRegistrationModel.setRemark(cursor.getString(6));
                customerRegistrationModel.setStreetNoName(cursor.getString(7));
                customerRegistrationModel.setCity(cursor.getString(8));
                customerRegistrationModel.setPhoneNo(cursor.getInt(9));
                customerRegistrationModel.setMobileNo(cursor.getInt(10));
                customerRegistrationModel.setNameShow(cursor.getString(11));
                customerRegistrationModel.setBirthday(cursor.getString(12));
                customerRegistrationModel.setAnniversary(cursor.getString(13));
                customerRegistrationModel.setOccupation(cursor.getString(14));
                customerRegistrationModel.setEmail(cursor.getString(15));
                customerRegistrationModel.setTotalPoint(cursor.getInt(16));
                customerRegistrationModel.setRedeemedPoint(cursor.getInt(17));
                customerRegistrationModel.setRemainingPoint(cursor.getInt(18));
                customerRegistrationModel.setShiftNO(cursor.getInt(19));
                customerRegistrationModel.setShiftName(cursor.getString(20));

                customerRegistrationModels.add(customerRegistrationModel);
            } while (cursor.moveToNext());
        }
        return customerRegistrationModels;
    }


    public ArrayList<EmployeeRegistrationModle> getAllEmployeeRegistration() {
        ArrayList<EmployeeRegistrationModle> employeeRegistrationModels = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + EMPLOYEE_REGISTRATION_TABLE;
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                EmployeeRegistrationModle employeeRegistrationModels1 = new EmployeeRegistrationModle();

                employeeRegistrationModels1.setJobGroup(cursor.getString(0));
                employeeRegistrationModels1.setEmployeeName(cursor.getString(1));
                employeeRegistrationModels1.setEmployeeNO(cursor.getInt(2));
                employeeRegistrationModels1.setMobileNo(cursor.getInt(3));
                employeeRegistrationModels1.setSecurityLevel(cursor.getString(4));
                employeeRegistrationModels1.setUserPassword(cursor.getInt(5));
                employeeRegistrationModels1.setActive(cursor.getInt(6));
                employeeRegistrationModels1.setHireDate(cursor.getString(7));
                employeeRegistrationModels1.setTerminationDate(cursor.getString(8));
                employeeRegistrationModels1.setPayBasic(cursor.getString(9));
                employeeRegistrationModels1.setPayRate(cursor.getString(10));
                employeeRegistrationModels1.setHolidayPay(cursor.getString(11));
                employeeRegistrationModels1.setEmployeeType(cursor.getInt(12));
                employeeRegistrationModels1.setShiftNo(cursor.getInt(13));
                employeeRegistrationModels1.setShiftName(cursor.getString(14));

                employeeRegistrationModels.add(employeeRegistrationModels1);
            } while (cursor.moveToNext());
        }
        return employeeRegistrationModels;
    }

    //Updating single record

    public void updateUsedCategories(UsedCategories usedCategories) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(CATEGORY_NAME, usedCategories.getCategoryName());
        values.put(NUMBER_OF_ITEMS, usedCategories.getNumberOfItems());
        values.put(CATEGORY_BACKGROUND, usedCategories.getBackground());
        values.put(CATEGORY_TEXT_COLOR, usedCategories.getTextColor());
        values.put(CATEGORY_POSITION, usedCategories.getPosition());

        // updating row
        db.update(USED_CATEGORIES, values, CATEGORY_NAME + " = '" + usedCategories.getCategoryName() + "'", null);
    }

    public void moveTablesTemp(int oldSectionNo, int oldTableNo, int sectionNo, int tableNo) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        ContentValues values2 = new ContentValues();

        values.put(SECTION_NO1, sectionNo);
        values.put(TABLE_NO1, tableNo);

        values2.put(SECTION_NUMBER2, sectionNo);
        values2.put(TABLE_NUMBER2, tableNo);

        db.update(ORDER_TRANSACTIONS_TEMP, values, SECTION_NO1 + " = '" + oldSectionNo + "' and " + TABLE_NO1 + " = '" + oldTableNo + "'", null);
        db.update(ORDER_HEADER_TEMP, values2, SECTION_NUMBER2 + " = '" + oldSectionNo + "' and " + TABLE_NUMBER2 + " = '" + oldTableNo + "'", null);
    }

    public void mergeTablesTemp(int oldSectionNo, int oldTableNo, int sectionNo, int tableNo) {
        db = this.getWritableDatabase();

        String selectQuery = "SELECT VOUCHER_SERIAL , VOUCHER_NO FROM " + ORDER_TRANSACTIONS_TEMP + " WHERE SECTION_NO = '" + sectionNo + "' and TABLE_NO = '" + tableNo + "'";
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        String voucherSerial = "", voucherNo = "";
        if (cursor.moveToFirst()) {
            voucherSerial = cursor.getString(0);
            voucherNo = cursor.getString(1);
        }
        ContentValues values = new ContentValues();

        values.put(SECTION_NO1, sectionNo);
        values.put(TABLE_NO1, tableNo);
        values.put(VOUCHER_NO1, voucherNo);
        values.put(VOUCHER_SERIAL1, voucherSerial);

        db.update(ORDER_TRANSACTIONS_TEMP, values, SECTION_NO1 + " = '" + oldSectionNo + "' and " + TABLE_NO1 + " = '" + oldTableNo + "'", null);
        //______________________________________________________

        String selectQuery2 = "SELECT TOTAL , TOTAL_DISCOUNT , TOTAL_LINE_DISCOUNT , ALL_DISCOUNT  , SUB_TOTAL , AMOUNT_DUE " +
                "FROM " + ORDER_HEADER_TEMP + " WHERE SECTION_NUMBER = '" + oldSectionNo + "' and TABLE_NUMBER = '" + oldTableNo + "'";

        String selectQuery3 = "SELECT TOTAL , TOTAL_DISCOUNT , TOTAL_LINE_DISCOUNT , ALL_DISCOUNT  , SUB_TOTAL , AMOUNT_DUE " +
                "FROM " + ORDER_HEADER_TEMP + " WHERE SECTION_NUMBER = '" + sectionNo + "' and TABLE_NUMBER = '" + tableNo + "'";

        db = this.getWritableDatabase();
        Cursor cursor2 = db.rawQuery(selectQuery2, null);
        Cursor cursor3 = db.rawQuery(selectQuery3, null);

        Double total = 0.0, totalDis = 0.0, totalLineDis = 0.0, allDis = 0.0, subTotal = 0.0, amountDue = 0.0;
        if (cursor2.moveToFirst()) {
            total = cursor2.getDouble(0);
            totalDis = cursor2.getDouble(1);
            totalLineDis = cursor2.getDouble(2);
            allDis = cursor2.getDouble(3);
            subTotal = cursor2.getDouble(4);
            amountDue = cursor2.getDouble(5);
        }
        if (cursor3.moveToFirst()) {
            total += cursor3.getDouble(0);
            totalDis += cursor3.getDouble(1);
            totalLineDis += cursor3.getDouble(2);
            allDis += cursor3.getDouble(3);
            subTotal += cursor3.getDouble(4);
            amountDue += cursor3.getDouble(5);
        }
        ContentValues values2 = new ContentValues();
        values2.put(TOTAL2, total);
        values2.put(TOTAL_DISCOUNT2, totalDis);
        values2.put(TOTAL_LINE_DISCOUNT2, totalLineDis);
        values2.put(ALL_DISCOUNT2, allDis);
        values2.put(SUB_TOTAL2, subTotal);
        values2.put(AMOUNT_DUE2, amountDue);

        db.update(ORDER_HEADER_TEMP, values2, SECTION_NUMBER2 + " = '" + sectionNo + "' and " + TABLE_NUMBER2 + " = '" + tableNo + "'", null);
        db.execSQL("delete from " + ORDER_HEADER_TEMP +
                " where " + SECTION_NUMBER2 + " = '" + oldSectionNo + "' and " + TABLE_NUMBER2 + " = '" + oldTableNo + "'");
    }

    public void deleteAllUsedCategories() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + USED_CATEGORIES);
        db.close();
    }

    public void deleteUsedItems(String categoryName) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from USED_ITEMS where CATEGORY_NAME2 = '" + categoryName + "'");
        db.close();
    }

    public void deleteFromOrderHeaderTemp(String sectionNo, String tableNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from ORDER_HEADER_TEMP WHERE SECTION_NUMBER = '" + sectionNo + "' and TABLE_NUMBER = '" + tableNo + "'");
        db.close();
    }

    public void deleteFromOrderTransactionTemp(String sectionNo, String tableNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from ORDER_TRANSACTIONS_TEMP WHERE SECTION_NO = '" + sectionNo + "' and TABLE_NO = '" + tableNo + "'");
        db.close();
    }

    public void deleteAllTables() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + TABLES);
        db.close();
    }

    public void deleteAllOrders() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + ORDER_HEADER_TEMP);
        db.execSQL("delete from " + ORDER_TRANSACTIONS_TEMP);
        db.execSQL("delete from " + ORDER_HEADER);
        db.execSQL("delete from " + ORDER_TRANSACTIONS);
        db.close();
    }

}
