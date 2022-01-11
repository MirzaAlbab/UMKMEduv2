package com.androiddevs.mvvmnewsapp.ui.fragments
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.androiddevs.mvvmnewsapp.R
import android.content.Intent

import android.view.ViewGroup

import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import com.androiddevs.mvvmnewsapp.ui.LoginActivity


class ProfileFragment : Fragment(com.androiddevs.mvvmnewsapp.R.layout.fragment_profile) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        val logout: Button = rootView.findViewById(R.id.Tombol) as Button;
        logout.setOnClickListener {
            val alertDialog = AlertDialog.Builder(requireContext()).create()
            alertDialog.setTitle("Logout")
            alertDialog.setMessage("Anda yakin ingin keluar?")

            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes"
            ) { dialog, which -> val intent = Intent(getActivity(), LoginActivity::class.java)
                // start your next activity
                startActivity(intent) }

            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No"
            ) { dialog, which -> dialog.dismiss() }
            alertDialog.show()

        }
        return rootView
    }
}