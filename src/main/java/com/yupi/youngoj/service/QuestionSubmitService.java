package com.yupi.youngoj.service;

import com.yupi.youngoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.youngoj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.youngoj.model.entity.User;

/**
* @author Plankton
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2024-09-19 14:30:27
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);
}
