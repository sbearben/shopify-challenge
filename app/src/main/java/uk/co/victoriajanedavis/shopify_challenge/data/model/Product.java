package uk.co.victoriajanedavis.shopify_challenge.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Product implements Parcelable {

    @SerializedName("id") @Expose private long id;
    @SerializedName("title") @Expose private String title;
    @SerializedName("vendor") @Expose private String vendor;
    @SerializedName("product_type") @Expose private String productType;
    @SerializedName("created_at") @Expose private Date createdAt;
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

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
        dest.writeString(this.vendor);
        dest.writeString(this.productType);
        dest.writeLong(this.createdAt.getTime());
        dest.writeString(this.tagsString);
        dest.writeList(this.variants);
        dest.writeParcelable(this.image, flags);
    }

    protected Product(Parcel in) {
        this.id = in.readLong();
        this.title = in.readString();
        this.vendor = in.readString();
        this.productType = in.readString();
        this.createdAt = new Date(in.readLong());
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
