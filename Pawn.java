import javax.swing.JLabel;

public class Pawn extends ChessPiece implements Constants{
    
    public Pawn(){
    
    }
    
    public Pawn(Location location, int type, int colour, JLabel label){
        pieceLocation = location;
        this.type = type;
        this.colour = colour;
        this.label = label;
        active = true;
        label.setLocation(location.getX()*75+20, (8-location.getY())*75+20);
    }
    
    @Override
    public boolean validateMove(Location destinationPosition) {
        
        int diffX = destinationPosition.getX() - pieceLocation.getX() ;
        int diffY;
        
        if( diffX == 0 ){
            if(colour == WHITE){
                diffY = destinationPosition.getY() - pieceLocation.getY();
                if(pieceLocation.getY() == 1){
                    if( diffY == 1 || ( diffY == 2 && ChessBoard.boardArray[pieceLocation.getX()][pieceLocation.getY()+1] == null) ){
                        return true;
                    }
                }
                else if(diffY == 1){
                    return true;
                }
            }
            else{
                diffY = pieceLocation.getY() - destinationPosition.getY();
                if(pieceLocation.getY() == 6){
                    if( diffY == 1 || ( diffY == 2 && ChessBoard.boardArray[pieceLocation.getX()][pieceLocation.getY()-1] == null ) ){
                        return true;
                    }
                }
                else if(diffY == 1){
                    return true;
                }
            }
        }
        return false;
    }
}
