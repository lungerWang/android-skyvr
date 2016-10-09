package com.sky.vr.service;

import com.sky.vr.data.mojing.TagsResource;
import com.sky.vr.data.mojing.Tags;

import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by sky on 16-9-29.
 */

public interface VideoService {

    @POST("1/tags_list.js")
    Observable<Tags> getCategory();

    @POST("1/category/catinfo/{resId}-start{start}-num{num}.js")
    Observable<TagsResource> getCategoryCatInfo(@Path("resId") int resId, @Path("start") int start, @Path("num") int num);

    @POST("1/tags_resource-type{resId}-tag{tag}-start{start}-num{num}.js")
    Observable<TagsResource> getTagsResource(@Path("resId") int resId, @Path("tag") int tag, @Path("start") int start, @Path("num") int num);
}
