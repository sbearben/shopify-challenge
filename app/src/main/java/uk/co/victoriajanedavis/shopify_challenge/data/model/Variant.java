package uk.co.victoriajanedavis.shopify_challenge.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Variant implements Parcelable {

    @SerializedName("id") @Expose private long id;
    @SerializedName("product_id") @Expose private long productId;
    @SerializedName("inventory_quantity") @Expose private int inventoryQuantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(int inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeLong(this.productId);
        dest.writeInt(this.inventoryQuantity);
    }

    protected Variant(Parcel in) {
        this.id = in.readLong();
        this.productId = in.readLong();
        this.inventoryQuantity = in.readInt();
    }

    public static final Parcelable.Creator<Variant> CREATOR = new Parcelable.Creator<Variant>() {
        @Override
        public Variant createFromParcel(Parcel source) {
            return new Variant(source);
        }

        @Override
        public Variant[] newArray(int size) {
            return new Variant[size];
        }
    };
}
