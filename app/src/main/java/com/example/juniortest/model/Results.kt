package com.example.juniortest.model

import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("context")
    val context: Context,
    @SerializedName("items")
    val items: List<Item>?,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("queries")
    val queries: Queries,
    @SerializedName("searchInformation")
    val searchInformation: SearchInformation,
    @SerializedName("url")
    val url: Url
)

data class Context(
    @SerializedName("title")
    val title: String
)

data class Item(
    @SerializedName("cacheId")
    val cacheId: String,
    @SerializedName("displayLink")
    val displayLink: String,
    @SerializedName("formattedUrl")
    val formattedUrl: String,
    @SerializedName("htmlFormattedUrl")
    val htmlFormattedUrl: String,
    @SerializedName("htmlSnippet")
    val htmlSnippet: String,
    @SerializedName("htmlTitle")
    val htmlTitle: String,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("pagemap")
    val pagemap: Pagemap,
    @SerializedName("snippet")
    val snippet: String,
    @SerializedName("title")
    val title: String
)

data class Pagemap(
    @SerializedName("cse_image")
    val cseImage: List<CseImage>,
    @SerializedName("cse_thumbnail")
    val cseThumbnail: List<CseThumbnail>,
    @SerializedName("metatags")
    val metatags: List<Metatag>,
    @SerializedName("thumbnail")
    val thumbnail: List<Thumbnail>
)

data class CseImage(
    @SerializedName("height")
    val height: String,
    @SerializedName("src")
    val src: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("width")
    val width: String
)

data class CseThumbnail(
    @SerializedName("height")
    val height: String,
    @SerializedName("src")
    val src: String,
    @SerializedName("width")
    val width: String
)

data class Metatag(
    @SerializedName("apple-mobile-web-app-title")
    val appleMobileWebAppTitle: String,
    @SerializedName("application-name")
    val applicationName: String,
    @SerializedName("dc.identifier")
    val dcIdentifier: String,
    @SerializedName("dc.source")
    val dcSource: String,
    @SerializedName("dc.subject")
    val dcSubject: String,
    @SerializedName("dc.type")
    val dcType: String,
    @SerializedName("docsearch:language")
    val docsearchLanguage: String,
    @SerializedName("fb:admins")
    val fbAdmins: String,
    @SerializedName("fb:app_id")
    val fbAppId: String,
    @SerializedName("format-detection")
    val formatDetection: String,
    @SerializedName("localized")
    val localized: String,
    @SerializedName("msapplication-tilecolor")
    val msapplicationTilecolor: String,
    @SerializedName("msapplication-tileimage")
    val msapplicationTileimage: String,
    @SerializedName("msvalidate.01")
    val msvalidate01: String,
    @SerializedName("naver-site-verification")
    val naverSiteVerification: String,
    @SerializedName("og:aria-text")
    val ogAriaText: String,
    @SerializedName("og:description")
    val ogDescription: String,
    @SerializedName("og:image")
    val ogImage: String,
    @SerializedName("og:image:secure_url")
    val ogImageSecureUrl: String,
    @SerializedName("og:site_name")
    val ogSiteName: String,
    @SerializedName("og:title")
    val ogTitle: String,
    @SerializedName("og:type")
    val ogType: String,
    @SerializedName("og:url")
    val ogUrl: String,
    @SerializedName("referrer")
    val referrer: String,
    @SerializedName("release")
    val release: String,
    @SerializedName("st:robots")
    val stRobots: String,
    @SerializedName("theme-color")
    val themeColor: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("twitter:aria-text")
    val twitterAriaText: String,
    @SerializedName("twitter:card")
    val twitterCard: String,
    @SerializedName("twitter:description")
    val twitterDescription: String,
    @SerializedName("twitter:image")
    val twitterImage: String,
    @SerializedName("twitter:site")
    val twitterSite: String,
    @SerializedName("twitter:title")
    val twitterTitle: String,
    @SerializedName("twitter:url")
    val twitterUrl: String,
    @SerializedName("version")
    val version: String,
    @SerializedName("viewport")
    val viewport: String,
    @SerializedName("yandex-verification")
    val yandexVerification: String
)

data class Thumbnail(
    @SerializedName("src")
    val src: String
)

data class Queries(
    @SerializedName("nextPage")
    val nextPage: List<NextPage>,
    @SerializedName("request")
    val request: List<Request>
)

data class NextPage(
    @SerializedName("count")
    val count: Int,
    @SerializedName("cx")
    val cx: String,
    @SerializedName("inputEncoding")
    val inputEncoding: String,
    @SerializedName("outputEncoding")
    val outputEncoding: String,
    @SerializedName("safe")
    val safe: String,
    @SerializedName("searchTerms")
    val searchTerms: String,
    @SerializedName("startIndex")
    val startIndex: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("totalResults")
    val totalResults: String
)

data class Request(
    @SerializedName("count")
    val count: Int,
    @SerializedName("cx")
    val cx: String,
    @SerializedName("inputEncoding")
    val inputEncoding: String,
    @SerializedName("outputEncoding")
    val outputEncoding: String,
    @SerializedName("safe")
    val safe: String,
    @SerializedName("searchTerms")
    val searchTerms: String,
    @SerializedName("startIndex")
    val startIndex: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("totalResults")
    val totalResults: String
)

data class SearchInformation(
    @SerializedName("formattedSearchTime")
    val formattedSearchTime: String,
    @SerializedName("formattedTotalResults")
    val formattedTotalResults: String,
    @SerializedName("searchTime")
    val searchTime: Double,
    @SerializedName("totalResults")
    val totalResults: String
)

data class Url(
    @SerializedName("template")
    val template: String,
    @SerializedName("type")
    val type: String
)
