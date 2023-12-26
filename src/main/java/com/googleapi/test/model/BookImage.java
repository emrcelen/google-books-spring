package com.googleapi.test.model;

public class BookImage {
    private String smallThumbnail;
    private String thumbnail;

    public BookImage(Builder builder){
        this.smallThumbnail = builder.smallThumbnail;
        this.thumbnail = builder.thumbnail;
    }

    //Getter:
    public String getSmallThumbnail() {
        return smallThumbnail;
    }
    public String getThumbnail() {
        return thumbnail;
    }

    public static class Builder{
        private String smallThumbnail;
        private String thumbnail;

        public Builder smallThumbnail (String smallThumbnail){
            this.smallThumbnail = smallThumbnail;
            return this;
        }
        public Builder thumbnail (String thumbnail){
            this.thumbnail = thumbnail;
            return this;
        }
        public BookImage build(){
            return new BookImage(this);
        }
    }
}
