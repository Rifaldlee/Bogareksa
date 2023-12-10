package com.bogareksa.sessions

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.datastore.core.DataStore
import com.bogareksa.ui.auth.LoginActivity
import java.util.prefs.Preferences




class LoginSession {
    lateinit var pref : SharedPreferences
    lateinit var editor : SharedPreferences.Editor
    lateinit var con : Context
    var PRIVATEMODE : Int = 0


    constructor(ctx : Context){
        this.con = ctx
        pref = ctx.getSharedPreferences(PREF_NAME,PRIVATEMODE)
        editor = pref.edit()
    }

    companion object{
        @Volatile
        private var INSTANCE: LoginSession? = null

        val PREF_NAME = "Login_Preference"
        val IS_LOGIN = "isLoggedin"
        val KEY_PASSWORD = "password"
        val KEY_EMAIL = "email"

    }

    fun createLoginSession(email: String,pass:String){
        editor.putBoolean(IS_LOGIN,true)
        editor.putString(KEY_EMAIL,email)
        editor.putString(KEY_PASSWORD,pass)
        editor.commit()
    }

    fun loginCheck(){
        if(!this.isLoggedin()){
            var itn : Intent = Intent(con,LoginActivity::class.java)
            itn.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            itn.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            con.startActivity(itn)
        }
    }

    fun getUserProduct():HashMap<String,String>{
        var user : Map<String,String> = HashMap<String,String>()
        (user as HashMap).put(KEY_EMAIL,pref.getString(KEY_EMAIL,null)!!)
        (user as HashMap).put(KEY_PASSWORD,pref.getString(KEY_PASSWORD,null)!!)
        return  user
    }

    fun isLoggedin() : Boolean{
        return pref.getBoolean(IS_LOGIN,false)
    }


}