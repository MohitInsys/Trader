package com.example.newsjpc.screen

import com.example.newsjpc.ImageModel
import com.example.newsjpc.R

data class Profile(val profileImage:Int,val name:String)

fun ProfileList():List<Profile>{
    val profileList= mutableListOf<Profile>()
    profileList.add(Profile(R.drawable.profile1,"Andrew"))
    profileList.add(Profile(R.drawable.profile2,"Nelson"))
    profileList.add(Profile(R.drawable.profile3,"Brew"))
    profileList.add(Profile(R.drawable.profile4,"Lincon"))
    profileList.add(Profile(R.drawable.profile5,"Peter"))
    profileList.add(Profile(R.drawable.profile6,"Narender"))
    profileList.add(Profile(R.drawable.profile7,"Alex"))
    profileList.add(Profile(R.drawable.profile8,"Adarsh"))
    profileList.add(Profile(R.drawable.profile9,"Johnson"))
    profileList.add(Profile(R.drawable.profile10,"Drew"))

return profileList
}

