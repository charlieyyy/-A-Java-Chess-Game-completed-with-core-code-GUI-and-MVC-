package Game;

public class Knight extends Piece{

    public Knight(int plr,Board brd,Cord crd){
        super(plr,brd,crd);
    }


    @Override
    /*
    Two squares vertically and one square horizontally
    One squares vertically and two square horizontally
     */
    public boolean move(int rows, int cols) {
        int curRank = this.getCrd().getRank();
        int curFile = this.getCrd().getFile();

        boolean shapeL1= (Math.abs(curFile-cols)==2) && (Math.abs(curRank-rows)==1);
        boolean shapeL2= (Math.abs(curFile-cols)==1) && (Math.abs(curRank-rows)==2);

        return boundary(rows,cols) && (shapeL1 || shapeL2);

    }

}
