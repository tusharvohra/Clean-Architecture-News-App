package com.carousell.domain.use_case

import com.carousell.common_utils.AppConstants
import com.carousell.common_utils.Resource
import com.carousell.domain.model.NewsArticle
import com.carousell.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetNewsArticleUseCase(private val newsRepository: NewsRepository) {

    operator fun invoke(sortingAction: AppConstants.SortingAction): Flow<Resource<List<NewsArticle>>> = flow {
        emit(Resource.Loading())
        try {
            when(sortingAction) {
                AppConstants.SortingAction.RECENT -> {
                    emit(Resource.Success(newsRepository.getNewsArticles().sortedByDescending { it.time_created }))
                }
                AppConstants.SortingAction.POPULAR -> {
                    emit(Resource.Success(newsRepository.getNewsArticles().sortedWith(compareBy({it.rank},{it.time_created}))))
                }
                AppConstants.SortingAction.TIME_CREATED -> {
                    emit(Resource.Success(newsRepository.getNewsArticles().sortedBy { it.time_created }))
                }
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }
}