package com.example.newsfeedapp.newsapiclient

import com.example.newsfeedapp.data.api.NewsAPIService
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class NewsAPIServiceTest {
    private lateinit var service: NewsAPIService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPIService::class.java)
    }

    private fun enqueMockResponse(
        fileName: String
    ){
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @Test
    fun getTopHeadLines_sentRequest_receivedExpected(){
        runBlocking {
            enqueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadlines("us",1).body()
            val request = server.takeRequest()
            assertThat(responseBody).isNotNull()
            assertThat(request.path).isEqualTo("/v2/top-headlines?country=us&page=1&apiKey=ed223680582c4d7095e28771707e4ae2")

        }
    }

    @Test
    fun getTopHeadLines_receivedResponse_correctPageSize(){
        runBlocking {
            enqueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadlines("us",1).body()
            val articleList = responseBody!!.articles
            assertThat(articleList.size).isEqualTo(20)
        }
    }

    @Test
    fun getTopHeadLines_receivedResponse_correctContent(){
        runBlocking {
            enqueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadlines("us",1).body()
            val articleList = responseBody!!.articles
            val article = articleList[0]
            assertThat(article.author).isEqualTo("Carolyn Y. Johnson")
            assertThat(article.url).isEqualTo("https://www.washingtonpost.com/science/2023/10/12/allen-brain-atlas-cell-types/")
            assertThat(article.publishedAt).isEqualTo("2023-10-12T18:27:40Z")
        }
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}