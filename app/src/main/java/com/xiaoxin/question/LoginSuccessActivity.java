package com.xiaoxin.question;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.transition.Explode;
import android.widget.EditText;

import com.xiaoxin.question.base.BaseActivity;
import com.xiaoxin.question.bean.Question;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class LoginSuccessActivity extends BaseActivity {

    @BindView(R.id.et_question_content)
    EditText etQuestionContent;
    @BindView(R.id.et_question_keyword)
    EditText etQuestionKeyword;
    @BindView(R.id.et_question_type)
    EditText etQuestionType;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.ti_quesition_content)
    TextInputLayout tiQuesitionContent;
    @BindView(R.id.ti_quesition_keyword)
    TextInputLayout tiQuesitionKeyword;
    @BindView(R.id.ti_quesition_type)
    TextInputLayout tiQuesitionType;
    private String mContent;
    private String mKeyWord;
    private String mType;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        ButterKnife.bind(this);
        setExplode();

    }


    private void setExplode() {
        Explode explode = new Explode();
        explode.setDuration(500);
        getWindow().setExitTransition(explode);
        getWindow().setEnterTransition(explode);
    }

    @OnClick(R.id.fab)
    public void onSubMit() {
        Question question = new Question();
        question.name = "jdk";
        mContent = etQuestionContent.getText().toString();
        mKeyWord = etQuestionKeyword.getText().toString();
        mType = etQuestionType.getText().toString();
        question.content = mContent;
        question.keyword = mKeyWord;
        question.type = mType;
        if (TextUtils.isEmpty(mContent)) {
            tiQuesitionContent.setError("Question'Content Is Null!");
            return;
        }else{
            tiQuesitionContent.setError(null);
        }
        if (TextUtils.isEmpty(mKeyWord)) {
            tiQuesitionKeyword.setError("Question'KeyWord Is Null!");
            return;
        }else
            tiQuesitionKeyword.setError(null);
        if (TextUtils.isEmpty(mType)) {
            tiQuesitionType.setError("Question'Type Is Null!");
            return;
        }
        else
            tiQuesitionType.setError(null);


        question.save(new SaveListener<String>() {
            @Override
            public void done(String objectId, BmobException e) {
                if (e == null) {
                    FastToast("添加数据成功，返回objectId为：" + objectId);
                } else {
                    FastToast("创建数据失败：" + e.getMessage());
                }
            }
        });
    }
}
