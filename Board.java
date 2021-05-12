import java.util.ArrayList;
import java.util.List;

import vessels.Vessel;

public class Board {
    List<Vessel> vessels = new ArrayList<Vessel>();
    char[][] board = new char[10][10];

    public void add(Vessel vessel) {
        
        System.out.println(vessel.width);
        if(vessel.busyLine.size() > 0) {
            System.out.println("linhas");
            System.out.println(vessel.busyLine);
            vessels.add(vessel);
        } else {
            System.out.println("colunas");
            System.out.println(vessel.busyColumn);
            vessels.add(vessel);
        }
    }

    public void updateBoard(Vessel vessel) {

    }

    public boolean posisionValid(Vessel vessel) {
        
        return true;
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