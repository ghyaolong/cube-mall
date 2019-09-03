package cube;

import java.util.UUID;

/**
 * @Author 289911401@qq.com
 * @description ID生成器
 * @date
 */
public class UUIDGenerator {
    public static String UUID32(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
