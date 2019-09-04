package android.example.funapp4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button start;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        start = (Button)findViewById ( R.id.start );

        start.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {

               Startgame();
            }
        } );
    }
    public void Startgame()
    {
        Intent intent = new Intent ( this,level1.class );
        startActivity ( intent );
        finish ();
    }
}
