package space.lobanovi.m3_hw8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import space.lobanovi.m3_hw8.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {


    lateinit var binding: FragmentSecondBinding

    private val args : SecondFragmentArgs by navArgs()
    private var name =""
    private var age =""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name = args.tittle
        age=args.message

        binding.detail.text = name
        binding.txtDes.text=age


        val button = binding.addBtn
        button.setOnClickListener {
            findNavController().navigate(R.id.firstFragment)
        }
    }
}