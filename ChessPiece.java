import javax.swing.JLabel;

public class ChessPiece implements ChessPieceInterface{
    protected Location pieceLocation;
    protected int type;
    protected int colour;
    protected boolean active;
    protected JLabel label;
    protected ChessPiece killedBy;
    
    public ChessPiece(){
    
    }
    
    public Location getLocation(){
        return pieceLocation;
    }
    
    public void setLocation(Location location){
        pieceLocation = location;
    }
    
    public void setLocation(int a, int b){
        pieceLocation.setLocation(a, b);
    }
    
    public int getX(){
        return pieceLocation.getX();
    }
    
    public int getY(){
        return pieceLocation.getY();
    }
    
    public int getType(){
        return type;
    }
    
    public int getColour(){
        return colour;
    }
    
    @Override
    public boolean isWhite() {
        return ( getColour() == Constants.WHITE );
    }

    @Override
    public boolean isBlack() {
        return ( getColour() == Constants.BLACK );
    }
    
    @Override
    public boolean isActive(){
        return active;
    }
    
    public void setActive(boolean value){
        active = value;
    }

    @Override
    public boolean validateMove(Location destinationPosition) {
        return false;
    }

    @Override
    public boolean makeMove(Location newLocation) {
        int x = newLocation.getX();
        int y = newLocation.getY();
        
        int boardX = x*75 + label.getWidth()/3;
        int boardY = (8-y-1)*75 + label.getHeight()/3;

        int oldX = pieceLocation.getX();
        int oldY = pieceLocation.getY();

        pieceLocation.setLocation(x, y);

        label.setLocation(boardX, boardY);
        label.setBackground(null);
        label.setOpaque(false);

        ChessBoard.boardArray[x][y] = this;
        ChessBoard.boardArray[oldX][oldY] = null;
        
        return true;
    }

    @Override
    public boolean hasCheckOnOpposingKing(Location positionOfOpposingKing) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ChessPiece kill(ChessPiece a) {
        killedBy = a;
        
        this.setActive(false);
        
        this.label.setLocation(75*50, 0);
        label.setBackground(null);
        label.setOpaque(false);
        
        return null;
    }
}
