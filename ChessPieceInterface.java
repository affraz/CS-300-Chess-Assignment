public interface ChessPieceInterface {
    boolean validateMove(Location destinationPosition);
    boolean makeMove(Location newLocation);
    boolean hasCheckOnOpposingKing(Location positionOfOpposingKing);
    boolean isActive();
    boolean isWhite();
    boolean isBlack();
    ChessPiece kill(ChessPiece a);
}
