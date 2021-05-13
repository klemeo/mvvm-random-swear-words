package ru.android.randomswearwords.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.android.randomswearwords.R
import ru.android.randomswearwords.databinding.FragmentHomeBinding
import ru.android.randomswearwords.presentation.HomeContract
import ru.android.randomswearwords.presentation.sealed.WordVS

class HomeFragment : Fragment(), HomeContract {

    private val viewModel: HomeViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeViewModel()
    }

    private fun initView() {
        viewModel.getWord()
        buttonNext.setOnClickListener {
            textView.isVisible = false
            commentView.isVisible = false
            viewModel.getWord()
        }

        selectedLanguage.setOnClickListener {
            val dialog = DialogListChoice()
            val manager = childFragmentManager
            dialog.show(manager, "dialogChoice")
        }

    }

    private fun observeViewModel() {

        viewModel.viewState.observe(viewLifecycleOwner, {
            when (it) {
                is WordVS.Post -> {

                    textView.text = it.postVM.insult
                    commentView.text =
                        if (it.postVM.comment == "") "No comment" else it.postVM.comment

                }
                is WordVS.ShowLoader -> {
                    if (it.showLoader) {
                        pbPost.visibility = View.VISIBLE
                        commentPost.visibility = View.VISIBLE
                    } else {
                        textView.isVisible = true
                        commentView.isVisible = true
                        pbPost.visibility = View.GONE
                        commentPost.visibility = View.GONE
                    }
                    Log.i("ShowLoader", it.showLoader.toString())
                }
                is WordVS.Error -> {
                    it.message?.let { message -> Log.i("Error", message) }
                }
            }
        })
    }

    override fun language(item: String) {
        selectedLanguage.text = item
        viewModel.language = item
        viewModel.getWord()
    }

}