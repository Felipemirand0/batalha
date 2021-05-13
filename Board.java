
import java.util.ArrayList;
import java.util.List;

import vessels.Vessel;

public class Board {

    List<Vessel> vessels = new ArrayList<Vessel>();
    char[][] board = new char[10][10];

    public void add(Vessel vessel) {

        System.out.println(vessel.width);
        if (vessel.busyLine.size() > 0) {
            System.out.println("lines");
            System.out.println(vessel.busyLine);

            if (posisionValid(vessel)) {
                System.out.println("ok");

                updateBoard(vessel);
            } else {
                System.out.print("error");
            }

        } else {
            System.out.println("columns");
            System.out.println(vessel.busyColumn);

        }
    }

    public void updateBoard(Vessel vessel) {

        if (vessel.busyLine.size() > 0) {
            for (int i = vessel.endLine; i < vessel.endLine + vessel.width; i++) {

                this.board[vessel.startLine][i] = 'v';

            }
        } else {
            for (int i = vessel.startLine; i < vessel.startLine + vessel.width; i++) {
                
                this.board[i][vessel.endLine]= 'b';
            }
        }

        vessels.add(vessel);
    }

    public boolean posisionValid(Vessel vessel) {
        boolean ans = true;
        if (vessel.busyLine.size() > 0) {
            for (int i = vessel.endLine; i < vessel.endLine + vessel.width; i++) {

                if (this.board[vessel.startLine][i] != '-') {
                    ans = false;
                    break;
                }
            }
        } else {
            for (int i = vessel.startLine; i < vessel.startLine + vessel.width; i++) {

                if (this.board[i][vessel.endLine] != '-') {
                    ans = false;
                    break;
                }

            }
        }
        return ans;
    }

    public List<Vessel> getBoards() {
        return this.vessels;
    }

    public Board() {
        System.out.println("\t0 \t1 \t2 \t3 \t4 \t5 \t6 \t7 \t8 \t9");
        // atribuindo os valores da matriz e printando o board 
        for (int line = 0; line < 10; line++) {
            System.out.print(line + "");
            for (int column = 0; column < 10; column++) {
                System.out.print("\t" + "-");
                this.board[line][column] = '-';
            }
            System.out.println();
        }
    }
}
