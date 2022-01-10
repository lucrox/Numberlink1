package gloo.numberlink;

public class Tag {

    private final int label;

    public Tag(int label) {
        this.label = label;
    }

    public String toString() {
        return Integer.toString(this.label);
    }

    public Path createNewPath(){
        return new Path(this);
    }
}
