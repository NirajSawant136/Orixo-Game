package android.example.funapp4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class level1 extends AppCompatActivity {

    Button up,down,left,right;
    Button[] b = new Button[5];
    ImageButton start;
    TextView[][] t = new TextView[6][6];
    TextView[] bl = new TextView[5];
    public int[][] status = new int[7][6];
    public int[] execute = new int[5];
    public int[] value = new int[5];
    public int[] win = new int[5];

    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.level_1 );

        up = (Button)findViewById ( R.id.up );
        down = (Button)findViewById ( R.id.down );
        left = (Button)findViewById ( R.id.left );
        right = (Button)findViewById ( R.id.right );

        b[0] = (Button)findViewById ( R.id.b1 );
        b[1] = (Button)findViewById ( R.id.b2 );
        b[2] = (Button)findViewById ( R.id.b3 );
        b[3] = (Button)findViewById ( R.id.b4 );
        b[4] = (Button)findViewById ( R.id.b5 );

        start = (ImageButton)findViewById ( R.id.start );

        bl[0] = (TextView)findViewById ( R.id.bl1 );
        bl[1] = (TextView)findViewById ( R.id.bl2 );
        bl[2] = (TextView)findViewById ( R.id.bl3 );
        bl[3] = (TextView)findViewById ( R.id.bl4 );
        bl[4] = (TextView)findViewById ( R.id.bl5 );

        for(int i=0;i<7;i++)
        {
            for(int j=0;j<6;j++)
            {
                status[i][j] = 0;
            }
        }

        status[0][3] = 2; status[1][1] = 2; status[3][0] = 2; status[5][5] = 2; status[6][1] = 2;

        t[0][1] = (TextView)findViewById ( R.id.t1 ); status[0][1] = 1;
        t[1][2] = (TextView)findViewById ( R.id.t2 ); status[1][2] = 1;
        t[1][3] = (TextView)findViewById ( R.id.t3 ); status[1][3] = 1;
        t[1][4] = (TextView)findViewById ( R.id.t4 ); status[1][4] = 1;
        t[1][5] = (TextView)findViewById ( R.id.t5 ); status[1][5] = 1;
        t[2][1] = (TextView)findViewById ( R.id.t6 ); status[2][1] = 1;
        t[2][3] = (TextView)findViewById ( R.id.t7 ); status[2][3] = 1;
        t[3][1] = (TextView)findViewById ( R.id.t8 ); status[3][1] = 1;
        t[3][2] = (TextView)findViewById ( R.id.t9 ); status[3][2] = 1;
        t[3][3] = (TextView)findViewById ( R.id.t10 ); status[3][3] = 1;
        t[3][4] = (TextView)findViewById ( R.id.t11 ); status[3][4] = 1;
        t[3][5] = (TextView)findViewById ( R.id.t12 ); status[3][5] = 1;
        t[4][1] = (TextView)findViewById ( R.id.t13 ); status[4][1] = 1;
        t[4][3] = (TextView)findViewById ( R.id.t14 ); status[4][3] = 1;
        t[5][1] = (TextView)findViewById ( R.id.t15 ); status[5][1] = 1;
        t[5][2] = (TextView)findViewById ( R.id.t16 ); status[5][2] = 1;
        t[5][3] = (TextView)findViewById ( R.id.t17 ); status[5][3] = 1;
        t[5][4] = (TextView)findViewById ( R.id.t18); status[5][4] = 1;

        value[0] = 4; value[1] = 4; value[2] = 3; value[3] = 3; value[4] = 4;

        for(int i=0;i<5;i++)
        {
            execute[i] = 0;
            win[i] = 0;
        }

        for(int i=0;i<5;i++)
        {
            final int finalI = i;
            b[i].setOnClickListener ( new View.OnClickListener ( ) {
                @Override
                public void onClick ( View view ) {
                    int k = finalI;
                    execute[finalI] = 1;
                    for(int j=0;j<5;j++)
                    {
                        if(j != finalI)
                        {
                            execute[j] = 0;

                        }
                    }
                }
            } );
        }
        start.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                 Restart();
            }
        } );
        up.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                int k=0;
                for(k=0;k<5;k++)
                {
                    if(execute[k] == 1)
                    {
                        upAction(k,PositionX ( k ),PositionY ( k ));
                    }
                }
            }
        } );
        down.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                int k=0;
                for(k=0;k<5;k++)
                {
                    if(execute[k] == 1)
                    {
                        downAction(k,PositionX ( k ),PositionY ( k ));
                    }
                }
            }
        } );
        left.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                int k=0;
                for(k=0;k<5;k++)
                {
                    if(execute[k] == 1)
                    {
                        leftAction(k,PositionX ( k ),PositionY ( k ));
                    }
                }
            }
        } );
        right.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                int k=0;
                for(k=0;k<5;k++)
                {
                    if(execute[k] == 1)
                    {
                        rightAction(k,PositionX ( k ),PositionY ( k ));
                    }
                }
            }
        } );
    }
    public int PositionX(int x)
    {
        int position = 10;
        if(x == 0)
            position = 0;
        else if(x == 1)
            position = 1;
        else if(x == 2)
            position = 3;
        else if(x == 3)
            position = 5;
        else if(x == 4)
            position = 6;
        return position;
    }
    public int PositionY(int y)
    {
        int position = 10;
        if(y == 0)
            position = 3;
        else if(y == 1)
            position = 1;
        else if(y == 2)
            position = 0;
        else if(y == 3)
            position = 5;
        else if(y == 4)
            position = 1;
        return position;
    }
    public void upAction(int position,int positionX,int positionY)
    {
        int count = 0;
        if(positionX - value[position] >= 0) {
            int k = positionX - value[position];
            for(int i=positionX-1;i>=k;i--) {
                if(i>=0) {
                    if ( status[i][positionY] == 1 )
                        count += 1;
                    else if ( status[i][positionY] == 2 )
                        k -= 1;
                }
            }
        }
        if(count == value[position]) {
            for(int i=0;i<value[position];i++) {
                if ( positionX - 1 - i >= 0 ) {
                    if ( status[positionX - 1 - i][positionY] == 1 ) {
                        t[positionX - 1 - i][positionY].setBackgroundResource ( R.drawable.main_values );
                        status[positionX - 1 - i][positionY] = 2;
                    } else {
                        value[position] += 1;
                    }
                }
            }
            bl[position].setText ( " " );
            win[position] = 1;
        }
        winStatus ();
    }
    public void downAction(int position,int positionX,int positionY)
    {
        int count = 0;
        if(positionX + value[position] < 6) {
            int k = positionX + value[position];
            for(int i=positionX+1;i<=k;i++) {
                if ( i < 6 ) {
                    if ( status[i][positionY] == 1 )
                        count += 1;
                    else if ( status[i][positionY] == 2 )
                        k += 1;
                }
            }
        }
        if(count == value[position]) {
            for (int i = 0; i < value[position]; i++) {
                if ( positionX + 1 + i < 6 ) {
                    if ( status[positionX + 1 + i][positionY] == 1 ) {
                        t[positionX + 1 + i][positionY].setBackgroundResource ( R.drawable.main_values );
                        status[positionX + 1 + i][positionY] = 2;
                    } else {
                        value[position] += 1;
                    }
                }
            }
            bl[position].setText ( " " );
            win[position] = 1;
        }
        winStatus ();
    }
    public void leftAction(int position,int positionX,int positionY)
    {
        int count = 0;
        if(positionY - value[position] >= 0) {
            int k = positionY - value[position];
            for(int i=positionX-1;i>=k;i--) {
                if(i>=0) {
                    if ( status[positionX][i] == 1 )
                        count += 1;
                    else if ( status[positionX][i] == 2 )
                        k -= 1;
                }
            }
        }
        if(count == value[position]) {
            for(int i=0;i<value[position];i++) {
                if ( positionY - 1 - i >= 0 ) {
                    if ( status[positionX][positionY - 1 - i] == 1 ) {
                        t[positionX][positionY - 1 - i].setBackgroundResource ( R.drawable.main_values );
                        status[positionX][positionY - 1 - i] = 2;
                    } else {
                        value[position] += 1;
                    }
                }
            }
            bl[position].setText ( " " );
            win[position] = 1;
        }
        winStatus ();
    }
    public void rightAction(int position,int positionX,int positionY)
    {
        int count = 0;
        if(positionY + value[position] < 6) {
            int k = positionY + value[position];
            for(int i=positionY+1;i<=k;i++) {
                if ( i < 6 ) {
                    if ( status[positionX][i] == 1 )
                        count += 1;
                    else if ( status[positionX][i] == 2 )
                        k += 1;
                }
            }
        }
        if(count == value[position]) {
            for (int i = 0; i < value[position]; i++) {
                if ( positionY + 1 + i < 6 ) {
                    if ( status[positionX][positionY + 1 + i] == 1) {
                        t[positionX][positionY + 1 + i].setBackgroundResource ( R.drawable.main_values );
                        status[positionX][positionY + 1 + i] = 2;
                    } else {
                        value[position] += 1;
                    }
                }
            }
            bl[position].setText ( " " );
            win[position] = 1;
        }
        winStatus ();
    }
    public void winStatus()
    {
        if(win[0] == 1 && win[1] == 1 && win[2] == 1 && win[3] == 1 && win[4] == 1 )
        {
            Intent intent = new Intent ( this,level2.class );
            startActivity ( intent );
            finish ();
        }
    }
    public void Restart()
    {
        Intent intent = new Intent ( this,level1.class );
        startActivity ( intent );
        finish ();
    }
}
