package com.example.amolgursali.kotlinvolley.GetSet

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by AmolGursali on 11/10/2017.
 */
class MobileDetails() : Parcelable
{
    var rom : String?=null
    var screenSize : String?=null
    var backCamera : String?=null
    var companyName : String?=null
    var name : String?=null
    var frontCamera : String?=null
    var battery : String?=null
    var operatingSystem : String?=null
    var processor : String?=null
    var url : String?=null
    var ram : String?=null

    get() = field

    set(value) {
        field=value
    }

    constructor(parcel: Parcel) : this() {
        rom = parcel.readString()
        screenSize = parcel.readString()
        backCamera = parcel.readString()
        companyName = parcel.readString()
        name = parcel.readString()
        frontCamera = parcel.readString()
        battery = parcel.readString()
        operatingSystem = parcel.readString()
        processor = parcel.readString()
        url = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(rom)
        parcel.writeString(screenSize)
        parcel.writeString(backCamera)
        parcel.writeString(companyName)
        parcel.writeString(name)
        parcel.writeString(frontCamera)
        parcel.writeString(battery)
        parcel.writeString(operatingSystem)
        parcel.writeString(processor)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MobileDetails> {
        override fun createFromParcel(parcel: Parcel): MobileDetails {
            return MobileDetails(parcel)
        }

        override fun newArray(size: Int): Array<MobileDetails?> {
            return arrayOfNulls(size)
        }
    }
}