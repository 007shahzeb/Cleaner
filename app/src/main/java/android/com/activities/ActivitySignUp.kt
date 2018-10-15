package android.com.activities

import android.com.loginwithsiginfirebase.R
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*
import com.wajahatkarim3.easyvalidation.core.view_ktx.validator

class ActivitySignUp : AppCompatActivity(), View.OnClickListener {

// https://androidexample365.com/a-text-and-input-validation-library-in-kotlin-for-android/
    // https://wajahatkarim.gitbook.io/easyvalidation/usage/validation-using-extension-methods

    var backArrowImage: ImageView? = null
    var edName: EditText? = null
    var edEmail: EditText? = null
    var edPassword: EditText? = null
    var edPhoneNumber: EditText? = null
    var edAddress: EditText? = null
    var edCity: EditText? = null
    var spinnerStates: Spinner? = null
    var edZipCode: EditText? = null
    var SignUpBtn: Button? = null
    var tvAlreadyMember: TextView? = null


    var name: String = ""
    var email: String = ""
    var password: String = ""
    var phone_number: String = ""
    var address: String = ""
    var city: String = ""
    var zip_code: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)



        findingIdsHere()
        eventListener()


    }

    private fun eventListener() {

        backArrowImage?.setOnClickListener(this)
        SignUpBtn?.setOnClickListener(this)
        tvAlreadyMember?.setOnClickListener(this)

    }

    private fun findingIdsHere() {

        backArrowImage = findViewById(R.id.backArrowImage) as ImageView
        edName = findViewById(R.id.edName) as EditText
        edEmail = findViewById(R.id.edEmail) as EditText

        edPassword = findViewById(R.id.edPassword) as EditText
        edPhoneNumber = findViewById(R.id.edPhoneNumber) as EditText

        edAddress = findViewById(R.id.edAddress) as EditText
        edCity = findViewById(R.id.edCity) as EditText

        spinnerStates = findViewById(R.id.spinnerStates) as Spinner
        edZipCode = findViewById(R.id.edZipCode) as EditText

        SignUpBtn = findViewById(R.id.SignUpBtn) as Button
        tvAlreadyMember = findViewById(R.id.tvAlreadyMember) as TextView

    }


    override fun onClick(v: View?) {


        when (v?.id) {


            R.id.backArrowImage -> {
                finish()
            }

            R.id.SignUpBtn -> {


                loginSuccess()


            }

            R.id.tvAlreadyMember -> {

                startActivity(Intent(this, ActivitySiginIn::class.java))

            }


        }


    }

    private fun loginSuccess() {


        name = edName!!.text.toString()
        email = edEmail!!.text.toString()
        password = edPassword!!.text.toString()
        phone_number = edPhoneNumber!!.text.toString()
        address = edAddress!!.text.toString()
        city = edCity!!.text.toString()
        zip_code = edZipCode!!.text.toString()


        validationForFeilds()


    }

    private fun validationForFeilds() {

        name.validator()
                .nonEmpty()
                .addErrorCallback {
                    edName!!.error = it
                    // it will contain the right message.
                    // For example, if edit text is empty,
                    // then 'it' will show "Can't be Empty" message
                }
                .addSuccessCallback {
                    validationSuccess()
                    // call Login webservice here or anything else for success usecase
                }
                .check()

        email.validator()
                .nonEmpty()
                .validEmail()
                .addErrorCallback {
                    edEmail!!.error = it
                    // it will contain the right message.
                    // For example, if edit text is empty,
                    // then 'it' will show "Can't be Empty" message
                }
                .addSuccessCallback {
                    validationSuccess()
                    // call Login webservice here or anything else for success usecase
                }
                .check()

        password.validator()
                .nonEmpty()
                .atleastOneNumber()
                .atleastOneSpecialCharacters()
                .atleastOneUpperCase()
                .addErrorCallback {
                    edPassword!!.error = it
                    // it will contain the right message.
                    // For example, if edit text is empty,
                    // then 'it' will show "Can't be Empty" message
                }
                .addSuccessCallback {
                    validationSuccess()
                    // call Login webservice here or anything else for success usecase
                }
                .check()


        phone_number.validator()
                .nonEmpty()
                .addErrorCallback {
                    edPhoneNumber!!.error = it
                    // it will contain the right message.
                    // For example, if edit text is empty,
                    // then 'it' will show "Can't be Empty" message
                }
                .addSuccessCallback {
                    validationSuccess()
                    // call Login webservice here or anything else for success usecase
                }
                .check()



        address.validator()
                .nonEmpty()
                .addErrorCallback {
                    edAddress!!.error = it
                    // it will contain the right message.
                    // For example, if edit text is empty,
                    // then 'it' will show "Can't be Empty" message
                }
                .addSuccessCallback {
                    validationSuccess()
                    // call Login webservice here or anything else for success usecase
                }
                .check()



        city.validator()
                .nonEmpty()
                .addErrorCallback {
                    edCity!!.error = it
                    // it will contain the right message.
                    // For example, if edit text is empty,
                    // then 'it' will show "Can't be Empty" message
                }
                .addSuccessCallback {
                    validationSuccess()
                    // call Login webservice here or anything else for success usecase
                }
                .check()



        zip_code.validator()
                .nonEmpty()
                .addErrorCallback {
                    edZipCode!!.error = it
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


        startActivity(Intent(this, DashboardActivity::class.java))
        Toast.makeText(applicationContext, "Signinup success", Toast.LENGTH_LONG).show()

    }


}