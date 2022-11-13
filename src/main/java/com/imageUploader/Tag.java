package com.imageUploader;

public class Tag {
    private String label;

    public Tag(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Tags{" +
                "label='" + label + '\'' +
                '}';
    }
}
