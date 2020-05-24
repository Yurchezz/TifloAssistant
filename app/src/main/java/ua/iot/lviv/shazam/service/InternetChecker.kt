package ua.iot.lviv.shazam.service

import java.net.InetAddress

class InternetChecker {
    companion object{
       fun isInternetAvaliable(): Boolean{
            return try {
                val ipAddr: InetAddress = InetAddress.getByName("google.com")
                !ipAddr.equals("")
            } catch (e: Exception) {
                false
            }
        }
    }
}