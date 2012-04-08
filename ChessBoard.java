import java.util.ArrayList;

public class ChessBoard {
    public static ChessPiece boardArray[][];
    public ArrayList<ChessPiece> blackPieces;
    public ArrayList<ChessPiece> whitePieces;
    public int turn;
    
    public ChessBoard(){
        boardArray = new ChessPiece[8][8];
        turn = Constants.WHITE;
        
        blackPieces = new ArrayList<ChessPiece>();
        whitePieces = new ArrayList<ChessPiece>();
    }
}
