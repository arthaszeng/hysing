package processor;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.utils.FilePersistentBase;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonPipeline extends FilePersistentBase implements Pipeline {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * new JsonFilePageModelPipeline with default path "/data/webmagic/"
     */
    public JsonPipeline() {
        setPath("/data/webmagic");
    }

    public JsonPipeline(String path) {
        setPath(path);
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        String path = this.path + PATH_SEPERATOR + task.getUUID() + PATH_SEPERATOR;
        Gson gson = new Gson();
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(getFile(path + DigestUtils.md5Hex(resultItems.getRequest().getUrl()) + ".json")));
            printWriter.write(gson.toJson(resultItems.getAll()));
            printWriter.close();
        } catch (IOException e) {
            logger.warn("write file error", e);
        }
    }
}
