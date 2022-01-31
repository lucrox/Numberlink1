package gloo.numberlink.model;

public record End(Tag tag) {

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