package com.example.customdialoginfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_dialog_fragment.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openDialog.setOnClickListener {
            val dialog = LayoutInflater.from(this).inflate(R.layout.custom_dialog_fragment, null)

            val mBuilder = AlertDialog.Builder(this)
                .setView(dialog)
                .setTitle("Login Form")

            val mAlertDialog = mBuilder.show()

            fun someFunction(somecallback:sumeCallback){
                var name = dialog.DialogName.text.toString()
                var Email = dialog.DialogEmail.text.toString()
                var password = dialog.DialogPassword.text.toString()

               somecallback.datapass()

                mainInfo.setText("Name :" + name +"\nEmail :"+ Email + "\nPassword :" + password)


            }



            dialog.DialogLogin.setOnClickListener {
                mAlertDialog.dismiss()

                someFunction(object : sumeCallback{
                    override fun datapass() {
                        val myToast = Toast.makeText(applicationContext,"Ruchira Bandara",Toast.LENGTH_LONG)
                        myToast.show()
                    }
                })

            }

            dialog.DialogCancel.setOnClickListener {
                mAlertDialog.dismiss()
            }






        }
    }
    interface sumeCallback{

        fun datapass()
    }
}