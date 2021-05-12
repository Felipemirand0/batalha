import vessels.AircraftCarrier;
import vessels.Ship;
import vessels.Submarine;
import vessels.Vessel;

class NavalBattle {
    Board board;

    // public void imprimir(){

    // }

    public void shoot(Vessel vessel, int lineTarget, int columnTarget){
        // 
    }

    public NavalBattle(Board board) {
        this.board = board;
    }

    public static void main(String[] args) {
        // / criando tabuleiro
        Board board = new Board();

        // Criando os embarcações
        Vessel submarine = new Submarine('h', 4 , 1);
        Vessel aircraftCarrier = new AircraftCarrier('v', 0, 2);
        Vessel ship = new Ship('h', 4 , 5);
        
        // adicionando os barcos
        board.add(submarine);
        board.add(aircraftCarrier);
        board.add(ship);

        NavalBattle nb = new NavalBattle(board);

        // bn . imprimir ();
        // submarino tenta atirar em (3 ,4)
        nb.shoot(ship, 3, 4);
        
        // navio tenta atirar em (0 ,0)
        // bn . atirar ( submarino , 0 , 0);
        // portaAviao tenta atirar em (10 ,0)
        // bn . atirar ( portaAviao , 10 , 0);
        // portaAviao tenta atirar em (4 ,1)
        // bn . atirar (navio , 4 , 1);
        // bn . imprimir ();
        // submarino tenta atirar em (4 ,1)
        // bn . atirar ( submarino , 4 , 1);
        // portaAviao tenta atirar em (0 ,2)
        // bn . atirar ( portaAviao , 0 , 2);
        // bn . imprimir ();
    }
}