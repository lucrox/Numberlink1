package gloo.numberlink.model;

public class End {

    private final Tag tag;

    public End(Tag tag) {
        this.tag = tag;
    }

    public Tag getTag() {
        return tag;
    }

    public String getLabel() {
        return tag.getLabel();
    }

    public Path createNewPath() {
        return this.tag.createNewPath();
    }

}