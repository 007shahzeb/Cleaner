package android.com.activities

import android.com.loginwithsiginfirebase.R
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.wajahatkarim3.easyvalidation.core.view_ktx.validator

class ActivityForgetPassword : AppCompatActivity(), View.OnClickListener {

    var edForgetPassword: EditText? = null
    var btnSend: Button? = null

    var forgetPassword: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)



        findingIdsHere()
        eventListener()


    }

    private fun eventListener() {

        btnSend!!.setOnClickListener(this)
    }

    private fun findingIdsHere() {

        edForgetPassword = findViewById(R.id.edForgetPassword) as EditText
        btnSend = findViewById(R.id.btnSend) as Button

    }

    override fun onClick(v: View?) {


        when (v?.id) {

            R.id.btnSend -> {

                LoginSuccess()

            }

        }


    }

    private fun LoginSuccess() {

        forgetPassword = edForgetPassword?.text.toString()


        forgetPassword.validator()
                .nonEmpty()
                .validEmail()
                .addErrorCallback {
                    edForgetPassword!!.error = it
                    // it will contain the right message.
                    // For example, if edit text is empty,
                    // then 'it' will show "Can't be Empty" message
                }
                .addSuccessCallback {
                    validationSuccess()
                    // call Login webservice here or anything else for success usecase
                }
                .check()


    }

    private fun validationSuccess() {
        Toast.makeText(applicationContext, "Forget Password", Toast.LENGTH_LONG).show()

    }


}