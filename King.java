import javax.swing.JLabel;

public class King extends ChessPiece implements Constants{
    
    public King(){
    
    }
    
    public King(Location location, int type, int colour, JLabel label){
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
        
        if(   (Math.abs(diffX) == 1 && Math.abs(diffY) == 1)
           || (Math.abs(diffX) == 1 && Math.abs(diffY) == 0)
           || (Math.abs(diffX) == 0 && Math.abs(diffY) == 1) ){
            return true;
        }
        
        return false;
    }
}
