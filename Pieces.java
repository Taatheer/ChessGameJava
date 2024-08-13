/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chessgame;

import java.util.LinkedList;
/**
 *
 * @author Taatheer
 */
public class Pieces {
    int xp;
    int yp;
    int x;
    int y;
    boolean isWhite;
    LinkedList<Pieces> ps;
    String name;
    public Pieces(int xp, int yp, boolean isWhite, String n, LinkedList<Pieces> ps){
        this.xp = xp;
        this.yp = yp;
        x = xp*64;
        y = yp*64;
        this.isWhite = isWhite;
        this.ps = ps;
        ps.add(this);
        name = n;
       
    }
    public void move(int xp, int yp){
        if(ChessGame.getPiece(xp*64,yp*64)!= null){
            if(ChessGame.getPiece(xp*64, yp*64).isWhite!=isWhite){
                ChessGame.getPiece(xp*64, yp*64).kill(xp*64,yp*64);
            }else{
                x = this.xp*64;    
        y = this.yp*64;
            return;
            }
        }
        this.xp = xp;
        this.yp = yp;
        x = xp*64;
        y = yp*64;
           
    }
    
    public void kill(int xp, int yp){
        ps.remove(this);
    }
    
}
