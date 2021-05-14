import vessels.AircraftCarrier;
import vessels.Ship;
import vessels.Submarine;
import vessels.Vessel;

class NavalBattle {
    Board board;

    public void shoot(Vessel vessel, int lineTarget, int columnTarget) {
        if(lineTarget >= 10 || lineTarget < 0 || columnTarget >= 10 || columnTarget < 0 || !this.verifyShot(vessel, lineTarget, columnTarget)) {
            System.out.println(String.format("\n[ERROR] Invalid position for the shot [%d-%d] [%s]", lineTarget, columnTarget, vessel.name));
        } else {
            if(this.destroyed(vessel)) {
                System.out.println(String.format("\n[ERROR] Navigation(%s) is destroyed", vessel.name));
            } else {
                this.board.board[lineTarget][columnTarget] = this.board.board[lineTarget][columnTarget] == '-' ? 'x' : 'd';
            }
        }
    }
    
    public boolean destroyed(Vessel vessel) {
        int amountMestroyed = 0;
        
        if (vessel.busyLine.size() > 0) {
            for (int i = vessel.endLine; i < vessel.endLine + vessel.width; i++) {
                if('d' == this.board.board[vessel.startLine][i]) {
                    amountMestroyed++;
                }
            }
        } else {
            for (int i = vessel.startLine; i < vessel.startLine + vessel.width; i++) {
                if('d' == this.board.board[i][vessel.endLine]) {
                    amountMestroyed++;
                }
            }
        }

        return amountMestroyed >= vessel.width;
    }

    public boolean verifyShot(Vessel vessel, int lineTarget, int columnTarget) {
        boolean isValid = true;
        
        if(this.board.board[lineTarget][columnTarget] == vessel.name.charAt(0)) {
            isValid = false;
        }

        return isValid;
    }

    public NavalBattle(Board board) {
        this.board = board;
    }

    public static void main(String[] args) {
        // / criando tabuleiro
        Board board = new Board();

        // Criando os embarcações
        Vessel ship = new Ship("n1", 'h', 4, 5);
        Vessel submarine = new Submarine("s1", 'h', 4, 1);
        Vessel aircraftCarrier = new AircraftCarrier("p1", 'v', 0, 2);

        // adicionando os barcos
        board.add(ship);
        board.add(submarine);
        board.add(aircraftCarrier);

        NavalBattle nb = new NavalBattle(board);

        System.out.println("\n\n--------------------------------  Initial board ----------------------------------");
        board.showBoard();        
        System.out.println(" ---------------------------------------------------------------------------------  \n\n");
        
        // Navio atirando na posição (3 , 4): água
        nb.shoot(ship, 3, 4);
        // Submarino atirando na posição (0 , 0): água
        nb.shoot(submarine, 0, 0);
        // Porta avioes atirando na posição (10 , 0): tiro inválido!
        nb.shoot(aircraftCarrier, 10, 0);
        // Porta avioes atirando na posição (4 , 1) e (4 , 2): destruindo submarino!
        nb.shoot(aircraftCarrier, 4, 1);
        nb.shoot(aircraftCarrier, 4, 2);
        // Submarino atirando na posição (4 , 1): não pode atirar
        nb.shoot(submarine, 4, 1);
        // Porta avioes atirando na posição (0 , 2): tiro inválido!
        nb.shoot(aircraftCarrier, 0, 2);

        System.out.println("\n\n -------------------------------  Final board ------------------------------------ ");
        board.showBoard();
        System.out.println(" --------------------------------------------------------------------------------- \n\n");
    }
}