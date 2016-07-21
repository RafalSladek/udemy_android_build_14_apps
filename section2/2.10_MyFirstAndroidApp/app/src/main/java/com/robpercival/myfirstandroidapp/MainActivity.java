package com.robpercival.myfirstandroidapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Locale;


public class MainActivity extends ActionBarActivity {

    public static final Double euroToDollarRatio = 0.908272;

    public void convert(final View view) {
        EditText dollarField = (EditText) findViewById(R.id.dollarField);
        Double dollars = Double.parseDouble(dollarField.getText().toString());

        Double euros = dollars * euroToDollarRatio;
        TextView textView = (TextView) findViewById(R.id.textView);

        String formattedEuros = DecimalFormat.getCurrencyInstance(Locale.GERMANY).format(euros);
        String currentCurrencyName = DecimalFormat.getCurrencyInstance(Locale.GERMANY).getCurrency().getDisplayName();
        textView.setText(formattedEuros);

        TextView currencyName = (TextView) findViewById(R.id.currencyName);
        currencyName.setText(currentCurrencyName);
        currencyName.setVisibility(View.VISIBLE);

        TextView currencyLabel = (TextView) findViewById(R.id.textView2);
        currencyLabel.setVisibility(View.VISIBLE);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
