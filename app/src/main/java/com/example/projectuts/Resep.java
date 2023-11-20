package com.example.projectuts;

import android.os.Parcel;
import android.os.Parcelable;

public class Resep implements Parcelable {
    private String Judul;
    private String Description;
    private int img;

    public Resep(String judul, String description, int img) {
        Judul = judul;
        Description = description;
        this.img = img;
    }

    public String getJudul() {
        return Judul;
    }

    public String getDescription() {
        return Description;
    }

    public void setJudul(String judul) {
        Judul = judul;
    }

    public void setDescription(String description) {
        Judul = description;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    // Parcelable implementation
    protected Resep(Parcel in) {
        Judul = in.readString();
        Description = in.readString();
        img = in.readInt();
    }

    public static final Creator<Resep> CREATOR = new Creator<Resep>() {
        @Override
        public Resep createFromParcel(Parcel in) {
            return new Resep(in);
        }

        @Override
        public Resep[] newArray(int size) {
            return new Resep[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Judul);
        dest.writeString(Description);
        dest.writeInt(img);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
