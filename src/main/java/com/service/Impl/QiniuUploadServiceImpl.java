package com.service.Impl;

import com.qiniu.util.Auth;
import com.service.QiniuUploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * Created by Rico on 2017/6/29.
 */
@Service
public class QiniuUploadServiceImpl implements QiniuUploadService {


    private static  final String ACCESS_KEY = "EAq0pw7idbZ94FyAC09I1V15gbKzlpZtEeeJ11bd";
    private static final String SECRET_KEY = "9sfAu2guXkH73n6hAm31-uRitprOy14GW_PbZQYc";
    private static final String BUCKET_NAME = "test";
    private Auth auth;

    public QiniuUploadServiceImpl() {
        this.auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    }


    @Override
    public String getUploadToken() {
        return auth.uploadToken(BUCKET_NAME);
    }
}
