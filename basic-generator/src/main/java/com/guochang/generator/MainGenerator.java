package com.guochang.generator;

import com.guochang.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {

    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("yupi");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");
        doGenerate(mainTemplateConfig);
    }

    private static void doGenerate(Object model) throws IOException, TemplateException {
        //静态文件生成
        String projectPath = System.getProperty("user.dir");
        String inputPath = projectPath+ File.separator + "generator-demo-projects" + File.separator + "acm-template";
        String outputPath=projectPath;
        StaticGenerator.copyFilesByRecursive(inputPath,outputPath);

        //动态文件生成
        String inputDynamicFilePath = projectPath + File.separator + "basic-generator" + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath = outputPath + File.separator + "acm-template/src/com/yupi/acm/MainTemplate.java";
        DynamicGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
    }


}
