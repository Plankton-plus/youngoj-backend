package com.yupi.youngoj.controller;

import com.yupi.youngoj.common.BaseResponse;
import com.yupi.youngoj.common.ErrorCode;
import com.yupi.youngoj.common.ResultUtils;
import com.yupi.youngoj.exception.BusinessException;
import com.yupi.youngoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.youngoj.model.entity.User;
import com.yupi.youngoj.service.QuestionSubmitService;
import com.yupi.youngoj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交接口
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 提交题目
     *
     * @param questionSubmitbAddRequest
     * @param request
     * @return questionSubmitId 提交题目的id
     */
    @PostMapping("/")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitbAddRequest,
                                                  HttpServletRequest request) {
        if (questionSubmitbAddRequest == null || questionSubmitbAddRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能上传题目
        final User loginUser = userService.getLoginUser(request);
        long questionSubmitId = questionSubmitService.doQuestionSubmit(questionSubmitbAddRequest, loginUser);
        return ResultUtils.success(questionSubmitId);
    }

}
