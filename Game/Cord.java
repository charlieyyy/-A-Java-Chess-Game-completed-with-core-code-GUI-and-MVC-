package Game;

public class Cord {


    private int rank, file;

    /*
    default constructor
     */
    public Cord(){
        rank = 0;
        file = 0;
    }

    /*
    constructor
     */
    public Cord(int i, int j){
        rank = i;
        file = j;
    }

    public void setCord(int i, int j){
        rank = i;
        file = j;
    }

    public int getRank(){
        return rank;
    }

    public int getFile(){
        return file;
    }


}
