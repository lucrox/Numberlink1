package gloo.numberlink;

public class End {
    private Tag tag;

    public End(Tag tag){
        this.tag = tag;
    }

    public Tag getTag() {
        return tag;
    }

    public Path createNewPath() {
        return this.tag.createNewPath();
    }

}
