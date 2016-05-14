   import java.awt.*;
   import java.awt.event.*;
   import javax.swing.*;
    public class Battleship extends JPanel
   {
      private JButton[][] board;
      private int[][] matrix;
      private int hits, torpedoes;
      private JLabel label;
      private JButton reset;
       public Battleship()
      {
         setLayout(new BorderLayout());
         hits = 0;
         torpedoes = 20;
      
         JPanel north = new JPanel();
         north.setLayout(new FlowLayout());
         add(north, BorderLayout.NORTH);
         label = new JLabel("Welcome to Battleship -- You have 20 torpedoes.");
         north.add(label);
      
         JPanel center = new JPanel();
         center.setLayout(new GridLayout(10,10));
         add(center, BorderLayout.CENTER);
      
         board = new JButton[10][10];
         matrix = new int[10][10];
         for(int r = 0; r < 10; r++)
            for(int c = 0; c < 10; c++)
            {
               board[r][c] = new JButton();
               board[r][c].setBackground(Color.blue);
               board[r][c].addActionListener( new Handler1(r, c) );
               center.add(board[r][c]);
            }
      
         reset = new JButton("Reset");
         reset.addActionListener( new Handler2() );
         reset.setEnabled(false);
         add(reset, BorderLayout.SOUTH);
      
         placeShips();
      }
       private void placeBattleship(int length)
      {
         int coin = (int)(Math.random()*2 + 1);
         int count = 0;
         switch(coin)
         {
            case 1:
               for(int x = 0; x < matrix.length; x++)
                  for(int y = 0; y < matrix[0].length; y++)
                  {
                     if(count < 4 && x == length)
                     {
                        matrix[x][y] = 1;
                        count++;
                     }
                  }
            case 2:
               for(int x = 0; x < matrix.length; x++)
               {
                  for(int y = 0; y < matrix[0].length; y++)
                  {
                     if(count < 4 && y == length)
                     {
                        matrix[x][y] = 1;
                        count++;
                     }
                  }
               }
         }
      }
       private void placeCarrier(int length)
      {
         int coin = (int)(Math.random()*2 + 1);
         int count = 0;
         switch(coin)
         {
            case 1:
               for(int x = 0; x < matrix.length; x++)
                  for(int y = 0; y < matrix[0].length; y++)
                  {
                     if(count < 5 && x == length)
                     {
                        matrix[x][y] = 1;
                        count++;
                     }
                  }
            case 2:
               for(int x = 0; x < matrix.length; x++)
               {
                  for(int y = 0; y < matrix[0].length; y++)
                  {
                     if(count < 5 && y == length)
                     {
                        matrix[x][y] = 1;
                        count++;
                     }
                  }
               }
         }
      }
       private void placeSub(int length)
      {
         int coin = (int)(Math.random()*2 + 1);
         int count = 0;
         switch(coin)
         {
            case 1:
               for(int x = 0; x < matrix.length; x++)
                  for(int y = 0; y < matrix[0].length; y++)
                  {
                     if(count < 3 && x == length)
                     {
                        matrix[x][y] = 1;
                        count++;
                     }
                  }
            case 2:
               for(int x = 0; x < matrix.length; x++)
               {
                  for(int y = 0; y < matrix[0].length; y++)
                  {
                     if(count < 3 && y == length)
                     {
                        matrix[x][y] = 1;
                        count++;
                     }
                  }
               }
         }
      }
       private void placeDestroyer(int length)
      {
         int coin = (int)(Math.random()*2 + 1);
         int count = 0;
         switch(coin)
         {
            case 1:
               for(int x = 0; x < matrix.length; x++)
                  for(int y = 0; y < matrix[0].length; y++)
                  {
                     if(count < 3 && x == length)
                     {
                        matrix[x][y] = 1;
                        count++;
                     }
                  }
            case 2:
               for(int x = 0; x < matrix.length; x++)
               {
                  for(int y = 0; y < matrix[0].length; y++)
                  {
                     if(count < 3 && y == length)
                     {
                        matrix[x][y] = 1;
                        count++;
                     }
                  }
               }
         }
      }
       private void placePatrol(int length)
      {
         int coin = (int)(Math.random()*2 + 1);
         int count = 0;
         switch(coin)
         {
            case 1:
               for(int x = 0; x < matrix.length; x++)
                  for(int y = 0; y < matrix[0].length; y++)
                  {
                     if(count < 2 && x == length)
                     {
                        matrix[x][y] = 1;
                        count++;
                     }
                  }
            case 2:
               for(int x = 0; x < matrix.length; x++)
               {
                  for(int y = 0; y < matrix[0].length; y++)
                  {
                     if(count < 2 && y == length)
                     {
                        matrix[x][y] = 1;
                        count++;
                     }
                  }
               }
         }
      }
       public void placeShips()
      {
         int lengthBattle = (int)(Math.random()*10);
         int lengthCarrier = (int)(Math.random()*10);
         int lengthSub = (int)(Math.random()*10);
         int lengthDestroyer = (int)(Math.random()*10);
         int lengthPatrol = (int)(Math.random()*10);
         placeBattleship(lengthBattle);
         placeCarrier(lengthCarrier);
         placeSub(lengthSub);
         placeDestroyer(lengthDestroyer);
         placePatrol(lengthPatrol);
      }
       private class Handler1 implements ActionListener
      {
         private int myRow, myCol;
          public Handler1(int r, int c)
         {
            myRow = r;
            myCol = c;
         }
          public void actionPerformed(ActionEvent e)
         {
            if(matrix[myRow][myCol] == 1)
            {
               board[myRow][myCol].setBackground(Color.green);
               board[myRow][myCol].setEnabled(false);
               torpedoes--;
               hits++;
            }
            else
            {
               board[myRow][myCol].setBackground(Color.red);
               board[myRow][myCol].setEnabled(false);
               torpedoes--;
            }
            if(torpedoes == 1)
               label.setText("You have " + torpedoes + " torpedo left");
            else
               label.setText("You have " + torpedoes + " torpedoes left");
            if(hits < 18 && torpedoes <= 0)
            {
               label.setText("You lose!");
               reset.setEnabled(true);
               for(int x = 0; x < matrix.length; x++)
                  for(int y = 0; y < matrix[0].length; y++)
                  {
                     if(matrix[x][y] == 1)
                        board[x][y].setBackground(Color.black);
                     board[x][y].setEnabled(false);
                  }
            }
            else if(hits == 18)
            {
               label.setText("You win!");
               for(int x = 0; x < matrix.length; x++)
                  for(int y = 0; y < matrix[0].length; y++)
                     board[x][y].setEnabled(false);
               reset.setEnabled(true);
            }
         }
      }
       private class Handler2 implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            torpedoes = 20;
            hits = 0;
            for(int x = 0; x < matrix.length; x++)
               for(int y = 0; y < matrix[0].length; y++)
                  matrix[x][y] = 0;
            reset.setEnabled(false);
            for(int x = 0; x < matrix.length; x++)
               for(int y = 0; y < matrix[0].length; y++)
               {
                  board[x][y].setEnabled(true);
                  board[x][y].setBackground(Color.blue);
               }
            placeShips();
            label.setText("Welcome to Battleship -- You have 20 torpedoes.");
         }
      }
   }