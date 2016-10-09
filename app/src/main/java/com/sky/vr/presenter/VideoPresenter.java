package com.sky.vr.presenter;

import android.content.Context;

import com.sky.vr.base.VRBasePresenter;
import com.sky.vr.contract.VideoContract;
import com.sky.vr.data.mojing.TagsResource;
import com.sky.vr.data.source.VideoRepository;
import com.sky.vr.data.source.local.VideoLocalDataSource;
import com.sky.vr.data.source.remote.VideoRemoteDataSource;
import com.sky.vr.event.VideoEvent;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by sky on 16-9-28.
 */

public class VideoPresenter extends VRBasePresenter<VideoEvent> implements VideoContract.Presenter {

    private VideoContract.View mView;
    private VideoRepository mRepository;

    public VideoPresenter(Context context, VideoContract.View view) {
        super(context);
        mView = view;
        view.setPresenter(this);
        mRepository = new VideoRepository(
                new VideoLocalDataSource(getContext()), new VideoRemoteDataSource());
    }

    @Override
    public void onMainThreadEvent(VideoEvent event) {

    }

    @Override
    public void loadTagsResource(int resId, int tag) {

        mRepository.getTagsResource(resId, tag, 0, 20)
                .subscribeOn(Schedulers.io())
                .map(new Func1<TagsResource, Object>() {
                    @Override
                    public Object call(TagsResource tagsResource) {

                        return null;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Object>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Object o) {

                    }
                });
    }
}
