package com.example.toolbar;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tempTextView;
    // 값을 돌려 받을 때는 미리 아래와 받을 객체가 만들어 져 있어야 한다.
    ActivityResultLauncher<Intent> startActivityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                Log.d("TAG","comeBack 돌아왔따");
                if(result.getResultCode() == Activity.RESULT_OK){
                    // 정상 동작 한다.
                    Intent data = result.getData();
                    int returnValue = data.getIntExtra("result", 0);
                    tempTextView = findViewById(R.id.tempTextView);
                    tempTextView.setText(returnValue + " << 값을 받았따");
                }else{
                    // 실패

                }
            }
            //
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar); // 지정한 툴바를 사용하겠다라고 지정
        //toolbar.setTitle("");
    }

    // 메뉴 xml을 가져와서 실제 메뉴바로 올리는 작업
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 객체를 가지고 와서 메모리에 올리는 작업(inflate)
        // xml로 정의된 view 또는 메뉴등을 실체 객체화 시키는 작업
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_type, menu);
        return true;
    }

    // 메뉴의 버튼을 눌렀을 때 동작
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d("TAG", "item: " + item.getItemId());
        if(R.id.menuItem1 == item.getItemId()){
            Log.d("TAG", "menu1 번이 눌러졌어요");
            Intent intent = new Intent(this, SubActivity.class);
            intent.putExtra("value1",15);
            //startActivity(intent); // 얘는 값을 돌려받지 않을 때 사용하는 코드
            // 값을 돌려 받아야 할 때 !!!
            startActivityResult.launch(intent); // 얘는 값을 돌려받을 때 사용하는 코드



        }else if(R.id.menuItem2 == item.getItemId()){
            Log.d("TAG", "menu2 번이 눌러졌어요");
            Uri number = Uri.parse("tel:01000000000");
            Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
            startActivity(callIntent);
        }else{

            Uri location = Uri.parse("geo:0,0?q=my+street+address");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
            Log.d("TAG", "menu3 번이 눌러졌어요");
            startActivity(mapIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}