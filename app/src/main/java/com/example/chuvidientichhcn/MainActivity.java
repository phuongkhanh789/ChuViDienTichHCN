package com.example.chuvidientichhcn;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.style.BulletSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends Activity implements OnClickListener {
    public static final int CHUVI = 1;
    public static final int DIENTICH = 2;
    public static final int HINHCHUNHAT = 1;

    private EditText etA, etB;
    private TextView tvResult;
    private Button hinhchunhat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etA = (EditText) findViewById(R.id.etA);
        etB = (EditText) findViewById(R.id.etB);
        tvResult = (TextView) findViewById(R.id.tvResult);
        hinhchunhat = (Button) findViewById(R.id.btChuNhat);
        hinhchunhat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, ChildActivity.class);
        int a = Integer.valueOf(etA.getText().toString());
        int b = Integer.valueOf(etB.getText().toString());
        // đối tượng Bundle chứa dữ liệu.

        Bundle bundle = new Bundle();
        bundle.putInt("CanhDai", a); // CanhDai là tên giao dịch
        bundle.putInt("CanhRong", b);

        // bundle GoiTin
        intent.putExtra("GoiTin", bundle);
        startActivityForResult(intent, HINHCHUNHAT);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // requestCode là định danh khi gửi
        // resultCode là định danh của Activity khác gửi cho
        // Nếu đang ở ChildActivity ấn nút Back thì data sẽ nhận giá trị rỗng
        if (data == null) {
            return;
        }
        // Nếu định danh lúc gửi là HINHCHUNHAT
        if (requestCode == HINHCHUNHAT) {
            // lấy giá trị kết quả
            Bundle bundle = data.getBundleExtra("TapTin");
            int kq = bundle.getInt("KetQua");
            if (resultCode == CHUVI) {
                tvResult.setText("Chu vi hình Chữ nhật là: " + kq);
            }
            if (resultCode == DIENTICH) {
                tvResult.setText("Diện tích hình Chữ nhật là: " + kq);
            }
        }
    }
}