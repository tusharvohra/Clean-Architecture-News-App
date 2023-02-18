import com.carousell.data.model.NewsArticleDTO
import com.carousell.domain.model.NewsArticle

// extension function to map DTO to Domain model
fun NewsArticleDTO.toDomainNewsArticle(): NewsArticle = NewsArticle(
    this.banner_url,
    this.description,
    this.rank,
    this.time_created,
    this.title
)