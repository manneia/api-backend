package com.luo.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luo.project.model.entity.Post;

/**
 * @author yupili
 * @Description  针对表【post(帖子)】的数据库操作Service
 */
public interface PostService extends IService<Post> {

    /**
     * @Description 校验
     * @param post 提交参数
     * @param add 是否为创建校验
     */
    void validPost(Post post, boolean add);
}
