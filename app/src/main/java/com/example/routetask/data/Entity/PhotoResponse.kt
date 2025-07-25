package com.example.routetask.data.Entity

import com.example.routetask.domain.model.Photo
import com.google.gson.annotations.SerializedName

data class PhotoResponse(

	@field:SerializedName("next_page")
	val nextPage: String? = null,

	@field:SerializedName("per_page")
	val perPage: Int? = null,

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("photos")
	val photos: List<PhotosItem?>? = null,

	@field:SerializedName("total_results")
	val totalResults: Int? = null
){
	fun toPhoto():Photo{
		return Photo(
			photoUrlList = photos?.filterNotNull()?.mapNotNull {
				it.src?.original
			}
		)

	}
}