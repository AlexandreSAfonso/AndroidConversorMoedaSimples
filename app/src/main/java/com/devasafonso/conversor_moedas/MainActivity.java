package com.devasafonso.conversor_moedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mViewHolder.EditValue = findViewById(R.id.edit_value);
        this.mViewHolder.TextDolar = findViewById(R.id.text_dolar);
        this.mViewHolder.TextEuro = findViewById(R.id.text_euro);
        this.mViewHolder.ButtonCalculate = findViewById(R.id.button_calculate);
        this.mViewHolder.ButtonCalculate.setOnClickListener(this);
        this.clearValues();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_calculate) {
            String value = this.mViewHolder.EditValue.getText().toString();
            if ("".equals(value)) {
                this.clearValues();
                Toast.makeText(this, this.getString(R.string.informe_valor), Toast.LENGTH_LONG).show();
            } else {
                Double valueDouble = Double.valueOf(value);
                this.mViewHolder.TextDolar.setText(String.format("%.2f", (valueDouble / 4)));
                this.mViewHolder.TextEuro.setText(String.format("%.2f", (valueDouble / 5)));

            }

        }

    }

    private void clearValues() {
        this.mViewHolder.EditValue.setText("");
        this.mViewHolder.TextDolar.setText("");
        this.mViewHolder.TextEuro.setText("");
    }

    private static class ViewHolder {
        EditText EditValue;
        TextView TextDolar;
        TextView TextEuro;
        Button ButtonCalculate;

    }
}
