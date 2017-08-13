package hlt.androidserviceexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button startStopButton;
    Intent intent;
    boolean isStart = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this, MyService.class);
        startService(intent);
        stopService(intent);

        startStopButton = (Button) findViewById(R.id.start_stop_service);

        startStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isStart){
                    stopService(intent);
                    isStart = false;
                    startStopButton.setText("Start Service");
                }else{
                    startService(intent);
                    isStart = true;
                    startStopButton.setText("Stop Service");
                }
            }
        });
    }


}
