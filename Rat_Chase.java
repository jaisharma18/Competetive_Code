import java.util.*;
public class Rat_Chase {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine();
        String maze[] = new String[row];
        for(int i = 0;i < row;i++){
            maze[i] = sc.nextLine();
        }
        // System.out.println(Arrays.toString(maze));
        // String maze[] = {"OXOO","OOOX","XOXO","XOOX","XXOO"};
        int[][] board = new int[row][col];
        solve(maze, board, 0, 0);
        if(board[row - 1][col - 1] == 0){
            System.out.println("NO PATH FOUND");
        }
    }

    public static void solve(String[] maze,int[][] board, int i,int j){
        if(i == board.length - 1 && j == board[0].length - 1){
            board[i][j] = 1;
            for(int k = 0;k < board.length;k++){
                for(int l = 0;l < board[0].length;l++){
                    System.out.print(board[k][l] + " ");
                }
                System.out.println();
            }
            return;
        }

        if( !(i >= 0 && i < board.length) || !(j >= 0 && j < board[0].length) ){
            return;
        }

        if(board[i][j] == 1 || maze[i].charAt(j) == 'X'){
            return;
        }

        board[i][j] = 1;

        // up
        solve(maze, board, i - 1, j);

        //down
        solve(maze, board, i + 1, j);

        //left
        solve(maze, board, i, j + 1);

        //right
        solve(maze, board, i, j - 1);

        board[i][j] = 0;
    }
}
