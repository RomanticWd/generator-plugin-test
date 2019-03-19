package com.example.core.run;

import com.example.core.entity.ColumnDefinition;
import com.example.core.entity.ConfigContext;
import com.example.core.helper.ColumnHelper;
import com.example.core.helper.DBHelper;
import com.example.core.service.Callback;
import com.example.core.util.FileUtil;
import com.example.core.util.VelocityUtil;
import org.apache.velocity.VelocityContext;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author LiuYue
 * @Date 2019/1/2
 * @Version 1.0
 */
public class GeneratorTest {

    private static String SourcePath = "E:\\Research\\maven_plugin\\src\\main\\resource\\";

    private static String OutputPath = "E:\\Research\\maven_plugin\\src\\main\\java\\com\\example\\gcode\\";

    public static void main(String[] args){

        ConfigContext configContext = new ConfigContext(SourcePath, OutputPath);

        //初始化DB工具类
        DBHelper dbHelper = new DBHelper(configContext);

        //得到数据库表的元数据
        List<Map<String, Object>> resultList = dbHelper.descTable();

        //元数据处理
        List<ColumnDefinition> columnDefinitionList = ColumnHelper.covertColumnDefinition(resultList);

        //生成代码
        /*GeneratorMojo.doGenerator(configContext, columnDefinitionList, new Callback() {
            public void write(ConfigContext configContext, VelocityContext context) {

                FileUtil.writeFile(configContext.getOutputPath(),                   //输出目录
                        String.format("%s.java",configContext.getTargetName()),    //文件名
                        VelocityUtil.render("entity.vm", context));                 //模板生成内容

                FileUtil.writeFile(configContext.getOutputPath(),
                        String.format("I%sDasService.java",configContext.getTargetName()),
                        VelocityUtil.render("contract.vm", context));

                FileUtil.writeFile(configContext.getOutputPath(),
                        String.format("%sDao.java",configContext.getTargetName()),
                        VelocityUtil.render("dao.vm", context));

                FileUtil.writeFile(configContext.getOutputPath(),
                        String.format("%sDasService.java",configContext.getTargetName()),
                        VelocityUtil.render("service.vm", context));
            }
        });*/

    }

}
