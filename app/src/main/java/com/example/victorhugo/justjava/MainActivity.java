package com.example.victorhugo.justjava;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Objects;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    //variables
    int quantity=1, priceOfCoffees=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView priceTextView = (TextView) findViewById(
                R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(priceOfCoffees));

    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //whippedCream Checkbox
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whipped_cream);
        //Chocolate Checkbox
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        //name EditText
        EditText txtName = (EditText) findViewById(R.id.name_text);

        String message = createOrderSummary((quantity * priceOfCoffees),txtName.getText().toString(), whippedCream.isChecked(),chocolate.isChecked());
         displayMessage(message);
    }
    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        if(quantity > 1){
            quantity -= 1;
        }else{
            Toast.makeText(getApplicationContext(),"MIN quantity are 1",Toast.LENGTH_SHORT).show();
            quantity = 0;
        }
        display(quantity);
    }
    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        if(quantity >= 100){
            Toast.makeText(getApplicationContext(),"MAX quantity are 100",Toast.LENGTH_SHORT).show();

        }else {
            quantity += 1;
            display(quantity);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(
                R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayMessage(String message){
        TextView priceTextView = (TextView) findViewById(
                R.id.price_text_view);
        priceTextView.setText(message);
    }

    private String createOrderSummary(int price,String name, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = "Name: " + name;
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd chocolate? " + addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        priceMessage += "\nThank you!";
        priceMessage += "\nThank you!";
        priceMessage += "\nThank you!";
        priceMessage += "\nThank you!";
        return priceMessage;
    }

}