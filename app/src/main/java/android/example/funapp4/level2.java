package android.example.funapp4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class level2 extends AppCompatActivity {

    Button up1,down1,left1,right1;
    Button[] bu = new Button[16];
    ImageButton start1;
    TextView[][] t1 = new TextView[6][6];
    public int[][] coord = new int[16][2];
    public int[][] status1 = new int[6][6];
    public int[] execute1 = new int[16];
    public int[] value1 = new int[16];
    public int[] win1 = new int[16];
    public int[] allow1 = new int[16];

    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.level_2 );

        up1 = (Button)findViewById ( R.id.up1 );
        down1 = (Button)findViewById ( R.id.down1 );
        left1 = (Button)findViewById ( R.id.left1 );
        right1 = (Button)findViewById ( R.id.right1 );

        bu[0] = (Button)findViewById ( R.id.bu1 );
        bu[1] = (Button)findViewById ( R.id.bu2 );
        bu[2] = (Button)findViewById ( R.id.bu3 );
        bu[3] = (Button)findViewById ( R.id.bu4 );
        bu[4] = (Button)findViewById ( R.id.bu5 );
        bu[5] = (Button)findViewById ( R.id.bu6 );
        bu[6] = (Button)findViewById ( R.id.bu7 );
        bu[7] = (Button)findViewById ( R.id.bu8 );
        bu[8] = (Button)findViewById ( R.id.bu9 );
        bu[9] = (Button)findViewById ( R.id.bu10 );
        bu[10] = (Button)findViewById ( R.id.bu11 );
        bu[11] = (Button)findViewById ( R.id.bu12 );
        bu[12] = (Button)findViewById ( R.id.bu13 );
        bu[13] = (Button)findViewById ( R.id.bu14 );
        bu[14] = (Button)findViewById ( R.id.bu15 );
        bu[15] = (Button)findViewById ( R.id.bu16 );

        start1 = (ImageButton)findViewById ( R.id.start1 );

        coord = new int[][]{{0, 1}, {0, 2}, {0, 3}, {0, 4}, {1, 0}, {1, 5}, {2, 0}, {2, 5}, {3, 0}, {3, 5}, {4, 0}, {4, 5}, {5, 1}, {5, 2}, {5, 3}, {5, 4}};

        for(int i=0;i<6;i++)
        {
            for(int j=0;j<6;j++)
            {
                status1[i][j] = 0;
            }
        }

        t1[0][1] = (TextView)findViewById ( R.id.ot1 ); status1[0][1] = 2;
        t1[0][2] = (TextView)findViewById ( R.id.ot2 ); status1[0][2] = 2;
        t1[0][3] = (TextView)findViewById ( R.id.ot3 ); status1[0][3] = 2;
        t1[0][4] = (TextView)findViewById ( R.id.ot4 ); status1[0][4] = 2;
        t1[1][0] = (TextView)findViewById ( R.id.ot5 ); status1[1][0] = 2;
        t1[1][5] = (TextView)findViewById ( R.id.ot6 ); status1[1][5] = 2;
        t1[2][0] = (TextView)findViewById ( R.id.ot7 ); status1[2][0] = 2;
        t1[2][5] = (TextView)findViewById ( R.id.ot8 ); status1[2][5] = 2;
        t1[3][0] = (TextView)findViewById ( R.id.ot9 ); status1[3][0] = 2;
        t1[3][5] = (TextView)findViewById ( R.id.ot10 ); status1[3][5] = 2;
        t1[4][0] = (TextView)findViewById ( R.id.ot11 ); status1[4][0] = 2;
        t1[4][5] = (TextView)findViewById ( R.id.ot12 ); status1[4][5] = 2;
        t1[5][1] = (TextView)findViewById ( R.id.ot13 ); status1[5][1] = 2;
        t1[5][2] = (TextView)findViewById ( R.id.ot14 ); status1[5][2] = 2;
        t1[5][3] = (TextView)findViewById ( R.id.ot15 ); status1[5][3] = 2;
        t1[5][4] = (TextView)findViewById ( R.id.ot16 ); status1[5][4] = 2;

        t1[1][1] = (TextView)findViewById ( R.id.in1 ); status1[1][1] = 1;
        t1[1][2] = (TextView)findViewById ( R.id.in2 ); status1[1][2] = 1;
        t1[1][3] = (TextView)findViewById ( R.id.in3 ); status1[1][3] = 1;
        t1[1][4] = (TextView)findViewById ( R.id.in4 ); status1[1][4] = 1;
        t1[2][1] = (TextView)findViewById ( R.id.in5 ); status1[2][1] = 1;
        t1[2][2] = (TextView)findViewById ( R.id.in6 ); status1[2][2] = 1;
        t1[2][3] = (TextView)findViewById ( R.id.in7 ); status1[2][3] = 1;
        t1[2][4] = (TextView)findViewById ( R.id.in8 ); status1[2][4] = 1;
        t1[3][1] = (TextView)findViewById ( R.id.in9 ); status1[3][1] = 1;
        t1[3][2] = (TextView)findViewById ( R.id.in10 ); status1[3][2] = 1;
        t1[3][3] = (TextView)findViewById ( R.id.in11 ); status1[3][3] = 1;
        t1[3][4] = (TextView)findViewById ( R.id.in12 ); status1[3][4] = 1;
        t1[4][1] = (TextView)findViewById ( R.id.in13 ); status1[4][1] = 1;
        t1[4][2] = (TextView)findViewById ( R.id.in14 ); status1[4][2] = 1;
        t1[4][3] = (TextView)findViewById ( R.id.in15 ); status1[4][3] = 1;
        t1[4][4] = (TextView)findViewById ( R.id.in16 ); status1[4][4] = 1;

        for(int i=0;i<16;i++)
        {
            value1[i] = 1;
            execute1[i] = 0;
            win1[i] = 0;
            allow1[i] = 0;
        }

        for(int i=0;i<16;i++)
        {
            final int finalI = i;
            bu[i].setOnClickListener ( new View.OnClickListener ( ) {
                @Override
                public void onClick ( View view ) {
                    int k = finalI;
                    execute1[finalI] = 1;
                    for(int j=0;j<16;j++)
                    {
                        if(j != finalI)
                        {
                            execute1[j] = 0;

                        }
                    }
                }
            } );
        }
        start1.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                Restart();
            }
        } );
        up1.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                int k=0;
                for(k=0;k<16;k++)
                {
                    if(execute1[k] == 1)
                    {
                        if(allow1[k] == 0)
                            upAction(k,PositionX ( k ),PositionY ( k ));
                    }
                }
            }
        } );
        down1.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                int k=0;
                for(k=0;k<16;k++)
                {
                    if(execute1[k] == 1)
                    {
                        if(allow1[k] == 0)
                            downAction(k,PositionX ( k ),PositionY ( k ));
                    }
                }
            }
        } );
        left1.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                int k=0;
                for(k=0;k<16;k++)
                {
                    if(execute1[k] == 1)
                    {
                        if(allow1[k] == 0)
                            leftAction(k,PositionX ( k ),PositionY ( k ));
                    }
                }
            }
        } );
        right1.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                int k=0;
                for(k=0;k<16;k++)
                {
                    if(execute1[k] == 1)
                    {
                        if(allow1[k] == 0)
                            rightAction(k,PositionX ( k ),PositionY ( k ));
                    }
                }
            }
        } );
    }
    public int PositionX(int x)
    {
        int position = x;

        return coord[position][0];
    }
    public int PositionY(int y)
    {
        int position = y;

        return coord[position][1];
    }
    public void upAction(int position,int positionX,int positionY)
    {
        int count = 0;
        if(positionX - value1[position] >= 0) {
            int k = positionX - value1[position];
            for(int i=positionX-1;i>=k;i--) {
                if(i>=0) {
                    if ( status1[i][positionY] == 1 )
                        count += 1;
                    else if ( status1[i][positionY] == 2 )
                        k -= 1;
                }
            }
        }
        if(count == value1[position]) {
            for(int i=0;i<value1[position];i++) {
                if ( positionX - 1 - i >= 0 ) {
                    if ( status1[positionX - 1 - i][positionY] == 1 ) {
                        t1[positionX - 1 - i][positionY].setBackgroundResource ( R.drawable.main_values );
                        status1[positionX - 1 - i][positionY] = 2;
                    } else {
                        value1[position] += 1;
                    }
                }
            }
            t1[positionX][positionY].setText ( " " );
            win1[position] = 1;
            allow1[position] = 1;
        }
        winStatus ();
    }
    public void downAction(int position,int positionX,int positionY)
    {
        int count = 0;
        if(positionX + value1[position] < 6) {
            int k = positionX + value1[position];
            for(int i=positionX+1;i<=k;i++) {
                if ( i < 6 ) {
                    if ( status1[i][positionY] == 1 )
                        count += 1;
                    else if ( status1[i][positionY] == 2 )
                        k += 1;
                }
            }
        }
        if(count == value1[position]) {
            for (int i = 0; i < value1[position]; i++) {
                if ( positionX + 1 + i < 6 ) {
                    if ( status1[positionX + 1 + i][positionY] == 1 ) {
                        t1[positionX + 1 + i][positionY].setBackgroundResource ( R.drawable.main_values );
                        status1[positionX + 1 + i][positionY] = 2;
                    } else {
                        value1[position] += 1;
                    }
                }
            }
            t1[positionX][positionY].setText ( " " );
            win1[position] = 1;
            allow1[position] = 1;
        }
        winStatus ();
    }
    public void leftAction(int position,int positionX,int positionY)
    {
        int count = 0;
        if(positionY - value1[position] >= 0) {
            int k = positionY - value1[position];
            for(int i=positionY-1;i>=k;i--) {
                if(i>=0) {
                    if ( status1[positionX][i] == 1 )
                        count += 1;
                    else if ( status1[positionX][i] == 2 )
                        k -= 1;
                }
            }
        }
        if(count == value1[position]) {
            for(int i=0;i<value1[position];i++) {
                if ( positionY - 1 - i >= 0 ) {
                    if ( status1[positionX][positionY - 1 - i] == 1 ) {
                        t1[positionX][positionY - 1 - i].setBackgroundResource ( R.drawable.main_values );
                        status1[positionX][positionY - 1 - i] = 2;
                    } else {
                        value1[position] += 1;
                    }
                }
            }
            t1[positionX][positionY].setText ( " " );
            win1[position] = 1;
            allow1[position] = 1;
        }
        winStatus ();
    }
    public void rightAction(int position,int positionX,int positionY)
    {
        int count = 0;
        if(positionY + value1[position] < 6) {
            int k = positionY + value1[position];
            for(int i=positionY+1;i<=k;i++) {
                if ( i < 6 ) {
                    if ( status1[positionX][i] == 1 )
                        count += 1;
                    else if ( status1[positionX][i] == 2 )
                        k += 1;
                }
            }
        }
        if(count == value1[position]) {
            for (int i = 0; i < value1[position]; i++) {
                if ( positionY + 1 + i < 6 ) {
                    if ( status1[positionX][positionY + 1 + i] == 1) {
                        t1[positionX][positionY + 1 + i].setBackgroundResource ( R.drawable.main_values );
                        status1[positionX][positionY + 1 + i] = 2;
                    } else {
                        value1[position] += 1;
                    }
                }
            }
            t1[positionX][positionY].setText ( " " );
            win1[position] = 1;
            allow1[position] = 1;
        }
        winStatus ();
    }
    public void winStatus()
    {
        int y = 0;
        for(int i=0;i<16 ;i++)
            if(win1[i] == 1)
                y += 1;
        if( y == 16 )
        {
            Intent intent = new Intent ( this,finaltp.class );
            startActivity ( intent );
            finish ();
        }
    }
    public void Restart()
    {
        Intent intent = new Intent ( this,level2.class );
        startActivity ( intent );
        finish ();
    }
}
