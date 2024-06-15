package com.example.flearns.ui.home.views

import android.media.AudioManager
import android.media.SoundPool
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.flearns.R
import com.example.flearns.databinding.FragmentHomeBinding
import com.example.flearns.domain.model.CategoryModel
import com.example.flearns.domain.model.CategoryResult
import com.example.flearns.domain.model.ConstantGeneral.Companion.CODE
import com.example.flearns.domain.model.ConstantGeneral.Companion.FIVE
import com.example.flearns.domain.model.ConstantGeneral.Companion.FOUR
import com.example.flearns.domain.model.ConstantGeneral.Companion.ONE
import com.example.flearns.domain.model.ConstantGeneral.Companion.THREE
import com.example.flearns.domain.model.ConstantGeneral.Companion.TWO
import com.example.flearns.domain.model.ConstantGeneral.Companion.VOLUM
import com.example.flearns.ui.home.viewmodel.CategoryClassViewModel
import com.example.flearns.ui.home.views.adapter.CategoryClassAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment (
    private var user:String?
): Fragment() {

    private var binding: FragmentHomeBinding? = null
    private val catClassViewModel: CategoryClassViewModel by viewModels()
    private var spAbc:SoundPool? = null
    private var sp123:SoundPool? = null
    private var spAnimals:SoundPool? = null
    private var spFood:SoundPool? = null
    private var spMeal:SoundPool? = null
    private var idCat:Int = CODE.toInt()
    private var playsSoundAbc:Int = CODE.toInt()
    private var playsSound123:Int = CODE.toInt()
    private var playsSoundAnimals:Int = CODE.toInt()
    private var playsSoundFood:Int = CODE.toInt()
    private var playsSoundMael:Int = CODE.toInt()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private val categoryObserver = Observer<CategoryResult> { result ->
        if (result.isSuccess) {
            result.category?.let {
                val adapter = CategoryClassAdapter(
                    it,
                    onItemClickListener,
                    requireContext()
                )
                binding?.recyclerview?.adapter = adapter
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(LayoutInflater.from(context),null, false)

        binding?.userName?.text = getText(R.string.msg_welcome).toString() + " " +  user

        initPlaySoundList()
        initRecycler()
        initObserver()
        catClassViewModel.getAllCatClass()

        return binding?.root
    }

    private fun initPlaySoundList(){

        spAbc = SoundPool(ONE,AudioManager.STREAM_MUSIC,ONE)
        sp123 = SoundPool(ONE,AudioManager.STREAM_MUSIC,ONE)
        spAnimals = SoundPool(ONE,AudioManager.STREAM_MUSIC,ONE)
        spFood = SoundPool(ONE,AudioManager.STREAM_MUSIC,ONE)
        spMeal = SoundPool(ONE,AudioManager.STREAM_MUSIC,ONE)

        playsSoundAbc = spAbc!!.load(context,R.raw.abecedario ,ONE )
        playsSound123 = sp123!!.load(context,R.raw.numbers ,ONE )
        playsSoundAnimals = spAnimals!!.load(context,R.raw.animals ,ONE )
        playsSoundFood = spFood!!.load(context,R.raw.food ,ONE )
        playsSoundMael = spMeal!!.load(context,R.raw.meal ,ONE )
    }

    private fun initRecycler() {
        val linearLayoutManager =  GridLayoutManager(requireContext(), TWO)
        binding?.recyclerview?.apply {
            layoutManager = linearLayoutManager
            isNestedScrollingEnabled = false
            setHasFixedSize(true)
        }
    }

    private fun initObserver() {
        catClassViewModel.categoryResultObserver.observe(viewLifecycleOwner, categoryObserver)
    }

    private var onItemClickListener:((categoryModel: CategoryModel, sound:String) -> Unit) = { category , soundR ->

        if(soundR == CODE){
            idCat = category.id

           when(idCat){
               ONE -> { playsSoundPool(spAbc, playsSoundAbc)}
               TWO -> { playsSoundPool(sp123, playsSound123)}
               THREE-> { playsSoundPool(spAnimals, playsSoundAnimals)}
               FOUR-> { playsSoundPool(spMeal, playsSoundMael)}
               FIVE -> { playsSoundPool(spFood, playsSoundFood)}
            }
        }else{
            Toast.makeText(context,category.name,Toast.LENGTH_SHORT).show()
        }
    }

    private fun playsSoundPool(sp:SoundPool?, playsSound :Int){
        sp?.play(playsSound,VOLUM,VOLUM,ONE ,CODE.toInt(),VOLUM)
    }

    companion object {

        @JvmStatic
        fun newInstance(user:String?) : HomeFragment {
            return HomeFragment(user)
        }
    }
}