package android.com.activities

import android.app.Activity
import android.app.ProgressDialog
import android.com.loginwithsiginfirebase.R
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*


class ActivitySiginIn : AppCompatActivity(), View.OnClickListener {


    var edEmailPhone: EditText? = null
    var edPassword: EditText? = null
    var chKeemMeLoggedIn: CheckBox? = null
    var loginBtn: Button? = null
    var tvForgetPass: TextView? = null
    var btnDontHave: Button? = null

    var backArrowImage: ImageView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)


        findingIdsHere()
        eventListner();


    }

    private fun eventListner() {

        loginBtn?.setOnClickListener(this)
        tvForgetPass?.setOnClickListener(this)
        btnDontHave?.setOnClickListener(this)
        backArrowImage?.setOnClickListener(this)
    }

    private fun findingIdsHere() {

        edEmailPhone = findViewById(R.id.edEmailPhone) as EditText
        edPassword = findViewById(R.id.edPassword) as EditText

        chKeemMeLoggedIn = findViewById(R.id.chKeemMeLoggedIn) as CheckBox
        loginBtn = findViewById(R.id.loginBtn) as Button
        tvForgetPass = findViewById(R.id.tvForgetPass) as TextView
        btnDontHave = findViewById(R.id.btnDontHave) as Button


    }


    override fun onClick(v: View?) {

        when (v?.id) {

            R.id.loginBtn -> {

                login()
            }

            R.id.tvForgetPass -> {
                startActivity(Intent(this, ActivityForgetPassword::class.java))
            }

            R.id.btnDontHave -> {
                startActivity(Intent(this, ActivitySignUp::class.java))
            }

            R.id.backArrowImage -> {
                finish()
            }

            else -> {

                Toast.makeText(applicationContext, "Else case", Toast.LENGTH_LONG).show()

            }
        }

    }

    private fun login() {


        if (!validate()) {
            onLoginFailed()
            return
        }

        loginBtn!!.isEnabled = false

        val progressDialog = ProgressDialog(this@ActivitySiginIn,
                R.style.AppTheme_Dark_Dialog)
        progressDialog.isIndeterminate = true
        progressDialog.setMessage("Login...")
        progressDialog.show()

        val email = edEmailPhone!!.text.toString()
        val password = edPassword!!.text.toString()


        android.os.Handler().postDelayed(
                {
                    onLoginSuccess()
                    progressDialog.dismiss()
                }, 3000)

    }

    private fun onLoginSuccess() {

        loginBtn!!.isEnabled = true
        startActivity(Intent(this, DashboardActivity::class.java))

    }


    private fun onLoginFailed() {

        Toast.makeText(baseContext, "Login failed", Toast.LENGTH_LONG).show()
        loginBtn!!.isEnabled = true

    }


    fun validate(): Boolean {

        var valid = true

        val email = edEmailPhone!!.text.toString()
        val password = edPassword!!.text.toString()

        if (email.isEmpty()) { // || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
            edEmailPhone!!.error = "enter a email address  or phone number"
            valid = false
        } else {
            edEmailPhone!!.error = null
        }

        if (password.isEmpty() || password.length < 4 || password.length > 10) {
            edPassword!!.error = "between 4 and 10 alphanumeric characters"
            valid = false
        } else {
            edPassword!!.error = null
        }

        return valid
    }

    companion object {
        private val TAG = "LoginActivity"
        private val REQUEST_SIGNUP = 0
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == Activity.RESULT_OK) {
                this.finish()
            }
        }
    }

    override fun onBackPressed() {
//        moveTaskToBack(true)

        finish()
    }

}


