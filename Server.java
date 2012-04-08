import java.awt.Color;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author affraz
 */
public class Server extends javax.swing.JFrame implements ServerMethods{
    
    public ChessBoard board;
    private javax.swing.JLabel currentLabel = null;
    boolean isLabelSelected = false;
    private ChessPiece currentPiece = null;
    private ChessPiece currentPiece2 = null;
    private java.awt.Color labelBackground = null;
    
    // For RMI
    private boolean turn = false;;
    static ClientMethods client;
    static Server obj;

    public Server() {
        
        initComponents();
        initializeBoard();
    }
    
    public void initializeBoard(){
        board = new ChessBoard();
        
        // Black Pieces
        board.boardArray[0][7] = new Rook( new Location(0,7), Constants.ROOK, Constants.BLACK, bRook1);
        board.boardArray[1][7] = new Knight( new Location(1,7), Constants.KNIGHT, Constants.BLACK, bKnight1);
        board.boardArray[2][7] = new Bishop( new Location(2,7), Constants.BISHOP, Constants.BLACK, bBishop1);
        board.boardArray[3][7] = new Queen( new Location(3,7), Constants.QUEEN, Constants.BLACK, bQueen);
        board.boardArray[4][7] = new King( new Location(4,7), Constants.KING, Constants.BLACK, bKing);
        board.boardArray[5][7] = new Bishop( new Location(5,7), Constants.BISHOP, Constants.BLACK, bBishop2);
        board.boardArray[6][7] = new Knight( new Location(6,7), Constants.KNIGHT, Constants.BLACK, bKnight2);
        board.boardArray[7][7] = new Rook( new Location(7,7), Constants.ROOK, Constants.BLACK, bRook2);
        
        board.boardArray[0][6] = new Pawn( new Location(0,6), Constants.PAWN, Constants.BLACK, bPawn1);
        board.boardArray[1][6] = new Pawn( new Location(1,6), Constants.PAWN, Constants.BLACK, bPawn2);
        board.boardArray[2][6] = new Pawn( new Location(2,6), Constants.PAWN, Constants.BLACK, bPawn3);
        board.boardArray[3][6] = new Pawn( new Location(3,6), Constants.PAWN, Constants.BLACK, bPawn4);
        board.boardArray[4][6] = new Pawn( new Location(4,6), Constants.PAWN, Constants.BLACK, bPawn5);
        board.boardArray[5][6] = new Pawn( new Location(5,6), Constants.PAWN, Constants.BLACK, bPawn6);
        board.boardArray[6][6] = new Pawn( new Location(6,6), Constants.PAWN, Constants.BLACK, bPawn7);
        board.boardArray[7][6] = new Pawn( new Location(7,6), Constants.PAWN, Constants.BLACK, bPawn8);
        
        for(int i = 0; i<8; i++){
            for(int j = 6; j<8; j++){
                board.blackPieces.add(board.boardArray[i][j]);
            }
        }
        
        // White Pieces
        board.boardArray[0][0] = new Rook( new Location(0,0), Constants.ROOK, Constants.WHITE, wRook1);
        board.boardArray[1][0] = new Knight( new Location(1,0), Constants.KNIGHT, Constants.WHITE, wKnight1);
        board.boardArray[2][0] = new Bishop( new Location(2,0), Constants.BISHOP, Constants.WHITE, wBishop1);
        board.boardArray[3][0] = new Queen( new Location(3,0), Constants.QUEEN, Constants.WHITE, wQueen);
        board.boardArray[4][0] = new King( new Location(4,0), Constants.KING, Constants.WHITE, wKing);
        board.boardArray[5][0] = new Bishop( new Location(5,0), Constants.BISHOP, Constants.WHITE, wBishop2);
        board.boardArray[6][0] = new Knight( new Location(6,0), Constants.KNIGHT, Constants.WHITE, wKnight2);
        board.boardArray[7][0] = new Rook( new Location(7,0), Constants.ROOK, Constants.WHITE, wRook2);
        
        board.boardArray[0][1] = new Pawn( new Location(0,1), Constants.PAWN, Constants.WHITE, wPawn1);
        board.boardArray[1][1] = new Pawn( new Location(1,1), Constants.PAWN, Constants.WHITE, wPawn2);
        board.boardArray[2][1] = new Pawn( new Location(2,1), Constants.PAWN, Constants.WHITE, wPawn3);
        board.boardArray[3][1] = new Pawn( new Location(3,1), Constants.PAWN, Constants.WHITE, wPawn4);
        board.boardArray[4][1] = new Pawn( new Location(4,1), Constants.PAWN, Constants.WHITE, wPawn5);
        board.boardArray[5][1] = new Pawn( new Location(5,1), Constants.PAWN, Constants.WHITE, wPawn6);
        board.boardArray[6][1] = new Pawn( new Location(6,1), Constants.PAWN, Constants.WHITE, wPawn7);
        board.boardArray[7][1] = new Pawn( new Location(7,1), Constants.PAWN, Constants.WHITE, wPawn8);
        
        for(int i = 0; i<8; i++){
            for(int j = 0; j<2; j++){
                board.whitePieces.add(board.boardArray[i][j]);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel = new javax.swing.JPanel();
        bRook1 = new javax.swing.JLabel();
        bKnight1 = new javax.swing.JLabel();
        bBishop2 = new javax.swing.JLabel();
        bBishop1 = new javax.swing.JLabel();
        bKnight2 = new javax.swing.JLabel();
        bRook2 = new javax.swing.JLabel();
        bQueen = new javax.swing.JLabel();
        bKing = new javax.swing.JLabel();
        bPawn1 = new javax.swing.JLabel();
        bPawn2 = new javax.swing.JLabel();
        bPawn3 = new javax.swing.JLabel();
        bPawn4 = new javax.swing.JLabel();
        bPawn5 = new javax.swing.JLabel();
        bPawn6 = new javax.swing.JLabel();
        bPawn7 = new javax.swing.JLabel();
        bPawn8 = new javax.swing.JLabel();
        wRook1 = new javax.swing.JLabel();
        wKnight1 = new javax.swing.JLabel();
        wRook2 = new javax.swing.JLabel();
        wKnight2 = new javax.swing.JLabel();
        wBishop1 = new javax.swing.JLabel();
        wBishop2 = new javax.swing.JLabel();
        wQueen = new javax.swing.JLabel();
        wKing = new javax.swing.JLabel();
        wPawn1 = new javax.swing.JLabel();
        wPawn2 = new javax.swing.JLabel();
        wPawn3 = new javax.swing.JLabel();
        wPawn4 = new javax.swing.JLabel();
        wPawn5 = new javax.swing.JLabel();
        wPawn6 = new javax.swing.JLabel();
        wPawn7 = new javax.swing.JLabel();
        wPawn8 = new javax.swing.JLabel();
        Board = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel.setOpaque(false);
        jPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelMouseClicked(evt);
            }
        });

        bRook1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/bRook.png"))); // NOI18N
        bRook1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        bKnight1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/bKnight.png"))); // NOI18N

        bBishop2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/bBishop.png"))); // NOI18N

        bBishop1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/bBishop.png"))); // NOI18N

        bKnight2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/bKnight.png"))); // NOI18N

        bRook2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/bRook.png"))); // NOI18N

        bQueen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/bQueen.png"))); // NOI18N
        bQueen.setAlignmentY(0.0F);

        bKing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/bKing.png"))); // NOI18N

        bPawn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/bPawn.png"))); // NOI18N

        bPawn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/bPawn.png"))); // NOI18N

        bPawn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/bPawn.png"))); // NOI18N

        bPawn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/bPawn.png"))); // NOI18N

        bPawn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/bPawn.png"))); // NOI18N

        bPawn6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/bPawn.png"))); // NOI18N

        bPawn7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/bPawn.png"))); // NOI18N

        bPawn8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/bPawn.png"))); // NOI18N

        wRook1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/wRook.png"))); // NOI18N
        wRook1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        wKnight1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/wKnight.png"))); // NOI18N
        wKnight1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        wRook2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/wRook.png"))); // NOI18N
        wRook2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        wKnight2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/wKnight.png"))); // NOI18N
        wKnight2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        wBishop1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/wBishop.png"))); // NOI18N
        wBishop1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        wBishop2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/wBishop.png"))); // NOI18N
        wBishop2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        wQueen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/wQueen.png"))); // NOI18N
        wQueen.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        wKing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/wKing.png"))); // NOI18N
        wKing.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        wPawn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/wPawn.png"))); // NOI18N
        wPawn1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        wPawn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/wPawn.png"))); // NOI18N
        wPawn2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        wPawn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/wPawn.png"))); // NOI18N
        wPawn3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        wPawn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/wPawn.png"))); // NOI18N
        wPawn4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        wPawn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/wPawn.png"))); // NOI18N
        wPawn5.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        wPawn6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/wPawn.png"))); // NOI18N
        wPawn6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        wPawn7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/wPawn.png"))); // NOI18N
        wPawn7.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        wPawn8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/wPawn.png"))); // NOI18N
        wPawn8.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bPawn3)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(bRook1)
                                .addGap(27, 27, 27)
                                .addComponent(bKnight1))
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(bPawn1)
                                .addGap(27, 27, 27)
                                .addComponent(bPawn2))
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(wRook1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(wPawn1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(wKnight1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(wPawn2, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(28, 28, 28)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bBishop1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(wPawn3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(wBishop1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(31, 31, 31)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bPawn4)
                    .addComponent(bQueen)
                    .addComponent(wPawn4)
                    .addComponent(wQueen))
                .addGap(27, 27, 27)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wKing)
                    .addComponent(wPawn5)
                    .addComponent(bKing)
                    .addComponent(bPawn5))
                .addGap(29, 29, 29)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wBishop2)
                    .addComponent(wPawn6)
                    .addComponent(bPawn6)
                    .addComponent(bBishop2))
                .addGap(32, 32, 32)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bKnight2)
                    .addComponent(wPawn7)
                    .addComponent(wKnight2)
                    .addComponent(bPawn7))
                .addGap(29, 29, 29)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wRook2)
                    .addComponent(wPawn8)
                    .addComponent(bPawn8)
                    .addComponent(bRook2))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bKing)
                    .addComponent(bQueen)
                    .addComponent(bRook2)
                    .addComponent(bKnight2)
                    .addComponent(bBishop1)
                    .addComponent(bBishop2)
                    .addComponent(bKnight1)
                    .addComponent(bRook1))
                .addGap(26, 26, 26)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bPawn2)
                    .addComponent(bPawn4)
                    .addComponent(bPawn1)
                    .addComponent(bPawn5)
                    .addComponent(bPawn7)
                    .addComponent(bPawn3)
                    .addComponent(bPawn6)
                    .addComponent(bPawn8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wPawn7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(wPawn8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(wPawn5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(wPawn6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(wPawn4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(wPawn3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(wPawn2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(wPawn1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(30, 30, 30)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wRook1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(wRook2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(wKnight1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(wKnight2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(wBishop2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(wBishop1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(wQueen, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(wKing, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(46, 46, 46))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel, gridBagConstraints);

        Board.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Chess_Board_gray.png"))); // NOI18N
        Board.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(Board, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

	public void selectPieceAt(int x, int y){
		
		currentPiece = board.boardArray[x][y];
		
		isLabelSelected = true;
		currentLabel = currentPiece.label;
		            
		currentLabel.setBackground(Color.blue);
		currentLabel.setOpaque(true);
	}

	public void deselectPiece(){
		currentPiece.label.setBackground(null);
		currentPiece.label.setOpaque(false);
		
		currentPiece = null;
		currentPiece2 = null;
		isLabelSelected = false;
		currentLabel = null;
		labelBackground = null;
	}

	public void changeTurn(){
		turn = false;
		
		// Set client turn
		try {
		    client.setClientTurn();
		}
		catch (RemoteException ex) {
		    ex.printStackTrace();
		}
	}

	public void gameLogic( java.awt.event.MouseEvent evt ){
        int x = evt.getX() / 75;
        int y = 8 - 1 - evt.getY() / 75;
        
        Location tmp = new Location(x,y);
        
        if( x >= 8 || y >= 8 || x < 0 || y < 0 )
            return;
        
        // If (x,y) has a piece
        if( board.boardArray[x][y] != null ){
        	// If that piece is new
            if( isLabelSelected ){
                
                if( board.boardArray[x][y].getColour() == board.turn ){
                    deselectPiece();
                }
                else{
                    if( currentPiece.validateMove( tmp ) ){
                        currentPiece2 = board.boardArray[x][y];
                        
                        try {
                            client.killRemote( currentPiece.getLocation(), tmp);
                            client.moveRemote( currentPiece.getLocation(), tmp );
                        }
                        catch (RemoteException ex) {
                            ex.printStackTrace();
                        }
                        
                        currentPiece2.kill(currentPiece);
                        currentPiece.makeMove( tmp );

                        changeTurn();
                        deselectPiece();
                    }
                }
            }
            else{
                if( board.boardArray[x][y].getColour() == board.turn ){
                    selectPieceAt(x,y);
                }
            }
        }
        else{
            if( isLabelSelected ){
                
                boolean isMoveValid = false;
                
                switch(currentPiece.getType()){
                    
                    case Constants.PAWN:
                        isMoveValid = ((Pawn)currentPiece).validateMove(new Location(x,y)) ;
                        break;
                        
                    case Constants.QUEEN:
                        isMoveValid = ((Queen)currentPiece).validateMove(new Location(x,y));
                        break;
                        
                    case Constants.BISHOP:
                        isMoveValid = ((Bishop)currentPiece).validateMove(new Location(x,y));
                        break;
                        
                    case Constants.KING:
                        isMoveValid = ((King)currentPiece).validateMove(new Location(x,y));
                        break;
                        
                    case Constants.ROOK:
                        isMoveValid = ((Rook)currentPiece).validateMove(new Location(x,y));
                        break;
                        
                    case Constants.KNIGHT:
                        isMoveValid = ((Knight)currentPiece).validateMove(new Location(x,y));
                        break;
                }
                
                if( isMoveValid ){
                
                	try {
                        client.moveRemote( currentPiece.getLocation(), tmp );
                    }
                    catch (RemoteException ex) {
                        ex.printStackTrace();
                    }
                
                    currentPiece.makeMove( tmp );

                    // Change turns
                    changeTurn();

                    deselectPiece();
                }
            }
        }
	}
    
    private void jPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMouseClicked
        if(turn){
            gameLogic(evt);
        }
        
    }//GEN-LAST:event_jPanelMouseClicke
    
    /**
     * @param args the command line arguments
     */
   public static void main(String args[]) throws Exception{
        
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        obj = new Server();
        ServerMethods serverStub = (ServerMethods) UnicastRemoteObject.exportObject(obj,0);
        String name = "serverStub";
        
        Registry reg = LocateRegistry.getRegistry();
        reg.rebind(name,serverStub);
        
                
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                obj.setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Board;
    private javax.swing.JLabel bBishop1;
    private javax.swing.JLabel bBishop2;
    private javax.swing.JLabel bKing;
    private javax.swing.JLabel bKnight1;
    private javax.swing.JLabel bKnight2;
    private javax.swing.JLabel bPawn1;
    private javax.swing.JLabel bPawn2;
    private javax.swing.JLabel bPawn3;
    private javax.swing.JLabel bPawn4;
    private javax.swing.JLabel bPawn5;
    private javax.swing.JLabel bPawn6;
    private javax.swing.JLabel bPawn7;
    private javax.swing.JLabel bPawn8;
    private javax.swing.JLabel bQueen;
    private javax.swing.JLabel bRook1;
    private javax.swing.JLabel bRook2;
    private javax.swing.JPanel jPanel;
    private javax.swing.JLabel wBishop1;
    private javax.swing.JLabel wBishop2;
    private javax.swing.JLabel wKing;
    private javax.swing.JLabel wKnight1;
    private javax.swing.JLabel wKnight2;
    private javax.swing.JLabel wPawn1;
    private javax.swing.JLabel wPawn2;
    private javax.swing.JLabel wPawn3;
    private javax.swing.JLabel wPawn4;
    private javax.swing.JLabel wPawn5;
    private javax.swing.JLabel wPawn6;
    private javax.swing.JLabel wPawn7;
    private javax.swing.JLabel wPawn8;
    private javax.swing.JLabel wQueen;
    private javax.swing.JLabel wRook1;
    private javax.swing.JLabel wRook2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setServerTurn() throws RemoteException {
        turn = true;
    }

    @Override
    public void startServer() throws RemoteException {
        try {
        
        	turn = true;
        	
            Registry reg = LocateRegistry.getRegistry("localhost");

            String name = "clientStub";
            client = (ClientMethods) reg.lookup(name);

            //System.out.println("Got remote client object");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void moveRemote(Location from, Location to) throws RemoteException {
        int x = to.getX();
        int y = to.getY();
        
        ChessPiece thePiece = board.boardArray[from.getX()][from.getY()];
        
        int boardX = x*75 + thePiece.label.getWidth()/3;
        int boardY = (8-y-1)*75 + thePiece.label.getHeight()/3;

        int oldX = thePiece.pieceLocation.getX();
        int oldY = thePiece.pieceLocation.getY();

        thePiece.pieceLocation.setLocation(x, y);

        thePiece.label.setLocation(boardX, boardY);
        thePiece.label.setBackground(null);
        thePiece.label.setOpaque(false);

        board.boardArray[x][y] = thePiece;
        board.boardArray[oldX][oldY] = null;
    }
    
    @Override
    public void killRemote(Location whome, Location byWhome) throws RemoteException{
        ChessPiece killer = board.boardArray[byWhome.getX()][byWhome.getY()];
        ChessPiece toBeKilled = board.boardArray[whome.getX()][whome.getY()];
        
        killer.kill(toBeKilled);
    }
}
