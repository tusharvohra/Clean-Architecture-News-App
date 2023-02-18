package com.carousell.news.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.carousell.common_utils.AppConstants
import com.carousell.domain.model.NewsArticle
import com.carousell.news.R
import com.carousell.news.databinding.ActivityNewsBinding
import com.carousell.news.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class NewsActivity : AppCompatActivity(), AdapterToActivityCallback {

    private var mBinding: ActivityNewsBinding? = null
    private val binding: ActivityNewsBinding
        get() = mBinding!!

    private val newsViewModel: NewsViewModel by viewModels()

    private val newsAdapter = NewsAdapter(this)

    private val newsDetailsDialog = NewsDetailsDialog()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, R.color.app_status_bar_red)
        // get the binding for this activity
        mBinding = ActivityNewsBinding.inflate(layoutInflater)
        setSupportActionBar(mBinding?.toolbar)
        setContentView(binding.root)

        setObservers()

        binding.rvNews.adapter = newsAdapter
    }

    private fun setObservers() {

        binding.swipeRefresh.setOnRefreshListener {
            newsViewModel.getNewsArticles(AppConstants.SortingAction.TIME_CREATED)
        }

        lifecycleScope.launchWhenCreated {
            newsViewModel.newsArticleStateFlow.collectLatest {
                if (it.isLoading) {
                    binding.swipeRefresh.isRefreshing = true
                }
                if (it.msg.isNotBlank()) {
                    binding.swipeRefresh.isRefreshing = false
                    binding.rvNews.visibility = View.VISIBLE
                    Toast.makeText(this@NewsActivity, it.msg, Toast.LENGTH_SHORT).show()
                }
                it.data?.let { list ->
                    binding.swipeRefresh.isRefreshing = false
                    binding.rvNews.visibility = View.VISIBLE
                    binding.rvNews.smoothScrollToPosition(0)
                    newsAdapter.setData(list)
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.recent -> newsViewModel.getNewsArticles(AppConstants.SortingAction.RECENT)
            R.id.popular -> newsViewModel.getNewsArticles(AppConstants.SortingAction.POPULAR)
        }
        return true
    }

    override fun onItemClick(newsArticle: NewsArticle) {
        newsDetailsDialog.arguments = Bundle().apply { putParcelable("DATA", newsArticle) }
        newsDetailsDialog.show(supportFragmentManager, NewsDetailsDialog::class.java.name)
    }
}