public Class Chess {
	 
	private ChessBoard chessBoard;
	private Player[] players;
	private Player currentPlayer;
	private List<Move> moves;
	private GameStatus gameStatus;

	public void movePlayer(Position fromPosition, Position currentPosition, Player player);
	public void endGame();
	private void changeTurn(); 

	
}

Class Player {

	private Color color;
	private Account account;
	private Time timeleft;

	public Move makeMove(Piece piece);
}

Class Time {

	private int mins;
	private int seconds;
}

Class Account {

	private String username;
	private String password;

	private String name;
	private String email;
	private String phone;
}

Class ChessBoard {

	private List<List<Cell>> board;

	public void resetBoard();
	public void updateBoard(Move move);
}

Class Move {

	private Piece piece;
	private Piece killedPiece;
	private Player player;
	private Position fromPosition;
	private Postion toPosition;
}

Class Cell {

	private Piece piece;
	private Postion position;
}

Class Postion {

	private int numeral;
	private char ch;
}

Enum Color {

	WHITE, BLACK;
}

Enum GameStatus {
	PAUSE, FORFEIGHTED, BLACK_WON, WHITE_WON, ACTIVE;
}

Class abstract Piece {

	private Color color;

	public abstract List<Moves> getPossibleMoves(Position from);
	public abstract boolean isValidMove(Position from, Position to);
	public abstract void movePiece(Position from, Position to);
}

Class Bishop extends Piece {

	public  List<Moves> getPossibleMoves(Cell from);
	public  boolean isValidMove(Cell from, Cell to);
	public  void movePiece(Position from, Position to);

}

Class Knight extends Piece {

	public  List<Moves> getPossibleMoves(Cell from);
	public  boolean isValidMove(Cell from, Cell to);
	public  void movePiece(Position from, Position to);
}

Class Rook extends Piece {

	public  List<Moves> getPossibleMoves(Cell from);
	public  boolean isValidMove(Cell from, Cell to);
	public  void movePiece(Position from, Position to);
}

Class Queen extends Piece {

	public  List<Moves> getPossibleMoves(Cell from);
	public  boolean isValidMove(Cell from, Cell to);
	public  void movePiece(Position from, Position to);
}

Class King extends Piece {

	public  List<Moves> getPossibleMoves(Cell from);
	public  boolean isValidMove(Cell from, Cell to);
	public  void movePiece(Position from, Position to);
}

Class Pawn extends Piece {

	public  List<Moves> getPossibleMoves(Cell from);
	public  boolean isValidMove(Cell from, Cell to);
	public  void movePiece(Position from, Position to);
}
