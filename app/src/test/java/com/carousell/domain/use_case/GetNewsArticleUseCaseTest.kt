package com.carousell.domain.use_case

import com.carousell.common_utils.AppConstants
import com.carousell.common_utils.Resource
import com.carousell.data.repository.FakeNewsRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class GetNewsArticleUseCaseTest {

    private lateinit var fakeNewsRepository: FakeNewsRepository
    private lateinit var getNewsArticleUseCase: GetNewsArticleUseCase

    @Before
    fun setUp() {
        fakeNewsRepository = FakeNewsRepository()
        getNewsArticleUseCase = GetNewsArticleUseCase(fakeNewsRepository)
    }

    @Test
    fun `Get news articles in order of the date they were created, correct order`(): Unit =
        runBlocking {
            println(">>>>>>>>>>>>>>>>TEST STARTED>>>>>>>>>>>>>>>>>>>>>>>")
            getNewsArticleUseCase.invoke(AppConstants.SortingAction.TIME_CREATED).collect {
                println(">>>>>>>>>>>>>>>>>>>>>$it>>>>>>>>>>>>>>>")
                when (it) {
                    is Resource.Success -> {
                        println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>${it.data}>>>>>>>>>>>>>>>>>>>>>>")
                        val newsArticles = it.data
                        for (i in 0..newsArticles?.size!! - 2) {
                            assert(newsArticles[i].time_created!! <= newsArticles[i + 1].time_created!!)
                        }
                    }
                    else -> {}
                }
            }
        }

    @Test
    fun `Get news articles in recent order, correct order`(): Unit = runBlocking {
        println(">>>>>>>>>>>>>>>>TEST STARTED>>>>>>>>>>>>>>>>>>>>>>>")
        getNewsArticleUseCase.invoke(AppConstants.SortingAction.RECENT).collect {
            println(">>>>>>>>>>>>>>>>>>>>>$it>>>>>>>>>>>>>>>")
            when (it) {
                is Resource.Success -> {
                    println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>${it.data}>>>>>>>>>>>>>>>>>>>>>>")
                    val newsArticles = it.data
                    for (i in 0..newsArticles?.size!! - 2) {
                        assert(newsArticles[i].time_created!! >= newsArticles[i + 1].time_created!!)
                    }
                }
                else -> {}
            }
        }
    }

    @Test
    fun `Get news articles in popularity order, correct order`(): Unit = runBlocking {
        println(">>>>>>>>>>>>>>>>TEST STARTED>>>>>>>>>>>>>>>>>>>>>>>")
        getNewsArticleUseCase.invoke(AppConstants.SortingAction.POPULAR).collect {
            println(">>>>>>>>>>>>>>>>>>>>>$it>>>>>>>>>>>>>>>")
            when (it) {
                is Resource.Success -> {
                    println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>${it.data}>>>>>>>>>>>>>>>>>>>>>>")
                    val newsArticles = it.data
                    for (i in 0..newsArticles?.size!! - 2) {
                        if (newsArticles[i].rank!! < newsArticles[i + 1].rank!!)
                            assert(true)
                        else if (newsArticles[i].rank!! == newsArticles[i + 1].rank!!)
                            assert(newsArticles[i].time_created!! <= newsArticles[i + 1].time_created!!)
                        else
                            assert(false)
                    }
                }
                else -> {}
            }
        }
    }


}