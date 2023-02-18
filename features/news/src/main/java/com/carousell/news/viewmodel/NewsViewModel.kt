package com.carousell.news.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carousell.common_utils.AppConstants
import com.carousell.common_utils.Resource
import com.carousell.domain.use_case.GetNewsArticleUseCase
import com.carousell.news.NewsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val getNewsArticleUseCase: GetNewsArticleUseCase) :
    ViewModel() {


    private val mNewsArticleMutableStateFlow = MutableStateFlow(NewsState())
    val newsArticleStateFlow: StateFlow<NewsState> = mNewsArticleMutableStateFlow

    init {
        getNewsArticles(AppConstants.SortingAction.TIME_CREATED)
    }

    fun getNewsArticles(sortingAction: AppConstants.SortingAction) {
        getNewsArticleUseCase.invoke(sortingAction).onEach {

            when (it) {
                is Resource.Loading -> {
                    mNewsArticleMutableStateFlow.value = NewsState(isLoading = true)
                }
                is Resource.Success -> {
                    mNewsArticleMutableStateFlow.value = NewsState(data = it.data)
                }
                is Resource.Error -> {
                    mNewsArticleMutableStateFlow.value = NewsState(msg = it.msg)
                }
            }

        }.launchIn(viewModelScope)
    }

}