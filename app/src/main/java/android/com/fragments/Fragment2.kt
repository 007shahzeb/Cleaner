package android.com.fragments
import android.app.Fragment
import android.com.loginwithsiginfirebase.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup



class Fragment2 : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater!!.inflate(R.layout.fragment_fragment2, container, false)
    }

}