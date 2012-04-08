import javax.swing.JLabel;

public class Bishop extends ChessPiece implements Constants{
    
    public Bishop(){
    
    }
    
    public Bishop(Location location, int type, int colour, JLabel label){
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
        int diffY = destinationPosition.getY() - pieceLocation.getY();
        
        boolean inBetween = false;
        boolean isFree = false;
        
        if(   (Math.abs(diffX) == Math.abs(diffY) ) ){
            if( diffX > 0 && diffY > 0 ){
                for(int i=1; i<diffX; i++){
                    isFree = ChessBoard.boardArray[pieceLocation.getX()+i][pieceLocation.getY()+i] == null;
                    inBetween = inBetween || !isFree;
                }
            }
            else if( diffX < 0 && diffY > 0 ){
                for(int i=1; i<diffY; i++){
                    isFree = ChessBoard.boardArray[pieceLocation.getX()-i][pieceLocation.getY()+i] == null;
                    inBetween = inBetween || !isFree;
                }
            }
            else if( diffX > 0 && diffY < 0 ){
                for(int i=1; i<diffX; i++){
                    isFree = ChessBoard.boardArray[pieceLocation.getX()+i][pieceLocation.getY()-i] == null;
                    inBetween = inBetween || !isFree;
                }
            }
            else if( diffX < 0 && diffY < 0 ){
                for(int i=1; i < Math.abs(diffX); i++){
                    isFree = ChessBoard.boardArray[pieceLocation.getX()-i][pieceLocation.getY()-i] == null;
                    inBetween = inBetween || !isFree;
                }
            }
            
            if(! inBetween ){
                return true;
            }
        }
        
        return false;
    }
}
