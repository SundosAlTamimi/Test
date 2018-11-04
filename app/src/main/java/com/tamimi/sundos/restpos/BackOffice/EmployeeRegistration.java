package com.tamimi.sundos.restpos.BackOffice;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.tamimi.sundos.restpos.DatabaseHandler;
import com.tamimi.sundos.restpos.Models.EmployeeRegistrationModle;
import com.tamimi.sundos.restpos.Models.Items;
import com.tamimi.sundos.restpos.Models.JobGroup;
import com.tamimi.sundos.restpos.R;
import com.tamimi.sundos.restpos.Settings;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class EmployeeRegistration extends AppCompatActivity {

    TableLayout tableEmployee;
    EditText empNo, empName, mobileNo, userPassword, hireDate, termination, payRate;
    Button newButton, saveButton, exitButton;
    Spinner securityLevel, payBasic, holidayPay, jobGroup;
    CheckBox active;
    DatabaseHandler mDHandler;
    ArrayAdapter<String> jobSpinner, holidayPaySpinner, securityLevelSpinner, payBasicSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.employee_registration);

        final ArrayList<String> jobList = new ArrayList<>();
        final ArrayList<String> empNameList = new ArrayList<>();
        final ArrayList<Integer> empNOList = new ArrayList<>();
        final ArrayList<Integer> mobileList = new ArrayList<>();
        final ArrayList<String> securityList = new ArrayList<>();
        final ArrayList<Integer> userPassList = new ArrayList<>();
        final ArrayList<Integer> ActiveList = new ArrayList<>();
        final ArrayList<String> hireDateList = new ArrayList<>();
        final ArrayList<String> terminationList = new ArrayList<>();
        final ArrayList<String> payBasicList = new ArrayList<>();
        final ArrayList<String> payRateList = new ArrayList<>();
        final ArrayList<String> holidayList = new ArrayList<>();
        ArrayList<JobGroup> jopGroupListForSpinner = new ArrayList<>();
        ArrayList<String> jopGroupSpinner = new ArrayList<>();
        ArrayList<String> payBasicListSpinner = new ArrayList<>();
        ArrayList<String> holidayPayListSpinner = new ArrayList<>();
        ArrayList<String> securityLevelListSpinner = new ArrayList<>();

        payBasicListSpinner.add("hourly pau");
        holidayPayListSpinner.add("over Time");
        securityLevelListSpinner.add("ip");
        securityLevelListSpinner.add("https");

        Initialization();
        mDHandler = new DatabaseHandler(EmployeeRegistration.this);

        jopGroupListForSpinner = mDHandler.getAllJobGroup();

        for (int i = 0; i < jopGroupListForSpinner.size(); i++) {
            jopGroupSpinner.add(jopGroupListForSpinner.get(i).getJobGroup());
        }

        jobSpinner = new ArrayAdapter<String>(EmployeeRegistration.this, R.layout.spinner_style, jopGroupSpinner);
        jobGroup.setAdapter(jobSpinner);

        securityLevelSpinner = new ArrayAdapter<String>(EmployeeRegistration.this, R.layout.spinner_style, securityLevelListSpinner);
        securityLevel.setAdapter(securityLevelSpinner);

        payBasicSpinner = new ArrayAdapter<String>(EmployeeRegistration.this, R.layout.spinner_style, payBasicListSpinner);
        payBasic.setAdapter(payBasicSpinner);

        holidayPaySpinner = new ArrayAdapter<String>(EmployeeRegistration.this, R.layout.spinner_style, holidayPayListSpinner);
        holidayPay.setAdapter(holidayPaySpinner);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!empNameList.isEmpty()) {
                    for (int i = 0; i < empNameList.size(); i++) {
                        EmployeeRegistrationModle employeeRegistrationModle = new EmployeeRegistrationModle();

                        employeeRegistrationModle.setJobGroup(jobList.get(i).toString());
                        employeeRegistrationModle.setEmployeeName(empNameList.get(i).toString());
                        employeeRegistrationModle.setEmployeeNO(empNOList.get(i));
                        employeeRegistrationModle.setMobileNo(mobileList.get(i));
                        employeeRegistrationModle.setSecurityLevel(securityList.get(i).toString());
                        employeeRegistrationModle.setUserPassword(userPassList.get(i));
                        employeeRegistrationModle.setActive(ActiveList.get(i));
                        employeeRegistrationModle.setHireDate(hireDateList.get(i).toString());
                        employeeRegistrationModle.setTerminationDate(terminationList.get(i).toString());
                        employeeRegistrationModle.setPayBasic(payBasicList.get(i).toString());
                        employeeRegistrationModle.setPayRate(payRateList.get(i).toString());
                        employeeRegistrationModle.setHolidayPay(holidayList.get(i).toString());
                        employeeRegistrationModle.setShiftNo(Settings.shift_number);
                        employeeRegistrationModle.setShiftName(Settings.shift_name);

                        mDHandler.addEmployeeRegistration(employeeRegistrationModle);
                        Toast.makeText(EmployeeRegistration.this, "Saved Successful", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } else {
                    Toast.makeText(EmployeeRegistration.this, " Not Have Any Data In Table ", Toast.LENGTH_SHORT).show();
                }

            }
        });
        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!empName.getText().toString().equals("") && !empNo.getText().toString().equals("") && !mobileNo.getText().toString().equals("") && !hireDate.getText().toString().equals("") &&
                        !termination.getText().toString().equals("") && !payRate.getText().toString().equals("")) {
                    String pass = userPassword.getText().toString();
                    jobList.add(jobGroup.getSelectedItem().toString());
                    Log.e("test--", "*** " + jobGroup.getSelectedItem().toString());
                    empNameList.add(empName.getText().toString());
                    empNOList.add(Integer.parseInt(empNo.getText().toString()));
                    mobileList.add(Integer.parseInt(mobileNo.getText().toString()));
                    securityList.add(securityLevel.getSelectedItem().toString());
                    userPassList.add(Integer.parseInt(pass));
                    if (active.isChecked()) {
                        ActiveList.add(1);
                    } else {
                        ActiveList.add(0);
                    }
                    hireDateList.add(hireDate.getText().toString());
                    terminationList.add(termination.getText().toString());
                    payBasicList.add(payBasic.getSelectedItem().toString());
                    payRateList.add(payRate.getText().toString());
                    holidayList.add(holidayPay.getSelectedItem().toString());
                    Toast.makeText(EmployeeRegistration.this, "OK ", Toast.LENGTH_SHORT).show();

                    insertRaw3(empName.getText().toString(), Integer.parseInt(empNo.getText().toString()), Integer.parseInt(mobileNo.getText().toString()),
                            securityLevel.getSelectedItem().toString(), Integer.parseInt(pass), hireDate.getText().toString(), termination.getText().toString()
                            , payBasic.getSelectedItem().toString(), payRate.getText().toString(), holidayPay.getSelectedItem().toString(), tableEmployee);


                    empName.setText("");
                    empNo.setText("");
                    mobileNo.setText("");
                    userPassword.setText("");
                    hireDate.setText("");
                    termination.setText("");
                    payRate.setText("");


                } else {
                    Toast.makeText(EmployeeRegistration.this, "Please Insert data ", Toast.LENGTH_SHORT).show();
                }

            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    void insertRaw3(String EmpName, int empNo, int mobileNo, String
            securityLevel, int userPassword, String hireDate
            , String terminationDate, String payBasic, String payRate, String holidayPay, TableLayout tableLayout) {

        if (true) {
            final TableRow row = new TableRow(EmployeeRegistration.this);

            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT);
            row.setLayoutParams(lp);

            for (int i = 0; i < 10; i++) {
                TextView textView = new TextView(EmployeeRegistration.this);
                switch (i) {
                    case 0:

                        textView.setText(EmpName);

                        break;
                    case 1:
                        textView.setText("  " + empNo);
                        break;
                    case 2:
                        textView.setText("  " + mobileNo);
                        break;
                    case 3:
                        textView.setText("  " + securityLevel);
                        break;
                    case 4:
                        textView.setText("  " + userPassword);
                        break;
                    case 5:
                        textView.setText("  " + hireDate);
                        break;
                    case 6:
                        textView.setText("  " + terminationDate);
                        break;
                    case 7:
                        textView.setText("  " + payBasic);
                        break;
                    case 8:
                        textView.setText("  " + payRate);
                        break;
                    case 9:
                        textView.setText("  " + holidayPay);
                        break;

                }

                textView.setTextColor(ContextCompat.getColor(EmployeeRegistration.this, R.color.text_color));
                textView.setGravity(Gravity.CENTER);

                TableRow.LayoutParams lp2 = new TableRow.LayoutParams(100, TableRow.LayoutParams.WRAP_CONTENT, 1.0f);
                textView.setLayoutParams(lp2);

                row.addView(textView);

            }

            tableLayout.addView(row);
        }
    }


    void Initialization() {
        {
            saveButton = (Button) findViewById(R.id.saveButton5);
            exitButton = (Button) findViewById(R.id.deleteButton5);
            newButton = (Button) findViewById(R.id.newButton5);

            empNo = (EditText) findViewById(R.id.empNo);
            empName = (EditText) findViewById(R.id.empName);
            mobileNo = (EditText) findViewById(R.id.mobileNo);
            userPassword = (EditText) findViewById(R.id.user_password8);
            hireDate = (EditText) findViewById(R.id.hire_date2);
            termination = (EditText) findViewById(R.id.termination);
            payRate = (EditText) findViewById(R.id.pay_rate);

            securityLevel = (Spinner) findViewById(R.id.spinner_security);
            payBasic = (Spinner) findViewById(R.id.pay_basic);
            holidayPay = (Spinner) findViewById(R.id.holiday_pay);
            jobGroup = (Spinner) findViewById(R.id.job_spinner);
            active = (CheckBox) findViewById(R.id.employeeCheck);

            tableEmployee = (TableLayout) findViewById(R.id.employee_reg);
        }
    }

}
