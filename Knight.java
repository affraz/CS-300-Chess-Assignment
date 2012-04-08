import javax.swing.JLabel;

public class Knight extends ChessPiece implements Constants{
    
    public Knight(){
    
    }
    
    public Knight(Location location, int type, int colour, JLabel label){
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
        
        if(   (Math.abs(diffX) == 2 && Math.abs(diffY) == 1)
           || (Math.abs(diffX) == 1 && Math.abs(diffY) == 2)){
            return true;
        }
        
        return false;
    }
}
