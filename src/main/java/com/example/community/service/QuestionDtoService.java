package com.example.community.service;

import com.example.community.demo.Question;
import com.example.community.demo.User;
import com.example.community.dto.QuestionDto;
import com.example.community.mappr.QuestionMapper;
import com.example.community.mappr.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Package: com.example.community.service
 * Description：
 * Author: weidongya
 * Date:  2020/3/26 13:47
 * Modified By:
 */
@Service
public class QuestionDtoService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    /*
     * @Description:查找所有的问题列表内容
     * @Author: weidongya
     * @Date: 2020/3/26 14:24
      * @param null
     * @result:
     **/
    public List<QuestionDto> list(){
        List<Question> questions = questionMapper.findAll();
        List<QuestionDto> questionDtos = new ArrayList<QuestionDto>();
     //   System.out.println(questions);
        for (Question question:questions) {
            User user = userMapper.findByAccount_id(Integer.toString(question.getCreator()));
            System.out.println(user);
            QuestionDto questionDto = new QuestionDto();
            questionDto.setUser(user);
            questionDto.setQuestion(question);
            questionDtos.add(questionDto);
        }
        return questionDtos;
    }
}