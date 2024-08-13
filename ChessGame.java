package chessgame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;  
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Image;




/**
 * 
 *
 * @author Taatheer
 */
public class ChessGame {
    public static LinkedList<Pieces> ps = new LinkedList<>();
    public static Pieces selectedPiece = null;
    public static void main(String[] args) throws IOException  {
        
       
        BufferedImage all = ImageIO.read(new File("C:\\Users\\Taatheer\\Downloads\\chess.png"));
        Image imgs[] = new Image[12];
        int ind = 0;
        for(int y=0;y<400;y+=200){
        for(int x=0;x<1200;x+=200){
            imgs[ind] = all.getSubimage(x,y,200,200).getScaledInstance(64,64,BufferedImage.SCALE_SMOOTH);
        ind++;
        }
        }
        
        Pieces whiteKing = new Pieces(4,7, true, "king",ps);
        Pieces blackKing = new Pieces(4,0, false, "king",ps);
        Pieces whiteRook1 = new Pieces(0,7, true, "rook",ps);
        Pieces whiteRook2 = new Pieces(7,7, true, "rook",ps);
        Pieces blackRook1 = new Pieces(0,0, false, "rook",ps);
        Pieces blackRook2= new Pieces(7,0, false, "rook",ps);
        Pieces blackQueen = new Pieces(3,0, false, "queen",ps);
        Pieces whiteQueen = new Pieces(3,7, true, "queen",ps);
        Pieces blackBishop1 = new Pieces(2,0, false, "bishop",ps);
        Pieces blackBishop2 = new Pieces(5,0, false, "bishop",ps);
        Pieces whiteBishop1 = new Pieces(2,7, true, "bishop",ps);
        Pieces whiteBishop2 = new Pieces(5,7, true, "bishop",ps);
        Pieces blackKnight1 = new Pieces(1,0, false, "knight",ps);
        Pieces blackKnight2 = new Pieces(6,0, false, "knight",ps);
        Pieces whiteKnight1 = new Pieces(1,7, true, "knight",ps);
        Pieces whiteKnight2 = new Pieces(6,7, true, "knight",ps);
        Pieces blackPawn1 = new Pieces(0,1, false, "pawn",ps);
        Pieces blackPawn2 = new Pieces(1,1, false, "pawn",ps);
        Pieces blackPawn3 = new Pieces(2,1, false, "pawn",ps);
        Pieces blackPawn4 = new Pieces(3,1, false, "pawn",ps);
        Pieces blackPawn5 = new Pieces(4,1, false, "pawn",ps);
        Pieces blackPawn6 = new Pieces(5,1, false, "pawn",ps);                   
        Pieces blackPawn7 = new Pieces(6,1, false, "pawn",ps);
        Pieces blackPawn8 = new Pieces(7,1, false, "pawn",ps);
        Pieces whitePawn1 = new Pieces(0,6, true, "pawn",ps);
        Pieces whitePawn2 = new Pieces(1,6, true, "pawn",ps);
        Pieces whitePawn3 = new Pieces(2,6, true, "pawn",ps);
        Pieces whitePawn4 = new Pieces(3,6, true, "pawn",ps);
        Pieces whitePawn5 = new Pieces(4,6, true, "pawn",ps);
        Pieces whitePawn6 = new Pieces(5,6, true, "pawn",ps);                   
        Pieces whitePawn7 = new Pieces(6,6, true, "pawn",ps);
        Pieces whitePawn8 = new Pieces(7,6, true, "pawn",ps);
        
        JFrame frame = new JFrame();
        frame.setBounds(10,10,512,512);
        frame.setUndecorated(true);
        JPanel pn;
        
        pn = new JPanel(){
            @Override
            public void paint(Graphics g){
                boolean white = true;
                
                for(int y = 0; y<8; y++){
                    
                    for(int x = 0; x<8; x++){
                        if(white){
                            g.setColor(new Color(235, 235, 208));
                        }else{
                            g.setColor(new Color (119, 148, 85));
                            
                        }
                        g.fillRect(x*64,y*64,64,64);
                        white =! white;
                    }
                    white =! white;
                }
                for(Pieces p:ps){
                    int ind = 0;
                    if(p.name.equalsIgnoreCase("king")){
                        ind = 0;
                    }
                    if(p.name.equalsIgnoreCase("queen")){
                        ind = 1;
                    }
                    if(p.name.equalsIgnoreCase("bishop")){
                        ind = 2;
                    }
                    if(p.name.equalsIgnoreCase("knight")){
                        ind = 3;
                    }
                    if(p.name.equalsIgnoreCase("rook")){
                        ind = 4;
                    }
                    if(p.name.equalsIgnoreCase("pawn")){
                        ind = 5;
                    }
                    if(!p.isWhite){
                        ind+=6;
                    }
                    g.drawImage(imgs[ind],p.xp*64, p.yp*64,this);
                }                        
            }
        };
        frame.add(pn);
        frame.addMouseMotionListener(new mouseMotionListener(){
            @Override
            public void mouseDragged(MouseEvent e){
                if(selectedPiece!= null){
                    selectedPiece.x = e.getX()-32;
                    selectedPiece.y = e.getY()-32;
                    frame.repaint();
                }
            }
            @Override
            public void mouseMoved(MouseEvent e){
            }
        });
        frame.addMouseListener(new mouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
            }
            @Override
            public void mousePressed(MouseEvent e){
                //System.out.println(getPiece(e.getX(), e.getY()).name);
                selectedPiece = getPiece(e.getX(), e.getY());
            }
            @Override
            public void mouseReleased(MouseEvent e){
                selectedPiece.move(e.getX()/64, e.getY()/64);
                frame.repaint();
            }
            @Override
            public void mouseEntered(MouseEvent e){
            }
            @Override
            public void mouseExited(MouseEvent e){
            }
        });
       
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }
    
    
    private static class mouseListener implements MouseListener {
        
        public mouseListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private static class mouseMotionListener implements MouseMotionListener {

        public mouseMotionListener() {
        }

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }
    public static Pieces getPiece(int x, int y){
        int xp = x/64;
        int yp = y/64;
        
        for(Pieces p:ps){
            if(p.xp==xp && p.yp==yp){
                return p;
            }
        }
        return null;
    }
}
