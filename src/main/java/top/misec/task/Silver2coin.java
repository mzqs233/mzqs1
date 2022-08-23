package top.misec.task;

import com.google.gson.JsonObject;
import lombok.extern.log4j.Log4j2;
import top.misec.apiquery.ApiList;
import top.misec.apiquery.oftenAPI;
import top.misec.utils.HttpUtil;

import static top.misec.task.TaskInfoHolder.STATUS_CODE_STR;
import static top.misec.task.TaskInfoHolder.userInfo;

/**
 * 银瓜子换硬币（失效）
 *
 * @author @JunzhouLiu @Kurenai
 * @since 2020-11-22 5:25
 */
@Log4j2
public class Silver2coin implements Task {

    @Override
    public void run() {
        System.out.print("111");
    }

    @Override
    public String getName() {
        return "银瓜子换硬币";
    }
}
