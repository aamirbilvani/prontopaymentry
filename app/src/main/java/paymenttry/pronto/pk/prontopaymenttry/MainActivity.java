package paymenttry.pronto.pk.prontopaymenttry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final SeekBar clientSeeker = (SeekBar) findViewById(R.id.clientSeeker);
        final SeekBar senderSeeker = (SeekBar) findViewById(R.id.senderSeeker);
        final SeekBar receiverSeeker = (SeekBar) findViewById(R.id.receiverSeeker);
        receiverSeeker.setEnabled(false);

        final TextView client = (TextView) findViewById(R.id.client);
        final TextView sender = (TextView) findViewById(R.id.sender);
        final TextView receiver = (TextView) findViewById(R.id.receiver);

        clientSeeker.setMax(6000);
        clientSeeker.setProgress(3000);

        senderSeeker.setMax(6000);
        senderSeeker.setProgress(3000);

        receiverSeeker.setMax(6000);
        receiverSeeker.setProgress(3000);

        clientSeeker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String keyword;
                if(progress > 3000)
                    keyword = "receives";
                else
                    keyword = "pays";
                client.setText("Client " + keyword + " Rs. " + Math.abs(progress - 3000));

                senderSeeker.setProgress(3000-((progress-3000)/2));
                receiverSeeker.setProgress(3000-((progress-3000)/2));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        senderSeeker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String keyword;
                if(progress > 3000)
                    keyword = "receives";
                else
                    keyword = "pays";
                sender.setText("Sender " + keyword + " Rs. " + Math.abs(progress - 3000));

                receiverSeeker.setProgress(6000- (progress+clientSeeker.getProgress())+3000);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });


        receiverSeeker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String keyword;
                if(progress > 3000)
                    keyword = "receives";
                else
                    keyword = "pays";
                receiver.setText("Receiver " + keyword + " Rs. " + Math.abs(progress - 3000));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }
}
