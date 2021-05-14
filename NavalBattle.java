import vessels.AircraftCarrier;
import vessels.Ship;
import vessels.Submarine;
import vessels.Vessel;

class NavalBattle {
    Board board;

    public void shoot(Vessel vessel, int lineTarget, int columnTarget) {
        if(lineTarget >= 10 || lineTarget < 0 || columnTarget >= 10 || columnTarget < 0 || !this.verifyShot(vessel, lineTarget, columnTarget)) {
            System.out.println(String.format("\n\n[ERROR] Invalid position for the shot [%d-%d] [%s]\n", lineTarget, columnTarget, vessel.name));
        } else {
            this.board.board[lineTarget][columnTarget] = this.board.board[lineTarget][columnTarget] == '-' ? 'x' : 'd';
        }
    }
    
    public boolean verifyShot(Vessel vessel, int lineTarget, int columnTarget) {
        boolean isValid = true;
        
        if (vessel.busyLine.size() > 0) {
            for (int i = vessel.endLine; i < vessel.endLine + vessel.width; i++) {
                if (vessel.startLine == lineTarget && i == columnTarget) {
                    isValid = false;
                    break;
                }
            }
        } else {
            for (int i = vessel.startLine; i < vessel.startLine + vessel.width; i++) {
                if (i == vessel.startLine && vessel.endLine == columnTarget) {
                    isValid = false;
                    break;
                }
            }
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

        System.out.println("\n\nInitial board: \n");
        board.showBoard();
        
        // Navio atirando na posição (3 , 4): água
        nb.shoot(ship, 3, 4);
        // Submarino atirando na posição (0 , 0): água
        nb.shoot(submarine, 0, 0);
        // Porta avioes atirando na posição (10 , 0): tiro inválido!
        nb.shoot(aircraftCarrier, 10, 0);
        // Porta avioes atirando na posição (4 , 1) e (4 , 2): destruindo submarino!
        nb.shoot(aircraftCarrier, 4, 1);
        nb.shoot(aircraftCarrier, 4, 2);
        // Porta avioes atirando na posição (0 , 2): tiro inválido!
        nb.shoot(aircraftCarrier, 4, 2);

        System.out.println("\n\nFinal board: \n");
        board.showBoard();
    }
}