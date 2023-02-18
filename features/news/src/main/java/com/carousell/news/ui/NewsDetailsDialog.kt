package com.carousell.news.ui

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.carousell.domain.model.NewsArticle
import com.carousell.news.R
import com.carousell.news.databinding.FragmentDialogNewsDetailsBinding

class NewsDetailsDialog : DialogFragment() {
    private var mBinding: FragmentDialogNewsDetailsBinding? = null
    private val binding: FragmentDialogNewsDetailsBinding
        get() = mBinding!!
    private var newsArticle: NewsArticle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            if (it.containsKey("DATA")) {
                newsArticle = it.getParcelable("DATA")
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentDialogNewsDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setCancelable(true)
        return dialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        mBinding?.tvDescription?.text = newsArticle?.description
        Glide.with(requireContext()).load(newsArticle?.banner_url)
            .placeholder(R.drawable.no_image_error)
            .fallback(R.drawable.no_image_error)
            .into(binding.ivImage)
    }
}