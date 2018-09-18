package uk.co.victoriajanedavis.shopify_challenge.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Product implements Parcelable {

    @SerializedName("id") @Expose private long id;
    @SerializedName("title") @Expose private String title;
    @SerializedName("tags") @Expose private String tagsString;
    @SerializedName("variants") @Expose private List<Variant> variants;
    @SerializedName("image") @Expose private Image image;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTagsString() {
        return tagsString;
    }

    public void setTagsString(String tagsString) {
        this.tagsString = tagsString;
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.title);
        dest.writeString(this.tagsString);
        dest.writeList(this.variants);
        dest.writeParcelable(this.image, flags);
    }

    protected Product(Parcel in) {
        this.id = in.readLong();
        this.title = in.readString();
        this.tagsString = in.readString();
        this.variants = new ArrayList<>();
        in.readList(this.variants, Variant.class.getClassLoader());
        this.image = in.readParcelable(Image.class.getClassLoader());
    }

    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
