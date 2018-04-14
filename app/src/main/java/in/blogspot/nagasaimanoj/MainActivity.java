package in.blogspot.nagasaimanoj;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity {
    Button btnRandomise;
    TextView tvResult, tvAppName;
    EditText etNumEnter;
    int i;
    Random randomGenerator = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumEnter = findViewById(R.id.etNumEnter);
        tvResult = findViewById(R.id.tvResult);
        tvAppName = findViewById(R.id.tvAppName);
        btnRandomise = findViewById(R.id.btnResult);

        btnRandomise.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (!etNumEnter.getText().toString().equals("")) {
                    i = Integer.parseInt(etNumEnter.getText().toString());
                    if (i != 0) {
                        tvAppName.setText(Integer.toString(randomGenerator.nextInt(i) + 1));
                        tvResult.setText("Hold on Randomise to Clear");
                    } else
                        tvResult.setText("please enter some greater value");
                } else {
                    tvResult.setText("Please enter some value");
                }
            }
        });
        btnRandomise.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvAppName.setText("");
                etNumEnter.setText("");
                tvResult.setText("");
                return true;
            }
        });
    }
}