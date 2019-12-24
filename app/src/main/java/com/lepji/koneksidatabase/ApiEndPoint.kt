package com.lepji.koneksidatabase

class ApiEndPoint {
    companion object{
        private val SERVER = "http://10.0.2.2/univ/"
        val SELECT : String = SERVER + "select.php"
        val INSERT : String = SERVER + "insert.php"
    }
}