package com.example.chuvidientichhcn;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ChildActivity extends Activity implements OnClickListener {
    private Button chuvi, dientich;
    private int a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        final TextView textView = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        // lấy Bundle với tên "GoiTin"
        Bundle bundle = intent.getBundleExtra("GoiTin");
        // lấy giá trị kiểu nguyên
        a = bundle.getInt("CanhDai");
        b = bundle.getInt("CanhRong");
        textView.setText("Đã nhận được dữ liệu " + a + " và " + b);
        chuvi = (Button) findViewById(R.id.btChuVi);
        chuvi.setOnClickListener(this);
        dientich = (Button) findViewById(R.id.btDienTich);
        dientich.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v == chuvi) {
            sendToMain(2 * (a + b), MainActivity.CHUVI);
        }
        if (v == dientich) {
            sendToMain((a * b), MainActivity.DIENTICH);
        }
    }
    // Hàm gửi dữ liệu về Activity1
    public void sendToMain(int value, int resultcode) {
        Intent intent = getIntent();
        Bundle bundle = new Bundle();
        bundle.putInt("KetQua", value);
        intent.putExtra("TapTin", bundle);
        setResult(resultcode, intent); // trả kết quả cho Activity1
        finish();
    }
}

