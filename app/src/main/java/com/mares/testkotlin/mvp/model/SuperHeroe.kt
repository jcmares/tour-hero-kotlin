package com.mares.testkotlin.mvp.model


import android.os.Parcel
import android.os.Parcelable
import androidx.databinding.BaseObservable

class SuperHeroe ( var name : String ,
                   var photo : String ,
                   var realName : String ,
                   var height : String ,
                   var power : String ,
                   var abilities : String ,
                   var groups : String)
    : BaseObservable(), Parcelable  {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun toString(): String {
        return "SuperHeroe(name='$name', photo='$photo', realName='$realName', height='$height', power='$power', abilities='$abilities', groups='$groups')"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(photo)
        parcel.writeString(realName)
        parcel.writeString(height)
        parcel.writeString(power)
        parcel.writeString(abilities)
        parcel.writeString(groups)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SuperHeroe> {
        override fun createFromParcel(parcel: Parcel): SuperHeroe {
            return SuperHeroe(parcel)
        }

        override fun newArray(size: Int): Array<SuperHeroe?> {
            return arrayOfNulls(size)
        }
    }
}

