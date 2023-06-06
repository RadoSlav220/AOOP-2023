import java.util.Random;

public class Coin {
    private Random rand;
    private Face face;

    public Coin(Face face){
        setFace(face);
    }

    public Face getFace() {
        return face;
    }

    public void setFace(Face face) {
        this.face = face != null ? face : Face.HEAD;
    }

    public void flip(){
        if (this.face == Face.HEAD){
            this.face = Face.TAIL;
        }
        else {
            this.face = Face.HEAD;
        }
    }

    public boolean isHeads(){
        return this.face == Face.HEAD;
    }

    @Override
    public String toString() {
        return "Coin with face " + face;
    }
}
