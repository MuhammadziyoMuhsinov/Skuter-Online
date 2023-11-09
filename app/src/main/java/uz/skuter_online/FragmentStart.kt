package uz.skuter_online

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import uz.skuter_online.databinding.FragmentStartBinding
import uz.skuter_online.databinding.InfoLayoutBinding


class FragmentStart : Fragment() {


   private lateinit var binding:FragmentStartBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater)

        binding.btnSotibOlish.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentStart_to_fragmentMain)
        }
        binding.btnXamkorlar.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentStart_to_fragmentHamkorlar)
        }
        binding.imgTelegram.setOnClickListener {
            val group_telegram = Intent (ACTION_VIEW, Uri.parse("https://t.me/skuter_uz1"))
            startActivity(group_telegram)
        }
        binding.imgInstagram.setOnClickListener {
            val group_instagram = Intent (ACTION_VIEW, Uri.parse("https://www.instagram.com/skuter.uz.rasmiy/?igshid=OGQ5ZDc2ODk2ZA%3D%3D"))
            startActivity(group_instagram)
        }
        binding.imgYoutube.setOnClickListener {
            val group_youtube = Intent (ACTION_VIEW, Uri.parse("https://www.youtube.com/@Skuteruz"))
            startActivity(group_youtube)
        }
        binding.info.setOnClickListener {
        val alertDialog = AlertDialog.Builder(binding.root.context,R.style.NewDialog).create()
            val itemDialog = InfoLayoutBinding.inflate(layoutInflater)
            itemDialog.close.setOnClickListener {
                alertDialog.dismiss()
            }
            alertDialog.setView(itemDialog.root)
            alertDialog.setOnDismissListener {
                binding.xira.isVisible = false
            }
            binding.xira.isVisible = true
            alertDialog.show()
        }




        return binding.root

    }

}