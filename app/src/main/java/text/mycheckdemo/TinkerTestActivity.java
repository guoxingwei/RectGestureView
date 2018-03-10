package text.mycheckdemo;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

public class TinkerTestActivity extends AppCompatActivity {

    private Button btn_Tinker,btn_Patch;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinker_test);

        btn_Tinker = findViewById(R.id.btn_Tinker);
        btn_Patch  = findViewById(R.id.btn_Patch);

        context = this;

        btn_Tinker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context,"Tinker修复了Bug",Toast.LENGTH_SHORT).show();
            }
        });

        btn_Patch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), Environment.getExternalStorageDirectory().getAbsolutePath() + "/patch_signed_7zip.apk");
            }
        });
    }
}
