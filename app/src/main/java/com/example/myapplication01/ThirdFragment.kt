package com.example.myapplication01

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myapplication01.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val b: FragmentThirdBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_third, container, false)

        //checking safe args is working
//        //getting safe arguments from previous fragment
//        val args = ThirdFragmentArgs.fromBundle(requireArguments())
//        //making a toast to make sure we the safe arguments
//        Toast.makeText(
//            context,
//            "Pussy num: ${args.numOfPussy}, tzbar: ${args.numOfZobr}",
//            Toast.LENGTH_LONG
//        ).show()
        //end checking

        setHasOptionsMenu(true)


        return b.root
    }// end of main()

    // 4 functions for sharing arguments from menu
    private fun getShareIntent(): Intent {
        val args = ThirdFragmentArgs.fromBundle(requireArguments())
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, args.numOfRAM.toString())
        //to get String resource getString(R.string.share_success_text, args.numOfRAM, args.numOfVGA)
        return shareIntent
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share_menu, menu)
        // check if the activity resolves
//        if (null == getShareIntent().resolveActivity(requireActivity().packageManager)) {
//            // hide the menu item if it doesn't resolve
//            menu.findItem(R.id.share)?.isVisible = false
//        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> startActivity(getShareIntent())
        }
        return super.onOptionsItemSelected(item)
    }

}
