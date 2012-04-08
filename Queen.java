import javax.swing.JLabel;

public class Queen extends ChessPiece implements Constants{
    
    public Queen(){
    
    }
    
    public Queen(Location location, int type, int colour, JLabel label){
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
        
        boolean inBetween = true;
        boolean isFree = false;
        
        boolean canMakeBishopMove = false;
        boolean canMakeRookMove = false;
        
        if( diffX == 0){
            inBetween = false;
            if( diffY > 0 ){
                for(int i=1; i < Math.abs(diffY); i++){
                    isFree = ChessBoard.boardArray[pieceLocation.getX()][pieceLocation.getY()+i] == null;
                    inBetween = inBetween || !isFree;
                }
            }
            else{
                for(int i=1; i < Math.abs(diffY); i++){
                    isFree = ChessBoard.boardArray[pieceLocation.getX()][pieceLocation.getY()-i] == null;
                    inBetween = inBetween || !isFree;
                }
            }
        }
        else if( diffY == 0 ){
            inBetween = false;
            if( diffX > 0 ){
                for(int i=1; i < Math.abs(diffX); i++){
                    isFree = ChessBoard.boardArray[pieceLocation.getX()+i][pieceLocation.getY()] == null;
                    inBetween = inBetween || !isFree;
                }
            }
            else{
                for(int i=1; i < Math.abs(diffX); i++){
                    isFree = ChessBoard.boardArray[pieceLocation.getX()-i][pieceLocation.getY()] == null;
                    inBetween = inBetween || !isFree;
                }
            }
        }
        
        canMakeRookMove = !inBetween;
        
        // For bishop
        
        inBetween = false;
        isFree = false;
        
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
            canMakeBishopMove = !inBetween;
        }
        
        if( canMakeBishopMove || canMakeRookMove )
            return true;
        else
            return false;
    }
}
